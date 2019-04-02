
import javafx.scene.control.Button;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class ConnectButton extends Button{
    private int row;
    private int column;

    
    public ConnectButton(String label,int row,int column){
        super(label);
        this.row = row;
        this.column = column;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getColumn(){
        return this.column;
    }
    
    public String toString(){
        return "(" + this.row + "," + this.column + ")"; 
    }
    
}
