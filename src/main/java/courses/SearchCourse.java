package courses;

import login.Login;

import java.io.BufferedReader;
import java.io.FileReader;

public class SearchCourse {

    public static void searchAllCourses() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("courseListFile.csv"))
        ) {
            String read = null;
            in.readLine();
            int i = 1;
            System.out.println("--------------");
            System.out.println("Kursų sąrašas:");
            System.out.println("--------------");
            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                System.out.println((i++) + ". " + splited[3]);
            }
        } catch (Exception e) {
        }
    }

    public static void searchCourseByStudent() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("courseListFile.csv"))
        ) {
            String read = null;
            int i = 1;
            in.readLine();
            System.out.println("------------------");
            System.out.println("Vykstantys kursai:");
            System.out.println("------------------");

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                    System.out.println((i++) + ". " + splited[3]);
            }

        } catch (Exception e) {
        }
    }

    public static void searchCourseByLecturer() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("courseListFile.csv"))
        ) {
            String read = null;
            System.out.println("-------");
            System.out.println("Kursai:");
            System.out.println("-------");
            int i = 1;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[2].equals(Login.getCurrentUser().getUserName())) {
                    System.out.println((i++) + ". " + splited[3]);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void searchStudentCourses() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("studentsInCourseFile.csv"))
        ) {
            String read = null;
            int i = 1;
            String userNameId = RegisterInCourse.returnStudentId(Login.getCurrentUser().getUserName());
            System.out.println("---------------------");
            System.out.println("Jūsų lankomi kursai:");
            System.out.println("---------------------");
            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                if (splited[0].equals(userNameId)) {
                    System.out.println((i++) + ". " + splited[2]);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void searchAllStudentInCourses() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("studentsInCourseFile.csv"))
        ) {
            String read = null;

            System.out.println("-------------------------");
            System.out.println("Kursą lankantys studentai:");
            System.out.println("-------------------------");

            while ((read = in.readLine()) != null) {

                String[] splited = read.split(",");
                int i = 1;
                if (RegisterInCourse.returnLecturerId(Login.getCurrentUser().getUserName()).equals(splited[1])) {

                    test(splited[0]);
                    System.out.println(Login.getCurrentUser().getFirstName() + " " + Login.getCurrentUser().getSecondName());
                }
            }
        } catch (Exception e) {
        }
    }

    public static String test(String studentId) {
        try (
                BufferedReader in = new BufferedReader(new FileReader("usersFile.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[0].equals(studentId)) {
                    Login.getCurrentUser().setFirstName(splited[1]);
                    Login.getCurrentUser().setSecondName(splited[2]);
                }
            }
        } catch (Exception e) {
        }
        return (Login.getCurrentUser().getFirstName() + Login.getCurrentUser().getSecondName());
    }
}
