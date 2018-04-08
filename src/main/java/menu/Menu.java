package menu;

import login.Login;

public class Menu {

    public static void mainMenuForAdmin() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        System.out.println("7. Baigti darbą");
        MenuActions.menuActionsByAdmin();
        menuForAllRolesValidation();
    }

    public static void mainMenuForLecturer() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Pridėti kursą");
        System.out.println("4. Ištrinti kursą");
        System.out.println("5. Pakeisti kursą");
        System.out.println("6. Priskirti kursai: ");
        System.out.println("7. Studentai užsiregisntravę į kursus");
        System.out.println("8. Baigti darbą");
        MenuActions.menuActionsByLecturer();
        menuForAllRolesValidation();
    }

    public static void mainMenuForStudent() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Visų kursų sąrašas");
        System.out.println("4. Užsiregistruotų kursų sąrašas");
        System.out.println("5. Užsiregistruoti į kursą");
        System.out.println("6. Baigti darbą");
        MenuActions.menuActionsByStudent();
        menuForAllRolesValidation();
    }

    public static void additionalMenuForAdmin() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        MenuActions.additionalActionsForAdmin();
    }

    public static void additionalMenuForStudent() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        MenuActions.additionalActionsForStudent();
    }

    public static void additionalMenuForLecturer() {
        System.out.println("\n----------------------------------");
        System.out.println("Išsirinkite pageidaujamą punktą:");
        System.out.println("----------------------------------");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        MenuActions.additionalActionsForLecturer();
    }

    public static void menuForAllRolesValidation() {
        if (Login.getCurrentUser().getRole().equals("admin")) {
            additionalMenuForAdmin();
        }
        if (Login.getCurrentUser().getRole().equals("student")) {
            additionalMenuForStudent();
        }
        if (Login.getCurrentUser().getRole().equals("lecturer")) {
            additionalMenuForLecturer();
        }
    }
}