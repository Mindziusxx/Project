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
                System.out.println("Pridėti kursą");
                break;
            case 3:
                System.out.println("Ištrinti kursą");
                break;
            case 4:
                System.out.println("Pakeisti kursą");
                break;
            case 5:
                Users.searchUser();
                break;
            case 6:
                Courses.searchCourse();
                break;
            case 7:
                System.out.println("Exit");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {


        switch (ScannerUtils.scanner1()) {
            case 1:
                userInfo();
                break;
            case 2:
                changeUserInfo();
                break;
            case 3:
                Courses.createCourse();
                break;
            case 4:
                System.out.println("Ištrinti kursą");
                break;
            case 5:
                System.out.println("Pakeisti kursą");
                break;
            case 6:
                System.out.println("Priskirti kursai: ");
                break;
            case 7:
                System.out.println("Studentai užsiregisntravę į kursus");
                break;
            case 8:
                System.out.println("Exit");
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
                System.out.println("Visų kursų sąrašas");
                break;
            case 4:
                System.out.println("Užsiregistruotų kursų sąrašas");
                break;
            case 5:
                System.out.println("Užsiregistruoti į kursą");
                break;
            case 6:
                System.out.println("Exit");
                break;
            default:
                break;
        }
    }

    public static void menuActionsToAdmin() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForAdmin();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                break;
        }
    }

    public static void menuActionsToStudent() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForStudent();
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                break;
        }
    }

    public static void menuActionsToLecturer() {
        switch (ScannerUtils.scanner1()) {
            case 1:
                Menu.printMenuForLecturer();
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
            Menu.otherMenu();

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
            Menu.otherMenu();
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
                    String uname = ScannerUtils.scanner();
                    splited.set(4, uname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setUserName(uname);

                    System.out.println("Įveskite naują firstName");
                    String fname = ScannerUtils.scanner();
                    splited.set(1, fname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(fname);

                    System.out.println("Įveskite naują lastName");
                    String lname = ScannerUtils.scanner();
                    splited.set(2, lname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setLastName(lname);

                    System.out.println("Įveskite naują personalNumber");
                    String pname = ScannerUtils.scanner();
                    splited.set(6, pname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setPersonalNumber(pname);

                    System.out.println("Įveskite naują dateOfBirth");
                    String dob = ScannerUtils.scanner();
                    splited.set(7, dob);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setDateOfBirth(dob);

                    System.out.println("Įveskite naują email");
                    String email = ScannerUtils.scanner();
                    splited.set(8, email);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setEmail(email);

                    System.out.println("Įveskite naują mobileNumber");
                    String mNumber = ScannerUtils.scanner();
                    splited.set(9, mNumber);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setMobileNumber(mNumber);

                    System.out.println("Įveskite naują gender");
                    String genter = ScannerUtils.scanner();
                    splited.set(10, genter);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setGender(genter);

                    System.out.println("Įveskite naują address");
                    String address = ScannerUtils.scanner();
                    splited.set(11, address);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setAddress(address);

                    System.out.println("Įveskite naują runningCourses");
                    String rCourses = ScannerUtils.scanner();
                    splited.set(12, rCourses);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setRunningCourses(rCourses);


                    System.out.println(Login.getCurrentUser().getUserName());
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            usersFile.delete();
            tmpFile.renameTo(new File("login.txt"));
            Menu.otherMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}