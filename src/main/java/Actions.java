import java.io.BufferedWriter;
import java.io.FileWriter;

public class Actions {

    public static void menuActionsByAdmin() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Actions.registerNewUser();
                break;
            case 2:
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("ats 1");
                break;
            case 2:
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByStudent() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("ats 1");
                break;
            case 2:
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsToAll() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForAdmin();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                break;
        }
    }


    public static void registerNewUser() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt", true))
        ) {
            System.out.println("Įveskite firstName:");
            String firstName = ScannerUtils.scanner();
            System.out.println("Įveskite secondName:");
            String secondName = ScannerUtils.scanner();
            System.out.println("Įveskite password:");
            String password = ScannerUtils.scanner();
            System.out.println("Įveskite userName:");
            String userName = ScannerUtils.scanner();
            System.out.println("Įveskite ROLE:");
            String role = ScannerUtils.scanner();
            bufferedWriter.newLine();
            bufferedWriter.write(firstName + "," + secondName + "," + password + "," + userName + "," + role);
            System.out.println("Naujas vartotojas sukurtas sėkmingai! \n");
        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }
}