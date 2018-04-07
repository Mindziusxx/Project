import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class Courses {

    private String code;
    private String tittle;
    private String desciption;
    private String startDate;
    private String credit;
    private String lecturerId;

    public Courses() {
        this.code = code;
        this.tittle = tittle;
        this.desciption = desciption;
        this.startDate = startDate;
        this.credit = credit;
        this.lecturerId = lecturerId;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDesciption() {
        return desciption;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCredit() {
        return credit;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String setTittle(String tittle) {
        this.tittle = tittle;
        return tittle;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }


    public static void createCourseByAdmin() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courseListFile.csv", true))

        ) {
            System.out.println("-------------------");
            System.out.println("Naujo kurso registracija");
            System.out.println("-------------------");
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
            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
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
            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

            System.out.println("Kursas sukurtas!");
        } catch (Exception e) {
            System.out.println("createCourseByLecturer" + e);
        }
    }


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

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[2].equals(Login.getCurrentUser().getUserName())) {
                    System.out.println(splited[3]);
                }
            }
        } catch (Exception e) {
        }
    }


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
        System.out.println("Kurso duomenys atnaujinti!\n");
    }

    public static void changeCourseByLecturer() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            Courses.searchCourseByLecturer();
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

    public static void userRegistrationInCourse() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("studentsInCourseFile.csv", true))
        ) {
            searchAllCourses();
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
        System.out.println("Jūs prisiregistravote į kursą!");
        Menu.menuForAllRolesValidation();
    }

    public static void searchStudentCourses() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("studentsInCourseFile.csv"))
        ) {
            String read = null;
            int i = 1;
            String userNameId = returnStudentId(Login.getCurrentUser().getUserName());
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

                if (returnLecturerId(Login.getCurrentUser().getUserName()).equals(splited[1]))
                    System.out.println(splited[0] + splited[2]);
            }
        } catch (Exception e) {
        }
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

    public static void deleteCourseByAdmin() {

        List<String> userStgrings = new ArrayList<>();
        Courses courses = new Courses();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            searchAllCourses();
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
        System.out.println(courses.getTittle() + " kursas ištrintas!");
    }


    public static void deleteCourseByLecturer() {

        List<String> userStgrings = new ArrayList<>();
        Courses courses = new Courses();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            searchCourseByLecturer();
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
        System.out.println(courses.getTittle() + " kursas ištrintas!");
    }
}