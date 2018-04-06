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
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {

        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Users.getUserInformation();
                break;
            case 2:
                Users.changeUserInfo();
                break;
            case 3:
                Courses.createCourseByLecturer();
                break;
            case 4:
                Courses.deleteCourseByAdmin();
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
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuActionsByStudent() {

        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Users.getUserInformation();
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
                Courses.userRegistrationInCourse();
                break;
            case 6:
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void additionalActionsForAdmin() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForAdmin();
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
        }
    }

    public static void additionalActionsForStudent() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForStudent();
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
        }
    }

    public static void additionalActionsForLecturer() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                Menu.mainMenuForLecturer();
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.println("Jūs išėjote iš programos!");
                System.out.println("-------------------------");
                System.exit(0);
                break;
        }
    }
}
