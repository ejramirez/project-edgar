
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class addCE extends javax.swing.JFrame {

    /**
     * Creates new form addCE
     */
    public addCE() {
        initComponents();
        campaign.removeAllItems();
        try {
             try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewDonations.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\Alexander\\Documents\\GitHub\\project-edgar\\Project-Edgar-Database.accdb",
                    "","");
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT CampaignTitle FROM Campaign");
            while(rs.next()) {
                campaign.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(addCE.class.getName()).log(Level.SEVERE, null, ex);
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

        backToMain = new javax.swing.JButton();
        addCampaignEvent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eventName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        moneyRaised = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campaign = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backToMain.setText("Back to Main!");
        backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });

        addCampaignEvent.setText("Add");
        addCampaignEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCampaignEventActionPerformed(evt);
            }
        });

        jLabel1.setText("Event Name");

        jLabel4.setText("Date");

        date.setText("MM/DD/YYYY");

        jLabel5.setText("Description");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel6.setText("Money Raised");

        jLabel7.setText("Campaign");

        campaign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campaign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campaignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToMain)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addCampaignEvent)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(11, 11, 11))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                    .addGap(5, 5, 5))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel2)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(moneyRaised, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campaign, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eventName)))))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backToMain)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(moneyRaised, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(campaign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(addCampaignEvent)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //button 1 - main
    private void backToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainActionPerformed
        this.setVisible(false); 
        new mainView().setVisible(true);
    }//GEN-LAST:event_backToMainActionPerformed
    //button 2 - add CE
    private void addCampaignEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCampaignEventActionPerformed
        try {
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(addCampaign.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con;
            con = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:\\Users\\Alexander\\Documents\\GitHub\\project-edgar\\Project-Edgar-Database.accdb",
                    "","");
            
            String insert = "INSERT INTO Events(EventName,EventDate,Description,MoneyRaised,CampaignTitle) Values(?,?,?,?,?)";
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            
            Date eDate = null;
            
            try {
                eDate = format.parse(date.getText());
            } catch (ParseException ex) {
                Logger.getLogger(addCampaign.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1,eventName.getText());
            ps.setTimestamp(2,new Timestamp(eDate.getTime()));
            ps.setString(3, description.getText());
            ps.setString(4,moneyRaised.getText());
            ps.setString(5, (String) campaign.getSelectedItem());
            ps.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(addCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(false);
        new mainView().setVisible(true);
    }//GEN-LAST:event_addCampaignEventActionPerformed

    private void campaignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campaignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campaignActionPerformed

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
            java.util.logging.Logger.getLogger(addCE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCampaignEvent;
    private javax.swing.JButton backToMain;
    private javax.swing.JComboBox campaign;
    private javax.swing.JTextField date;
    private javax.swing.JTextArea description;
    private javax.swing.JTextField eventName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField moneyRaised;
    // End of variables declaration//GEN-END:variables
}
