public class ActionsForMenu {

    public static void menuActionsByAdmin() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Users.registerNewUser();
                break;
            case 2:
                Courses.createCourseByAdmin();
                break;
            case 3:
                Courses.deleteCourseByAdmin();
                break;
            case 4:
                Courses.changeCourseByAdmin();
                break;
            case 5:
                Users.searchAllStudents();
                break;
            case 6:
                Courses.searchAllCourses();
                break;
            case 7:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-7");
                menuActionsByAdmin();
                break;
        }
    }

    public static void menuActionsByLecturer() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Users.getUserInformation();
                break;
            case 2:
                Users.changeUserInformation();
                break;
            case 3:
                Courses.createCourseByLecturer();
                break;
            case 4:
                Courses.deleteCourseByLecturer();
                break;
            case 5:
                Courses.changeCourseByLecturer();
                break;
            case 6:
                Courses.searchCourseByLecturer();
                break;
            case 7:
                Courses.searchAllStudentInCourses();
                break;
            case 8:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-8");
                menuActionsByLecturer();
                break;
        }
    }

    public static void menuActionsByStudent() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Users.getUserInformation();
                break;
            case 2:
                Users.changeUserInformation();
                break;
            case 3:
                Courses.searchCourseByStudent();
                break;
            case 4:
                Courses.searchStudentCourses();
                break;
            case 5:
                Courses.userRegistrationInCourse();
                break;
            case 6:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-6");
                menuActionsByStudent();
                break;
        }
    }

    public static void additionalActionsForAdmin() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForAdmin();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-2");
                additionalActionsForAdmin();
                break;
        }
    }

    public static void additionalActionsForStudent() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForStudent();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-2");
                additionalActionsForStudent();
                break;

        }
    }

    public static void additionalActionsForLecturer() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForLecturer();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos!");
                System.exit(0);
                break;
            default:
                System.out.println("Tokios pasirinkimo nėra, rinkitės punktą tarp 1-2");
                additionalActionsForLecturer();
                break;
        }
    }
}
