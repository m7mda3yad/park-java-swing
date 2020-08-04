package parking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class plate extends JPanel {
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5 ; 
    JLabel l6,l7, l8,l9,l10,l11;
    plate() {
           tiket t= new tiket();
        int a1 = t.get_number_from_file("1001.txt");
        int a2 = t.get_number_from_file("1002.txt");
        int a3 = t.get_number_from_file("1003.txt");
        int a4 = t.get_number_from_file("1004.txt");
       // setBackground(Color.MAGENTA);
        setSize(600, 400);
        setLocation(10, 10);
        setLayout(null);        l1 = new JLabel("Plate Name");
        l2 = new JLabel("Plate Id");
        l3 = new JLabel("Spot Number");
        l4 = new JLabel("plate1         1001");
        l5 = new JLabel("plate2         1002");
        l6 = new JLabel("plate3         1003");
        l7 = new JLabel("plate4         1004");
        l8 = new JLabel(Integer.toString(a1));
        l9 = new JLabel(Integer.toString(a2));
        l10 = new JLabel(Integer.toString(a3));
        l11 = new JLabel(Integer.toString(a4));
        b1 = new JButton("Update");
        b2 = new JButton("Update");
        b3 = new JButton("Update");
        b4 = new JButton("Update");
        b1.setBounds(500, 120, 100, 30);
        b2.setBounds(500, 190, 100, 30);
        b3.setBounds(500, 260, 100, 30);
        b4.setBounds(500, 340, 100, 30);
        l1.setBounds(50, 70, 150, 50);
        l1.setFont(new Font("bold", Font.BOLD, 20));
        l2.setBounds(180, 70, 150, 50);
        l2.setFont(new Font("bold", Font.BOLD, 20));
        l3.setBounds(320, 70, 150, 50);
        l3.setFont(new Font("bold", Font.BOLD, 20));
        l4.setBounds(70, 120, 200, 50);
        l4.setFont(new Font("bold", Font.BOLD, 20));
        l5.setBounds(70, 180, 200, 50);
        l5.setFont(new Font("bold", Font.BOLD, 20));
        l6.setBounds(70, 260, 200, 50);
        l6.setFont(new Font("bold", Font.BOLD, 20));
        l7.setBounds(70, 320, 200, 50);
        l7.setFont(new Font("bold", Font.BOLD, 20));
        l8.setBounds(350, 120, 200, 50);
        l8.setFont(new Font("bold", Font.BOLD, 20));
        l9.setBounds(350, 180, 200, 50);
        l9.setFont(new Font("bold", Font.BOLD, 20));
        l10.setBounds(350, 260, 200, 50);
        l10.setFont(new Font("bold", Font.BOLD, 20));
        l11.setBounds(350, 320, 200, 50);
        l11.setFont(new Font("bold", Font.BOLD, 20));
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);add(l9);add(l10);add(l11);

    p obj1 = new p();
    p obj2 = new p();
    p obj3 = new p();
    p obj4 = new p();
        this.b1.addActionListener(obj1);
        this.b2.addActionListener(obj2);
        this.b3.addActionListener(obj3);
        this.b4.addActionListener(obj4);
}
private class p implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    tiket t =new tiket();
        if (e.getSource() == b1 ) {
            String sn = JOptionPane.showInputDialog("Enter Spot Number");
      try{
          t.re("1001.txt",Integer.parseInt(sn));
            l8.setText(sn);
      }
      catch(NumberFormatException es){}
        
        }
        if (e.getSource() == b2 ) {
            String sn = JOptionPane.showInputDialog("Enter Spot Number");

      try{
          t.re("1002.txt",Integer.parseInt(sn));
            l9.setText(sn);
      }
      catch(NumberFormatException es){}
        }
        if (e.getSource() == b3 ) {
            String sn = JOptionPane.showInputDialog("Enter Spot Number");
            
              try{
          t.re("1003.txt",Integer.parseInt(sn));
            l10.setText(sn);
      }
      catch(NumberFormatException es){}
        }
        if (e.getSource() == b4 ) {
            String sn = JOptionPane.showInputDialog("Enter Spot Number");
                    try{
          t.re("1004.txt",Integer.parseInt(sn));
            l11.setText(sn);
      }
      catch(NumberFormatException es){}
        
        }}}}