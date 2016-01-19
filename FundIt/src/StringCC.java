/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
class StringCC {
    //StringCC means String Currency Cleaner
    
    /**
     * Cleans the given string of anything that isn't a number or a single decimal
     * 
     * @param s is the string that is to be cleaned
     * @return the cleaned string
     */
    public String CleanUp(String s){
        
        /*
        *    Some of this code is paraphrased from a stackoverflow user named MADPROGRAMMER.
        *    it has been modified to meet the needs of the program.
        */
        System.out.println("\n" + s);
       
        
        StringBuilder Combiner = new StringBuilder(s);
        int x = 0;
        while(x < Combiner.length()){
            char c = Combiner.charAt(x);
            if(c < '0' && c > '9' || c == ' ' || c == '$' || c == ',' || Character.isLetter(c)){
                Combiner.deleteCharAt(x);
            }else{
                x++;
            }
        }
        
        s = new String(Combiner);
        System.out.println(s);
        return s;
    }
}
