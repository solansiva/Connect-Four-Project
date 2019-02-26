/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Solan
 */
public class ConnectFourTestClient {
    public static void main(String args[]){
        ConnectFourGame boardgame = new ConnectFourGame(ConnectFourEnum.BLACK);
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println(boardgame.toString());
            System.out.println(boardgame.getTurn() + ":Mark where? Enter row column");
            int row = scan.nextInt() - 1;
            int column = scan.nextInt() - 1;
            scan.nextLine();
            boardgame.takeTurn(row, column);
            
            
    }while(boardgame.getGameState() == ConnectFourEnum.IN_PROGRESS);
        System.out.println(boardgame.getGameState());
    
    
    }
}
