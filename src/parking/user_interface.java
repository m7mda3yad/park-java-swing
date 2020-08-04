package parking;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class user_interface extends  Employee{
    tiket t ;
    static int m1=0,m2=0,m3=0,m4=0;
    static JFrame frame;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton btn_close;
  int n=0,x=0,y=0,z=0;
    private final JTextField t1;
    user_interface(){
    t= new tiket();
    try
    {
        n= t.get_number_from_file("p1_booked.txt");
        x= t.get_number_from_file("p2_booked.txt");
        y= t.get_number_from_file("p3_booked.txt");
        z= t.get_number_from_file("p4_booked.txt");
        m1 = t.get_number_from_file("1001.txt");
        m2 = t.get_number_from_file("1002.txt");
        m3 = t.get_number_from_file("1003.txt");
        m4 = t.get_number_from_file("1004.txt");
    }   catch(Exception exx){}
        frame= new JFrame();
        frame.setSize(650,450);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.validate();
        frame.setLocation(100, 100);
        frame.setFont(new Font("bold",Font.BOLD,20));
        frame.setLayout(null);
        JButton btn_close;
        btn_close= new JButton("Exit");
        btn_close.setBackground(Color.getHSBColor(0,2,255));
        btn_close.setForeground(Color.white);
        btn_close.setBounds(60,40,100,30);
        btn_close.addActionListener((ActionEvent e) ->  {

    try{ 
        t.re("p1_booked.txt",n);
        t.re("p2_booked.txt",x);
        t.re("p3_booked.txt",y);
        t.re("p4_booked.txt",z);
        }
     catch(Exception ex)
     {
     n=0;x=0;y=0;z=0;
     }
        frame.setVisible(false);
        Employee emp=new Employee(1);});
        this.t1= new JTextField();
        this.b1= new JButton("Searsh");
        this.b2= new JButton("PLATE 1  "+ "\n" + n + "/" + m1);
        this.b3= new JButton("PLATE 2  "+ "\n" + x + "/" + m2);
        this.b4= new JButton("PLATE 3  "+ "\n" + y + "/" + m3);
        this.b5= new JButton("PLATE 4  "+ "\n" + z + "/" + m4);
        this.t1.setBounds(180, 40, 250, 30);
        this.b1.setBounds(470, 25, 100, 60);
        this.b2.setBounds(60, 100, 250, 125);
        this.b3.setBounds(315, 100, 250, 125);
        this.b4.setBounds(60, 230, 250, 125);
        this.b5.setBounds(315, 230, 250, 125);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
        if(n<m1)b2.setBackground(Color.decode("#2571A6"));
        if(x<m1)b3.setBackground(Color.decode("#2571A6"));
        if(y<m1)b4.setBackground(Color.decode("#2571A6"));
        if(z<m1)b5.setBackground(Color.decode("#2571A6"));
                frame.add(b4);
                frame.add(btn_close);
                frame.add(b5);
                frame.add(b2);
                frame.add(b3);
                frame.add(t1);
                frame.add(b1);
                ev2 v= new ev2();
        this.b2.addActionListener(v);
        this.b3.addActionListener(v);
        this.b4.addActionListener(v);
        this.b5.addActionListener(v);
        this.b1.addActionListener(v);
    }
 
    private class ev2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== b1){      
                String x=t1.getText();
              if(isNumeric(x)){
    int id=Integer.parseInt(x);
    fun(id);}}
      if(e.getSource()== b2){
                if(n<m1){
                  b2.setBackground(Color.decode("#2571A6"));
              String s=JOptionPane.showInputDialog(null, "Enter ID");
                    if(s!=null&&s.length()>3){
       fun3("plate 1",s);
                n++;
                    b2.setText("PLATE 1  "+ "\n" + n + "/" + m1);
                    }else JOptionPane.showMessageDialog(null, "car number is short");
                }
                else
                {
                    b2.setBackground(Color.DARK_GRAY);
                    b2.setForeground(Color.red);
                }
            }
            else if(e.getSource()== b3){
                if(x<m2){
                    b3.setBackground(Color.decode("#2571A6"));

                    String s=JOptionPane.showInputDialog(null, "Enter ID");
                    if(s!=null&&s.length()>3){
        fun3("plate 2",s);
                     
                        x++;
                        b3.setText("PLATE 2  "+ "\n" + x + "/" + m2);
              }else JOptionPane.showMessageDialog(null, "car number is short");
                        }
                     else
                    {
                        b3.setBackground(Color.DARK_GRAY);
                        b3.setForeground(Color.red);
                    } 
              }
            else if(e.getSource()== b4){
                if(y<m3){
                    String s=JOptionPane.showInputDialog(null, "Enter ID");
                
                    if(s!=null&&s.length()>3){
                           b4.setBackground(Color.decode("#2571A6")); 
           fun3("plate 3",s);
                         y++;
                        b4.setText("PLATE 3  "+ "\n" + y + "/" + m3);
                    }else JOptionPane.showMessageDialog(null, "car number is short");
                }    else
                    {
                        b4.setBackground(Color.DARK_GRAY);
                        b4.setForeground(Color.red);
         }
            }
            else if(e.getSource()== b5){
                if(z<m4){
                    String s=JOptionPane.showInputDialog(null, "Enter ID");
                      
                    if(s!=null&&s.length()>3){
                       b5.setBackground(Color.decode("#2571A6"));
           fun3("plate 4",s);
                  z++;
                        b5.setText("PLATE 4  "+ "\n" + z + "/" + m4);
                    }else JOptionPane.showMessageDialog(null, "car number is short");
                }else
                    {
                        b5.setBackground(Color.DARK_GRAY);
                        b5.setForeground(Color.red);
}}}}

    public  void fun3(String plate, String car) {
            try {
                t=(tiket)t.print_recet( car , plate );
       JFrame ths =new JFrame();
       JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
       JButton b;
       ths.setTitle("project");
       ths.setSize(250,300);
       ths.setVisible(true);
       ths.setResizable(false);
       ths.setLocation(450, 100);
       ths.setLayout(null);
       l1 = new JLabel("id : ");
       l2 = new JLabel(Integer.toString(t.ID));
       l3 = new JLabel("Car number : ");
       l4 = new JLabel(t.car_number);
       l5 = new JLabel("Plate name : ");
       l6 = new JLabel(t.floar_name);
       l7 = new JLabel("Date In  : ");
       l8 = new JLabel(t.intry);
       b = new JButton("Print");

       l1.setBounds(10, 20, 70, 25);        ths.add(l1);
       l2.setBounds(85, 20, 80, 25);        ths.add(l2);
       l3.setBounds(10, 55, 70, 25);        ths.add(l3);
       l4.setBounds(85, 55, 80, 25);        ths.add(l4);
       l5.setBounds(10, 90, 70, 25);        ths.add(l5);
       l6.setBounds(85, 90, 80, 25);        ths.add(l6);
       l7.setBounds(10, 125,70, 25);        ths.add(l7);
       l8.setBounds(85, 125,80, 25);        ths.add(l8);
        b.setBounds(60, 230,70, 30);        ths.add( b);

       b.addActionListener((ActionEvent e) -> { ths.setVisible(false);});
      } catch (FileNotFoundException ex) {
                System.out.println("error in user inter face fun3");
            }
        }
