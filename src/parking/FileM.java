package parking;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
public class FileM {
    //function to write in file
    public boolean write(String word, String path, boolean apendtype) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(new java.io.File(path), apendtype));
            writer.println(word);
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
        return false;
    }

    //function to wrire in file id
    public static boolean writeid(int idd, String path, boolean apendtype) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(new java.io.File(path), apendtype));
            writer.println(idd);
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
        return false;
    }

    //function to read id from file
    public static int ReadAllLines(String path) throws FileNotFoundException {
        File myfile = new File(path);
        Scanner sc = new Scanner(myfile);
        int n = sc.nextInt();
        sc.close();
        return n;
    }

    public ArrayList<String> Read(String path) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner Reader = null;
        try {
            Reader = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        while (Reader.hasNext()) {
            String line = Reader.nextLine();
            String sperated[] = line.split("@");
            String s = sperated[0] + " " + sperated[1] + " " + sperated[2];
            arrayList.add(s);
        }
        Reader.close();
        return arrayList;
    }

    //fun read line by id
    public String read(String id, String path) {
        //ArrayList<String>Infile=new ArrayList<>();
        Scanner Reader = null;
        try {
            Reader = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        while (Reader.hasNext()) {
            String line = Reader.nextLine();
            String seprated[] = line.split("@");
            if (seprated[0].equals(id)) {
                Reader.close();
                return seprated[0] + " " + seprated[1] + " " + seprated[2];
            }
        }
        return null;
    }

    public ArrayList<Object> readall(String path) {
        admin_code x;
        ArrayList<admin_code> user = new ArrayList();
        try {
            Scanner reader = new Scanner(new File(path));
            while (reader.hasNext()) {
                x = new admin_code();
                String line = reader.nextLine();
                String[] sperated = line.split("@");
                x.c = Integer.parseInt(sperated[0]);
                x.name = sperated[1];
                x.pass = sperated[2];
                user.add(x);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return (ArrayList<Object>) (Object) user;
    }
       
    public String update(String id, String Name, String Bass, String path) throws FileNotFoundException {
        boolean apend;
        String s = "this user not found";
        admin_code pep = new admin_code();
        ArrayList<Object> arrayList = readall(path);
        for (int i = 0; i < arrayList.size(); i++) {
            pep = (admin_code) arrayList.get(i);
            if (i == 0) {
                apend = false;
            } else {
                apend = true;
            }
            if (pep.c == parseInt(id)) {
                pep.c = parseInt(id);
                pep.name = Name;
                pep.pass = Bass;
                String line = pep.c + "@" + pep.name + "@" + pep.pass + "@";
                write(line, "user.txt", apend);
                s = "this user is updated";
            } else {
                String line = pep.c + "@" + pep.name + "@" + pep.pass + "@";
                write(line, "user.txt", apend);
            }
        }
        return s;
    }

    public String deletd(int id, String path) throws FileNotFoundException {
        String s = "this user not found";
        boolean apend;
        int v = 0;
        admin_code pep = new admin_code();
        ArrayList<Object> arrayList = readall(path);
        for (int i = 0; i < arrayList.size(); i++) {
            pep = (admin_code) arrayList.get(i);
            if (i == 0 || v == 1) {
                apend = false;
            } else {
                apend = true;
            }
            if (pep.c == id) {
                s = "this use is deleted";
                if (i == 0) {
                    v = 1;
                }
            } else {
                String line = pep.c + "@" + pep.name + "@" + pep.pass + "@";
                if (i == 0 || v == 1) {
                    write(line, "user.txt", false);
                } else {
                    write(line, "user.txt", true);
                }}}
        return s;
    }   

    public static boolean write2(String id, String path, boolean apendtype) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(new java.io.File(path), apendtype));
            writer.println(id);
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
        return false;
    }
}