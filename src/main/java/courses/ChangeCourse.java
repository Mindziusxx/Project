package courses;

import login.Login;
import scanner.ScannerUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeCourse {

    public static void changeCourseByAdmin() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            System.out.println("Įveskite kurso pavadinimą, kurį norite redaguoti: ");
            String course = ScannerUtils.scannerForWord();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course)) {
                    List<String> splited = Arrays.asList(line.split(","));

                    System.out.println("--------------------------------");
                    System.out.println("Norite pakeisti Lektorių? (Y/N)?");
                    System.out.println("--------------------------------");
                    String answer1 = ScannerUtils.scannerForWord();

                    if (answer1.equals("Y") || answer1.equals("y")) {
                        System.out.println("\nĮveskite naujas lektoriaus vartotojo vardas: ");
                        String lecturerUserName = ScannerUtils.scannerForWord();
                        splited.set(2, lecturerUserName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setUserName(lecturerUserName);
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Norite pakeisti kurso pavadinimą? (Y/N)?");
                    System.out.println("----------------------------------------");
                    String answer2 = ScannerUtils.scannerForWord();

                    if (answer2.equals("Y") || answer2.equals("y")) {
                        System.out.println("\nĮrašykite naują kurso pavadinimą:");
                        String courseName = ScannerUtils.scannerForWord();
                        splited.set(3, courseName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(courseName);
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("Norite pakeisti kurso aprašymą (Y/N)?");
                    System.out.println("-------------------------------------");
                    String answer3 = ScannerUtils.scannerForWord();

                    if (answer3.equals("Y") || answer3.equals("y")) {
                        System.out.println("\nĮrašykite naują kurso aprašymą:");
                        String courseDesciption = ScannerUtils.scannerForWord();
                        splited.set(4, courseDesciption);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(courseDesciption);
                    }

                    System.out.println("-------------------------------------------");
                    System.out.println("Norite pakeisti kurso pradžios datą? (Y/N)?");
                    System.out.println("-------------------------------------------");

                    String answer4 = ScannerUtils.scannerForWord();

                    if (answer4.equals("Y") || answer4.equals("y")) {

                        System.out.println("\nĮrašykite naują kurso pradžios datą: ");
                        String newStartDate = ScannerUtils.scannerForWord();
                        splited.set(5, newStartDate);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(newStartDate);
                    }

                    System.out.println("---------------------------------------");
                    System.out.println("Norite pakeisti kreditų skaičių? (Y/N)?");
                    System.out.println("---------------------------------------");

                    String answer5 = ScannerUtils.scannerForWord();

                    if (answer5.equals("Y") || answer5.equals("y")) {
                        System.out.println("\nĮrašykite naują kreditų skaičių: ");
                        String newCredit = ScannerUtils.scannerForWord();
                        splited.set(6, newCredit);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(newCredit);
                    }
                } else {
                    System.out.println("Tokio kurso nėra!");
                }
                userStgrings.add(line);
            }
        } catch (Exception e) {
            System.out.println("changeCourseByAdmin" + e);
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
    }

    public static void changeCourseByLecturer() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            SearchCourse.searchCourseByLecturer();
            System.out.println("Įveskite kurso pavadinimą iš pateikto sąrašo, kurį norite keisti:");
            String course = ScannerUtils.scannerForWord();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course) && line.split(",")[2].equals(Login.getCurrentUser().getUserName())) {
                    List<String> splited = Arrays.asList(line.split(","));

                    System.out.println("----------------------------------------");
                    System.out.println("Norite pakeisti kurso pavadinimą? (Y/N)?");
                    System.out.println("----------------------------------------");
                    String answer1 = ScannerUtils.scannerForWord();
                    if (answer1.equals("Y") || answer1.equals("y")) {
                        System.out.println("\nĮveskite kurso pavadinimą:");
                        String tittle = ScannerUtils.scannerForWord();
                        splited.set(3, tittle);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(tittle);
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Norite pakeisti kurso aprašymą? (Y/N)?");
                    System.out.println("----------------------------------------");
                    String answer2 = ScannerUtils.scannerForWord();
                    if (answer2.equals("Y") || answer2.equals("y")) {
                        System.out.println("\nĮveskite kurso aprašymą:");
                        String courseDesciption = ScannerUtils.scannerForWord();
                        splited.set(4, courseDesciption);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(courseDesciption);
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Norite pakeisti kurso pradžios datą? (Y/N)?");
                    System.out.println("----------------------------------------");
                    String answer3 = ScannerUtils.scannerForWord();
                    if (answer3.equals("Y") || answer3.equals("y")) {
                        System.out.println("\nĮveskite kurso pradžios datą:");
                        String startDate = ScannerUtils.scannerForWord();
                        splited.set(5, startDate);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(startDate);
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Norite pakeisti keditų kiekį? (Y/N)?");
                    System.out.println("----------------------------------------");
                    String answer4 = ScannerUtils.scannerForWord();
                    if (answer4.equals("Y") || answer4.equals("y")) {
                        System.out.println("\nĮveskite keditų kiekį:");
                        String credit = ScannerUtils.scannerForWord();
                        splited.set(6, credit);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(credit);
                    }
                }
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
        System.out.println("Kursas atnaujintas!");
    }
}
