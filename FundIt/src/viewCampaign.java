
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class viewCampaign extends javax.swing.JFrame {

    /**
     * Creates new form viewCampaign
     */
    public viewCampaign() throws IOException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.textArea.setEditable(false);
        this.campaigns.removeAllItems();
        String DBLoc1 = "jdbc:ucanaccess:///Users/Alexander/Documents/Projects/Project-Edgar/Project-Edgar-Database.accdb"; // Alex
        String DBLoc2 = "jdbc:ucanaccess://C:\\Users\\Owner\\Desktop\\project-edgar\\Project-Edgar-Database.accdb"; // Mercedes
        String DBLoc3 = "jdbc:ucanaccess://C:\\Users\\aung\\Desktop\\project-edgar\\Project-Edgar-Database.accdb"; // Aung
        String DBLoc4 = "jcbc:ucanaccess://C:"; // Alissa (Insert Location)
        String DBLoc5 = "jdbc:ucanaccess://C:"; // Eric (Insert Location)
        String MainDBLoc = "jdbc:ucanaccess://C:"; // Warren Achievement (Insert Location)
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            this.con = DriverManager.getConnection(
                    DBcon.Connect(),
                    DBcon.Login(), DBcon.Pass()); // DATABASE LOCATION          
            this.st = this.con.createStatement();
            ResultSet rs = this.st.executeQuery("SELECT CampaignTitle FROM Campaign");
            while(rs.next()) {
                this.campaigns.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(addCE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
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

        viewCampaigns = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        clearText = new javax.swing.JButton();
        backToMain = new javax.swing.JButton();
        campaigns = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        viewSpecificCampaign = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewCampaigns.setText("View All Campaigns");
        viewCampaigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCampaignsActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        clearText.setText("Clear Text Area");
        clearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextActionPerformed(evt);
            }
        });

        backToMain.setText("Back to Main");
        backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });

        campaigns.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campaigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campaignsActionPerformed(evt);
            }
        });

        viewSpecificCampaign.setText("View Campaign");
        viewSpecificCampaign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSpecificCampaignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(viewCampaigns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campaigns, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewSpecificCampaign))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                        .addComponent(backToMain))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewCampaigns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campaigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewSpecificCampaign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToMain)
                    .addComponent(clearText))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   //button 2 - show campaigns
    private void viewCampaignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCampaignsActionPerformed
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Campaign");
            while (rs.next()) {
                textArea.append("CAMPAIGN TITLE: " + rs.getString(1) + " \n");
                textArea.append("START DATE: " + rs.getString(2).substring(0,10) + " \n");
                textArea.append("END DATE: " + rs.getString(3).substring(0,10) + " \n");
                textArea.append("FINANCIAL GOAL: $" + rs.getString(4) + " \n");
                textArea.append("DESCRIPTION: " + rs.getString(5) + " \n");
                textArea.append("-------------------------------"
                        + "-------------------------------"
                        + "-------------------------------" + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewCampaignsActionPerformed

    private void clearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextActionPerformed
        this.textArea.setText("");
    }//GEN-LAST:event_clearTextActionPerformed

    private void backToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainActionPerformed
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        new mainView().setVisible(true);
    }//GEN-LAST:event_backToMainActionPerformed

    private void campaignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campaignsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campaignsActionPerformed

    private void viewSpecificCampaignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSpecificCampaignActionPerformed
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Campaign WHERE Campaign.CampaignTitle LIKE '" + this.campaigns.getSelectedItem().toString() + "' ");
            while (rs.next()) {
                this.textArea.append("CAMPAIGN TITLE: " + rs.getString(1) + " \n");
                this.textArea.append("START DATE: " + rs.getString(2).substring(0,10) + " \n");
                this.textArea.append("END DATE: " + rs.getString(3).substring(0,10) + " \n");
                this.textArea.append("FINANCIAL GOAL: $" + rs.getString(4) + " \n");
                this.textArea.append("DESCRIPTION: " + rs.getString(5) + " \n");
                this.textArea.append("-------------------------------" 
                              + "-------------------------------"
                              + "-------------------------------" + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewSpecificCampaignActionPerformed

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
            java.util.logging.Logger.getLogger(viewCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewCampaign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewCampaign().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMain;
    private javax.swing.JComboBox campaigns;
    private javax.swing.JButton clearText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton viewCampaigns;
    private javax.swing.JButton viewSpecificCampaign;
    // End of variables declaration//GEN-END:variables
    private Connection con; 
    private Statement st;
}
