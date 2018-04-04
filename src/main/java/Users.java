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

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getRunningCourses() {
        return runningCourses;
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

    public void setRunningCourses(String runningCourses) {
        this.runningCourses = runningCourses;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public static void searchUser() {
        try (
                BufferedReader in = new BufferedReader(new FileReader("users.csv"))
        ) {
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");
                System.out.println(splited[4]);
            }
        } catch (Exception e) {
        }
    }

    public static void changeUserInfo() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("users.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[4].equals(Login.getCurrentUser().getUserName())) {


                    ///Su switch pasidaryti...
                    ///1. Menu ką norim keisiti ir tada switch.
                   /// Menu.userMenuChange();


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

        Menu.otherMenu();
    }

    public static void userInfo() {

        System.out.println("Jūsų duomenys: \n");

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("users.csv"));
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

    public static void registerNewUser() {
        Users users = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.csv", true))
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

}