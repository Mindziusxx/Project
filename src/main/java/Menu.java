public class Menu {

    public static void mainMenuForAdmin() {

        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        System.out.println("7. Baigti darbą");
        ActionsForMenu.menuActionsByAdmin();
        menuForAllRolesValidation();
    }

    public static void mainMenuForLecturer() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Pridėti kursą");
        System.out.println("4. Ištrinti kursą");
        System.out.println("5. Pakeisti kursą");
        System.out.println("6. Priskirti kursai: ");
        System.out.println("7. Studentai užsiregisntravę į kursus");
        System.out.println("8. Baigti darbą");
        ActionsForMenu.menuActionsByLecturer();
        menuForAllRolesValidation();
    }

    public static void mainMenuForStudent() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Visų kursų sąrašas");
        System.out.println("4. Užsiregistruotų kursų sąrašas");
        System.out.println("5. Užsiregistruoti į kursą");
        System.out.println("6. Baigti darbą");
        ActionsForMenu.menuActionsByStudent();
        menuForAllRolesValidation();
    }

    public static void additionalMenuForAdmin() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.additionalActionsForAdmin();
    }

    public static void additionalMenuForStudent() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.additionalActionsForStudent();
    }

    public static void additionalMenuForLecturer() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.additionalActionsForLecturer();
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


    public static void userMenuChange() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");

    }

}
