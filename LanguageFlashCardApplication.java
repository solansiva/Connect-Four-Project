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
public class LanguageFlashCardApplication {

    /**
     * Main function that creates the flashcard game and runs through the file
     * inputed by the user with all the questions
     *
     * @param args String arguments
     */
    public static void main(String[] args) {
        LanguageFlashCards cardgame;
        Scanner userInput = new Scanner(System.in);//Input scanner
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        String filenames = userInput.nextLine();//Scan nextLine 

        cardgame = new LanguageFlashCards(filenames);//Creating cardgame
        cardgame.reset();//Reset games

        String yesOrno;
        do {
            cardgame.nextCard();
            if (!cardgame.hasNext()) {
                System.out.println("Game over, good job");
                break;
            }//Check if hasNext return false if true end game
            System.out.println("Score = " + cardgame.getScore());
            System.out.println("Keep going? (Y or N)");
            yesOrno = userInput.nextLine();
            if (yesOrno.equalsIgnoreCase("N")) {
                System.out.println("Your score is " + cardgame.getScore() + " so far");
            } //If N end game and output score
        } while (yesOrno.equalsIgnoreCase("Y") == true && cardgame.hasNext());

    }
}
