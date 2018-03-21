import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Login  {


    ///Ciklo reikia, kad loginas pasijungtų iš failo...

    public static void login() {


        System.out.println("Prašau įveskite username");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("Prašau įveskite password");
        String input1 = sc.next();


        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;


            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");


                ///Čia reikia susitvarkyti norm. loginą, kad neteisingu atveju gerą print duotų ir teisingu nebeimtu blogo print... Gal IF iF'e - pabandyti.

                if (splited[3].equals(input) && splited[2].equals(input1)) {
                    MenuByRole.printMenuForAdmin();
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
