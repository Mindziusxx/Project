package courses;

import scanner.ScannerUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteCourse {
    public static void deleteCourseByAdmin() {

        List<String> userStgrings = new ArrayList<>();
        Courses courses = new Courses();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            SearchCourse.searchAllCourses();
            System.out.println("\nĮrašykite, iš pateikto sąrašo, kursą, kurį norite ištrinti:");
            String courseName = ScannerUtils.scannerForWord();
            courses.setTittle(courseName);

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.split(",")[3].equals(courseName))
                    userStgrings.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStgrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+courses.getTittle() + " kursas ištrintas!");
    }

    public static void deleteCourseByLecturer() {

        List<String> userStgrings = new ArrayList<>();
        Courses courses = new Courses();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            SearchCourse.searchCourseByLecturer();
            System.out.println("\nĮrašykite, iš pateikto sąrašo, kursą, kurį norite ištrinti:");
            String courseName = ScannerUtils.scannerForWord();
            courses.setTittle(courseName);

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.split(",")[3].equals(courseName))
                    userStgrings.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStgrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+courses.getTittle() + " kursas ištrintas!");
    }
}
