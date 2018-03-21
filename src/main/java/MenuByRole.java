import java.util.Scanner;

public class MenuByRole extends ScannerUtils {


    public static void menuActions() {

        switch (scanner1()) {
            case 1:
                ActionByRole.registerNewUser();
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


    public static void printMenuForAdmin() {

        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        menuActions();
    }


    public static void printMenuForLecturer() {
        System.out.println("1. Veiksmas 1");
        System.out.println("2. Veiksmas 2");
        System.out.println("3. Veiksmas 3");
        System.out.println("4. Exit");
        menuActions();
    }


    public static void printMenuForStudent() {
        System.out.println("1. Veiksmas 1");
        System.out.println("2. Veiksmas 2");
        System.out.println("3. Veiksmas 3");
        System.out.println("4. Exit");
        menuActions();
    }
}
