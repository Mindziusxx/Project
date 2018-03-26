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

        Users users = new Users();

        users.setFirstName("admin");
        users.setSecondName("admin");
        users.setPassword("admin");
        users.setUserName("admin");
        RoleNew.ADMIN.getroleName();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {

            bufferedWriter.write("ID,firstName,secondName,password,userName,role,personalNumber,dateOfBirth,email,mobileNumber,gender,address,runningCourses");
            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," + users.getSecondName() + "," + users.getPassword() + "," + users.getUserName() + "," + RoleNew.ADMIN.getroleName());

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
    }
}


