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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JFrame;

public class passwordCheck extends JFrame
{
    Connection con;
    ResultSet rs;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    
    public passwordCheck() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel2 = new JLabel();
        this.jPasswordField1 = new JPasswordField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Tahoma", 1, 12));
        this.jLabel1.setText("UserName :");
        this.jLabel2.setFont(new Font("Tahoma", 1, 12));
        this.jLabel2.setText("Password :");
        this.jButton1.setText("Sign-in");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                passwordCheck.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("Change Password");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                passwordCheck.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setText("Exit");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                passwordCheck.this.jButton3ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(77, 77, 77).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPasswordField1).addComponent(this.jTextField1, -1, 104, 32767))).addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(this.jButton1).addGap(20, 20, 20).addComponent(this.jButton2).addGap(25, 25, 25).addComponent(this.jButton3))).addContainerGap(78, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(80, 80, 80).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jPasswordField1, -2, -1, -2)).addGap(55, 55, 55).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2).addComponent(this.jButton3)).addContainerGap(80, 32767)));
        this.pack();
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        new newPassword().setVisible(true);
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        System.exit(0);
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
            System.out.println("testing");
            final PreparedStatement ps = this.con.prepareStatement(sql);
            ps.executeQuery();
            this.rs = ps.getResultSet();
            String un = null;
            String pw = null;
            while (this.rs.next()) {
                pw = this.rs.getString(1);
                un = this.rs.getString(2);
            }
            final String value1 = this.jTextField1.getText();
            final char[] a = this.jPasswordField1.getPassword();
            final String value2 = new String(a);
            if (value1.equals(un) && value2.equals(pw)) {
                new NewJFrame().setVisible(true);
                this.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect UserName or Password.");
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
                new passwordCheck().setVisible(true);
            }
        });
    }
}
