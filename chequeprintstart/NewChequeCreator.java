package chequeprintstart;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.Connection;
import javax.swing.JFrame;

public class NewChequeCreator extends JFrame
{
    private Connection con2;
    private JButton jButton1;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
    
    public NewChequeCreator() {
        this.initComponents();
        this.setTitle("ChequeHandler 1.0 by LoJiS System Solutions");
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jTextField3 = new JTextField();
        this.jTextField4 = new JTextField();
        this.jTextField5 = new JTextField();
        this.jTextField6 = new JTextField();
        this.jTextField7 = new JTextField();
        this.jTextField8 = new JTextField();
        this.jLabel10 = new JLabel();
        this.jTextField9 = new JTextField();
        this.jButton3 = new JButton();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setForeground(new Color(204, 0, 0));
        this.jLabel1.setIcon(new ImageIcon("C:\\Users\\Smiling_anish\\Desktop\\hdfc-bank-cheque_2.jpg"));
        this.jButton1.setText("EXIT");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewChequeCreator.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel2.setText("name_x");
        this.jLabel3.setText("name_y");
        this.jLabel4.setText("amountName_x");
        this.jLabel5.setText("amountName_y");
        this.jLabel6.setText("amount_x");
        this.jLabel7.setText("amount_y");
        this.jLabel8.setText("date_x");
        this.jLabel9.setText("date_y");
        this.jLabel10.setText("BANK NAME/CHEQUE NAME");
        this.jButton3.setText("SAVE");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewChequeCreator.this.jButton3ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Tahoma", 1, 14));
        this.jLabel11.setForeground(new Color(204, 0, 0));
        this.jLabel11.setIcon(new ImageIcon(this.getClass().getResource("/chequeprintstart/hdfc-bank-cheque_2.jpg")));
        this.jLabel12.setFont(new Font("Tahoma", 1, 12));
        this.jLabel12.setForeground(new Color(51, 0, 204));
        this.jLabel12.setText("All fields above this line should be filled with numbers only.( in mm)");
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(169, 169, 169).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel12).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel2).addComponent(this.jLabel6).addComponent(this.jLabel8).addComponent(this.jLabel10)).addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField7, -1, 54, 32767).addComponent(this.jTextField3, -1, 54, 32767).addComponent(this.jTextField1, -1, 54, 32767).addComponent(this.jTextField5, -1, 54, 32767)).addGap(74, 74, 74).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel5).addComponent(this.jLabel7).addComponent(this.jLabel9)).addGap(93, 93, 93).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTextField2, -1, 49, 32767).addComponent(this.jTextField4).addComponent(this.jTextField6).addComponent(this.jTextField8, -2, 49, -2)).addGap(201, 201, 201)).addGroup(layout.createSequentialGroup().addComponent(this.jTextField9, -2, 130, -2).addContainerGap()))))).addGroup(layout.createSequentialGroup().addGap(374, 374, 374).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3).addContainerGap(396, 32767)).addGroup(layout.createSequentialGroup().addGap(134, 134, 134).addComponent(this.jLabel11, -2, 581, -2).addContainerGap(173, 32767)).addGroup(layout.createSequentialGroup().addGap(198, 198, 198).addComponent(this.jLabel1, -2, 157, -2).addContainerGap(533, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel2).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jTextField2, -2, -1, -2)).addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel4).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jTextField4, -2, -1, -2)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jLabel6).addComponent(this.jTextField5, -2, -1, -2).addComponent(this.jTextField6, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jTextField8, -2, -1, -2))).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jTextField7, -2, -1, -2)))).addGap(7, 7, 7).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jTextField9, -2, -1, -2)).addGap(15, 15, 15).addComponent(this.jLabel1, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton3)).addGap(16, 16, 16).addComponent(this.jLabel11, -2, 250, -2).addGap(46, 46, 46)));
        this.pack();
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            this.con2 = DriverManager.getConnection("jdbc:odbc:cheque", "", "lojis");
        }
        catch (SQLException ex) {
            System.err.println("SQLException" + ex.getMessage());
        }
        try {
            final String sql = "INSERT INTO bank_Names (bank_name,name_x,name_y,amountName_x,amountName_y,amount_x,amount_y,date_x,date_y) VALUES('" + this.jTextField9.getText() + "','" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "','" + this.jTextField3.getText() + "','" + this.jTextField4.getText() + "','" + this.jTextField5.getText() + "','" + this.jTextField6.getText() + "','" + this.jTextField7.getText() + "','" + this.jTextField8.getText() + "')";
            final PreparedStatement ps = this.con2.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Saved.");
            this.jLabel1.setText("Saved");
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString() + "Please fill all fields and in numbers only");
        }
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewChequeCreator().setVisible(true);
            }
        });
    }
}
