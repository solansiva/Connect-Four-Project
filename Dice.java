/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumathy
 */
import java.util.Date;
import java.util.Random;

/*
 * Models a set of dice
 *
 * @author Schramm
 */
public class Dice {
    private Random random;
    private int die[];
    
    // Default Constructor : A pair of die
    
    public Dice() {
        this(2);
    }
    /**
     * 
     * @param numDice The number of dice to be created
     */
    public Dice(int numDice) {
        this.random = new Random(new Date().hashCode());
        if (numDice < 1) throw new IllegalArgumentException ("You must create at least one die");
        this.die = new int[numDice];
        for (int i=0; i<this.die.length;i++) {
            this.die[i] = rollDie();
        }
    }
    
    /** A private function that rolls a single die. Used for safety
     *  to avoid common error in forgetting to maps random ints (from 0 to max)
     *  to required ints (from 1 to max+1)
     * @return A number from 1 to 6.
     */
    private int rollDie() {
         return this.random.nextInt(6) + 1;
        // return (this.random.nextInt(5999) / 1000) + 1;
    }
    
    public int roll() {
        int sum = 0;
        for (int i=0; i<die.length;i++) {
            this.die[i] = rollDie();
            sum += this.die[i];
        }
        return sum;
    }
    
    // @return  True if there exists any pair of duplicate die.
    // There may be multiple pairs but this method returns upon the first found.
    
    public boolean hasDoubles() { 
        for (int i=0; i<this.die.length;i++) {
            for (int j=1; j<this.die.length;j++) {
                if (this.die[i] == this.die[j]) return true;
            }
        }
        return false;
    }
    
    // @return Defensive copy of die values 
    public int[] getDieValues() {
        int temp[] = new int[die.length];
        // TBD: Is there an array-copy method?
        for (int i=0;i<temp.length;i++) {
            temp[i]=this.die[i];
        }
        return temp;
    }
    
    public String toString() {
        String s = "";
        for (int i=0;i<this.die.length;i++) {
            s += this.die[i] + " ";
        }
        return s;
    }
}

