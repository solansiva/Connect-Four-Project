/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Solan
 */
public class SnLSquare {
    
    private int number;//Initialize int number  
    
    /**
     * 
     * @param number number used to set this.number to 
     * the number of the parameter 
     */
    public SnLSquare(int number){    
        
        this.number = number;            
    }
    
    /**
     * 
     * @return number 
     */
    public int getNumber(){
        return number;
    }
    
    /**
     * 
     * @return getNumber() 
     */
    public int landOn(){
        return getNumber();
    }
    
    /**
     * 
     * @return string of the number 
     */
    public String toString(){ 
        return "" +getNumber();
        
    }
    
    /**
     * 
     * @param other object type argument
     * @return boolean creates to object of snakes and ladders and compares to 
     * see if both are equal to null or if both are the same
     */
    public boolean equals(Object other){
     if (other == null){
         return false;
         }  
     if (other == this){
         return true;
     }
    
     if (getClass() != other.getClass()){
         return false;
     }
     SnLSquare s = (SnLSquare)other; 
     return(this.number == s.number);
           
    }

}