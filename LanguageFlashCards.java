/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 *
 * @author Solan
 */
public class LanguageFlashCards extends AbstractFlashCards {

    private static final String COMMA_DELIMITER = ",";//Static final string ","   
    private String filename;//Private string filename initialized 

    /**
     * Creates language game and reads question and answers
     *
     * @param filename the file that must be read
     */
    public LanguageFlashCards(String filename) {
        this.filename = filename;//Setting this.filename to filename

        try (BufferedReader read = new BufferedReader(new FileReader(this.filename))) {

            String readline;
            readline = read.readLine();
            while ((readline = read.readLine()) != null) {
                String[] flashcardL = readline.split(COMMA_DELIMITER);
                super.addCard(flashcardL[0], flashcardL[1]);

            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file");//Catches if file does not exist and 
            //prints error message
        } catch (IOException e) {

        }//Catches IOException

    }
}
