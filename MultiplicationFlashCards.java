/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class MultiplicationFlashCards extends AbstractFlashCards {

    /**
     * Creates the flash cards for the multiplication game
     *
     * @param multiplier single multiplier number used to create flashcards
     */
    public MultiplicationFlashCards(int multiplier) {
        this(new int[]{multiplier});
    }

    /**
     * Creates the flashcards game out of several numbers and the multiple of
     * the number in a set of 12
     *
     * @param multipliers list of numbers that create the game
     */
    public MultiplicationFlashCards(int[] multipliers) {
        super();
        for (int i = 0; i < multipliers.length; i++) {
            for (int j = 0; j < 13; j++) {
                super.addCard(multipliers[i] + "*" + j, "" + multipliers[i] * j);
            }//Loop through the multipliers and the size of the list and adds
            //Adds the mulitpliers to the list 
        }
    }
}
