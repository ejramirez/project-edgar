
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class Config {
    //String USERDIR = System.getProperty("user.dir");
    
    public static String getProperty(String s) throws FileNotFoundException, IOException{
        
        FileReader reader =  new FileReader("config.properties");
        Properties properties = new Properties();
        properties.load(reader);
        System.out.println(properties.getProperty(s));
        return properties.getProperty(s);
        
    }
    
}
