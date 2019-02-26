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
public class MultiplicationFlashCardApplication {

    /**
     * Main function that creates the flashcard multiplication game and runs
     * through the list of multiples inputed by the player
     *
     * @param args String arguments
     */
    public static void main(String[] args) {
        MultiplicationFlashCards cardgame;
        Scanner userInput = new Scanner(System.in);//Scanner type userInput
        System.out.println("What time tables would you like to test? (Between 1 and 12 inclusive)");
        String userin = userInput.nextLine();
        String[] strings = userin.split(" ");//Splits input by the spaces 
        int[] ints = new int[strings.length];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);//Takes string array to integers

        }//Loop through the size of ints array

        cardgame = new MultiplicationFlashCards(ints);//Create multiplication game
        cardgame.reset();//Reset game

        String yesOrno;

        do {
            cardgame.nextCard();
            if (!cardgame.hasNext()) {
                System.out.println("Game done, nice job");
                break;
            }//Check if hasNext return false if true end game 
            System.out.println("Score = " + cardgame.getScore());
            System.out.println("Keep going? (Y or N)");
            yesOrno = userInput.nextLine();
            if (yesOrno.equalsIgnoreCase("N")) {
                System.out.println("Your score is " + cardgame.getScore() + " so far");
            }//If N print out game score
        } while (yesOrno.equalsIgnoreCase("Y") != false && cardgame.hasNext());

    }

}
