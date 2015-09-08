
import static com.sun.xml.internal.ws.api.pipe.Fiber.current;
import java.io.IOException;
import static java.util.concurrent.ThreadLocalRandom.current;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class BackupExit {
    //private Object jLabel2;
    
    public static void initialize() throws InterruptedException, IOException{
        String USERHOME = System.getProperty("user.home");
        //String USERNAME = System.getProperty("user.name");
        String Backup = USERHOME + "\\Documents\\GitHub\\project-edgar\\backupData.bat";
            
            Process commandProcess = Runtime.getRuntime().exec(Backup);
            int processComplete = commandProcess.waitFor();
            
            System.out.println(USERHOME);
            System.out.println(System.getProperty("user.dir"));
            System.out.println(System.getProperty("user.name"));
            
            if(processComplete == 0){
                System.out.println("Backup Complete.");
                //jLabel2.setText("Backup Complete.");
                
            }else{
                System.out.println("Backup Failure.");
            }
            
            System.exit(0);
    }
    
    public static void backupNoExit() throws IOException, InterruptedException{
        String USERHOME = System.getProperty("user.home");
        //String USERNAME = System.getProperty("user.name");
        String Backup = USERHOME + "\\Documents\\GitHub\\project-edgar\\backupData.bat";
            
            Process commandProcess = Runtime.getRuntime().exec(Backup);
            int processComplete = commandProcess.waitFor();
            
            System.out.println(USERHOME);
            System.out.println(System.getProperty("user.dir"));
            System.out.println(System.getProperty("user.name"));
            
            if(processComplete == 0){
                System.out.println("Backup Complete.");                
            }else{
                System.out.println("Backup Failure.");
            }
    }
}
