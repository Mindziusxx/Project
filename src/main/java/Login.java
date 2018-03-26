import java.io.BufferedReader;
import java.io.FileReader;

public class Login {

    public static void login() {

        Users users = new Users();

        System.out.println("Prašau įveskite username");
        users.setUserName(ScannerUtils.scanner());
        System.out.println("Prašau įveskite password");
        users.setPassword(ScannerUtils.scanner());

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[4].equals(users.getUserName()) && splited[3].equals(users.getPassword())) {

                    if (splited[5].equals(RoleNew.ADMIN.getroleName())) {
                        Menu.printMenuForAdmin();
                    }
                    if (splited[5].equals(RoleNew.LECTURER.getroleName())) {
                        Menu.printMenuForLecturer();
                    }
                    if (splited[5].equals(RoleNew.STUDENT.getroleName())) {
                        Menu.printMenuForStudent(users.getUserName());
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

