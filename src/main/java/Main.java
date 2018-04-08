import login.Login;

import static files.CreateProjectFiles.createProjectFiles;

public class Main {

    public static void main(String[] args) {

        createProjectFiles();
        Login.login();
    }

}