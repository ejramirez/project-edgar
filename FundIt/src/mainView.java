
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */

public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        String instructions = "Below you will find all the documentation that you will need in order to navigate around "
                + "the application and understand all if its functionality. It's highly recommended that you thoroughly read this guide! If a t"
                + "any point you are confused on some aspect of the application make sure to come back to this menu and find the solution "
                + "to your confusion here. \n"
                + "------------------------------------------------------------------------------------------------------------------------";
        this.documentation.setText("");
        this.documentation.setBackground(Color.white);
        this.documentation.setText(instructions);
        this.documentation.setEnabled(true);
        this.documentation.setEditable(false);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentation = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        viewEvents = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(3000, 3000));

        jButton1.setText("View Donations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Donations");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add Campaign");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View Campaign");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add Campaign Event");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("View Donors");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        documentation.setColumns(20);
        documentation.setLineWrap(true);
        documentation.setRows(5);
        documentation.setWrapStyleWord(true);
        documentation.setEnabled(false);
        jScrollPane1.setViewportView(documentation);

        jButton8.setText("Add Donor");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Welcome to $cotTrak!");
        jLabel1.setMaximumSize(new java.awt.Dimension(175, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(175, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(175, 22));

        jButton6.setText("Export to Text File");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        viewEvents.setText("View Events");
        viewEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventsActionPerformed(evt);
            }
        });

        jButton9.setText("Update Info");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Export Menu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Exit Program");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewEvents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        try {
            new viewDonations().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //button 2 - add donation(s)
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false); 
        new addDonation().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false); 
        new addCE().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        new viewDonors().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
    //button 3 - add campaign
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false); 
        new addCampaign().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    //button 4 - view campaign
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false); 
        new viewCampaign().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false); 
        new addDonor().setVisible(true); 
    }//GEN-LAST:event_jButton8ActionPerformed
     
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         ArrayList<ArrayList<String>> R1= new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> R2= new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> R3= new ArrayList<ArrayList<String>>();
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
           // con = DriverManager.getConnection(
             //       "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\data\\project-edgar\\Project-Edgar-Database.accdb",
               //     "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
           con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\project-edgar\\Project-Edgar-Database.accdb",
                    "","");
            //
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT Fname, Minit, Lname,"
                    + "Title, PreferredHouseholdName, "
                    + "Street, "
                    + "City, State, ZipCode,"
                    + "Phone, "
                    + "EmailAddress,"
                    + "UserStatus, Solicitation,"
                    + "PreferredMailStreet,"
                    + "PreferredMailCity, PreferredMailState, PreferredMailZipCode,"
                    + "PreferredPhone, PreferredEmail FROM Individual left outer join Donor on (Individual.DonorID = Donor.DonorID)");

            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            jTextArea1.setText(null); 
             while (rs.next()) {
                  ArrayList<String> temprs= new ArrayList<String>();  
                temprs.add(rs.getString(1));
                temprs.add(rs.getString(2));
                temprs.add(rs.getString(3));
                temprs.add(rs.getString(4));
                temprs.add(rs.getString(5));
                temprs.add(rs.getString(6));
                temprs.add(rs.getString(7));
                temprs.add(rs.getString(8));
                temprs.add(rs.getString(9));
                temprs.add(rs.getString(10));
                temprs.add(rs.getString(11));
                temprs.add(rs.getString(12));
                temprs.add(rs.getString(13));
                temprs.add(rs.getString(14));
                temprs.add(rs.getString(15));
                temprs.add(rs.getString(16));
                temprs.add(rs.getString(17));
                temprs.add(rs.getString(18));
                
                R1.add(temprs);                  
            }
             
            ResultSet Rs = s.executeQuery("SELECT OrgName, PrimaryContact,"
                    + "Street, "
                    + "City, State, ZipCode,"
                    + "Phone, "
                    + "EmailAddress,"
                    + "UserStatus, Solicitation,"
                    + "PreferredMailStreet,"
                    + "PreferredMailCity, PreferredMailState, PreferredMailZipCode,"
                    + "PreferredPhone, PreferredEmail FROM Corporate_Organization left outer join Donor on (Corporate_Organization.DonorID = Donor.DonorID)");
           
            while (Rs.next()) {
                  ArrayList<String> temprs= new ArrayList<String>();  
                temprs.add(Rs.getString(1));
                temprs.add(Rs.getString(2));
                temprs.add(Rs.getString(3));
                temprs.add(Rs.getString(4));
                temprs.add(Rs.getString(5));
                temprs.add(Rs.getString(6));
                temprs.add(Rs.getString(7));
                temprs.add(Rs.getString(8));
                temprs.add(Rs.getString(9));
                temprs.add(Rs.getString(10));
                temprs.add(Rs.getString(11));
                temprs.add(Rs.getString(12));
                temprs.add(Rs.getString(13));
                temprs.add(Rs.getString(14));
                temprs.add(Rs.getString(15));
                temprs.add(Rs.getString(16));                
                R2.add(temprs);                  
            }
             ResultSet Result = s.executeQuery("SELECT GrantName, GrantNumber, "
                    + "StartDate, EndDate, NextReportDate, "
                    + "Street, "
                    + "City, State, ZipCode,"
                    + "Phone, "
                    + "EmailAddress, "
                    + "UserStatus, Solicitation,"
                    + "PreferredMailStreet,"
                    + "PreferredMailCity, PreferredMailState, PreferredMailZipCode,"
                    + "PreferredPhone, PreferredEmail FROM Grant left outer join Donor on (Grant.DonorID = Donor.DonorID)");
             
            while (Result.next()) {
                  ArrayList<String> temprs= new ArrayList<String>();  
                temprs.add(Result.getString(1));
                temprs.add(Result.getString(2));
                temprs.add(Result.getString(3));
                temprs.add(Result.getString(4));
                temprs.add(Result.getString(5));
                temprs.add(Result.getString(6));
                temprs.add(Result.getString(7));
                temprs.add(Result.getString(8));
                temprs.add(Result.getString(9));
                temprs.add(Result.getString(10));
                temprs.add(Result.getString(11));
                temprs.add(Result.getString(12));
                temprs.add(Result.getString(13));
                temprs.add(Result.getString(14));
                temprs.add(Result.getString(15));
                temprs.add(Result.getString(16));
                temprs.add(Result.getString(17));
                temprs.add(Result.getString(18));
                temprs.add(Result.getString(19));
                R3.add(temprs);                  
            }
           FileOutputStream fop = null;
		File file;
		String content; 
      try {
			file = new File("C:\\Users\\aung\\Desktop\\project-edgar\\EXPORT.txt");
			fop = new FileOutputStream(file);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
        
        
         for(ArrayList<String> x : R1){   
            for(int i=0;i<x.size();i++){
         content = x.get(i);
          byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
                        fop.write('\n');
            }
            fop.write('\n');
            fop.write('\n');
         }
         for(ArrayList<String> x : R2){   
            for(int i=0;i<x.size();i++){
         content = x.get(i);
          byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
                        fop.write('\n');
            }
            fop.write('\n');
            fop.write('\n');
         }
         for(ArrayList<String> x : R3){   
            for(int i=0;i<x.size();i++){
         content = x.get(i);
          byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
                        fop.write('\n');
            }
            fop.write('\n');
            fop.write('\n');
         }
         fop.flush();
         fop.close();
         } catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
		}
			} catch (IOException e) {
				e.printStackTrace();
                        }
                }
        con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.append("Export to Text File is done");
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void viewEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventsActionPerformed
        this.setVisible(false);
        new viewEvents().setVisible(true);
    }//GEN-LAST:event_viewEventsActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); 
        new updateInfo().setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); 
        new exportMenu().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            // TODO add your handling code here:
            /*
            CodeSource codeSource = mainView.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            
            String dbName = "C:\\users\\Eric\\Documents\\GitHub\\project-edgar\\Project-Edgar-Database.accdb";
            String dbUser = "";
            String dbPass = "";
            
            String folderPath = jarDir + "\\backup";
            
            File f1 = new File(folderPath);
            f1.mkdir();
            
            String savePath = "\"" + jarDir + "\\backup\\" + "backup.accdb\"";
            
            String executeCmd = "copy " + dbName + " " + savePath;
            */       
            
            //This block of code creates a backup for the database by executing a batch file within
            //the folders of the program
            /*
            String Backup = "C:\\Users\\Eric\\Documents\\GitHub\\project-edgar\\backupData.bat";
            
            Process commandProcess = Runtime.getRuntime().exec(Backup);
            int processComplete = commandProcess.waitFor();
            
            if(processComplete == 0){
                System.out.println("Backup Complete.");
                jLabel2.setText("Backup Complete.");
                
            }else{
                System.out.println("Backup Failure.");
            }
            
            System.exit(0);
            */
            BackupExit.initialize();
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed
    

        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea documentation;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton viewEvents;
    // End of variables declaration//GEN-END:variables

}
