import java.util.Scanner;

public class MenuByRole {




    public static void printMenuForAdmin() {

        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        ActionByRole.menuActionsByAdmin();
        printMenuForAll();
    }


    public static void printMenuForLecturer() {
        System.out.println("1. Veiksmas 1");
        System.out.println("2. Veiksmas 2");
        System.out.println("3. Veiksmas 3");
        System.out.println("4. Exit");
    }


    public static void printMenuForStudent() {
        System.out.println("1. Veiksmas 1");
        System.out.println("2. Veiksmas 2");
        System.out.println("3. Veiksmas 3");
        System.out.println("4. Exit");
    }


    public static void printMenuForAll() {

        System.out.println("Pasirinkite norimą punktą: \n");
        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");
        ActionByRole.menuActionsToAll();
    }

}
