package parking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class userd extends JPanel {
    JButton b1,b2,b3;
   
userd (){
    show_data();
setBackground(Color.CYAN);
        setSize(600, 400);
        setLocation(10, 10);
        setLayout(null);  
        b1=new JButton("Add User");b2=new JButton("Update User");b3=new JButton("Delete User");
        b1.setBounds(50,10,150,50);
        b2.setBounds(210,10,150,50);
        b3.setBounds(370,10,150,50);
         add(b1);add(b2);add(b3);
         mm obj1=new mm();
        mm obj2=new mm();
        mm obj3=new mm();
        this.b1.addActionListener(obj1);
        this.b2.addActionListener(obj2);
        this.b3.addActionListener(obj3); 
}
    private class mm implements ActionListener
    {
      @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) 
            {
                                    String fn = JOptionPane.showInputDialog("Enter name");
                                    if(fn!=null&&fn.length()>2){
                                    String pa = JOptionPane.showInputDialog("Enter password");
                                    if(pa!=null&&pa.length()>5){
                try {
                  admin_code a= new admin_code();
                   a.adduser(fn, pa);
   
                } catch (FileNotFoundException ex) {
                    System.out.println("error in add user");
                }                
                show_data();
                }JOptionPane.showMessageDialog(null, "password  very short");
                }JOptionPane.showMessageDialog(null, "user name very short");
            }
           else if (e.getSource() == b2) {
               
                                            String id = JOptionPane.showInputDialog("Enter id");
                                           if(id!=null&&id.length()>0&&isNumeric(id)){
                                            String fn = JOptionPane.showInputDialog("Enter name");
                                           if(fn!=null&&fn.length()>2){
                                            String pa = JOptionPane.showInputDialog("Enter password");
                                           if(pa!=null&&pa.length()>5){
                try {
                  admin_code a= new admin_code();
                  a.updateuser(id, fn, pa);
                 } catch (FileNotFoundException ex) {
                    System.out.println("error in update user");
                }
                                show_data();
                }JOptionPane.showMessageDialog(null, "Id  Not Found");
                }JOptionPane.showMessageDialog(null, "User Name  Very Short");
                }JOptionPane.showMessageDialog(null, "Password Not Found");
            }
               // delete
            else if (e.getSource() == b3) { 
                String id = JOptionPane.showInputDialog("Enter id");
                         if(id!=null&&id.length()>0&&isNumeric(id)){
           try {
                admin_code a = new admin_code();
                 a.delete_user( id);
                show_data();
                 } catch (FileNotFoundException ex) {
                       System.err.println("user 66");
         }
show_data();
 }JOptionPane.showMessageDialog(null, "Id  Not Found");
}
}}
    
                    public static boolean isNumeric(final String str) {
                            if (str == null || str.length() == 0) {
                                        return false;}
                                    try {
                                        Integer.parseInt(str);
                                        return true;
                                    } catch (NumberFormatException e) {
                        return false;}}

    
   private void show_data(){
   try {
    admin_code a = new admin_code();
    ArrayList<Object> user=new ArrayList<>();
user=a.showalluser();
  int size = user.size();
System.out.println(size); 
DefaultTableModel model = new DefaultTableModel();
 model.addColumn("User Name ");
 model.addColumn("PassWord");
 model.addColumn("Id");
 String[]ss= {"User Name ","PassWord","Id"};
model.addRow(ss);
for(int r=0; r<size; r++){
a=(admin_code)user.get(r);
   ss[0]=a.name;         
   ss[1]= a.pass;         
   ss[2]=Integer.toString(a.getC()) ;         
model.addRow(ss);
  }
JTable t = new JTable(model);
t.setBackground(null);
t.setBounds(70,90,400,400);
t.setForeground(Color.WHITE);
add(t);     

   } catch (FileNotFoundException ex) 
        { 
            System.err.println("userd 104");       
        } 
}
}