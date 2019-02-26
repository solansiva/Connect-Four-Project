/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class SnakesAndLadders {

    public static int NUM_PLAYERS;// Creating static int for number of players
    public static final int NUM_SQUARES = 100;// Creating final static int for the number of squares in snakes and ladder
    private SnLSquare[] board;// creating the board for snakes and ladder of type SnLSquare[]
    private int[] players;// Creating an int array for the players position
    private Dice dice;// Creating a dice to roll values

    /**
     * Default constructor for Snakes and Ladders
     */
    public SnakesAndLadders() {
        this(2);
    }

    /**
     * Argument Constructor for Snakes and Ladder
     *
     * @param nPlayers, the number of players that will be playing the game
     */
    public SnakesAndLadders(int nPlayers) {
        if (nPlayers < 1) // If the number of players is less than the possible number of players throw new IllegalArgumentException
        {
            throw new IllegalArgumentException("Must have at least 1 player");
        }

        NUM_PLAYERS = nPlayers;// Set static NUM_PLAYERS to the number of players playing 
        this.players = new int[NUM_PLAYERS];// Creating array players of capacity the number of players
        for (int i = 0; i < players.length; i++) {
            players[i] = 1;
        }// Using a loop to loop through the number of players and set each player to 1
        this.dice = new Dice();// Creating a new dice to roll 

        this.board = new SnLSquare[NUM_SQUARES];// Creating board of type SnLSquare with the size NUM_SQUARES
        for (int i = 0; i < board.length; i++) {
            board[i] = new SnLSquare(i + 1);
        }//Loop through the size of the board and set each element in the board
        //to the appropriate square number

        board[3] = new LadderSquare(4, 14);
        board[8] = new LadderSquare(9, 31);
        board[19] = new LadderSquare(20, 38);
        board[27] = new LadderSquare(28, 84);
        board[39] = new LadderSquare(40, 59);
        board[62] = new LadderSquare(63, 81);
        board[70] = new LadderSquare(71, 91);
        //Intializing each ladder to the board

        board[16] = new SnakeSquare(17, 7);
        board[53] = new SnakeSquare(54, 34);
        board[61] = new SnakeSquare(62, 18);
        board[63] = new SnakeSquare(64, 60);
        board[86] = new SnakeSquare(87, 24);
        board[92] = new SnakeSquare(93, 73);
        board[94] = new SnakeSquare(95, 75);
        board[98] = new SnakeSquare(99, 78);
        //Intializing each snake to the board

    }

    /**
     * takeTurn for each player
     *
     * @param player the player that is taking the turn
     * @return true or false on if double was rolled
     */
    public boolean takeTurn(int player) {
        //Keep the rolled dice value
        int num = dice.roll();
        //Int array of dice values
        int dices[] = dice.getDieValues();
        //Gets the players position plus the number rolled during the turn 
        int sum = getPlayerPosition(player) + num;
        //Prints out the Player who rolled and the number rolled
        System.out.println("Player " + player + " rolled " + num);

        if (sum > 100) {
            sum = 200 - sum;
        }//To check if the value rolled plus the players position is greater 
        //than 100 and set sum to the players new position 
        players[player] = board[sum - 1].landOn();// Set players new position

        // Check if any doubles are present and return boolean answer
        return dices[0] == dices[1];
    }

    /**
     * isPlayer to check if who the winner is
     *
     * @param player the player who is currently being checked to see if they
     * won
     * @return true or false depending on if the player has won by landing on
     * square 100
     */
    public boolean isPlayerWinner(int player) {
        return (this.players[player] == 100);
    }

    /**
     * get the player who has won the game
     *
     * @return the number of the player who won or -1 if no one has won
     */
    public int getWinner() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == 100) {
                return i;
            }
        }// loops through both players and check if any are at square 100, 
        //if yah the players number is returned, if both are not at square 100 return -1
        return -1;
    }

    /**
     * Get the position of the player
     *
     * @param player the player's position who is being checked
     * @return return the position of the player
     */
    public int getPlayerPosition(int player) {
        return this.players[player];
    }

    /**
     * toStrong to print out the board
     *
     * @return the string of the board
     */
    @Override
    public String toString() {
        String string = new String();//Create a new string of type String
        for (int i = 0; i < board.length; i++) {
            if (i != 0 && i % 10 == 0) {
                string += "\n";
            }//insert a new line
            string += " | " + board[i].toString();// Set string to the board and each value of the board

        }
        return string;
    }

    /**
     * String for the current positions
     *
     * @return the string value if the current position of the player in the
     * format ex.0:12
     */
    public String toStringCurrentPositions() {
        String string = new String();//Create a new string of type String
        for (int i = 0; i < players.length; i++) {
            string += i + ":" + players[i] + " ";
        }//loops through the number of players and sets the string to the player's number and player's position 
        return string;
    }

    /**
     * main access class
     * @param args String[] args only string arguments accepted 
     */
    public static void main(String[] args) {
        SnakesAndLadders boardgame = new SnakesAndLadders();// Create boardgame of type SnakesAndLadders
        System.out.println("Snakes and Ladders");// Print out the name of the game "Snakes and Ladders"
        System.out.println(boardgame.toString());// Print out the toString of the created boardgame 
        while (boardgame.getWinner() == -1)//Check while no winner is present 
        {
            for (int i = 0; i < NUM_PLAYERS; i++)//loops through the number players
            {
                boolean turn;
                turn = boardgame.takeTurn(i);// sets boolean turn to takeTurn of the current player

                while (turn && boardgame.getWinner() == -1)//checks if both turn and winner are equal to -1
                {
                    System.out.println(boardgame.toStringCurrentPositions());// Prints out the current position ofthe boardgame
                    turn = boardgame.takeTurn(i);// sets boolean turn to takeTurn of the current player
                }
                System.out.println(boardgame.toStringCurrentPositions());// Prints out the current position ofthe boardgame
            }
        }

        System.out.println("Player " + boardgame.getWinner() + " wins");// Prints out the player who won 
    }
}
