
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class DBcon {
    
    /*
    * This class helps with making the programmer not have to retype the location of the database each time the database needs called.
    * This also allows for the database location, user login, and user password to only have to be changed in one place instead of 
    * each instance when the database has to be called.
    */
    public static String Connect() throws IOException{
        
        String driver = "jdbc:ucanaccess://";
        
        String USERHOME = System.getProperty("user.home");
        String USERDIR = System.getProperty("user.dir");
        String Path = driver + USERDIR + "\\Project-Edgar-Database.accdb";
        String MainPath = driver + USERDIR + "\\WAC_ScotTrak_Database.accdb";
        String ConfigPath = driver + Config.getProperty("CurrentDatabasePath");
        
        //return "jdbc:ucanaccess://" + USERDIR + "\\WAC_ScotTrak_Database.accdb";
        System.out.println(ConfigPath);
        return ConfigPath; 
        
        //(file path, db login, db password) - since it doesnt have a login, leave it blank
    }
    
    public static String Login(){
    
        //type Database login in the return statement
        return ""; //(file path, db login, db password) - since it doesnt have a login, leave it blank
    
    }
    
    public static String Pass(){ 
        
        //type Database login in the return statement
        return ""; //(file path, db login, db password) - since it doesnt have a login, leave it blank
        
    }
    
}
