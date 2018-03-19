import java.io.*;
import java.util.Scanner;

public class ScannerUtils extends Main {


    public static void createFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {
            bufferedWriter.write("admin,admin");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void login() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;
            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                System.out.println("Prašau įveskite username");
                Scanner sc = new Scanner(System.in);
                String input = sc.next();
                System.out.println("Prašau įveskite password");
                String input1 = sc.next();

                if (splited[0].equals(input) && splited[1].equals(input1)) {
                    Meniu.printMenu();
                } else{
                    System.out.println("username arba password yra neteisingas");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//
    public static String scanner () {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    public static int scanner1 () {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        return input1;
    }
}
