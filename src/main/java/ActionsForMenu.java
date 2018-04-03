public class ActionsForMenu {

    public static void menuActionsByAdmin() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Users.registerNewUser();
                Menu.otherMenu();
                break;
            case 2:
                System.out.println("Pridėti kursą");
                Courses.createCourseByAdmin1();
                break;
            case 3:
                System.out.println("Ištrinti kursą");
                break;
            case 4:
                System.out.println("Pakeisti kursą");
                Courses.changeCourseByAdmin();
                break;
            case 5:
                Users.searchUser();
                break;
            case 6:
                Courses.searchCourseByStudent();
                break;
            case 7:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Users.userInfo();
                Menu.otherMenu();
                break;
            case 2:
                Users.changeUserInfo();
                break;
            case 3:
                Courses.createCourseByLecturer1();
                break;
            case 4:
                System.out.println("Ištrinti kursą");
                break;
            case 5:
                System.out.println("Pakeisti kursą");
                Courses.changeCourseByLecturer ();
                break;
            case 6:
                System.out.println("Priskirti kursai: ");
                Courses.searchCourseByLecturer();
                break;
            case 7:
                System.out.println("Studentai užsiregisntravę į kursus");
                Courses.searchAllStudentInCourses();
                break;
            case 8:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuActionsByStudent( ) {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Users.userInfo();
                break;
            case 2:
                Users.changeUserInfo();
                break;
            case 3:
                Courses.searchCourseByStudent();
                break;
            case 4:
                Courses.searchStudentCourses();
                break;
            case 5:
                System.out.println("Užsiregistruoti į kursą");
                Courses.userRegistrationInCourse();
                break;
            case 6:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuActionsToAdmin() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForAdmin();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
        }
    }

    public static void menuActionsToStudent() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForStudent();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
        }
    }

    public static void menuActionsToLecturer() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForLecturer();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                System.exit(0);
                break;
        }
    }
}