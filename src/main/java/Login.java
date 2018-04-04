import java.io.BufferedReader;
import java.io.FileReader;

public class Login {

    private static  Users currentUser;

    public static void login() {

        currentUser = new Users();

       while (true) {

           System.out.println("Vartotojas: ");
           currentUser.setUserName(ScannerUtils.scanner());
           System.out.println("Slaptažodis: ");
           currentUser.setPassword(ScannerUtils.scanner());

        try (
                BufferedReader in = new BufferedReader(new FileReader("users.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {

                try {

                String[] splited = read.split(",");

                if (splited[4].equals(currentUser.getUserName()) && splited[3].equals(currentUser.getPassword()) ) {


                        currentUser.setFirstName(splited[1]);
                        currentUser.setSecondName(splited[2]);
                        currentUser.setRole(splited[5]);
                        currentUser.setPersonalNumber(splited[6]);
                        currentUser.setDateOfBirth(splited[7]);
                        currentUser.setEmail(splited[8]);
                        currentUser.setMobileNumber(splited[9]);
                        currentUser.setGender(splited[10]);
                        currentUser.setAddress(splited[11]);
                        currentUser.setRunningCourses(splited[12]);

                        if (currentUser.getRole().equals(RoleNew.ADMIN.getroleName())) {
                            Menu.printMenuForAdmin();
                        }
                        if (currentUser.getRole().equals(RoleNew.LECTURER.getroleName())) {
                            Menu.printMenuForLecturer();
                        }
                        if (currentUser.getRole().equals(RoleNew.STUDENT.getroleName())) {
                            Menu.printMenuForStudent();
                        }
                        break;
                    } else {
                    }
            }
            catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
           System.out.println("\nNeteisingi prisijungimo duomenys. Bandykite dar kartą!\n");
    }
    }

    public static Users getCurrentUser(){
        return currentUser;
    }
}