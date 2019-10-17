package chequeprintstart;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JFrame;

public class newPassword extends JFrame
{
    private Connection con;
    private ResultSet rs;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JPasswordField jPasswordField3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    
    public newPassword() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jTextField1 = new JTextField();
        this.jTextField2 = new JTextField();
        this.jPasswordField1 = new JPasswordField();
        this.jPasswordField2 = new JPasswordField();
        this.jPasswordField3 = new JPasswordField();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setText("Current Username :");
        this.jLabel2.setText("New Username :");
        this.jLabel3.setText("Current Password :");
        this.jLabel4.setText("New Password :");
        this.jLabel5.setText("Retype new Password :");
        this.jButton1.setText("Submit");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                newPassword.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("Exit");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                newPassword.this.jButton2ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(52, 52, 52).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5)).addGap(25, 25, 25).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTextField1, -1, 109, 32767).addComponent(this.jTextField2).addComponent(this.jPasswordField1).addComponent(this.jPasswordField2).addComponent(this.jPasswordField3))).addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(this.jButton1).addGap(54, 54, 54).addComponent(this.jButton2))).addContainerGap(100, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addGap(16, 16, 16).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField2, -2, -1, -2)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jPasswordField1, -2, -1, -2)).addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jPasswordField2, -2, -1, -2)).addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5).addComponent(this.jPasswordField3, -2, -1, -2)).addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(15, 32767)));
        this.pack();
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            this.con = DriverManager.getConnection("jdbc:odbc:cheque", "", "lojis");
        }
        catch (SQLException ex) {
            System.err.println("SQLException" + ex.getMessage());
        }
        try {
            final String sql = "SELECT password,username FROM pword WHERE ID=1";
            final PreparedStatement ps = this.con.prepareStatement(sql);
            ps.executeQuery();
            this.rs = ps.getResultSet();
            String un = null;
            String pw = null;
            while (this.rs.next()) {
                pw = this.rs.getString(1);
                un = this.rs.getString(2);
            }
            final String cun = this.jTextField1.getText();
            final String nun = this.jTextField2.getText();
            final char[] a = this.jPasswordField1.getPassword();
            final char[] b = this.jPasswordField2.getPassword();
            final char[] c = this.jPasswordField3.getPassword();
            final String cpw = new String(a);
            final String npw = new String(b);
            final String rpw = new String(c);
            if (!npw.equals(rpw)) {
                JOptionPane.showMessageDialog(null, "New passwords do not match.");
            }
            else if (cun.equals(un) && cpw.equals(pw)) {
                final String sql2 = "UPDATE pword SET password=?,username=? WHERE ID=1";
                this.con.close();
                final Connection con1 = DriverManager.getConnection("jdbc:odbc:cheque", "", "lojis");
                final PreparedStatement ps2 = con1.prepareStatement(sql2);
                ps2.setString(1, npw);
                ps2.setString(2, nun);
                ps2.executeUpdate();
                System.out.println("testing");
                JOptionPane.showMessageDialog(null, "New Password and username saved.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Please type correct current username and password.");
            }
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new newPassword().setVisible(true);
            }
        });
    }
}
