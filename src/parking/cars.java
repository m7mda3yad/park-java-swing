package parking;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class cars extends JPanel {
    cars () {
        setLayout(null);   
       // setBackground(Color.PINK);
        setSize(600, 400);
        setLocation(10, 10);
        try {
ArrayList<tiket> n = new ArrayList();
tiket t = new tiket();
n=t.read_all();
tiket add=new tiket();
int size = n.size();
 System.out.println(size); 
DefaultTableModel model = new DefaultTableModel();
 model.addColumn("Car Number");
 model.addColumn("Time Of Entry");
  model.addColumn("Time Of Out");
String[]ss= {"car unmber","Entry","Out"};
model.addRow(ss);
  for (int r=0; r<size; r++){
add=n.get(r);
    ss[0]= add.car_number;         
    ss[1]=add.intry ;         
    ss[2]=add.out ;         
model.addRow(ss);
  }
JTable tt = new JTable(model);
tt.setBounds(10, 10, 500, 400);
add(tt);     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
