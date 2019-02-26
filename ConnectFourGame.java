/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Observable;
/**
 *
 * @author Solan
 */
public class ConnectFourGame extends Observable{
    private int nColumns;
    private int nRows;
    private int numToWin;
    private int nMarks;
    private ConnectFourEnum[][] grid;
    private ConnectFourEnum gameState;
    private ConnectFourEnum turn;
    
    public ConnectFourGame(ConnectFourEnum initialTurn){
        this(8, 8, 4, initialTurn);
        
    }
    
    public ConnectFourGame(int nRows, int nColumns, int numToWin, ConnectFourEnum initialTurn){
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.turn = initialTurn;
        this.nMarks = 0;
        this.gameState = ConnectFourEnum.IN_PROGRESS;
        this.grid = new ConnectFourEnum[nRows][nColumns];

        
                
        for(int i = 0; i < nRows; i++){
             for(int j = 0; j < nColumns; j++){
                grid[i][j] = ConnectFourEnum.EMPTY;
         }
     
      }   

        
    }
    
    public void reset(ConnectFourEnum initialTurn){
        this.nMarks = 0;
        this.turn = initialTurn;
        this.grid = new ConnectFourEnum[nRows][nColumns];
        this.gameState = ConnectFourEnum.IN_PROGRESS;
         
        
        
        for(int i = 0; i < nRows; i++){
             for(int j = 0; j < nColumns; j++){
                grid[i][j] = ConnectFourEnum.EMPTY;

         }
     
      }   

    }
    
    
    
    public ConnectFourEnum takeTurn(int row, int column){
       if(row < 0 || row >= nRows || column < 0 || column >= nColumns){
           throw new IllegalArgumentException("Wrong number of rows and columns");
       }
       if(row > 0 && grid[row - 1][column] == ConnectFourEnum.EMPTY){
           throw new IllegalArgumentException("Square below taken");
       }
       
       if(grid[row][column] == ConnectFourEnum.EMPTY){
           grid[row][column] = turn;
       }else{
           System.out.println("Filled square, next turn");
           return gameState;
       }
    
       int number;
       
       for(int i = 0; i < nColumns - numToWin + 1; i++){
           number = 1;
           for(int j = 0; j < numToWin - 1; j++ ){
               if(grid[row][i] == this.turn && grid[row][i + j] == grid[row][i + j + 1]){
                   number++;
                   if(number == numToWin){
                       gameState = turn;
                   }
               }
           }
       }
       
       for(int i = 0; i < nRows - numToWin + 1; i++){
           number = 1;
           for(int j = 0; j < numToWin - 1; j++){
               if(grid[i][column] == this.turn && grid[i + j][column] == grid[i + j + 1][column]){
                   number++;
                   if(number == numToWin){
                       gameState = turn;
                   }
               }
           }
       }

        if(nMarks == nRows * nColumns && gameState == ConnectFourEnum.IN_PROGRESS){
            gameState = ConnectFourEnum.DRAW;
            
        }
        
        if(turn == ConnectFourEnum.BLACK){
            turn = ConnectFourEnum.RED;
        }else{
            turn = ConnectFourEnum.BLACK;
        }
        return gameState;
    }

        
    public ConnectFourEnum getGameState(){
        return gameState;
    }
    
    public ConnectFourEnum getTurn(){
        return turn;
    }
    
    public String toString(){
         String str = new String();
        for(int i =0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                str += grid[i][j] + " | ";
            }
            str += "\n";
        }
        return str;
    
    } 

  
}