public  void fun(int id){
    try {
            t=t.read_recet(id);
             if(t.ereor==1)
           {
               if(t.floar_name.equals("plate 1"))  b2.setText("PLATE 1  "+ "\n" + --n + "/" + m1);
               if(t.floar_name.equals("plate 2"))b3.setText("PLATE 1  "+ "\n" + --x + "/" + m2);
               if(t.floar_name.equals("plate 3"))b4.setText("PLATE 1  "+ "\n" + --y + "/" + m3);
               if(t.floar_name.equals("plate 4"))b5.setText("PLATE 1  "+ "\n" + --z + "/" + m4);

               JFrame ths =new JFrame();
      JLabel l1,l2,l3,l4,l6,l7,l8,l9,l10,l11,l12;
       JButton b;
        ths.setTitle("project");
        ths.setSize(200,300);
        ths.setVisible(true);
        ths.setResizable(false);
        ths.setLocation(450, 100);
        ths.setLayout(null);
         l1 = new JLabel("id : ");
         l2 = new JLabel(Integer.toString(t.ID));
         l3 = new JLabel("Car Number  ");
         l4 = new JLabel(t.car_number);
         l6 = new JLabel(t.floar_name);
         l7 = new JLabel("Date In  ");
         l8 = new JLabel(t.intry);
         l9 = new JLabel("Date Out  ");
         l10 = new JLabel(t.out);
         l11 = new JLabel("Money  ");
         l12 = new JLabel(Integer.toString(t.cost));
         b = new JButton("Print"); 
         l1.setBounds(10, 20, 70, 25);ths.add(l1);//this.l1.setFont(new Font("bold",Font.BOLD,15));
         l2.setBounds(85, 20, 70, 25);ths.add(l2);//this.l2.setFont(new Font("bold",Font.BOLD,15));
         l3.setBounds(10, 55, 70, 25);ths.add(l3);//this.l3.setFont(new Font("bold",Font.BOLD,15));
         l4.setBounds(85, 55, 70, 25);ths.add(l4);//this.l4.setFont(new Font("bold",Font.BOLD,15));
         l6.setBounds(85, 90, 70, 25);ths.add(l6);//this.l6.setFont(new Font("bold",Font.BOLD,15));
         l7.setBounds(10, 125,70, 25);ths.add(l7);//this.l7.setFont(new Font("bold",Font.BOLD,15));
         l8.setBounds(85, 125,70, 25);ths.add(l8);//this.l8.setFont(new Font("bold",Font.BOLD,15));
         l9.setBounds(10, 160,70, 25);ths.add(l9);
        l10.setBounds(85, 160,70, 25);ths.add(l10);
        l11.setBounds(10, 195,70, 25);ths.add(l11);
        l12.setBounds(85, 195,70, 25);ths.add(l12);
        b.setBounds  (60, 230,70, 30);ths.add(b);
        b.addActionListener((ActionEvent e) -> { ths.setVisible(false);});
        if(n<m1)b2.setBackground(Color.decode("#2571A6"));
        if(x<m1)b3.setBackground(Color.decode("#2571A6"));
        if(y<m1)b4.setBackground(Color.decode("#2571A6"));
        if(z<m1)b5.setBackground(Color.decode("#2571A6"));
           }
          else 
             JOptionPane.showMessageDialog(null, " Sorry Not Found Id ");
            
    } catch (FileNotFoundException ex) {
                System.err.println("Error in user interface fun");            
            }
}
  

   public static boolean isNumeric(final String str) {
                            if (str == null || str.length() == 0) {
                                        return false;}
                                    try {
                                        Integer.parseInt(str);
                                        return true;
                                    } catch (NumberFormatException e) {
                        return false;}}} 