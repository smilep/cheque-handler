// 
// Decompiled by Procyon v0.5.36
// 

package chequeprintstart;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Paint;
import java.awt.print.PageFormat;
import java.awt.Graphics;
import java.sql.ResultSetMetaData;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.LayoutStyle;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.awt.print.Printable;
import javax.swing.JFrame;

public class NewJFrame extends JFrame implements Printable
{
    public Connection con3;
    public PreparedStatement ps2;
    public String sql2;
    public ResultSet rs2;
    String name;
    String sql3;
    PreparedStatement ps3;
    ResultSet rs3;
    String[] d;
    Connection con4;
    int rowCount;
    String[] a;
    String bName;
    int[] b;
    int f;
    int[] c;
    Toolkit tk;
    int dpi;
    private Connection con;
    ResultSet rs;
    BufferedImage img;
    Graphics2D g2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JCheckBox jCheckBox1;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    
    public NewJFrame() {
        this.a = null;
        this.bName = null;
        this.rs = null;
        this.initComponents();
        final Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize();
        final int screenWidth = screenSize.width;
        final int screenHeight = screenSize.height;
        this.setSize(screenWidth - 100, screenHeight - 100);
        this.setTitle("ChequeHandler 1.0 by LoJiS System Solutions");
        this.comboFill();
        this.combo2Fill();
    }
    
