import java.io.BufferedReader;
import java.io.FileReader;

public class Login {

    public static void login() {


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

                if (splited[4].equals(userName) && splited[3].equals(password)) {

                    if (splited[5].equals(RoleNew.ADMIN.getroleName())) {
                        Menu.printMenuForAdmin();
                    }
                    if (splited[5].equals(RoleNew.LECTURER.getroleName())) {
                        Menu.printMenuForLecturer();
                    }
                    if (splited[5].equals(RoleNew.STUDENT.getroleName())) {
                        Menu.printMenuForStudent(userName);
                    }
                    break;
                } else {
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }




}

