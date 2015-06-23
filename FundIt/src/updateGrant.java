
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * @author Eric
 */
public class updateGrant extends javax.swing.JFrame {

    /**
     * Creates new form updateIndDonor
     */
    
    
    public updateGrant() {
        initComponents();
        
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();
        String selectDonor = "(Select Donor)";
        jComboBox5.addItem(selectDonor);
        
        jComboBox7.removeAllItems();
        jComboBox7.addItem("");
        jComboBox7.setBackground(Color.lightGray);
        jComboBox7.setEditable(false);
        jComboBox7.setEnabled(false);
        
        
        //This is to pull all the names of the donors from the database, this has to be done before the frame appears.
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
                
                //Fname, Minit, Lname
                System.out.print(rs.getString(1) + " ");
                jComboBox5.addItem(/*rs.getString(20) + "     , " +*/ rs.getString(1) + ", " + rs.getString(3) + " " + rs.getString(2));
                System.out.print(rs.getString(20));
                jComboBox7.addItem(rs.getString(20));
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //This needs to be added, when the database connection is done if the program sees that it is one of these instead of pulling from the
        //database it will instead compare itself to these until it finds the one that it's equal to which will then be used in the updates
        jComboBox1.addItem(" ");
        jComboBox1.addItem("Ms");
        jComboBox1.addItem("Miss");
        jComboBox1.addItem("Mrs");
        jComboBox1.addItem("Mr");
        jComboBox1.addItem("Prof.");
        jComboBox1.addItem("Dr");
        jComboBox1.addItem("Rev.");
        
        jComboBox2.addItem(" ");
        jComboBox2.addItem("AL");
        jComboBox2.addItem("AK");
        jComboBox2.addItem("AZ");
        jComboBox2.addItem("AR");
        jComboBox2.addItem("CA");
        jComboBox2.addItem("CO");
        jComboBox2.addItem("CT");
        jComboBox2.addItem("DE");
        jComboBox2.addItem("FL");
        jComboBox2.addItem("GA");
        jComboBox2.addItem("HI");
        jComboBox2.addItem("ID");
        jComboBox2.addItem("IL");
        jComboBox2.addItem("IN");
        jComboBox2.addItem("IO");
        jComboBox2.addItem("KS");
        jComboBox2.addItem("KY");
        jComboBox2.addItem("LA");
        jComboBox2.addItem("ME");
        jComboBox2.addItem("MD");
        jComboBox2.addItem("MA");
        jComboBox2.addItem("MI");
        jComboBox2.addItem("MN");
        jComboBox2.addItem("MS");
        jComboBox2.addItem("MO");
        jComboBox2.addItem("MT");
        jComboBox2.addItem("NE");
        jComboBox2.addItem("NV");
        jComboBox2.addItem("NH");
        jComboBox2.addItem("NJ");
        jComboBox2.addItem("NM");
        jComboBox2.addItem("NY");
        jComboBox2.addItem("NC");
        jComboBox2.addItem("ND");
        jComboBox2.addItem("OH");
        jComboBox2.addItem("OK");
        jComboBox2.addItem("OR");
        jComboBox2.addItem("PA");
        jComboBox2.addItem("RI");
        jComboBox2.addItem("SC");
        jComboBox2.addItem("SD");
        jComboBox2.addItem("TN");
        jComboBox2.addItem("TX");
        jComboBox2.addItem("UT");
        jComboBox2.addItem("VT");
        jComboBox2.addItem("VA");
        jComboBox2.addItem("WA");
        jComboBox2.addItem("WV");
        jComboBox2.addItem("WI");
        jComboBox2.addItem("WY");
        
        jComboBox3.addItem(" ");
        jComboBox3.addItem("Active");
        jComboBox3.addItem("Inactive");
        jComboBox3.addItem("Deceased");
        
        jComboBox4.addItem(" ");
        jComboBox4.addItem("TRUE");
        jComboBox4.addItem("FALSE");
        
        jComboBox6.addItem(" ");
        jComboBox6.addItem("AL");
        jComboBox6.addItem("AK");
        jComboBox6.addItem("AZ");
        jComboBox6.addItem("AR");
        jComboBox6.addItem("CA");
        jComboBox6.addItem("CO");
        jComboBox6.addItem("CT");
        jComboBox6.addItem("DE");
        jComboBox6.addItem("FL");
        jComboBox6.addItem("GA");
        jComboBox6.addItem("HI");
        jComboBox6.addItem("ID");
        jComboBox6.addItem("IL");
        jComboBox6.addItem("IN");
        jComboBox6.addItem("IO");
        jComboBox6.addItem("KS");
        jComboBox6.addItem("KY");
        jComboBox6.addItem("LA");
        jComboBox6.addItem("ME");
        jComboBox6.addItem("MD");
        jComboBox6.addItem("MA");
        jComboBox6.addItem("MI");
        jComboBox6.addItem("MN");
        jComboBox6.addItem("MS");
        jComboBox6.addItem("MO");
        jComboBox6.addItem("MT");
        jComboBox6.addItem("NE");
        jComboBox6.addItem("NV");
        jComboBox6.addItem("NH");
        jComboBox6.addItem("NJ");
        jComboBox6.addItem("NM");
        jComboBox6.addItem("NY");
        jComboBox6.addItem("NC");
        jComboBox6.addItem("ND");
        jComboBox6.addItem("OH");
        jComboBox6.addItem("OK");
        jComboBox6.addItem("OR");
        jComboBox6.addItem("PA");
        jComboBox6.addItem("RI");
        jComboBox6.addItem("SC");
        jComboBox6.addItem("SD");
        jComboBox6.addItem("TN");
        jComboBox6.addItem("TX");
        jComboBox6.addItem("UT");
        jComboBox6.addItem("VT");
        jComboBox6.addItem("VA");
        jComboBox6.addItem("WA");
        jComboBox6.addItem("WV");
        jComboBox6.addItem("WI");
        jComboBox6.addItem("WY");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Preferred HH Name:");

        jLabel3.setText("Street:");

        jLabel4.setText("City:");

        jLabel5.setText("Phone:");

        jLabel6.setText("Email:");

        jLabel7.setText("Status:");

        jLabel8.setText("Solicitation:");

        jTextField1.setText("jTextField1");
        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jLabel9.setText("Title:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jLabel10.setText("State:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Zip:");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton1.setText("Back to Update Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Select Donor:");

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

        jLabel13.setText("Preffered Street:");

        jLabel14.setText("Preffered City:");

        jLabel15.setText("Preffered Phone:");

        jLabel16.setText("Preffered Email:");

        jTextField10.setText("jTextField10");

        jTextField11.setText("jTextField11");

        jTextField12.setText("jTextField12");

        jTextField13.setText("jTextField13");

        jLabel17.setText("State:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel18.setText("Zipcode:");

        jTextField14.setText("jTextField14");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("DonorID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jTextField9)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new updateInfo().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        //Getting everything from the Textfields and comboboxes
        String Fname, Minit, Lname;
        String Title;
        String PreferredHHName;
        String Street, City, State, Zipcode;
        String Phone, Email, Status, Solicitation;
        String pStreet, pCity, pState, pZipcode;
        String pPhone, pEmail;
        String DonorID;
        
        Fname = jTextField1.getText();
        Minit = jTextField2.getText();
        Lname = jTextField3.getText();
        PreferredHHName = jTextField4.getText();
        
        Street = jTextField5.getText();
        City = jTextField6.getText();
        Zipcode = jTextField7.getText();
        
        Phone = jTextField8.getText();
        Email = jTextField9.getText();
        
        pStreet = jTextField10.getText();
        pCity = jTextField11.getText();
        pZipcode = jTextField14.getText();
        
        pPhone = jTextField12.getText();
        pEmail = jTextField13.getText();
        
        Title = jComboBox1.getSelectedItem().toString();
        State = jComboBox2.getSelectedItem().toString();
        Status = jComboBox3.getSelectedItem().toString();
        Solicitation = jComboBox4.getSelectedItem().toString();
        pState = jComboBox6.getSelectedItem().toString();
        
        DonorID = jComboBox7.getSelectedItem().toString(); //jComboBox5.getSelectedItem().toString().substring(0, 5);
        
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
                    "jdbc:ucanaccess://C:\\Users\\Eric\\Documents\\GitHub\\project-edgar\\Project-Edgar-Database.accdb",
                    "", ""); //(file path, db login, db password) - since it doesnt have a login, leave it blank
          
            Statement s = con.createStatement();
            
            System.out.println("Connection to DB established...");
            
            s.executeUpdate("UPDATE [Donor] SET " //Very syntactial, Table names must always have brackets around them when using the executeUpdate method
                    + "Donor.Street = " + "'" + Street + "',"
                    + "Donor.City = " + "'" + City + "',"
                    + "Donor.State = " + "'" + State + "',"
                    + "Donor.ZipCode = " + "'" + Zipcode + "',"
                    + "Donor.Phone = " + "'" + Phone + "',"
                    + "Donor.EmailAddress = " + "'" + Email + "',"
                    + "Donor.UserStatus = " + "'" + Status + "',"
                    + "Donor.Solicitation = " + "'" + Solicitation + "',"
                    + "Donor.PreferredPhone = " + "'" + pPhone + "',"
                    + "Donor.PreferredEmail = " + "'" + pEmail + "',"
                    + "Donor.PreferredMailStreet = " + "'" + pStreet + "',"
                    + "Donor.PreferredMailCity = " + "'" + pCity + "',"
                    + "Donor.PreferredMailState = " + "'" + pState + "',"
                    + "Donor.PreferredMailZipCode = " + "'" + pZipcode + "'"
                    + "WHERE (Donor.DonorID = '" + DonorID + "')");
            
            s.executeUpdate("UPDATE [Individual] SET " //also remember to space everything correctly, program was reading SETIND instead of SET IND
                    + "Individual.Fname = " + "'" + Fname + "',"
                    + "Individual.Minit = " + "'" + Minit + "',"
                    + "Individual.Lname = " + "'" + Lname + "',"
                    + "Individual.PreferredHouseholdName = " + "'" + PreferredHHName + "',"
                    + "Individual.Title = " + "'" + Title + "'"
                    + "WHERE (Individual.DonorID = '" + DonorID + "')");
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            System.out.println("Update Executed.");
            
            con.commit();
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jLabel19.setText("Updated.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        jLabel19.setText("");
        
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
        
        //This is how you do ItemStateChanges when calling from a database with UCANACCESS
        //jcombobox ItemStateChange
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            System.out.print("; Selected " + evt.getItem());
            
            jComboBox7.setSelectedIndex(jComboBox5.getSelectedIndex());
            
            String DonorID = jComboBox7.getSelectedItem().toString();//evt.getItem().toString().substring(0, 5); //Remember to get the DonorID, very important if you want to
                                                                       //pull up the selected donor information. It's used in the SQL Statement
            
            
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
                    + "PreferredPhone, PreferredEmail FROM Individual left outer join Donor on (Individual.DonorID = Donor.DonorID)"
                    + "WHERE (Individual.DonorID = " + DonorID + ")"); 
            
            System.out.println("Is connection closed: " + con.isClosed());
            System.out.println("Connection to DB established...");
            while(rs.next()){
                
                //Fname, Minit, Lname
                System.out.print(rs.getString(1) + " ");
                jTextField1.setText(rs.getString(1) + "");
                System.out.print(rs.getString(2) + " ");
                jTextField2.setText(rs.getString(2) + "");
                System.out.print(rs.getString(3) + " ");
                jTextField3.setText(rs.getString(3) + "");
                
                //title, p. HH name
                System.out.print(rs.getString(4) + " ");
                //jComboBox1.addItem(rs.getString(4));
                jComboBox1.setSelectedItem(rs.getString(4));
                System.out.print(rs.getString(5) + " ");
                jTextField4.setText(rs.getString(5) + "");
                
                //street,city, state, zipcode
                System.out.print(rs.getString(6) + " ");
                jTextField5.setText(rs.getString(6) + "");
                System.out.print(rs.getString(7) + " ");
                jTextField6.setText(rs.getString(7) + "");
                System.out.print(rs.getString(8) + " ");
                //jComboBox2.addItem(rs.getString(8));
                jComboBox2.setSelectedItem(rs.getString(8));
                System.out.print(rs.getString(9) + " ");
                jTextField7.setText(rs.getString(9) + "");
                
                //phone, email, status, solicitation
                System.out.print(rs.getString(10) + " ");
                jTextField8.setText(rs.getString(10) + "");
                System.out.print(rs.getString(11) + " ");
                jTextField9.setText(rs.getString(11) + "");
                System.out.print(rs.getString(12) + " ");
                //jComboBox3.addItem(rs.getString(12));
                jComboBox3.setSelectedItem(rs.getString(12));
                System.out.print(rs.getString(13) + " ");
                //jComboBox4.addItem(rs.getString(13));
                jComboBox4.setSelectedItem(rs.getString(13));
                
                //Preffered
                System.out.print(rs.getString(14) + " ");
                jTextField10.setText(rs.getString(14) + "");
                System.out.print(rs.getString(15) + " ");
                jTextField11.setText(rs.getString(15) + "");
                System.out.print(rs.getString(16) + " ");
                //jComboBox6.addItem(rs.getString(16));
                jComboBox6.setSelectedItem(rs.getString(16));
                System.out.print(rs.getString(17) + " ");
                jTextField14.setText(rs.getString(17) + "");
                System.out.print(rs.getString(18) + " ");
                jTextField12.setText(rs.getString(18) + "");
                System.out.print(rs.getString(19) + " ");
                jTextField13.setText(rs.getString(19) + "");
            }
            
            con.close();
            System.out.println("Is connection closed: " + con.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if(evt.getStateChange() == ItemEvent.DESELECTED){
            System.out.print("; Deselected " + evt.getItem());
        }   
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(updateIndDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateIndDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateIndDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateIndDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateIndDonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
