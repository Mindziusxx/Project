import login.Login;

import static courses.SearchCourse.test;
import static files.CreateProjectFiles.createProjectFiles;

public class Main {

    public static void main(String[] args) {

        createProjectFiles();
        Login.login();
    }

}