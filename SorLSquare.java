/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class SorLSquare extends SnLSquare {

    private int endSquare;

    /**
     *
     * @param number number of the current square
     * @param endSquare number of the endSquare
     */
    public SorLSquare(int number, int endSquare) {
        super(number);
        //If number is = to endSquare throw new IllegalArgumentException
        if (number == endSquare) 
        {
            throw new IllegalArgumentException("You have landed on the last square");
        }

        this.endSquare = endSquare;
    }

    /**
     *
     * @return endSquare
     */
    public int getEndSquare() {
        return endSquare;

    }

    /**
     *
     * @return getEndSquare(), endsquare value
     */
    @Override
    public int landOn() {
        return getEndSquare();
    }

    /**
     *
     * @return string representation of the number and endSquare with :
     */
    @Override
    public String toString() {
        return super.toString() + ":" + getEndSquare();

    }

    /**
     * 
     * @param other object type argument
     * @return boolean creates to object of snakes and ladders and compares to 
     * see if both are equal to null or if both are the same
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other) && this.getEndSquare() == ((SorLSquare) (other)).getEndSquare();
    }
}
