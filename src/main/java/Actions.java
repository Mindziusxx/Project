import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Actions {

    public static void menuActionsByAdmin() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Actions.registerNewUser();
                break;
            case 2:
                changeUserInfo();
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("ats 1");
                break;
            case 2:
                changeUserInfo();
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByStudent( ) {

        switch (ScannerUtils.scanner1()) {
            case 1:
                userInfo();
                break;
            case 2:
                changeUserInfo();
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsToAll() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("Aprašyti visų Rolių nukreipimą į jų MENU");
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                break;
        }
    }


    public static void registerNewUser() {
        Users users = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt", true))
        ) {
            System.out.println("Įveskite firstName:");
            users.setFirstName(ScannerUtils.scanner());

            System.out.println("Įveskite secondName:");
            users.setSecondName(ScannerUtils.scanner());

            System.out.println("Įveskite password:");
            users.setPassword(ScannerUtils.scanner());

            System.out.println("Įveskite userName:");
            users.setUserName(ScannerUtils.scanner());

            System.out.println("Įveskite ROLE:");
            String role = ScannerUtils.scanner();

            bufferedWriter.newLine();

            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," + users.getSecondName()
                    + "," + users.getPassword() + "," + users.getUserName() + "," + role + ","+
                    "personalNumber,dateOfBirth,email,mobileNumber,gender,address,runningCourses");

            System.out.println("Naujas vartotojas sukurtas sėkmingai! \n");

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }


    public static void userInfo() {

        System.out.println("Jūsų duomenys: \n");

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (Login.getCurrentUser().getUserName().equals(splited[4])) {
                    for (int i = 0; i < splited.length; i++) {
                        System.out.println(splited[i]);
                    }
                    break;
                } else {
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }


    public static void changeUserInfo() {

        File usersFile = new File("login.txt");
        File tmpFile = new File("tmp.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile))
        ) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[4].equals(Login.getCurrentUser().getUserName())) {

                    System.out.println("Įveskite naują userName");

                    List<String> splited = Arrays.asList(line.split(","));
                    String name = ScannerUtils.scanner();
                    splited.set(4, name);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(name);

                }
                bufferedWriter.write(line);

                bufferedWriter.newLine();
            }
            usersFile.delete();
            tmpFile.renameTo(new File("login.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}