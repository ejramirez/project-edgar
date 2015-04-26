
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.text.MaskFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class viewDonations extends javax.swing.JFrame {
    

    /**
     * Creates new form viewDonations
     */
    public viewDonations() throws ParseException {
        initComponents();
        jFormattedTextField1.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);  
        jTextField3.setEnabled(false);
        dateMask1 = new MaskFormatter("####-##-##");
        dateMask1.install(jFormattedTextField1);
        dateMask2 = new MaskFormatter("####-##-##");
        dateMask2.install(jFormattedTextField2);
              
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Above");
        jComboBox2.addItem("Below");
        jComboBox1.removeAllItems();
         try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\data\\project-edgar\\Project-Edgar-Database.accdb",
                    "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
           //
                 Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CampaignTitle FROM Campaign");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
             jComboBox1.addItem(rs.getString(1));
            }
              con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Get Donations!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("By dates(YYYY-MM-DD)");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("View all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("Dollar Amount");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setText("YYYY-MM-DD");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setText("YYYY-MM-DD");
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("By Campaign");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("By Amount");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("To");

        jRadioButton4.setText(" By Amount ");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jTextField2.setText("Dollar Amount");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField3.setText("Dollar Amount");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Between ");

        jLabel3.setText("And");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton2))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jTextField2))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jRadioButton4))
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new mainView().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\data\\project-edgar\\Project-Edgar-Database.accdb",
                    "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
           //
            //
            if(jRadioButton1.isSelected()){
                Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CampaignTitle, "
                    + "Amount, DDate, Notes, "
                    + "EventName, EventDate FROM Donations");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
                  
            while (rs.next()) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date datemin = format.parse(jFormattedTextField1.getText());
            System.out.println("datemin"+datemin);
            Date datemax = format.parse(jFormattedTextField2.getText());
            System.out.println("datemax"+datemax);
            Date datetar = format.parse(rs.getString(3).substring(0,10));
            System.out.println("datetar"+datetar);
            if(datetar.after(datemin) && datetar.before(datemax)){
                            
                //Campaign Title
                  System.out.print(rs.getString(1) + " \n");
                  jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(3).substring(0,10) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(6).substring(0,10) + " \n");
                  
                   jTextArea1.append("\n");
            }
            }
            }
            
            //jRadioButton2
            if(jRadioButton2.isSelected()){            
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("SELECT CampaignTitle, "
                    + "Amount, DDate, Notes, "
                    + "EventName, EventDate FROM Donations");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
                  
            while (rs.next()) {
                
                if(jComboBox1.getSelectedItem().toString().equals(rs.getString(1))) {
                 //Campaign Title             
                  System.out.print(rs.getString(1) + " \n");
                  jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3) + " \n");
                   jTextArea1.append(rs.getString(3) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6) + " \n");
                   jTextArea1.append(rs.getString(6) + " \n");
                  
                   jTextArea1.append("\n");
            }
            }
            }
            
            // jRadioButton3
            if(jRadioButton3.isSelected()){
                Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CampaignTitle, "
                    + "Amount, DDate, Notes, "
                    + "EventName, EventDate FROM Donations");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
                  
            while (rs.next()) {
                
                if(Double.parseDouble(jTextField1.getText())<=Double.parseDouble(rs.getString(2))&&
                        Double.parseDouble(jTextField2.getText())>=Double.parseDouble(rs.getString(2))) {
                 //Campaign Title             
                  System.out.print(rs.getString(1) + " \n");
                  jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(3).substring(0,10) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(6).substring(0,10) + " \n");
                  
                   jTextArea1.append("\n");
            }
            }
            }
            //jRadioButton4
            if(jRadioButton4.isSelected()){
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("SELECT CampaignTitle, "
                    + "Amount, DDate, Notes, "
                    + "EventName, EventDate FROM Donations");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
                  
            while (rs.next()) {
                
                if(Double.parseDouble(jTextField3.getText())>=Double.parseDouble(rs.getString(2))&&
                        jComboBox2.getSelectedItem().toString().equals("Below")) {
                 //Campaign Title             
                  System.out.print(rs.getString(1) + " \n");
                  jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(3).substring(0,10) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(6).substring(0,10) + " \n");
                  
                   jTextArea1.append("\n");
            }
                else if(Double.parseDouble(jTextField3.getText())<=Double.parseDouble(rs.getString(2))&&
                        jComboBox2.getSelectedItem().toString().equals("Above")) {
                 //Campaign Title             
                  System.out.print(rs.getString(1) + " \n");
                  jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(3).substring(0,10) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(6).substring(0,10) + " \n");
                  
                   jTextArea1.append("\n");
            }
            }
            }
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextArea1.append("View All \n");
          try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\data\\project-edgar\\Project-Edgar-Database.accdb",
                    "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
           //
            //
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CampaignTitle, "
                    + "Amount, DDate, Notes, "
                    + "EventName, EventDate FROM Donations");
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while (rs.next()) {
                //Campaign Title
                   System.out.print(rs.getString(1) + " \n");
                   jTextArea1.append(rs.getString(1) + " \n");
                   
                //Amount, DDate   
                   System.out.print(rs.getString(2) + " ");
                   jTextArea1.append(rs.getString(2) + " ");
                   System.out.print(rs.getString(3).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(3).substring(0,10) + " \n");
                   
                //Notes
                   System.out.print(rs.getString(4) + " \n");
                   jTextArea1.append(rs.getString(4)+ " \n");
                   
                //Event Name, Event Date
                   System.out.print(rs.getString(5) + " ");
                   jTextArea1.append(rs.getString(5) + " ");
                   System.out.print(rs.getString(6).substring(0,10) + " \n");
                   jTextArea1.append(rs.getString(6).substring(0,10) + " \n");
                  
                   jTextArea1.append("\n");
            }
           //
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jFormattedTextField1.setEnabled(true);     
        jFormattedTextField2.setEnabled(true);   
        jTextField1.setEnabled(false); 
        jTextField2.setEnabled(false);  
        jTextField3.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
       // jTextArea2.append("Amount DDate Notes CampaignTitle PledgeID Event Name Event Date \n"); 
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    // TODO add your handling code here:
    jComboBox1.setEnabled(true);
    jComboBox2.setEnabled(false);
    jTextField2.setEnabled(false);  
    jTextField3.setEnabled(false);
    jFormattedTextField1.setEnabled(false);
    jFormattedTextField2.setEnabled(false);
    jTextField1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    // TODO add your handling code here:
    jTextField1.setEnabled(true);
    jTextField2.setEnabled(true);  
    jTextField3.setEnabled(false);
    jComboBox1.setEnabled(false);
    jComboBox2.setEnabled(false);
    jFormattedTextField1.setEnabled(false);
    jFormattedTextField2.setEnabled(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
    jTextField1.setEnabled(false);        
    jTextField2.setEnabled(false);  
    jTextField3.setEnabled(true);  
    jComboBox1.setEnabled(false);
    jComboBox2.setEnabled(true);
    jFormattedTextField1.setEnabled(false);
    jFormattedTextField2.setEnabled(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewDonations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDonations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDonations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDonations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewDonations().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private MaskFormatter dateMask1;
    private MaskFormatter dateMask2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
