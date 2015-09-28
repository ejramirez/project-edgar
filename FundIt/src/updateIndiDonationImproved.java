
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class updateIndiDonationImproved extends javax.swing.JFrame {

    /**
     * Creates new form updateIndiDonationImproved
     */
    public updateIndiDonationImproved() {
        initComponents();
        
        
        //jComboBox1.removeAllItems();
        //jComboBox2.removeAllItems();
        
        //jComboBox1.removeItem("Item 1");
        jComboBox1.removeItem("Item 2");
        jComboBox1.removeItem("Item 3");
        jComboBox1.removeItem("Item 4");
        
        //jComboBox2.removeItem("Item 1");
        jComboBox2.removeItem("Item 2");
        jComboBox2.removeItem("Item 3");
        jComboBox2.removeItem("Item 4");
        
        //jComboBox1.addItem("(Select Donor)");
        
        jComboBox5.removeAllItems();
        jComboBox5.addItem("");
        
        jComboBox6.removeAllItems();
        jComboBox6.addItem("");
        
        //jComboBox2.addItem("(ID)");
        jComboBox2.setBackground(Color.lightGray);
        jComboBox2.setEditable(false);
        jComboBox2.setEnabled(false);
        
        jComboBox4.setBackground(Color.lightGray);
        jComboBox4.setEditable(false);
        jComboBox4.setEnabled(false);
        
        //Donation ComboBox
        jComboBox3.removeItem("Item 2");
        jComboBox3.removeItem("Item 3");
        jComboBox3.removeItem("Item 4");
        
        jComboBox4.removeItem("Item 2");
        jComboBox4.removeItem("Item 3");
        jComboBox4.removeItem("Item 4");
        
        
        
        //Getting Donor Names and ID's
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT Fname, Minit, Lname, "
                    + "DonorID FROM Individual"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Fname, Minit, Lname
                System.out.print(rs.getString(1) + " ");
                jComboBox1.addItem(rs.getString(1) + ", " + rs.getString(2) + " " + rs.getString(3));
                System.out.print(rs.getString(4));
                jComboBox2.addItem(rs.getString(4));
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print(jComboBox2.getSelectedItem().toString() + "; " + jComboBox1.getSelectedItem().toString());
        
        
        //Pulling Campaigns
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT CampaignTitle"
                    + " FROM Campaign"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Fname, Minit, Lname
                System.out.print(rs.getString(1));
                jComboBox5.addItem(rs.getString(1));
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pulling Events
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT EventName"
                    + " FROM Events"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Event Names
                System.out.print(rs.getString(1));
                jComboBox6.addItem(rs.getString(1));
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jTextField1.setColumns(7);
        jTextField2.setColumns(7);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Back To Donation Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pull Donations");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Pull Donation Info");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount:");

        jLabel2.setText("CheckID:");

        jLabel3.setText("Date of Donation:");

        jLabel5.setText("Notes");

        jLabel6.setText("Campaign:");

        jLabel7.setText("Event:");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Help");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jLabel8)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        jLabel8.setText("");
        jComboBox2.setSelectedIndex(jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        new updateDonationMenu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        //jTextField1.removeAll();
        //jTextField2.removeAll();
        //jTextField3.removeAll();
        //jTextField4.removeAll();
        
        jComboBox3.removeAllItems();
        jComboBox3.addItem("Item 1");
        
        jComboBox4.removeAllItems();
        jComboBox4.addItem("Item 1");
        
        String DonorID = jComboBox2.getSelectedItem().toString();
        
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT Amount, "
                    + " DonationID"
                    + " FROM Donations WHERE (Donations.DonorID = " + DonorID + ")"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                jComboBox3.addItem(rs.getString(1)); //Amount
                jComboBox4.addItem(rs.getString(2)); //DonationID
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        jLabel8.setText("");
        jComboBox4.setSelectedIndex(jComboBox3.getSelectedIndex());
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        jTextField1.removeAll();
        jTextField2.removeAll();
        jTextField3.removeAll();
        jTextField4.removeAll();
        
        String DonationID = jComboBox4.getSelectedItem().toString();
        String DonorID = jComboBox2.getSelectedItem().toString();
        
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();  
            System.out.println("Connection to DB established...");
            
            ResultSet rs = s.executeQuery("SELECT Amount, DDate, Notes, "
                    + "CampaignTitle, EventName, CheckID, DonationID"
                    + " FROM Donations WHERE (Donations.DonorID = " + DonorID + ") AND (Donations.DonationID = " + DonationID + ")"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                jTextField1.setText(rs.getString(1)); //Amount
                jTextField3.setText(rs.getString(2)); //Donation Date
                jTextField4.setText(rs.getString(3)); //Notes
                
                System.out.print(rs.getString(4) + " ");
                jComboBox5.setSelectedItem(rs.getString(4)); //Campaign Title
                
                System.out.print(rs.getString(5) + " ");
                jComboBox6.setSelectedItem(rs.getString(5)); //Event Name
                
                System.out.print(rs.getString(6) + " ");
                jTextField2.setText(rs.getString(6)); //CheckID
                
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
        //String Camp = jComboBox5.getSelectedItem().toString();
        
        /*
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
            
            ResultSet rs = s.executeQuery("SELECT EventName, CampaignTitle"
                    + " FROM Events WHERE (CampaignTitle = " + Camp + ")"); 
            
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Fname, Minit, Lname
                System.out.print(rs.getString(1) + " ");
                jComboBox6.addItem(rs.getString(1));
                
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        //Getting everything from the Textfields and comboboxes
        String Amounts, DDate, Notes, CampaignTitle, EventName, CheckID;
        String DonorID, DonationID;
        
        Amounts = jTextField1.getText();
        CheckID = jTextField2.getText();
        DDate = jTextField3.getText();
        Notes = jTextField4.getText();
        
        CampaignTitle = jComboBox5.getSelectedItem().toString();
        EventName = jComboBox6.getSelectedItem().toString();
        
        DonorID = jComboBox2.getSelectedItem().toString(); 
        DonationID = jComboBox4.getSelectedItem().toString();
        
        StringCC str = new StringCC();
        Float Amount = Float.parseFloat(str.CleanUp(Amounts));
        
        //Start of Connection
        //This is how UPDATES in UCANACCESS are done.
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonors.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();
            
            System.out.println("Connection to DB established...");
            
            s.executeUpdate("UPDATE [Donations] SET " //also remember to space everything correctly, program was reading SETIND instead of SET IND
                    + "Donations.Amount = " + "'" + Amount + "',"
                    + "Donations.CheckID = " + "'" + CheckID + "',"
                    + "Donations.DDate = " + "'" + DDate + "',"
                    + "Donations.Notes = " + "'" + Notes + "',"
                    + "Donations.CampaignTitle = " + "'" + CampaignTitle + "',"
                    + "Donations.EventName = " + "'" + EventName + "' " 
                    + "WHERE (Donations.DonorID = '" + DonorID + "') AND (Donations.DonationID = '" + DonationID + "')");
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            System.out.println("Update Executed.");
            
            con.commit();
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jLabel8.setText("Updated.");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JOptionPane Help = new JOptionPane();
        JOptionPane.showMessageDialog(this, "Choose a Donor you wish to update. Once you choose a donor the program will"
                + "then pull the donor's donation data, which will appear on \nthe second dropdown menu."
                + "You may then choose a donation from the currently selected donor, then push the Pull Donation Info "
                + "button.\nOnce this happens the Donation info will show up in the empty textfields and dropdown menus."
                + " From here you can then modify the donation\ncontents. Then press Update to update the database with"
                + " the new data you just put in.\n\nFor more information please take a look at the extended manual.");
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(updateIndiDonationImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateIndiDonationImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateIndiDonationImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateIndiDonationImproved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateIndiDonationImproved().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
