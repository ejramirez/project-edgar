
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class viewEvents extends javax.swing.JFrame {
    
    public viewEvents() {
        initComponents();
        this.campaigns.removeAllItems();
        this.events.removeAllItems();
        this.textArea.setEditable(false);
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
            rs = this.st.executeQuery("SELECT EventName FROM Events");
            while (rs.next()) {
                this.events.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(addCE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewEvents.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        viewAllEvents = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        events = new javax.swing.JComboBox();
        viewEvent = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        backToMain = new javax.swing.JButton();
        clearTextArea = new javax.swing.JButton();
        campaigns = new javax.swing.JComboBox();
        eventByCampaign = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        viewAllEvents.setText("View All Events");
        viewAllEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllEventsActionPerformed(evt);
            }
        });

        events.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        viewEvent.setText("View Event");
        viewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventActionPerformed(evt);
            }
        });

        backToMain.setText("Back to Main");
        backToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });

        clearTextArea.setText("Clear Text Area");
        clearTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextAreaActionPerformed(evt);
            }
        });

        campaigns.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eventByCampaign.setText("View Event");
        eventByCampaign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventByCampaignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(events, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(viewAllEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campaigns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(eventByCampaign))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(viewEvent)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearTextArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backToMain)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewAllEvents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(events, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewEvent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campaigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eventByCampaign))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToMain)
                    .addComponent(clearTextArea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextAreaActionPerformed
        this.textArea.setText("");
    }//GEN-LAST:event_clearTextAreaActionPerformed

    private void backToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainActionPerformed
        this.setVisible(false);
        new mainView().setVisible(true);
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(viewEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backToMainActionPerformed

    private void viewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventActionPerformed
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Events WHERE Events.EventName LIKE '" + this.events.getSelectedItem().toString() + "' ");
            while (rs.next()) {
                this.textArea.append("EVENT NAME: " + rs.getString(1) + " \n");
                this.textArea.append("DATE: " + rs.getString(2).substring(0,10) + " \n");
                this.textArea.append("DESCRIPTION: " + rs.getString(3) + " \n");
                this.textArea.append("MONEY RAISED: $" + rs.getString(4) + " \n");
                this.textArea.append("CAMPAIGN TITLE: " + rs.getString(5) + " \n");
                this.textArea.append("-------------------------------" 
                              + "-------------------------------"
                              + "-------------------------------" + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewEventActionPerformed

    private void eventByCampaignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventByCampaignActionPerformed
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Events WHERE Events.CampaignTitle LIKE '" + this.campaigns.getSelectedItem().toString() + "' ");
            while (rs.next()) {
                this.textArea.append("EVENT NAME: " + rs.getString(1) + " \n");
                this.textArea.append("DATE: " + rs.getString(2).substring(0,10) + " \n");
                this.textArea.append("DESCRIPTION: " + rs.getString(3) + " \n");
                this.textArea.append("MONEY RAISED: $" + rs.getString(4) + " \n");
                this.textArea.append("CAMPAIGN TITLE: " + rs.getString(5) + " \n");
                this.textArea.append("-------------------------------" 
                              + "-------------------------------"
                              + "-------------------------------" + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eventByCampaignActionPerformed

    private void viewAllEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllEventsActionPerformed
        try {
            ResultSet rs = this.st.executeQuery("SELECT * FROM Events");
            while (rs.next()) {
                this.textArea.append("EVENT NAME: " + rs.getString(1) + " \n");
                this.textArea.append("DATE: " + rs.getString(2).substring(0,10) + " \n");
                this.textArea.append("DESCRIPTION: " + rs.getString(3) + " \n");
                this.textArea.append("MONEY RAISED: $" + rs.getString(4) + " \n");
                this.textArea.append("CAMPAIGN TITLE: " + rs.getString(5) + " \n");
                this.textArea.append("-------------------------------" 
                              + "-------------------------------"
                              + "-------------------------------" + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewCampaign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewAllEventsActionPerformed

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
            java.util.logging.Logger.getLogger(viewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewEvents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMain;
    private javax.swing.JComboBox campaigns;
    private javax.swing.JButton clearTextArea;
    private javax.swing.JButton eventByCampaign;
    private javax.swing.JComboBox events;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton viewAllEvents;
    private javax.swing.JButton viewEvent;
    // End of variables declaration//GEN-END:variables
    private Connection con;
    private Statement st;
}
