public class Menu {

    public static void printMenuForAdmin() {

        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        System.out.println("7. Baigti darbą");
        ActionsForMenu.menuActionsByAdmin();
        otherMenu();
    }

    public static void printMenuForLecturer() {
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
        otherMenu();
    }

    public static void printMenuForStudent() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Visų kursų sąrašas");
        System.out.println("4. Užsiregistruotų kursų sąrašas");
        System.out.println("5. Užsiregistruoti į kursą");
        System.out.println("6. Baigti darbą");
        ActionsForMenu.menuActionsByStudent();
        otherMenu();
    }

    public static void adminMenu() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.menuActionsToAdmin();
    }

    public static void studentMenu() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.menuActionsToStudent();
    }

    public static void lecturerMenu() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");
        ActionsForMenu.menuActionsToLecturer();
    }

    public static void otherMenu() {

        if (Login.getCurrentUser().getRole().equals("admin")) {
            adminMenu();
        }
        if (Login.getCurrentUser().getRole().equals("student")) {
            studentMenu();
        }
        if (Login.getCurrentUser().getRole().equals("lecturer")) {
            lecturerMenu();
        }
    }


    public static void userMenuChange() {
        System.out.println("\nIšsirinkite pageidaujamą punktą:\n");
        System.out.println("1. Grįžti į pagrindinį sąrašą");
        System.out.println("2. Baigti darbą");

    }

}
