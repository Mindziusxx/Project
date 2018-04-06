import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Users {

    private String ID;
    private String password;
    private String firstName;
    private String lastName;
    private String secondName;
    private String userName;
    private String role;
    private String personalNumber;
    private String dateOfBirth;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String runningCourses;


    public Users() {

        this.ID = ID;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.role = role;
        this.personalNumber = personalNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.runningCourses = runningCourses;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String setSecondName(String secondName) {
        this.secondName = secondName;
        return secondName;
    }

    public String setUserName(String userName) {
        this.userName = userName;
        return userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public static void registerNewUser() {
        Users users = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("usersFile.csv", true))
        ) {

            System.out.println("----------------------------");
            System.out.println("Naujo vartotojo registracija");
            System.out.println("----------------------------");
            System.out.println("Vardas:");
            users.setFirstName(ScannerUtils.scannerForWord());
            System.out.println("Pavardė:");
            users.setSecondName(ScannerUtils.scannerForWord());
            System.out.println("Slaptažodis:");
            users.setPassword(ScannerUtils.scannerForWord());
            System.out.println("Vartotojo prisijungimo vardas:");
            users.setUserName(ScannerUtils.scannerForWord());
            System.out.println("Vartotojo teisės (student/lecturer):");
            String role = ScannerUtils.scannerForWord();

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," + users.getSecondName()
                    + "," + users.getPassword() + "," + users.getUserName() + "," + role + "," +
                    "personalNumber,dateOfBirth,email,mobileNumber,gender,address");

            System.out.println("\nNaujas vartotojas sukurtas sėkmingai!");

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }


    public static void searchAllStudents() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("usersFile.csv"))
        ) {
            String read = null;

            int i = 1;
            System.out.println("-----------------");
            System.out.println("Studentų sąrašas:");
            System.out.println("-----------------");
            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (splited[5].equals("student")) {
                    System.out.println((i++) + ". " + splited[4]);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void changeUserInfo() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("usersFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[4].equals(Login.getCurrentUser().getUserName())) {


                    ///Su switch pasidaryti...

                    ///1. Menu ką norim keisiti ir tada switch.

                    ///Menu.userMenuChange();


                    System.out.println("Įveskite userName");
                    List<String> splited = Arrays.asList(line.split(","));
                    String uname = ScannerUtils.scannerForWord();
                    splited.set(4, uname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setUserName(uname);

                    System.out.println("Įveskite firstName");
                    String fname = ScannerUtils.scannerForWord();
                    splited.set(1, fname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setFirstName(fname);

                    System.out.println("Įveskite lastName");
                    String lname = ScannerUtils.scannerForWord();
                    splited.set(2, lname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setLastName(lname);

                    System.out.println("Įveskite naują personalNumber");
                    String pname = ScannerUtils.scannerForWord();
                    splited.set(6, pname);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setPersonalNumber(pname);

                    System.out.println("Įveskite dateOfBirth");
                    String dob = ScannerUtils.scannerForWord();
                    splited.set(7, dob);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setDateOfBirth(dob);

                    System.out.println("Įveskite email");
                    String email = ScannerUtils.scannerForWord();
                    splited.set(8, email);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setEmail(email);

                    System.out.println("Įveskite mobileNumber");
                    String mNumber = ScannerUtils.scannerForWord();
                    splited.set(9, mNumber);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setMobileNumber(mNumber);

                    System.out.println("Įveskite gender");
                    String genter = ScannerUtils.scannerForWord();
                    splited.set(10, genter);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setGender(genter);

                    System.out.println("Įveskite address");
                    String address = ScannerUtils.scannerForWord();
                    splited.set(11, address);
                    line = splited.stream().collect(Collectors.joining(","));
                    Login.getCurrentUser().setAddress(address);
                }
                userStgrings.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStgrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu.menuForAllRolesValidation();
    }

    public static void getUserInformation() {

        System.out.println("Jūsų duomenys: \n");

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("usersFile.csv"));
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
            Menu.menuForAllRolesValidation();
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }
}