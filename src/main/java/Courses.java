import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;


public class Courses {

    ///private static  Users currentUser;


    private String code;
    private String tittle;
    private String desciption;
    private int startDate;
    private int credit;
    private int lecturerId;

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

    public int getStartDate() {
        return startDate;
    }

    public int getCredit() {
        return credit;
    }

    public int getLecturerId() {
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

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public static void createCourse() {

        Courses courses = new Courses();

        ///currentUser = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course.txt"))
        ) {

            bufferedWriter.write("lecturerId, userName,code,tittle,desciption,startDate,credit");
            bufferedWriter.newLine();


            System.out.println("Prašau įveskite tittle");
            courses.setTittle(ScannerUtils.scanner());

            System.out.println("Prašau įveskite desciption");
            courses.setDesciption(ScannerUtils.scanner());

            System.out.println("Prašau įveskite startDate");
            courses.setStartDate(ScannerUtils.scanner1());

            System.out.println("Prašau įveskite credit");
            courses.setCredit(ScannerUtils.scanner1());


            bufferedWriter.write(returnID() + "," + Login.getCurrentUser().getUserName()
                    +  "," + courses.getTittle() + "," + courses.getDesciption() + "," + courses.getStartDate() + "," + courses.getCredit());

        } catch (Exception e) {
            System.out.println("createCourse" + e);
        }
    }


    public static String returnID() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("login.txt"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[1].equals(Login.getCurrentUser().getUserName())) {
                    {
                        return splited[0];
                    }
                } else {
                }
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
        return null;
    }



    public static void searchCourse() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("course.txt"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                System.out.println(splited[3]);
            }
        } catch (Exception e) {
        }
    }

}
