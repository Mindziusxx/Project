import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Login {

    public static void  login() {

        Roles roles = new Roles();

        System.out.println("Prašau įveskite username");
        String userName = ScannerUtils.scanner();
        System.out.println("Prašau įveskite password");
        String password = ScannerUtils.scanner();


        BufferedReader in = null;


        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;


            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                ///Čia reikia susitvarkyti norm. loginą, kad neteisingu atveju gerą print duotų ir teisingu nebeimtu blogo print... Gal IF iF'e - pabandyti.

                if (splited[3].equals(userName) && splited[2].equals(password)) {
                    roles.checkRole("admin");
//                    Menu.printMenuForAdmin();
                    break;
                } else {
                    ///System.out.println("username arba password yra neteisingas");
                }
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }


}
