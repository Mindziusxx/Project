import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Login extends ScannerUtils {



    ///Ciklo reikia, kad loginas pasijungtų iš failo...

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

                if (splited[5].equals(input) && splited[4].equals(input1)) {
                    MenuByRole.printMenuForAdmin();
                } else {
                    System.out.println("username arba password yra neteisingas");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
