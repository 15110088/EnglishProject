package javaapplication4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.apache.commons.lang3.ArrayUtils;

public class TableTest {
    public static void main(String[] args) {
         
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Color[] rowColors = new Color[] {
                randomColor(), randomColor(), randomColor(), randomColor(), randomColor()
        };
   
             
         

       
 String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};

        Object[][] data = {
        {"Kathy", "Smith",
         "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe",
         "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black",
         "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White",
         "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown",
         "Pool", new Integer(10), new Boolean(false)}
        };
        // JTable table = new JTable(3, 3);
      final JTable table = new JTable(data, columnNames);
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel pane  = new JLabel("sdsd"); 
                  JLabel pane1  = new JLabel("LOSFH"); 
                if(row==0){
              pane.setText("Long");
                pane.setForeground(rowColors[row]);
                return pane;}return null;
}
            
        });
        frame.setLayout(new BorderLayout());

        JButton btn = new JButton("Change row2's color");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rowColors[1] = randomColor();
                rowColors[0] = randomColor();
                rowColors[2] = randomColor();
                rowColors[3] = randomColor();
                rowColors[4] = randomColor();
                table.repaint();
                                                        }
        });

        frame.add(table, BorderLayout.NORTH);
        frame.add(btn, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private static Color randomColor() {
        Random rnd = new Random();
        return new Color(rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256));
    }
}