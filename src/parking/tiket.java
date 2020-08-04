package parking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class tiket extends FileM{
    public static int id;
    public String intry;
    public String out;
    public int  ID ;
    public int cost;
    public String floar_name;
    public String car_number;
    public int ereor;
    public  int counter ;
    public tiket() {
    }
FileM f;
    public static int idd() throws FileNotFoundException {
      int x = FileM.ReadAllLines("id.txt");
        return x;
    }

    public static int getid() throws FileNotFoundException {
        int z = idd();
        FileM.writeid(++z,"id.txt",false);
        return z;
    }

    public   ArrayList<Object> store_array(String File_name) {
        String s;
        tiket y;
        ArrayList<tiket> k = new ArrayList();
        try (Scanner re = new Scanner(new File(File_name))) {
            while (re.hasNext()) {
                y = new tiket();
                s = re.nextLine();
                String[] seprator = s.split("@");
                y.ID = Integer.parseInt(seprator[0]);
                y.car_number = seprator[1];
                y.floar_name = seprator[2];
                y.intry = seprator[3];
                k.add(y);
            }
            re.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (ArrayList<Object>) (Object) k;
    }
 
    public   void write_file(String File_name,ArrayList<Object> h){
        try (BufferedWriter p = new BufferedWriter(new FileWriter("database.txt"))) {
            tiket pep = new tiket();
            for (int o=0;o<h.size();o++)
            {
                pep = (tiket) h.get(o);
                    p.write(pep.ID + "@" + pep.car_number + "@" + pep.floar_name + "@" + pep.intry);
                    p.append("\n");
            }
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
 }}

    public   Object print_recet(String platenumber, String floar_name) throws FileNotFoundException{
        tiket y = new tiket();
        id = getid();
        Date date = new Date();
        SimpleDateFormat q = new SimpleDateFormat("hh");
        y.ID = id;
        y.car_number = platenumber;
        y.floar_name = floar_name;
        y.intry = q.format(date);
         try (BufferedWriter p = new BufferedWriter(new FileWriter("database.txt", true))) {
            p.write(id + "@" + platenumber + "@" + floar_name + "@" + q.format(date));
            //p.write(String.valueOf(car));
            p.append('\n');
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return y;
    }

    public   tiket read_recet(int id) throws FileNotFoundException {
        String s = null;
        tiket x = null;
        tiket xd = null;
        try (Scanner re = new Scanner(new File("database.txt"))) {
            Date date2 = new Date();
            SimpleDateFormat q = new SimpleDateFormat("hh");
            while (re.hasNext()) {
                x = new tiket();
                x.ereor =0;
                s = re.nextLine();
                String[] seprator = s.split("@");
                x.ID = Integer.parseInt(seprator[0]);
                if (id == x.ID) {
                int y1,y2,cost;
                    y1 = Integer.parseInt(seprator[3]);
                    y2 = Integer.parseInt(q.format(date2));
                    cost = Math.abs(y1 - y2)*20;
                    x.ereor=1;
                    x.ID = Integer.parseInt(seprator[0]);
                    x.car_number = seprator[1];
                    x.floar_name = seprator[2];
                    x.intry = seprator[3];
                    x.out = q.format(date2);
                    x.cost = cost;
                    get_cost(cost);
                    xd=x;
                    try (BufferedWriter b = new BufferedWriter(new FileWriter("data_out_car.txt", true))) {
                        b.write(x.car_number + "@" + x.intry + "@" + q.format(date2) + "@" + x.cost);
                        b.append('\n');
                        b.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            ArrayList<Object> t = store_array("database.txt");
            tiket pep = new tiket();
            for (int o=0;o<t.size();o++)
            {
                pep = (tiket) t.get(o);
                if(pep.ID==id)
                {
                    t.remove(o);
                }
            }
            write_file("database.txt",t);
        }
        return xd;
    }

    public   ArrayList<tiket> read_all() throws FileNotFoundException {
        String s = null;
        String []u = new String[10];
        ArrayList<tiket> n = new ArrayList();
        tiket x;
        int xd=0;
        try (Scanner re = new Scanner(new File("data_out_car.txt"))) {
            int i = 0;
            while (re.hasNext()) {
                x = new tiket();
                s = re.nextLine();
                String[] seprator = s.split("@");
                x.car_number = seprator[0];
                x.intry = seprator[1];
                x.out = seprator[2];
                x.cost = Integer.parseInt(seprator[3]);
                x.counter=++xd;
                //System.out.println(x.car_number + " " + x.intry + " " + x.out);
                n.add(x);
            }
            re.close();
        }
        return (ArrayList<tiket>)n;    }
  
    public  void get_cost(int num) throws FileNotFoundException{
             int sum=0;
        Scanner read=new Scanner(new File("money.txt"));
            int rule=read.nextInt();
            sum=rule+num;
        read.close();
          try {
           PrintWriter file = new PrintWriter(new File("money.txt"));
           file.print(sum);
           file.close();
       } catch (FileNotFoundException ex) {
       }
    }
 
    public  void re(String file_name,int spot){
   FileM ob = new FileM();
   ob.writeid(spot,file_name,false);
}
 
    public  void re2(String file_name,String s){
   FileM ob = new FileM();
   ob.write2(s,file_name,false);
}

    public int get_number_from_file(String file_name ){
    
        Scanner obj1;
        int x=0;
        try {
            obj1 = new Scanner(new File(file_name));
        
        while(obj1.hasNext()){
            x=obj1.nextInt();
      }
        obj1.close();
      
        } catch (FileNotFoundException ex) {
        }
        return x;
    }}