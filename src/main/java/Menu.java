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
        printMenuForAll();
    }

    public static void printMenuForLecturer() {
        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Pridėti kursą");
        System.out.println("4. Pridėti kursą");
        System.out.println("5. Ištrinti kursą");
        System.out.println("6. Pakeisti kursą");
        System.out.println("7. Priskirti kursai: ");
        System.out.println("8. Studentai užsiregisntravę į kursus");
        System.out.println("9. Exit");

        Actions.menuActionsByLecturer();
        printMenuForAll();
    }


    public static void printMenuForStudent( ) {
        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("3. Visų kursų sąrašas");
        System.out.println("4. Užsiregistruotų kursų sąrašas");
        System.out.println("5. Užsiregistruoti į kursą");
        System.out.println("6. Exit");

        Actions.menuActionsByStudent();
    }

    public static void printMenuForAll() {

        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");

        Actions.menuActionsToAll();
    }
}
