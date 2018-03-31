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


    public static void createCourseByLecturer() {

        Courses courses = new Courses();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course list.csv"))
        ) {

            System.out.println("Prašau įveskite tittle");
            courses.setTittle(ScannerUtils.scanner());
            System.out.println("Prašau įveskite desciption");
            courses.setDesciption(ScannerUtils.scanner());
            System.out.println("Prašau įveskite startDate");
            courses.setStartDate(ScannerUtils.scanner());
            System.out.println("Prašau įveskite credit");
            courses.setCredit(ScannerUtils.scanner());


            bufferedWriter.write(UUID.randomUUID().toString() + "," + returnLecturerId(Login.getCurrentUser().getUserName()) + "," +
                    Login.getCurrentUser().getUserName() + "," + courses.getTittle() + "," + courses.getDesciption()
                    + "," + courses.getStartDate() + "," + courses.getCredit());
        } catch (Exception e) {
            System.out.println("createCourse" + e);
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


    public static void searchCourse() {
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

}