    public void comboFill() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            this.con3 = DriverManager.getConnection("jdbc:odbc:cheque", "", "lojis");
        }
        catch (SQLException ex) {
            System.err.println("SQLException" + ex.getMessage());
        }
        try {
            this.sql2 = "SELECT bank_name FROM bank_names";
            (this.ps2 = this.con3.prepareStatement(this.sql2, 1004, 1007)).executeQuery();
            (this.rs2 = this.ps2.getResultSet()).last();
            final int rowCount = this.rs2.getRow();
            this.a = new String[rowCount];
            this.rs2.beforeFirst();
            int i = 0;
            while (this.rs2.next()) {
                this.a[i] = this.rs2.getString(1);
                ++i;
            }
            this.jComboBox1.removeAllItems();
            for (int u = 0; u < rowCount; ++u) {
                this.jComboBox1.insertItemAt(this.a[u], u);
            }
            this.con3.close();
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    public void combo2Fill() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            this.con4 = DriverManager.getConnection("jdbc:odbc:cheque", "", "lojis");
        }
        catch (SQLException ex) {
            System.err.println("SQLException" + ex.getMessage());
        }
        try {
            this.sql3 = "SELECT DISTINCT customer_name FROM customer_cheque";
            (this.ps3 = this.con4.prepareStatement(this.sql3)).executeQuery();
            this.rs3 = this.ps3.getResultSet();
            int i = 0;
            while (this.rs3.next()) {
                ++i;
            }
            this.rs3.close();
            this.sql3 = "SELECT DISTINCT customer_name FROM customer_cheque";
            (this.ps3 = this.con4.prepareStatement(this.sql3)).executeQuery();
            this.rs3 = this.ps3.getResultSet();
            this.d = new String[i];
            int l = 0;
            while (this.rs3.next()) {
                this.d[l] = this.rs3.getString(1);
                ++l;
            }
            this.jComboBox2.removeAllItems();
            this.jComboBox2.insertItemAt("", 0);
            for (int u = 0; u < i; ++u) {
                this.jComboBox2.insertItemAt(this.d[u], u + 1);
            }
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel2 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jTextField3 = new JTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jLabel4 = new JLabel();
        this.jTextField4 = new JTextField();
        this.jButton5 = new JButton();
        this.jLabel5 = new JLabel();
        this.jButton6 = new JButton();
        this.jComboBox1 = new JComboBox();
        this.jLabel6 = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.jButton7 = new JButton();
        this.jButton8 = new JButton();
        this.jComboBox2 = new JComboBox();
        this.jLabel7 = new JLabel();
        this.jTextField5 = new JTextField();
        this.jButton9 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setText("Name");
        this.jLabel2.setText("Amount ( in numbers, commas allowed)");
        this.jLabel3.setText("Amount in words");
        this.jButton1.setText("SAVE & CREATE IMAGE");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setText("SEARCH");
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton2ActionPerformed(evt);
            }
        });
        this.jScrollPane2.setBorder(null);
        this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        this.jScrollPane2.setViewportView(this.jTable1);
        this.jButton3.setText("CLEAR");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton3ActionPerformed(evt);
            }
        });
        this.jButton4.setText("EXIT");
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton4ActionPerformed(evt);
            }
        });
        this.jLabel4.setText("Date");
        this.jButton5.setText("CREATE NEW CHEQUE FORMAT");
        this.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton5ActionPerformed(evt);
            }
        });
        this.jLabel5.setFont(new Font("Tahoma", 1, 12));
        this.jLabel5.setForeground(new Color(204, 0, 0));
        this.jButton6.setText("SAVE ONLY");
        this.jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton6ActionPerformed(evt);
            }
        });
        this.jComboBox1.setModel(new DefaultComboBoxModel<String>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jComboBox1ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Choose Bank:");
        this.jCheckBox1.setFont(new Font("Tahoma", 1, 12));
        this.jCheckBox1.setText("Crossed");
        this.jCheckBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.jCheckBox1.setMargin(new Insets(0, 0, 0, 0));
        this.jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jButton7.setForeground(new Color(255, 51, 0));
        this.jButton7.setText("About");
        this.jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton7ActionPerformed(evt);
            }
        });
        this.jButton8.setText("SAVE & PRINT");
        this.jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton8ActionPerformed(evt);
            }
        });
        this.jComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.jComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jComboBox2ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Tahoma", 1, 12));
        this.jLabel7.setText("ID");
        this.jButton9.setText("Delete");
        this.jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                NewJFrame.this.jButton9ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(107, 107, 107).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton5).addComponent(this.jLabel4).addComponent(this.jLabel1)).addGap(31, 31, 31).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField4, -2, 148, -2).addGroup(layout.createSequentialGroup().addComponent(this.jButton1).addGap(34, 34, 34).addComponent(this.jButton8).addGap(17, 17, 17).addComponent(this.jButton6).addGap(26, 26, 26).addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3)).addComponent(this.jTextField3, -2, 443, -2).addComponent(this.jTextField2, -2, 150, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(layout.createSequentialGroup().addComponent(this.jTextField1, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jComboBox2, -2, -1, -2).addGap(130, 130, 130)))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField5, -2, 42, -2)).addComponent(this.jLabel6)).addGap(39, 39, 39))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jButton4)).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jComboBox1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton9)))).addComponent(this.jLabel2).addComponent(this.jLabel3))).addGroup(layout.createSequentialGroup().addGap(209, 209, 209).addComponent(this.jScrollPane2, -2, 494, -2).addGap(69, 69, 69).addComponent(this.jButton7)).addGroup(layout.createSequentialGroup().addGap(287, 287, 287).addComponent(this.jLabel5)).addGroup(layout.createSequentialGroup().addGap(653, 653, 653).addComponent(this.jCheckBox1))).addContainerGap(827, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(19, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jComboBox2, -2, -1, -2)).addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField2, -2, -1, -2)).addGap(24, 24, 24).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextField3, -2, -1, -2)).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField4, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addGap(22, 22, 22).addComponent(this.jCheckBox1).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5).addComponent(this.jButton1).addComponent(this.jButton8).addComponent(this.jButton6).addComponent(this.jButton2).addComponent(this.jButton3).addComponent(this.jButton4)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jScrollPane2, -2, 251, -2)).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jComboBox1, -2, -1, -2).addComponent(this.jLabel6)).addGap(39, 39, 39).addComponent(this.jButton7).addGap(29, 29, 29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jTextField5, -2, -1, -2).addComponent(this.jButton9)))).addGap(175, 175, 175)));
        this.pack();
    }
    
    private void jButton9ActionPerformed(final ActionEvent evt) {
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
            if (this.jTextField5.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter ID.");
            }
            else {
                final String sql = "DELETE FROM customer_cheque WHERE ID=?";
                final PreparedStatement ps = this.con.prepareStatement(sql);
                ps.setString(1, this.jTextField5.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record with ID-" + this.jTextField5.getText() + " deleted from database.");
            }
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    private void jComboBox2ActionPerformed(final ActionEvent evt) {
        this.name = (String)this.jComboBox2.getSelectedItem();
        this.jTextField1.setText(this.name);
    }
    
    private void jButton8ActionPerformed(final ActionEvent evt) {
        if (this.bName == null) {
            this.jLabel5.setText("Please Select a Bank.");
        }
        else if (this.jTextField1.getText().equals("")) {
            this.jLabel5.setText("Please fill customer's name.");
        }
        else if (this.jTextField2.getText().equals("")) {
            this.jLabel5.setText("Please fill the amount.");
        }
        else if (this.jTextField3.getText().equals("")) {
            this.jLabel5.setText("Please fill the amount in words.");
        }
        else if (this.jTextField4.getText().equals("")) {
            this.jLabel5.setText("Please fill date.");
        }
        else {
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
                this.dpi = 70;
                final int[] d = new int[this.f];
                for (int k = 0; k < this.f; ++k) {
                    this.c[k] = (int)((this.dpi + 4) * this.b[k] / 25.4);
                    d[k] = (int)(this.c[k] / 96 * 25.5);
                }
                final String sql = "INSERT INTO customer_cheque(customer_name,amount_num,Date_onCheque) VALUES('" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "','" + this.jTextField4.getText() + "')";
                final PreparedStatement ps = this.con.prepareStatement(sql);
                ps.executeUpdate();
                this.jLabel5.setText("Record Saved. Now printing window will open.");
                final PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this);
                final boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    }
                    catch (PrinterException ex2) {}
                }
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.toString());
            }
        }
    }
    
    private void jButton7ActionPerformed(final ActionEvent evt) {
        new AboutUs().setVisible(true);
    }
    
    private void jCheckBox1ActionPerformed(final ActionEvent evt) {
    }
    
    private void jComboBox1ActionPerformed(final ActionEvent evt) {
        this.bName = (String)this.jComboBox1.getSelectedItem();
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
            final String sql3 = "SELECT * FROM bank_names WHERE bank_name=?";
            final PreparedStatement ps = this.con.prepareStatement(sql3, 1004, 1007);
            ps.setString(1, this.bName);
            ps.executeQuery();
            this.rs = ps.getResultSet();
            final ResultSetMetaData meta = this.rs.getMetaData();
            this.b = new int[meta.getColumnCount() - 2];
            while (this.rs.next()) {
                int s;
                for (s = 0; s < meta.getColumnCount() - 2; ++s) {
                    this.b[s] = this.rs.getInt(s + 3);
                }
                ++s;
            }
            this.c = new int[meta.getColumnCount() - 2];
            this.f = meta.getColumnCount() - 2;
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    private void jButton6ActionPerformed(final ActionEvent evt) {
        if (this.bName == null) {
            this.jLabel5.setText("Please Select a Bank.");
        }
        else if (this.jTextField1.getText().equals("")) {
            this.jLabel5.setText("Please fill customer's name.");
        }
        else if (this.jTextField2.getText().equals("")) {
            this.jLabel5.setText("Please fill the amount.");
        }
        else if (this.jTextField4.getText().equals("")) {
            this.jLabel5.setText("Please fill date.");
        }
        else {
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
                final String sql = "INSERT INTO customer_cheque(customer_name,amount_num,Date_onCheque) VALUES('" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "','" + this.jTextField4.getText() + "')";
                System.out.println("testing");
                final PreparedStatement ps = this.con.prepareStatement(sql);
                ps.executeUpdate();
                this.jLabel5.setText("Record Saved.");
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.toString());
            }
        }
    }
    
    private void jButton5ActionPerformed(final ActionEvent evt) {
        new NewChequeCreator().setVisible(true);
    }
    
    @Override
    public int print(final Graphics g, final PageFormat pf, final int page) throws PrinterException {
        if (page > 0) {
            return 1;
        }
        final Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.drawString(this.jTextField1.getText(), this.c[0], this.c[1] + 6);
        g2d.drawString(this.jTextField3.getText(), this.c[2], this.c[3] + 9);
        g2d.drawString(this.jTextField2.getText(), this.c[4], this.c[5] + 6);
        g2d.drawString(this.jTextField4.getText(), this.c[6], this.c[7] + 7);
        if (this.jCheckBox1.isSelected()) {
            g2d.drawLine(0, 70, 70, 0);
            g2d.drawLine(0, 80, 80, 0);
            System.out.println("selected");
        }
        return 0;
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.jLabel5.setText("");
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
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
            final String h = this.jTextField1.getText();
            PreparedStatement ps;
            if (this.jTextField1.getText().equals("")) {
                final String sql = "SELECT * FROM customer_cheque";
                ps = this.con.prepareStatement(sql, 1004, 1007);
            }
            else {
                final String sql = "SELECT * FROM customer_cheque WHERE customer_name LIKE '%'+?+'%'";
                ps = this.con.prepareStatement(sql, 1004, 1007);
                ps.setString(1, h);
            }
            ps.executeQuery();
            this.rs = ps.getResultSet();
            final ResultSetMetaData meta = this.rs.getMetaData();
            final String[] columnName = new String[meta.getColumnCount()];
            for (int i = 1; i <= meta.getColumnCount(); ++i) {
                columnName[i - 1] = meta.getColumnLabel(i);
            }
            this.rs.last();
            final int rowCount = this.rs.getRow();
            final Object[][] a = new Object[rowCount][meta.getColumnCount()];
            this.rs.beforeFirst();
            int j = 0;
            while (this.rs.next()) {
                for (int s = 0; s < meta.getColumnCount(); ++s) {
                    a[j][s] = this.rs.getObject(s + 1);
                }
                ++j;
            }
            this.jTable1.setModel(new DefaultTableModel(a, columnName));
        }
        catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        if (this.bName == null) {
            this.jLabel5.setText("Please Select a Bank.");
        }
        else if (this.jTextField1.getText().equals("")) {
            this.jLabel5.setText("Please fill customer's name.");
        }
        else if (this.jTextField2.getText().equals("")) {
            this.jLabel5.setText("Please fill the amount.");
        }
        else if (this.jTextField3.getText().equals("")) {
            this.jLabel5.setText("Please fill the amount in words.");
        }
        else if (this.jTextField4.getText().equals("")) {
            this.jLabel5.setText("Please fill date.");
        }
        else {
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
                this.dpi = 96;
                final int[] d = new int[this.f];
                for (int k = 0; k < this.f; ++k) {
                    this.c[k] = (int)((this.dpi + 4) * this.b[k] / 25.4);
                    d[k] = (int)(this.c[k] / 96 * 25.5);
                }
                final String sql = "INSERT INTO customer_cheque(customer_name,amount_num,Date_onCheque) VALUES('" + this.jTextField1.getText() + "','" + this.jTextField2.getText() + "','" + this.jTextField4.getText() + "')";
                final PreparedStatement ps = this.con.prepareStatement(sql);
                ps.executeUpdate();
                this.img = new BufferedImage(790, 1132, 1);
                (this.g2 = this.img.createGraphics()).setPaint(new Color(255, 255, 255));
                this.g2.fillRect(0, 0, this.img.getWidth(), this.img.getHeight());
                this.g2.setColor(Color.black);
                this.g2.drawString(this.jTextField1.getText(), this.c[0], this.c[1]);
                this.g2.drawString(this.jTextField3.getText(), this.c[2], this.c[3]);
                this.g2.drawString(this.jTextField2.getText(), this.c[4], this.c[5]);
                this.g2.drawString(this.jTextField4.getText(), this.c[6], this.c[7]);
                if (this.jCheckBox1.isSelected()) {
                    this.g2.drawLine(0, 70, 70, 0);
                    this.g2.drawLine(0, 80, 80, 0);
                }
                final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
                final Date date = new Date();
                final String dateString = dateFormat.format(date);
                final File outputfile = new File(this.jTextField1.getText() + dateString + ".png");
                ImageIO.write(this.img, "png", outputfile);
                JOptionPane.showMessageDialog(null, "DONE");
            }
            catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.toString());
            }
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
}
