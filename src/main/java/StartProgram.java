import java.io.File;

class StartProgram {

    public static void start() {

        File usersFile = null;
        File courseListFile = null;
        File studentsInCourseFile = null;

        boolean bool = false;

        try {
            usersFile = new File("usersFile.csv");
            courseListFile = new File("courseListFile.csv");
            studentsInCourseFile = new File("studentsInCourseFile.csv");

            if (bool = usersFile.exists()) {
                FileValidation.usersFileValidation();
            } else {
                usersFile.createNewFile();
                FileValidation.usersFileValidation();
            }

            if (bool = courseListFile.exists()) {
                FileValidation.courseListFileValidation();
            } else {
                courseListFile.createNewFile();
                FileValidation.courseListFileValidation();
            }

            if (bool = studentsInCourseFile.exists()) {
                FileValidation.studentsUnCourseFileValidation();
            } else {
                studentsInCourseFile.createNewFile();
                FileValidation.studentsUnCourseFileValidation();
            }

        } catch (Exception e) {

            // if any error occurs
            e.printStackTrace();
        }
    }
}