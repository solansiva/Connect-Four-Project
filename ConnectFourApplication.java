
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Solan
 */
public class ConnectFourApplication extends Application {

    public static final int NUM_COLUMNS = 8;
    public static final int NUM_ROWS = 8;
    public static final int NUM_TO_WIN = 4;
    public static final int BUTTON_SIZE = 20;
    private ConnectFourGame gameEngine;
    private ConnectButton[][] buttons;
    private ConnectMove connectmove;
    private Random rand;

    @Override
    public void start(Stage PrimaryStage) {
        rand = new Random();

        if (rand.nextInt(2) == 1) {
            gameEngine = new ConnectFourGame(ConnectFourEnum.BLACK);

        } else {
            gameEngine = new ConnectFourGame(ConnectFourEnum.RED);
        }
        buttons = new ConnectButton[NUM_ROWS][NUM_COLUMNS];

        GridPane buttonSide = new GridPane();
        BorderPane root = new BorderPane();
        Pane topRow = new HBox();
        Pane bottomRow = new HBox();
        EventHandler<ActionEvent> buttonHandler = new ButtonHandler();

        TextField urTurn = new TextField(gameEngine.getTurn() + " starts");
        urTurn.setEditable(false);
        urTurn.setMaxWidth(Double.MAX_VALUE);
        urTurn.setMinWidth(PrimaryStage.getMaxWidth());
        topRow.getChildren().add(urTurn);

        Button checkTurn = new Button();
        checkTurn.setText("Take my turn");
        bottomRow.getChildren().add(checkTurn);

        Scene scene = new Scene(root, 510, 380);
        PrimaryStage.setTitle("Connect Four");
        PrimaryStage.setScene(scene);

        Observer obs = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                buttons[connectmove.getRow()][connectmove.getColumn()].setText(connectmove.getColour().toString());
                buttons[connectmove.getRow()][connectmove.getColumn()].setDisable(true);
                urTurn.setText(gameEngine.getTurn() + " turn");

            }
        };
        gameEngine.addObserver(obs);
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                buttons[i][j] = new ConnectButton("EMPTY", i, j);
                buttons[i][j].setMinHeight(BUTTON_SIZE);
                buttons[i][j].setMaxWidth(Double.MAX_VALUE);
                buttons[i][j].setOnAction(buttonHandler);
                buttonSide.add(buttons[i][j], j, NUM_ROWS - 1 - i);
            }
        }

        checkTurn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gameEngine.takeTurn(connectmove.getRow(), connectmove.getColumn());
                gameEngine.hasChanged();
                gameEngine.notifyObservers(obs);

                obs.update(gameEngine, this);
                Alert gameOver;
                if (gameEngine.getGameState() == ConnectFourEnum.DRAW) {
                    gameOver = new Alert(AlertType.INFORMATION, "Draw");
                } else {
                    gameOver = new Alert(AlertType.INFORMATION, connectmove.getColour() + "win");
                }

                gameOver.setTitle("Informative alert");
                gameOver.setHeaderText("Game Over");
                gameOver.showAndWait();
                gameEngine.reset(gameEngine.getTurn());

                for (int i = 0; i < NUM_ROWS; i++) {
                    for (ConnectButton j : buttons[i]) {
                        j.setDisable(false);
                        j.setText("EMPTY");
                    }
                }
            }

        });

        root.setTop(topRow);
        root.setCenter(buttonSide);
        root.setBottom(bottomRow);
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            ConnectButton button = (ConnectButton) event.getSource();
            connectmove = new ConnectMove(button.getRow(), button.getColumn(), gameEngine.getTurn());

        }
    }
}
