
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.write.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class exportIndividualInfo extends javax.swing.JFrame {

    /**
     * Creates new form exportIndividualInfo
     */
    public exportIndividualInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Export to Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back to Export Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            
            String Fname, Minit, Lname;
            String Title;
            String PreferredHHName;
            String Street, City, State, Zipcode;
            String Phone, Email, Status, Solicitation;
            String pStreet, pCity, pState, pZipcode;
            String pPhone, pEmail;
            String DonorID;
            
            //Writing into an excel spreadsheet
            WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
            
            WritableSheet sheet = workbook.createSheet("Individual Donors",0);
            
            //Fonts
            WritableFont TimesNewRoman18pt = new WritableFont(WritableFont.TIMES,12);
            WritableCellFormat TimesNewRoman18ptFormat = new WritableCellFormat(TimesNewRoman18pt);
            
            //Headers
            Label FnameHeader = new Label(0,0,"First Name", TimesNewRoman18ptFormat);
            sheet.addCell(FnameHeader);
            
            Label MinitHeader = new Label(1,0,"Middle Initial", TimesNewRoman18ptFormat);
            sheet.addCell(MinitHeader);
            
            Label LnameHeader = new Label(2,0,"Last Name", TimesNewRoman18ptFormat);
            sheet.addCell(LnameHeader);
            
            Label TitleHeader = new Label(3,0,"Title", TimesNewRoman18ptFormat);
            sheet.addCell(TitleHeader);
            
            Label PHHNHeader = new Label(4,0,"PrefferredHHN Name", TimesNewRoman18ptFormat);
            sheet.addCell(PHHNHeader);
            
            Label StreetHeader = new Label(5,0,"Street Name", TimesNewRoman18ptFormat);
            sheet.addCell(StreetHeader);
            
            Label CityHeader = new Label(6,0,"City", TimesNewRoman18ptFormat);
            sheet.addCell(CityHeader);
            
            Label StateHeader = new Label(7,0,"State", TimesNewRoman18ptFormat);
            sheet.addCell(StateHeader);
            
            Label ZipHeader = new Label(8,0,"Zipcode", TimesNewRoman18ptFormat);
            sheet.addCell(ZipHeader);
            
            Label PhoneHeader = new Label(9,0,"Phone", TimesNewRoman18ptFormat);
            sheet.addCell(PhoneHeader);
            
            Label EmailHeader = new Label(10,0,"Email", TimesNewRoman18ptFormat);
            sheet.addCell(EmailHeader);
            
            Label StatusHeader = new Label(11,0,"Status", TimesNewRoman18ptFormat);
            sheet.addCell(StatusHeader);
            
            Label SolicitationHeader = new Label(12,0,"Solicitation", TimesNewRoman18ptFormat);
            sheet.addCell(SolicitationHeader);
            
            Label pStreetHeader = new Label(13,0,"pStreet", TimesNewRoman18ptFormat);
            sheet.addCell(pStreetHeader);
            
            Label pCityHeader = new Label(14,0,"pCity", TimesNewRoman18ptFormat);
            sheet.addCell(pCityHeader);
            
            Label pStateHeader = new Label(15,0,"pState", TimesNewRoman18ptFormat);
            sheet.addCell(pStateHeader);
            
             Label pZipHeader = new Label(16,0,"pZipcode", TimesNewRoman18ptFormat);
            sheet.addCell(pZipHeader);
            
             Label pPhoneHeader = new Label(17,0,"pPhone", TimesNewRoman18ptFormat);
            sheet.addCell(pPhoneHeader);
            
             Label pEmailHeader = new Label(18,0,"pEmail", TimesNewRoman18ptFormat);
            sheet.addCell(pEmailHeader);
            
            //Moving position
            int xPos = 0; //x-coord
            int yPos = 1;//y-coord
            //int cPos = 0;//Column Number
            
            //Pulling from the database
            try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\Eric\\Documents\\Github\\project-edgar\\Project-Edgar-Database.accdb",
                    "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT Fname, Minit, Lname,"
                    + "Title, PreferredHouseholdName, "
                    + "Street, "
                    + "City, State, ZipCode,"
                    + "Phone, "
                    + "EmailAddress,"
                    + "UserStatus, Solicitation,"
                    + "PreferredMailStreet,"
                    + "PreferredMailCity, PreferredMailState, PreferredMailZipCode,"
                    + "PreferredPhone, PreferredEmail, DonorID FROM Individual left outer join Donor on (Individual.DonorID = Donor.DonorID)"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Pulling the data
                
                Fname = rs.getString(1);
                Minit = rs.getString(2);
                Lname = rs.getString(3);
                Title = rs.getString(4);
                PreferredHHName = rs.getString(5);
                Street = rs.getString(6);
                City = rs.getString(7);
                State = rs.getString(8);
                Zipcode = rs.getString(9);
                Phone = rs.getString(10);
                Email = rs.getString(11);
                Status = rs.getString(12);
                Solicitation = rs.getString(13);
                pStreet = rs.getString(14);
                pCity = rs.getString(15);
                pState = rs.getString(16);
                pZipcode = rs.getString(17);
                pPhone = rs.getString(18);
                pEmail = rs.getString(19);
                
                //Setting x to the correct starting position
                xPos = 0;
                
                
                
            //Writing into the cells
            
            Label label1 = new Label(xPos,yPos,Fname);
            sheet.addCell(label1);
            xPos++;
            
            Label label2 = new Label(xPos,yPos,Minit);
            sheet.addCell(label2);
            xPos++;
            
            Label label3 = new Label(xPos,yPos,Lname);
            sheet.addCell(label3);
            xPos++;
            
            Label label4 = new Label(xPos,yPos,Title);
            sheet.addCell(label4);
            xPos++;
            
            Label label5 = new Label(xPos,yPos,PreferredHHName);
            sheet.addCell(label5);
            xPos++;
            
            Label label6 = new Label(xPos,yPos,Street);
            sheet.addCell(label6);
            xPos++;
            
            Label label7 = new Label(xPos,yPos,City);
            sheet.addCell(label7);
            xPos++;
            
            Label label8 = new Label(xPos,yPos,State);
            sheet.addCell(label8);
            xPos++;
            
            Label label9 = new Label(xPos,yPos,Zipcode);
            sheet.addCell(label9);
            xPos++;
            
            Label label10 = new Label(xPos,yPos,Phone);
            sheet.addCell(label10);
            xPos++;
            
            Label label11 = new Label(xPos,yPos,Email);
            sheet.addCell(label11);
            xPos++;
            
            Label label12 = new Label(xPos,yPos,Status);
            sheet.addCell(label12);
            xPos++;
            
            Label label13 = new Label(xPos,yPos,Solicitation);
            sheet.addCell(label13);
            xPos++;
            
            Label label14 = new Label(xPos,yPos,pStreet);
            sheet.addCell(label14);
            xPos++;
            
            Label label15 = new Label(xPos,yPos,pCity);
            sheet.addCell(label15);
            xPos++;
            
            Label label16 = new Label(xPos,yPos,pState);
            sheet.addCell(label16);
            xPos++;
            
            Label label17 = new Label(xPos,yPos,pZipcode);
            sheet.addCell(label17);
            xPos++;
            
            Label label18 = new Label(xPos,yPos,pPhone);
            sheet.addCell(label18);
            xPos++;
            
            Label label19 = new Label(xPos,yPos,pEmail);
            sheet.addCell(label19);
            xPos++;
            
            
                
            yPos++;
                    
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            
            
            
            workbook.write();
            workbook.close();
            
            
        } catch (IOException | WriteException ex) {
            Logger.getLogger(exportIndividualInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); 
        new exportMenu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(exportIndividualInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exportIndividualInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exportIndividualInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(exportIndividualInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new exportIndividualInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
