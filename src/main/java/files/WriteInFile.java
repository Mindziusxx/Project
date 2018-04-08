package files;
import roles.Roles;
import users.Users;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.UUID;

public class WriteInFile {

    public static void writeInUserFile() {
        Users users = new Users();

        users.setFirstName("admin");
        users.setSecondName("admin");
        users.setPassword("admin");
        users.setUserName("admin");
        Roles.ADMIN.setRoleName("admin");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("usersFile.csv"))
        ) {
            bufferedWriter.write("ID,firstName,secondName,password,userName,role,personalNumber,dateOfBirth," +
                    "email,mobileNumber,gender,address");
            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," +
                    users.getSecondName() + "," + users.getPassword() + "," + users.getUserName() + "," +
                    Roles.ADMIN.getRoleName() + ",personalNumber,dateOfBirth,email,mobileNumber,gender,address");
        } catch (Exception e) {
            System.out.println("writeInUserFile" + e);
        }
    }

    public static void writeInCourseListFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courseListFile.csv"))
        ) {

            bufferedWriter.write("code,lecturerId,userName,tittle,desciption,startDate,credit");
        } catch (Exception e) {
            System.out.println("writeInCourseListFile" + e);
        }
    }

    public static void writeInStudentsInCourseFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("studentsInCourseFile.csv"))
        ) {
            bufferedWriter.write("ID,lecturerId,tittle");
        } catch (Exception e) {
            System.out.println("writeInStudentsInCourseFile" + e);
        }
    }
}
