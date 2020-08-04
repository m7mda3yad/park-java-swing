package parking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class admin_code extends Employee{
       int c;
       String id;
       FileM ob = new FileM();
   public int getC() {
        return c;
    } 
    public admin_code() throws FileNotFoundException {
    }
    //function to get id
   
    //function add user
    public boolean adduser(String name, String bass) throws FileNotFoundException {
        int id=tiket.getid();
        String line = id+"@"+name + "@" + bass + "@";
        if (ob.write(line, "user.txt", true)) {
            return true;
        } else
            return false;
    }
    //function to show all user
    public ArrayList<Object> showalluser()throws FileNotFoundException{
         ArrayList<Object> user=new ArrayList<>();
         user=ob.readall("user.txt");
      return (ArrayList<Object>) (Object) user; 
    }
    //function to update user
    public String updateuser(String id,String name,String bass)throws FileNotFoundException{
      String s=ob.update(id,name,bass,"user.txt");
        return s;
    }
    //function to delete user
 
    public   void delete_user(String id_user) throws FileNotFoundException
        {
            String s;
            admin_code y;
            ArrayList<admin_code> k = new ArrayList();
            try (Scanner re = new Scanner(new File("user.txt"))) {
                while (re.hasNext()) {
                    y = new admin_code();
                    s = re.nextLine();
                    String[] seprator = s.split("@");
                    y.c = Integer.parseInt(seprator[0]);
                    y.name = seprator[1];
                    y.pass = seprator[2];
                    k.add(y);
                }
                re.close();
            } catch (FileNotFoundException e) {
                System.err.println("admin code 59");
            }
            admin_code pep = new admin_code();
            for (int o=0;o<k.size();o++)
            {
                pep = (admin_code) k.get(o);
                if(pep.id==id_user)
                {
                    k.remove(o);
                }
            }
            try (BufferedWriter p = new BufferedWriter(new FileWriter("user.txt"))) {
                for (int o=0;o<k.size();o++)
                {
                    pep = (admin_code) k.get(o);
                    p.write(pep.c + "@" + pep.name + "@" + pep.pass + "@");
                    p.append("\n");
                }
                p.close();
            } catch (IOException e) {
                System.err.println("admin code 79");
            }}}