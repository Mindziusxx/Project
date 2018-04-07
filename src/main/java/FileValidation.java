import java.io.BufferedReader;
import java.io.FileReader;

public class FileValidation {

    public static void usersFileValidation() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("usersFile.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                WriteInFile.writeInUserFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("usersFileValidation" + e);
        }
    }

    public static void courseListFileValidation() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("courseListFile.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                WriteInFile.writeInCourseListFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("courseListFileValidation" + e);
        }
    }

    public static void studentsUnCourseFileValidation() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("studentsInCourseFile.csv"));
            String read = null;
            if ((read = in.readLine()) == null) {
                WriteInFile.writeInStudentsInCourseFile();
            } else {
            }
        } catch (Exception e) {
            System.out.println("studentsUnCourseFileValidation" + e);
        }
    }
}


