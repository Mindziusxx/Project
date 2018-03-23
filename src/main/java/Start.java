import java.io.*;
import java.util.UUID;

public class Start {

    public static void startProgram() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;

            if ((read = in.readLine()) == null) {
                createFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }


    public static void createFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {

            bufferedWriter.write("ID,firstName,secondName,password,userName,role,personalNumber,dateOfBirth,email,mobileNumber,gender,address,runningCourses");
            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + ",,,admin,admin,admin");

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
    }
}


