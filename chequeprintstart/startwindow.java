// 
// Decompiled by Procyon v0.5.36
// 

package chequeprintstart;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.awt.EventQueue;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.Connection;
import javax.swing.JPanel;

public class startwindow extends JPanel
{
    private Connection con;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    
    public startwindow() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel2 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jTextField3 = new JTextField();
        this.jButton1 = new JButton();
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Name:");
        this.jTextField1.setText("jTextField1");
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Amount in words:");
        this.jTextField2.setText("jTextField2");
        this.jLabel3.setFont(new Font("Tahoma", 0, 14));
        this.jLabel3.setText("Amount in numbers:");
        this.jTextField3.setText("jTextField3");
        this.jButton1.setText("SAVE");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                startwindow.this.jButton1ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(83, 83, 83).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField3, -1, 249, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 48, -2).addComponent(this.jLabel2)).addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField2, -1, 247, 32767).addComponent(this.jTextField1, -1, 247, 32767)))).addContainerGap(239, -2)).addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(this.jButton1).addContainerGap(540, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(75, 75, 75).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 27, -2).addComponent(this.jTextField1, -2, -1, -2)).addGap(31, 31, 31).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField2, -2, -1, -2)).addGap(42, 42, 42).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextField3, -2, -1, -2)).addGap(101, 101, 101).addComponent(this.jButton1).addContainerGap(108, 32767)));
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new startwindow().setVisible(true);
            }
        });
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
            this.con = DriverManager.getConnection("jdbc:odbc:cheque", "", "");
        }
        catch (SQLException ex) {
            System.err.println("SQLException" + ex.getMessage());
        }
        try {
            final String sql = "INSERT INTO customer_cheque VALUES('" + this.jTextField1.getText() + "','" + this.jTextField3.getText() + "')";
            System.out.println("testing");
            final PreparedStatement ps = this.con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Saved");
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
}
