/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class SnakeSquare extends SorLSquare {

    /**
     *
     * @param number the number of the square the player is at
     * @param endSquare the endSquare of where the player will end up
     */
    public SnakeSquare(int number, int endSquare) {
        super(number, endSquare);//
        if (endSquare > number) {
            throw new IllegalArgumentException("less than endSquare and greater than endSquare");
        }//Checks if the endSquare is greater than number, if so throws IllegalArgumentException
    }
    
    /**
     * 
     * @return square number and prints snake message
     */
    @Override
    public int landOn(){
        System.out.println("Landed on snake time to go down");
        return super.landOn();
    }
    /**
     *
     * @return String representation of number "-" endSquare
     */
    @Override
    public String toString() {
        return this.getNumber() + "-" + this.getEndSquare();//String value of number "-" endSquare
    }
}

//Equals is not ovewritten, becuase no new instances are being compared