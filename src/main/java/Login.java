import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Login {

    public static void login() {

        ///Roles roles = new Roles();

        System.out.println("Prašau įveskite username");
        String userName = ScannerUtils.scanner();
        System.out.println("Prašau įveskite password");
        String password = ScannerUtils.scanner();


        BufferedReader in = null;


        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;


            ///Čia reikės taisyti, nes negerai user ieško...


            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[3].equals(userName) && splited[2].equals(password)) {
                    if (userName.equals(RoleNew.ADMIN.getroleName())) {
                        Menu.printMenuForAdmin();
                    }
                    if (userName.equals(RoleNew.LECTURER.getroleName())) {
                        Menu.printMenuForLecturer();
                    }
                    if (userName.equals(RoleNew.STUDENT.getroleName())) {
                        Menu.printMenuForStudent();
                    }
                    break;
                }

                else {
                    ///System.out.println("username arba password yra neteisingas");
                }
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }
}
