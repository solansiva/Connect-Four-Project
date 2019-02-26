
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Solan
 */
public class AbstractFlashCards {

    private ArrayList<String> unAnsweredCards;//Private string arraylist
    private HashMap<String, String> flashCards;//Private string hashmap
    private int score;//Private integer to keep track of player score
    private Scanner scanner;//Private input scanner
    private Random random;//Private random number generator random

    /**
     * Default constructor AbstractFlashCards that initializes unAnsweredCards
     * ArrayList, flashCards HashMap,score, the input scanner and random number
     * generator
     */
    public AbstractFlashCards() {
        this.unAnsweredCards = new ArrayList<String>();
//unAnsweredCards creates ArrayList type String
        this.flashCards = new HashMap<String, String>();
        //flashCards creates HashMap with string values for keys and values
        this.score = 0;
//Set score to 0
        scanner = new Scanner(System.in);
//create new Scanner type scanner
        random = new Random();
//create new Random type number generator random
    }

    /**
     * addCard places the question and answer in the HashMap and places the
     * question in the ArrayList
     *
     * @param question the question string being asked
     * @param answer the answer string for the question
     */
    protected void addCard(String question, String answer) {
        flashCards.put(question, answer);
//add question and answer in HashMap using put function
        unAnsweredCards.add(question);
//add question to ArrayList using add function
    }

    /**
     * reset functions clear out the deck and re shuffles the cards
     */
    public void reset() {
        ArrayList<String> newCards = new ArrayList<String>();
//create new ArrayList to hold cards
        unAnsweredCards = new ArrayList<String>(flashCards.keySet());
//Set questions inunAnsweredCards to flashCards keys 
        for (int i = 1; i < unAnsweredCards.size(); i++) {
            newCards.add(random.nextInt(i), unAnsweredCards.get(i));
        }//Loop through size of unAnswereCards 
        newCards.add(random.nextInt(unAnsweredCards.size()), unAnsweredCards.get(0));
        unAnsweredCards = newCards;
//Set unAnsweredCards to new shuffled ArrayList
    }

    /**
     * Boolean checks to see if any remaining turns
     *
     * @return boolean expression true or false depending on whether there is a
     * turn next
     */
    public boolean hasNext() {
        return (unAnsweredCards.isEmpty() != true);
    }

    /**
     * Boolean checks is nextCard is preset and prints out appropriate message
     * if card was right or wrong, prints out ArrayList at the beginning and if
     * the answer is wrong
     *
     * @return Boolean true or False dependant on
     */
    public boolean nextCard() {
        if (hasNext()) {
            if (unAnsweredCards.size() == flashCards.size()) {
                System.out.println(unAnsweredCards);
            }//Print cards at the beginning of the game if both sizes are equal
            System.out.println(unAnsweredCards.get(0));
            String ans = scanner.nextLine();
            if (ans.equals(flashCards.get(unAnsweredCards.get(0)))) {
                System.out.println("Correct you are my friend");
                score = score + 1;
                unAnsweredCards.remove(0);
                return true;

            }//loop through answer and return true if correct, remove the answer and
            //print correct
            System.out.println("You're wrong, maybe next time");
            unAnsweredCards.add(random.nextInt(unAnsweredCards.size()), unAnsweredCards.get(0));
            unAnsweredCards.remove(0);
            System.out.println(unAnsweredCards);
            return true;
        }//Shuffle if wrong, return true and print wrong
        return false;
    }

    /**
     * Retrieve the players score
     *
     * @return integer value of the player score
     */
    public int getScore() {
        return this.score;
    }
}


Set<Integer> keys = a.keySet();
for(Integer k : keys){

}

for(int i =0; i< a.size();i++){

}
