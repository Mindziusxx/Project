public class Menu {


    public static void printMenuForAdmin() {

        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        System.out.println("7. Exit");

        Actions.menuActionsByAdmin();
        adminMenu();
    }

    public static void printMenuForLecturer() {
        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Pridėti kursą");
        System.out.println("4. Ištrinti kursą");
        System.out.println("5. Pakeisti kursą");
        System.out.println("6. Priskirti kursai: ");
        System.out.println("7. Studentai užsiregisntravę į kursus");
        System.out.println("8. Exit");

        Actions.menuActionsByLecturer();
        lecturerMenu();
    }


    public static void printMenuForStudent() {
        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Visų kursų sąrašas");
        System.out.println("4. Užsiregistruotų kursų sąrašas");
        System.out.println("5. Užsiregistruoti į kursą");
        System.out.println("6. Exit");
        Actions.menuActionsByStudent();

    }

    public static void adminMenu() {
        System.out.println(" \n Pasirinkite norimą punktą: \n");
        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");
        Actions.menuActionsToAdmin();
    }

    public static void studentMenu() {
        System.out.println(" \n Pasirinkite norimą punktą: \n");
        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");
        Actions.menuActionsToStudent();
    }

    public static void lecturerMenu() {
        System.out.println(" \n Pasirinkite norimą punktą: \n");
        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");
        Actions.menuActionsToLecturer();
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
}
