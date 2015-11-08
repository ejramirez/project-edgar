
import static com.sun.xml.internal.ws.api.pipe.Fiber.current;
import java.io.IOException;
import static java.util.concurrent.ThreadLocalRandom.current;
import com.dropbox.core.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        String USERNAME = System.getProperty("user.name");
        String USERDIR = System.getProperty("user.dir");
        System.out.println(USERDIR);
        
        String Backup = USERHOME + "\\Documents\\GitHub\\project-edgar\\backupData.bat"; //using this for now, will switch to backup3 when it's ready
        String Backup2 = USERNAME + "\\Documents\\GitHub\\project-edgar\\backupData.bat";
        String Backup3 = USERDIR + "\\backupData.bat"; //in order for this to work, move backup.bat to Fundit folder
        
        System.out.println(Backup3);
        
            Process commandProcess = Runtime.getRuntime().exec(Backup3);
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
    
    public static void dropboxSave() throws DbxException{
        try {
            // Getting app key and secret from the Dropbox developers website.
            final String APP_KEY = "adsnzii0iuy1n5a";
            final String APP_SECRET = "ekx1b9q6h32igxi";
            
            DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
            
            DbxRequestConfig config = new DbxRequestConfig(
                    "JavaTutorial/1.0", Locale.getDefault().toString());
            DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
            
            
            
            // Have the user sign in and authorize your app.
            String authorizeUrl = webAuth.start();
            //System.out.println("1. Go to: " + authorizeUrl);
            //System.out.println("2. Click \"Allow\" (you might have to log in first)");
            //System.out.println("3. Copy the authorization code.");
            //String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
            
            URL auth;
            auth = new URL(authorizeUrl);
            DesktopBrowse.openWebpage(auth);
            String code = JOptionPane.showInputDialog("1. A webpage asking you to allow to connect to dropbox will appear."
                    + "\n2. Click \"Allow\" (you might have to log in first).\n"
                    + "3. Copy the authorization code.\n4. Paste the code in the input field. (ctrl-v to paste)"
                    + "\n5. Please wait until uploading is done, the time that it is done in may vary depending on your internet connection.");
            
            // This will fail if the user enters an invalid authorization code.
            DbxAuthFinish authFinish = webAuth.finish(code);
            String accessToken = authFinish.accessToken;
            
            DbxClient client = new DbxClient(config, accessToken);
            
            System.out.println("Linked account: " + client.getAccountInfo().displayName);
            
            //file that is being uploaded
            String USERDIR = System.getProperty("user.dir");
            String dBackup = USERDIR + "\\Project-Edgar-Database.accdb"; //change the access file name when it's time to give the database to sean
            
            File inputFile = new File(dBackup);
            FileInputStream inputStream = new FileInputStream(inputFile);
            try {
                
                //check list
                List<String> filenames = new ArrayList<String>();
                DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
                System.out.println("Files in the root path:");
                for (DbxEntry child : listing.children) {
                    //System.out.println("	" + child.name + ": " + child.toString());
                    filenames.add(child.name);
                }
                System.out.println("Files in List:");
                for (String filename : filenames) {
                    System.out.println(filename);
                }
                //end of check list
                
                //Check if file exists, if not write a new one, else overwrite the old one
                
                //System.out.println("Overwriting...");
                DbxEntry.File OverwriteFile = client.uploadFile("/Project-Edgar-Database.accdb",
                DbxWriteMode.force(), inputFile.length(), inputStream);
                System.out.println("Uploaded: " + OverwriteFile.toString());
                        
                    
                //DbxEntry.File uploadedFile = client.uploadFile("/Project-Edgar-Database.accdb",
                //DbxWriteMode.add(), inputFile.length(), inputStream); //change DbxWriteMode to .force() to overwrite exisiting files
                
                //I would have to put the code to overwrite and existing file here
                //but first I would have to check if the file exists at all.
                //System.out.println("Uploaded: " + uploadedFile.toString());
            } finally {
                inputStream.close();
            }
            
            System.out.println("Upload Complete.");
            
        } catch (IOException ex) {
            Logger.getLogger(BackupExit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
