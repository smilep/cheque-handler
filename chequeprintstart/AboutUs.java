// 
// Decompiled by Procyon v0.5.36
// 

package chequeprintstart;

import java.awt.EventQueue;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AboutUs extends JFrame
{
    private JButton jButton1;
    private JLabel jLabel1;
    
    public AboutUs() {
        this.initComponents();
        final Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = kit.getScreenSize();
        final int screenWidth = screenSize.width;
        final int screenHeight = screenSize.height;
        this.setLocation(screenWidth / 3, screenHeight / 4);
        this.setTitle("ChequeHandler 1.0 by LoJiS System Solutions");
    }
    
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.setBackground(new Color(255, 0, 0));
        this.setCursor(new Cursor(0));
        this.setForeground(new Color(51, 0, 255));
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/chequeprintstart/Untitled.jpg")));
        this.jButton1.setText("OK");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                AboutUs.this.jButton1ActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(168, 168, 168).addComponent(this.jButton1))).addContainerGap(44, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(34, 32767).addComponent(this.jLabel1).addGap(20, 20, 20).addComponent(this.jButton1).addContainerGap()));
        this.pack();
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AboutUs().setVisible(true);
            }
        });
    }
}
