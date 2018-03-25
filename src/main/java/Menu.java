public class Menu {


    public static void printMenuForAdmin() {

        System.out.println("Pasirinkite norimą punktą: \n");

        System.out.println("1. Užregistruoti naują vartotoją");
        System.out.println("2. Pridėti kursą");
        System.out.println("3. Ištrinti kursą");
        System.out.println("4. Pakeisti kursą");
        System.out.println("5. Visų studentų sąrašas");
        System.out.println("6. Visų kursų sąrašas");
        Actions.menuActionsByAdmin();
        printMenuForAll();
    }

    public static void printMenuForLecturer() {
        System.out.println("1. Veiksmas L");
        System.out.println("2. Veiksmas L");
        System.out.println("3. Veiksmas L");
        System.out.println("4. Exit");
        Actions.menuActionsByLecturer();
    }


    public static void printMenuForStudent(String user) {
        System.out.println("1. Pažiūrėti savo info");
        System.out.println("2. Keisti savo info");
        System.out.println("4. Exit");
        Actions.menuActionsByStudent(user);
    }


    public static void printMenuForAll() {

        System.out.println("Pasirinkite norimą punktą: \n");
        System.out.println("1. Grįžti į Meniu");
        System.out.println("2. Išeiti iš programos");
        Actions.menuActionsToAll();
    }

}
