package parking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class admin extends JFrame {
static         plate p=new plate();
static         cars c=new cars();
static         userd u=new userd();        
    JPanel p1,p2,p3,p4;
    JButton b1,b2,b3,b4;
    JButton btn_close;
       public admin(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(900,500);
        setVisible(true);
        setResizable(false);
        setLocation(100,100);
        setLayout(null);
        setTitle("Admin");
        add(p);add(u);add(c);
        b1=new JButton("User Details");
        b2=new JButton("PLate Details");
        b3=new JButton("Show All Cars");
        b4=new JButton("Show All Money");
        btn_close= new JButton("Exit");
        btn_close.setBackground(Color.getHSBColor(0,2,255));
        btn_close.setForeground(Color.white);
        b1.setBounds(700,20,150,50);
        b2.setBounds(700,100,150,50);
        b3.setBounds(700,180,150,50);
        b4.setBounds(700,280,150,50);
        btn_close.setBounds(700,380,150,50);
        p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();
        add(b1);add(b2);add(b3);add(b4);add(btn_close);
 btn_close.addActionListener((ActionEvent e) -> 
 {
setVisible(false);
Employee emp=new Employee(1);
 });
        nn obj1=new nn();
        this.b1.addActionListener(obj1);
        nn obj2=new nn();
        this.b2.addActionListener(obj2);
        nn obj3=new nn();
        this.b3.addActionListener(obj3);
        nn obj4=new nn();
        this.b4.addActionListener(obj4);
    }
private class nn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
u.setVisible(true);
c.setVisible(false);
p.setVisible(false);
            }
            else if(e.getSource()==b2){
p.setVisible(true);
c.setVisible(false);
u.setVisible(false);
            }
 else if(e.getSource()==b3){
c.setVisible(true);
u.setVisible(false);
p.setVisible(false);
            }
            else if(e.getSource()==b4){
             tiket t = new tiket();
                int x=t.get_number_from_file("money.txt");
             int m = JOptionPane.showConfirmDialog(null,x,"All Money",JOptionPane.YES_NO_OPTION);
             if (m==0)t.re("money.txt",0); //value =yes
            }
        }
    }
}
