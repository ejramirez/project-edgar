
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    /*
        This class gets information from the configuration file called config.properties
    */
    private final static Properties properties = new Properties();
    
    
    /**
     * 
     * @param s is the property that will be pulled from the configuration file.
     * @return the return is the value that is at the parameter s
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getProperty(String s) throws FileNotFoundException, IOException{
        
        FileReader reader =  new FileReader("config.properties");
        properties.load(reader);
        System.out.println(properties.getProperty(s));
        return properties.getProperty(s);
        
    }
    
    /**
     * 
     * @param prop is the property within the config file that will be set
     * @param sett is the setting that the property will be set to within the config file.
     * @return null
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String setProperty(String prop, String sett) throws FileNotFoundException, IOException{
        
        FileInputStream in = new FileInputStream("config.properties");
        properties.load(in);
        in.close();
        
        FileOutputStream out = new FileOutputStream("config.properties");
        properties.setProperty(prop, sett);
        properties.store(out,null);
        out.close();
        
        return null;
    }
    
    public static String newProperty(String prop, String Sett){
    
        return null;
    }
    
}
