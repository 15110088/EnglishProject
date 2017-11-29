/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.awt.Color;
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

/**
 *
 * @author LongDu
 */
public class DataTable  {
    //
     public static JFrame frm1=new JFrame();//Frame sau khi chon file
   
   
    //
    JFrame f;//Chose file
    Hashtable table;
    SuLuDuLieu dl = new SuLuDuLieu();
   

    String[] chuoi;
    public DataTable(){
    prepareGUI();
    }
     private void prepareGUI (){
     f=new JFrame();
     f.setSize(175,81);
     JButton b = new JButton("Choose file");//creating instance of JButton  
        b.setBounds(0, 0, 175, 81);
        f.setLocationRelativeTo(null);//ra giua man hinh
        f.setUndecorated(true);// mat khung
        f.add(b);
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
     
        
        b.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e) {
             JFileChooser file = new JFileChooser();
               int value = file.showOpenDialog(null);
                String ten = file.getSelectedFile().getName();
                String dir = file.getCurrentDirectory().toString();
                String path = dir + "\\" + ten;
                    
                System.out.println(path);
                try {
                    dl.read(path);

                    table = new Hashtable();
                   
                   String d = dl.c.concat(dl.b);// b la chu tu vung  +  c la chu ben phien am ghep lai thanh 1 chuoi 
                    
                   chuoi = d.split("");// tach ra thanh tu chu dua vao mang  de dua vao hash table 
                   System.out.println(d);
                   giaodien();
                   
        
                } catch (IOException ex) {
                    Logger.getLogger(DataTable.class.getName()).log(Level.SEVERE, null, ex);
                }    
                
                }
                });
        }
//      public static void main(String[] args) {
//      // OpenFile a =new OpenFile();
//    
//    }
      public void giaodien() {
          
           
        
        
        JLabel lbn1 =new JLabel("Bảng dữ liệu");
        lbn1.setBounds(20, 10, 500, 100);// nen
         lbn1.setForeground(Color.decode("#000000"));
         
            JTextField oseach =new JTextField();
        oseach.setBounds(250, 10, 130, 30);// nen
        oseach.setForeground(Color.decode("#9b9595"));
        JButton btnseach = new JButton("Seach");
        btnseach.setBounds(380, 10, 80,30);
       
           Object[][] both={};
        for(int i = 0 ;i<dl.dem3;i++){
         Object [][] data = {{""+dl.cot1[i],""+dl.cot2[i],""+dl.cotchuyendoi[i]}
            };
             both = (Object[][])ArrayUtils.addAll(both, data);
            }

       
             
          String[] columnNames = {"First",
                                "Second",
                                "Third",
                               };


         JTable table = new JTable(both, columnNames);
         
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
     
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
//        System.out.println("______________________________");
//          System.out.println(table.getValueAt(1, 0));
//          String a;
//          a="book";
//         if(table.getValueAt(5, 0).equals(a))
//               System.out.println(table.getValueAt(5,1));  
//           if(table.getValueAt(5, 0).equals(a))
//               System.out.println("That 's it");  
//         //Create and set up the content pane.
       
        scrollPane.setBounds(20, 70, 400, 200);
        scrollPane.setEnabled(true);
       // scrollPane.setOpaque(true); //content panes must be opaque
       int x = 40;
       JLabel label1 = new JLabel();
       JLabel label2 = new JLabel();
       JLabel label3 =new JLabel();
       JLabel label4 = new JLabel();
       JLabel label5 = new JLabel();
       JLabel label6 = new JLabel();
           
     
        createlbn(label1,250,x,"LongDeptrai");
        createlbn(label2,250,x+20,"LongDeptrai");
        createlbn(label3,250,x+40,"LongDeptrai");
        createlbn(label4,250,x+60,"LongDeptrai");
        createlbn(label5,250,x+80,"LongDeptrai");
        createlbn(label6,250,x+100,". . . ");
        
        
     
        frm1.getContentPane().setBackground( Color.decode("#82cc9d") );
         frm1.add(lbn1);
         
         frm1.add(oseach);
         frm1.add(btnseach);
         frm1.add(scrollPane);
        
        
         frm1.setSize(500, 300);
        //Display the window.
      
       
      
        frm1.setLayout(null);     
       
      
        frm1.setBackground(new Color(63, 191, 65));
      
       
        frm1.setLocationRelativeTo(null);
        
        frm1.setUndecorated(true);
        
       
        String str = oseach.getText();
          oseach.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
//          int dem=0;
//         
//          int count =oseach.getText().length();
//          if(count==0){ label1.setVisible(false); label2.setVisible(false); label3.setVisible(false); label4.setVisible(false); label5.setVisible(false);return;}
//        for(int i=0;i<=count-1;i++){
//          for(int j =0;i<dl.dem3;j++){
//        if(table.getValueAt(j, 0).toString().charAt(0)==oseach.getText().charAt(i)){
//            dem++;
//          
//            switch(dem){
//                case 1:
//                { label1.setText(table.getValueAt(j, 0).toString());
//                  label1.setVisible(true);break;}
//                 case 2:
//                { label2.setText(table.getValueAt(j, 0).toString());
//                  label2.setVisible(true);break;}
//                 case 3:
//                { label3.setText(table.getValueAt(j, 0).toString());
//                  label3.setVisible(true);break;}
//                 case 4:
//                { label4.setText(table.getValueAt(j, 0).toString());
//                  label4.setVisible(true);break;}
//                 case 5:
//                { label5.setText(table.getValueAt(j, 0).toString());
//                  label5.setVisible(true);break;}
//                 case 6:
//                { 
//                  label6.setVisible(true);break;}
//                 default:{
//                 
//                 }
//                
//                
//            }
//        
//        }
//        }
//        }
//           
           
      }

      public void keyTyped(KeyEvent e) {
      }

      public void keyPressed(KeyEvent e) {
      }
    }); 
          
         frm1.setVisible(true);  
          
          
 }
      public static void createlbn(JLabel lbn2,int x,int y,String a){
          lbn2.setText(a);
           lbn2.setBounds(x, y, 130, 20);// nen
         lbn2.setForeground(Color.decode("#000000"));
         lbn2.setBackground(Color.decode("#ddd4d4"));
         lbn2.setFont(new Font("", Font.PLAIN, 10));
         lbn2.setOpaque(true);
         setButtonOK(lbn2);
         frm1.add(lbn2);
         lbn2.setVisible(false);
         
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
   
       public static void setButtonOK(JLabel btn) {
        int x = btn.getSize().width;
        int y = btn.getSize().height;
        //  System.out.println(""+ix+" "+iy);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {// khi click
               
                   
                

                    
                
            }

            @Override
            public void mousePressed(MouseEvent e) {//  nhan giữ
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {// thả ra 
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {//khi rê chuột vào nút
                    btn.setBackground(Color.decode("#76c4e8"));
            }

            @Override
            public void mouseExited(MouseEvent e) {// khi rê chuột khỏi nút
                 btn.setBackground(Color.decode("#ddd4d4"));
            }
        });

    } 
       public static void main(String[] args) {
        DataTable a=new DataTable();
       a.prepareGUI();
      
        
    }
       
}
