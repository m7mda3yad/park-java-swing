package parking;import java.awt.Color;
import java.awt.event.ActionEvent;import java.io.File;
import java.io.FileNotFoundException;import java.util.ArrayList;
import java.util.Scanner;import javax.swing.ImageIcon;
import javax.swing.JButton;import javax.swing.JFrame;
import javax.swing.JLabel;import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Employee {
   String name;
   String pass;

   Employee(int x){view_page_login();}

   Employee(){}

   public  void get_data (String filenam,JTextField tf1,JTextField tf2 ,JFrame frame) {
    String username = tf1.getText();
    String pass = tf2.getText();
     int log=0; 
   log = login(filenam,username, pass); //show if log in true
   switch (log){
      case 2:
     frame.setVisible(false);
    user_interface Project=new user_interface();
     break;
      case 1:
    frame.setVisible(false);
admin a = new admin();
    break;  
      default:
     for (int i = 0; i < 10; i++)
     java.awt.Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(frame,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
      break;       
   }
  }  

   public void view_page_login(){
  
     JFrame frame ; 
     JLabel  l2, l3;
     JTextField tf1;
     JTextField tf2;
     JButton btn1 , btn2, btn3 ;
     ImageIcon icon ;
     JLabel label ;   
        frame  = new JFrame("Login Form"); 
        btn1   = new JButton("admin");
        btn2   = new JButton("user");
        btn3   = new JButton("Exit");
        l2     = new JLabel("Username");
        l3     = new JLabel("Password");
        tf1    = new JTextField();
        tf2    = new JTextField();
        icon   = new ImageIcon("xdd.jpg");
        label  = new JLabel(icon);
  
   frame.setSize(666,666);
   frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
   frame.setLayout(null);
   frame.setVisible(true);
   frame.validate();
   label.setBounds(10,10,740, 750);   l2.setBounds(550, 210,250, 40);
   tf1.setBounds(550, 240, 250, 40);   l3.setBounds(550, 290, 250, 40);
   tf2.setBounds(550, 320, 250, 40);   btn1.setBounds(600, 380, 150, 40);
   btn2.setBounds(600, 440, 150, 40);  btn3.setBounds(1200, 650, 100, 40);  
   btn1.setBackground(Color.getHSBColor(180,155,255));
   btn3.setBackground(Color.getHSBColor(0,2,255));
   btn2.setBackground(Color.getHSBColor(100,155,155));
   btn1.setForeground(Color.white);  btn2.setForeground(Color.white);  btn3.setForeground(Color.white);
   frame.add(l2);  frame.add(tf1);  frame.add(l3);  frame.add(tf2);  frame.add(btn1);  frame.add(btn2);frame.add(btn3);
   btn1.addActionListener((ActionEvent e) -> {    get_data("admin.txt", tf1, tf2, frame);}); //log in for admin
   btn2.addActionListener((ActionEvent e) -> {    get_data( "user.txt", tf1, tf2, frame);}); //log in for user
   btn3.addActionListener((ActionEvent e) -> {        System.exit(0);  }); //log in for user
}
public int login(String path,String name,String pass){
        int flag=0;
        Scanner Reader = null;
        try {                                    Reader = new Scanner(new File(path));
        } catch (FileNotFoundException e) {      System.out.println(e);} 
        while (Reader.hasNext()) {
            String line = Reader.nextLine();
            String sperated[] = line.split("@");
            if(sperated[1].equals(name)&&sperated[2].equals(pass)){
                flag=1;
            }}
        Reader.close();
        if(flag==1&&path.equals("admin.txt"))
            return  1;
            if(flag==1&&path.equals("user.txt")){
            return  2;
        }    return 0;
        }}