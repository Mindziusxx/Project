import java.io.*;
import java.util.UUID;

public class Start {

    public static void startProgram() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("users.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                createFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }


    public static void startProgram1() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("course list.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                createFile1();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }

    public static void startProgram2() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("student in course.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                createFile2();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }

    }

    public static void createFile() {

        Users users = new Users();

        users.setFirstName("admin");
        users.setSecondName("admin");
        users.setPassword("admin");
        users.setUserName("admin");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.csv"))
        ) {

            bufferedWriter.write("ID,firstName,secondName,password,userName,role,personalNumber," +
                    "dateOfBirth,email,mobileNumber,gender,address,runningCourses");
            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," +
                    users.getSecondName() + "," + users.getPassword() + "," + users.getUserName() + "," +
                    "admin,personalNumber,dateOfBirth,email,mobileNumber,gender,address,runningCourses");

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
        startProgram1();
        startProgram2();
    }

    public static void createFile1() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course list.csv"))
        ) {

            bufferedWriter.write("code,lecturerId, userName,tittle,desciption,startDate,credit");

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
    }

    public static void createFile2() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student in course.csv"))
        ) {

            bufferedWriter.write("ID,lecturerId,tittle");

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
    }
}


