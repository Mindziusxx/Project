package courses;

import login.Login;
import scanner.ScannerUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.UUID;

public class CreateCourse {
    public static void createCourseByAdmin() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courseListFile.csv", true))

        ) {
            System.out.println("------------------------");
            System.out.println("Naujo kurso registracija");
            System.out.println("------------------------");
            System.out.println("Įveskite lektoriaus prisijungimo vardą:");
            Login.getCurrentUser().setUserName(ScannerUtils.scannerForWord());
            System.out.println("\nĮveskite kurso pavadinimą:");
            courses.setTittle(ScannerUtils.scannerForWord());
            System.out.println("\nĮveskite kurso aprašymą:");
            courses.setDesciption(ScannerUtils.scannerForWord());
            System.out.println("\nĮveskite kurso pradžios datą:");
            courses.setStartDate(ScannerUtils.scannerForWord());
            System.out.println("\nĮveskite kreditus:");
            courses.setCredit(ScannerUtils.scannerForWord());

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + RegisterInCourse.returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

        } catch (Exception e) {
            System.out.println("createCourseByAdmin" + e);
        }
        System.out.println("\nNaujas kursas sukurtas sėkmingai!");
    }

    public static void createCourseByLecturer() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courseListFile.csv", true))
        ) {
            System.out.println("------------------------");
            System.out.println("Naujo kurso registracija");
            System.out.println("------------------------");

            System.out.println("Įveskite kuros pavadinimą:");
            courses.setTittle(ScannerUtils.scannerForWord());
            System.out.println("Įveskite kurso aprašymą:");
            courses.setDesciption(ScannerUtils.scannerForWord());
            System.out.println("Įveskite kurso pradžios datą:");
            courses.setStartDate(ScannerUtils.scannerForWord());
            System.out.println("Įveskite kreditų kiekį:");
            courses.setCredit(ScannerUtils.scannerForWord());

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + RegisterInCourse.returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

            System.out.println("Kursas sukurtas!");
        } catch (Exception e) {
            System.out.println("createCourseByLecturer" + e);
        }
    }
}
