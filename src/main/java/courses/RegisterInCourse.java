package courses;
import login.Login;
import menu.Menu;
import scanner.ScannerUtils;

import java.io.*;

public class RegisterInCourse {

    public static void userRegistrationInCourse() throws IOException {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("studentsInCourseFile.csv", true))
        ) {
            SearchCourse.searchAllCourses();
            System.out.println("\nRegistruokitės iš pateikto sąrašo (įveskite kurso pavadinimą):");
            courses.setTittle(ScannerUtils.scannerForWord());
            System.out.println("Įrašykite lektorių:");
            String UserName = ScannerUtils.scannerForWord();
            String studentId = returnStudentId(Login.getCurrentUser().getUserName());
            String lecturerId = returnLecturerId(UserName);
            String coursesTittle = courses.getTittle();

            bufferedWriter.newLine();
            bufferedWriter.write(studentId + "," + lecturerId + "," + coursesTittle);

        } catch (Exception e) {
            System.out.println("userRegistrationInCourse" + e);
        }
        System.out.println("\nJūs prisiregistravote į kursą!");
        Menu.menuForAllRolesValidation();
    }

    public static String returnLecturerId(String userName) {
        Courses courses = new Courses();

        try (
                BufferedReader in = new BufferedReader(new FileReader("usersFile.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[4].equals(userName)) {
                    courses.setLecturerId(splited[0]);
                } else {
                }
            }
        } catch (Exception e) {
        }
        return courses.getLecturerId();
    }

    public static String returnStudentId(String userName) {
        try (
                BufferedReader in = new BufferedReader(new FileReader("usersFile.csv"))
        ) {
            String read = null;
            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[4].equals(userName)) {
                    Login.getCurrentUser().setID(splited[0]);
                } else {
                }
            }
        } catch (Exception e) {
        }
        return Login.getCurrentUser().getID();
    }
}
