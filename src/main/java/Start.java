import java.io.*;

public class Start {

    public static void startProgram() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("users.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                CreateFile.createFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }

    public static void startProgram1() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("course list.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                CreateFile.createFile1();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }

    public static void startProgram2() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("student in course.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                CreateFile.createFile2();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }
}


