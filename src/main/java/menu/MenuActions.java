package menu;

import courses.*;
import scanner.ScannerUtils;
import users.UserInformation;
import users.UserRegistration;
import users.Users;

import java.io.IOException;

public class MenuActions {

    public static void menuActionsByAdmin() {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                UserRegistration.registerNewUser();
                break;
            case 2:
                CreateCourse.createCourseByAdmin();
                break;
            case 3:
                DeleteCourse.deleteCourseByAdmin();
                break;
            case 4:
                ChangeCourse.changeCourseByAdmin();
                break;
            case 5:
                Users.searchAllStudents();
                break;
            case 6:
                SearchCourse.searchAllCourses();
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

    public static void menuActionsByLecturer() throws IOException {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                UserInformation.getUserInformation();
                break;
            case 2:
                UserInformation.changeUserInformation();
                break;
            case 3:
                CreateCourse.createCourseByLecturer();
                break;
            case 4:
                DeleteCourse.deleteCourseByLecturer();
                break;
            case 5:
                ChangeCourse.changeCourseByLecturer();
                break;
            case 6:
                SearchCourse.searchCourseByLecturer();
                break;
            case 7:
                SearchCourse.searchAllStudentInCourses();
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

    public static void menuActionsByStudent() throws IOException {
        switch (ScannerUtils.scannerForNumber()) {
            case 1:
                UserInformation.getUserInformation();
                break;
            case 2:
                UserInformation.changeUserInformation();
                break;
            case 3:
                SearchCourse.searchCourseByStudent();
                break;
            case 4:
                SearchCourse.searchStudentCourses();
                break;
            case 5:
                RegisterInCourse.userRegistrationInCourse();
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

    public static void additionalActionsForAdmin() throws IOException {
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

    public static void additionalActionsForStudent() throws IOException {
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

    public static void additionalActionsForLecturer() throws IOException {
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
