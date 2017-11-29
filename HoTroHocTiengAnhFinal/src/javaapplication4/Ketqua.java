/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.Theme.setPic;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.commons.lang3.ArrayUtils;
import javaapplication4.Theme;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author LongDu
 */
public class Ketqua  {
    //
    public  JFrame frm1=new JFrame();//Frame sau khi chon file
    public  String[] luuq,luua,cotdapan;
    public  int countRow;
      public void giaodien() {
          
        JLabel lbn1 =new JLabel("Bảng dữ liệu");
        lbn1.setBounds(20, 10, 500, 100);// nen
        lbn1.setForeground(Color.decode("#e6f7e6"));
         
        JLabel lbnthoat = new JLabel();
         lbnthoat.setBounds(550, 5, 40, 40);
         setPic(lbnthoat, "btn\\close2.png", 24, 24);
          setButton(lbnthoat, "btn//close2.png", "btn//close2.png", "btn//close1.png", 24, 24);
            
            JLabel xanh= new JLabel();
             JLabel red= new JLabel();
             JLabel txanh= new JLabel(" -  Cau sai");
             JLabel tred= new JLabel(" -  Cau dung");
              tred.setForeground(Color.WHITE);
             txanh.setForeground(Color.WHITE);
              tred.setBounds(455, 93, 100, 20);
              txanh.setBounds(455, 122, 100, 10);
             red.setBackground(Color.red);
             xanh.setBackground(Color.GREEN);
              red.setBounds(440, 100, 10, 10);
              xanh.setBounds(440, 125, 10, 10);
              xanh.setOpaque(true);
              red.setOpaque(true);
        
        String[] cot1;cot1=new String[countRow];
        for(int i = 0;i<countRow;i++){
           cot1[i]="Cau "+(i+1);  
          
        }
         
        String[][] both={};
        for(int i = 0 ;i<countRow;i++){
        String [][] data = {{""+cot1[i],""+luuq[i],""+luua[i],""+cotdapan[i]}
            };
             both = (String[][])ArrayUtils.addAll(both, data);
            }

         String[] columnNames = {"Cau Hoi",
                                "Noi Dung",
                                 "Tra Loi",
                                "Dap An"};
             
         

       

         JTable table = new JTable(both, columnNames);
         table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {              
                  JLabel pane1  = new JLabel();  
                  pane1.setFont(new Font("Serif", Font.PLAIN, 14));
                pane1.setText(table.getValueAt(row, column).toString());
                if(column!=0&&luua[row].equals(cotdapan[row]))pane1.setForeground(Color.GREEN);
                if(column!=0&&!luua[row].equals(cotdapan[row]))pane1.setForeground(Color.red);
                if(column==2 && luua[row].equals(""))pane1.setText("No answer");
                return pane1;
}
            
        });
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
       
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(20, 70, 400, 180);
        scrollPane.setEnabled(true);
     
    
     
           
     
    
        
        
     
        frm1.getContentPane().setBackground( Color.decode("#031c1e") );
        frm1.add(lbn1);
        frm1.add(lbnthoat);
        frm1.add(xanh);
         frm1.add(red);
          frm1.add(txanh);
         frm1.add(tred);
         
      
        frm1.add(scrollPane);
        
        
        frm1.setSize(600, 300);
        //Display the window.
        frm1.setLayout(null);     
        frm1.setBackground(new Color(63, 191, 65));  
        frm1.setLocationRelativeTo(null);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.setUndecorated(true);
        frm1.setVisible(true); 
        
       
           
      }

         
          
          
 
     public  void setButton(JLabel btn, String file1, String file2, String file3, int dx, int dy) {
        int x = btn.getSize().width;
        int y = btn.getSize().height;
        //  System.out.println(""+ix+" "+iy);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {// khi click
                try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon); 
                   
                    frm1.setVisible(false);
                    frm1.dispose();
                    
                   
                } catch (IOException ex) {
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {//  nhan giữ
                 try {
                    BufferedImage image = ImageIO.read(new File(file3));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                   
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {// thả ra 
                 try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {//khi rê chuột vào nút
                try {
                    BufferedImage image = ImageIO.read(new File(file2));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {// khi rê chuột khỏi nút
                try {
                    BufferedImage image = ImageIO.read(new File(file1));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                    btn.setIcon(icon);
                } catch (IOException ex) {
                }
            }
        });

    }
       public static void setPic(JLabel lbn, String file, int dx, int dy) {
        try {
            BufferedImage image = ImageIO.read(new File(file));
            int x = lbn.getSize().width;
            int y = lbn.getSize().height;
            //  System.out.println(""+ix+" "+iy);
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
            lbn.setIcon(icon);
        } catch (Exception e) {
        }

    }
   
       
//       public static void main(String[] args) {
//        Ketqua a=new Ketqua();
//            
//    }
       
}
