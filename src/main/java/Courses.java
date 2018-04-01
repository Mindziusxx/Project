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


    public static void createCourseByAdmin1() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course list.csv", true))
        ) {

            System.out.println("Prašau įveskite lektoriaus userName");
            String userName = Login.getCurrentUser().setUserName(ScannerUtils.scanner());

            System.out.println("Prašau įveskite tittle");
            courses.setTittle(ScannerUtils.scanner());
            System.out.println("Prašau įveskite desciption");
            courses.setDesciption(ScannerUtils.scanner());
            System.out.println("Prašau įveskite startDate");
            courses.setStartDate(ScannerUtils.scanner());
            System.out.println("Prašau įveskite credit");
            courses.setCredit(ScannerUtils.scanner());

            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(userName) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());

            System.out.println("Naujas kursas sukurtas sėkmingai! \n");


        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }

    public static void createCourseByLecturer1() {
        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course list.csv", true))
        ) {

            System.out.println("Prašau įveskite tittle");
            courses.setTittle(ScannerUtils.scanner());
            System.out.println("Prašau įveskite desciption");
            courses.setDesciption(ScannerUtils.scanner());
            System.out.println("Prašau įveskite startDate");
            courses.setStartDate(ScannerUtils.scanner());
            System.out.println("Prašau įveskite credit");
            courses.setCredit(ScannerUtils.scanner());

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
                BufferedReader in = new BufferedReader(new FileReader("course list.csv"))
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
                BufferedReader in = new BufferedReader(new FileReader("course list.csv"))
        ) {
            String read = null;

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
        File usersFile = new File("course list.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {

            System.out.println("Įveskite kurso pavadinimą, kurį norite keisti: ");
            String course = ScannerUtils.scanner();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course)) {

                    System.out.println("Pakeisti userName");
                    List<String> splited = Arrays.asList(line.split(","));
                    String uname = ScannerUtils.scanner();
                    splited.set(2, uname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setUserName(uname);

                    System.out.println("Pakeisti tittle");
                    String tittle = ScannerUtils.scanner();
                    splited.set(3, tittle);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(tittle);

                    System.out.println("Pakeisti desciption");
                    String desciption = ScannerUtils.scanner();
                    splited.set(4, desciption);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(desciption);

                    System.out.println("Pakeisti startDate");
                    String startDate = ScannerUtils.scanner();
                    splited.set(5, startDate);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(startDate);

                    System.out.println("Pakeisti credit");
                    String credit = ScannerUtils.scanner();
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

    public static void changeCourseByLecturer () {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("course list.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {

            System.out.println("Įveskite kurso pavadinimą, kurį norite keisti: ");
            String course = ScannerUtils.scanner();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[3].equals(course) && line.split(",")[2].equals(Login.getCurrentUser().getUserName())) {

                    System.out.println("Pakeisti tittle");
                    List<String> splited = Arrays.asList(line.split(","));
                    String tittle = ScannerUtils.scanner();
                    splited.set(3, tittle);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(tittle);

                    System.out.println("Pakeisti desciption");
                    String desciption = ScannerUtils.scanner();
                    splited.set(4, desciption);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(desciption);

                    System.out.println("Pakeisti startDate");
                    String startDate = ScannerUtils.scanner();
                    splited.set(5, startDate);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(startDate);

                    System.out.println("Pakeisti credit");
                    String credit = ScannerUtils.scanner();
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


    public static void userRegistrationInCourse() {     /// REIKIA PADARYTI!!!

        Users users = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("usersInCourse.csv", true))
        ) {


            System.out.println("reikia, kad listas išsikviestų visų course esamų");

            System.out.println("Galima įvesti kurso ID ar tittle ir tada sukurtų lentą (failą) su USER, TITTLE (ar ID) ir LECTURER ID");


            bufferedWriter.newLine();

            bufferedWriter.write(


                    "NAUJAS FAILAS"
            );

            Menu.otherMenu();

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }




    public static String returnLecturerId(String userName) {
        Courses courses = new Courses();

        try (
                BufferedReader in = new BufferedReader(new FileReader("users.csv"))
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

}