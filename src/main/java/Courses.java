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

    public String getCode() {
        return code;
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

    public String setCode(String code) {
        this.code = code;
        return code;
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

            ///REIKIA PASIDARYTI TIKRINIMĄ TOKS USERIS EGZISTUOJA...

            System.out.println("Įveskite lektoriaus prisijungimo vardą");
            Login.getCurrentUser().setUserName(ScannerUtils.scannerForWord());

            System.out.println("\nĮveskite kurso pavadinimą: ");
            courses.setTittle(ScannerUtils.scannerForWord());
            System.out.println("\nKurso aprašymą: ");
            courses.setDesciption(ScannerUtils.scannerForWord());
            System.out.println("\nKurso pradžios data: ");
            courses.setStartDate(ScannerUtils.scannerForWord());
            System.out.println("\nKreditai: ");
            courses.setCredit(ScannerUtils.scannerForWord());

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
        System.out.println("Naujas kursas sukurtas sėkmingai! \n");
//        System.out.println("Tokio lektoriasu nėra. Bandykite dar kartą!\n");
    }

    public static void createCourseByLecturer() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courseListFile.csv", true))
        ) {

            System.out.println("Prašau įveskite tittle");
            courses.setTittle(ScannerUtils.scannerForWord());
            System.out.println("Prašau įveskite desciption");
            courses.setDesciption(ScannerUtils.scannerForWord());
            System.out.println("Prašau įveskite startDate");
            courses.setStartDate(ScannerUtils.scannerForWord());
            System.out.println("Prašau įveskite credit");
            courses.setCredit(ScannerUtils.scannerForWord());

            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

            System.out.println("Naujas kursas sukurtas sėkmingai! \n");

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }


    public static void searchCourseByStudent() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("courseListFile.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                System.out.println(splited[3]);
            }
        } catch (Exception e) {
        }
    }

    public static void searchCourseByLecturer() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("courseListFile.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[2].equals(Login.getCurrentUser().getUserName())) {
                    System.out.println("\nKursai:\n");
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

            System.out.println("Įveskite kurso pavadinimą, kurį norite keisti: ");
            String course = ScannerUtils.scannerForWord();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course)) {

                    System.out.println("\nPakeisti userName: ");
                    List<String> splited = Arrays.asList(line.split(","));
                    String uname = ScannerUtils.scannerForWord();
                    splited.set(2, uname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setUserName(uname);

                    System.out.println("\nPakeisti kurso pavadinimą: ");
                    String tittle = ScannerUtils.scannerForWord();
                    splited.set(3, tittle);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(tittle);

                    System.out.println("\nPakeisti kurso aprašymą:");
                    String desciption = ScannerUtils.scannerForWord();
                    splited.set(4, desciption);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(desciption);

                    System.out.println("\nPakeisti kurso pradžios datą: ");
                    String startDate = ScannerUtils.scannerForWord();
                    splited.set(5, startDate);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(startDate);

                    System.out.println("\nPakeisti keditų kiekį: ");
                    String credit = ScannerUtils.scannerForWord();
                    splited.set(6, credit);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(credit);
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
    }

    public static void changeCourseByLecturer() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {

            System.out.println("Įveskite kurso pavadinimą, kurį norite keisti: ");
            String course = ScannerUtils.scannerForWord();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course) && line.split(",")[2].equals(Login.getCurrentUser().getUserName())) {

                    System.out.println("\nPakeisti kurso pavadinimą: ");
                    List<String> splited = Arrays.asList(line.split(","));
                    String tittle = ScannerUtils.scannerForWord();
                    splited.set(3, tittle);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(tittle);

                    System.out.println("\nPakeisti kurso aprašymą:");
                    String desciption = ScannerUtils.scannerForWord();
                    splited.set(4, desciption);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(desciption);

                    System.out.println("\nPakeisti kurso pradžios datą: ");
                    String startDate = ScannerUtils.scannerForWord();
                    splited.set(5, startDate);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(startDate);

                    System.out.println("\nPakeisti keditų kiekį: ");
                    String credit = ScannerUtils.scannerForWord();
                    splited.set(6, credit);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(credit);
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
    }


    public static void userRegistrationInCourse() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("studentsInCourseFile.csv", true))
        ) {
            System.out.println("Kurso pavadinimas: ");
            courses.setTittle(ScannerUtils.scannerForWord());

            System.out.println("Dėstytojas: ");
            String UserName = ScannerUtils.scannerForWord();

            String a = returnStudentId(Login.getCurrentUser().getUserName());
            String b = returnLecturerId(UserName);
            String c = courses.getTittle();

            bufferedWriter.newLine();

            bufferedWriter.write(a + "," + b + "," + c);

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
        System.out.println("Prisireginai!");
        Menu.menuForAllRolesValidation();
    }

    public static void searchStudentCourses() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("studentsInCourseFile.csv"))
        ) {
            String read = null;

            String userName = returnStudentId(Login.getCurrentUser().getUserName());

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[0].equals(userName)) {

                    System.out.println(splited[2]);
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

        File usersFile = new File("courseListFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;

            System.out.println("Įrašykite kurso pavadinimą: \n");
            String userName = ScannerUtils.scannerForWord();

            while ((line = bufferedReader.readLine()) != null) {

                if (!line.split(",")[3].equals(userName))

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
    }


}