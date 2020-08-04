 package parking;
import java.io.IOException;
public class Parking {
    public static void main(String[] args) throws IOException {
    Employee x=new Employee(1);
    }
}
/****************************************************************************************
 *  Employee e = new Employee();                                                        *   
 *  ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admin.bin"));    *
 *  try {                                                                               *
 *  while((e=(Employee)ois.readObject())!=null){                                        *
 *  if(e.name.equals("admin"))                                                          *
 *  System.out.println("yesssssssssssssssssssss");                                      *   
 *  }       } catch (ClassNotFoundException ex) {                                       *  
 *  System.out.println("errrrrrrrrrror");                                               *
 *        }                                                                             *
 *  ois.close();                                                                        *
 *                                                                                      *
 ****************************************************************************************/