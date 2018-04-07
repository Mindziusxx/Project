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
                    System.out.println((i++) + ". " + splited[4] + " (" + splited[1] + ", " + splited[2] + ")");
                }
            }
        } catch (Exception e) {
        }
    }

    public static void changeUserInformation() {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("usersFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[4].equals(Login.getCurrentUser().getUserName())) {
                    List<String> splited = Arrays.asList(line.split(","));

                    System.out.println("------------------------------------");
                    System.out.println("Norite įvesti/pakeisti vardą? (Y/N)?");
                    System.out.println("------------------------------------");
                    String answer2 = ScannerUtils.scannerForWord();

                    if (answer2.equals("Y") || answer2.equals("y")) {
                        System.out.println("\nĮveskite naują vardą: ");
                        String firstName = ScannerUtils.scannerForWord();
                        splited.set(1, firstName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(firstName);
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("Norite įvesti/pakeisti pavardę? (Y/N)?");
                    System.out.println("--------------------------------------");
                    String answer3 = ScannerUtils.scannerForWord();

                    if (answer3.equals("Y") || answer3.equals("y")) {
                        System.out.println("\nĮveskite naują pavardę: ");
                        String secondName = ScannerUtils.scannerForWord();
                        splited.set(2, secondName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(secondName);
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("Norite įvesti/pakeisti pavardę? (Y/N)?");
                    System.out.println("--------------------------------------");
                    String answer4 = ScannerUtils.scannerForWord();

                    if (answer4.equals("Y") || answer4.equals("y")) {
                        System.out.println("\nĮveskite naują pavardę: ");
                        String lastName = ScannerUtils.scannerForWord();
                        splited.set(2, lastName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(lastName);
                    }

                    System.out.println("---------------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti namų telefono numerį? (Y/N)?");
                    System.out.println("---------------------------------------------------");
                    String answer5 = ScannerUtils.scannerForWord();

                    if (answer5.equals("Y") || answer5.equals("y")) {
                        System.out.println("\nĮveskite naują telefono numerį?: ");
                        String phoneNumber = ScannerUtils.scannerForWord();
                        splited.set(6, phoneNumber);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(phoneNumber);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti gimimo datą? (Y/N)?");
                    System.out.println("------------------------------------------");
                    String answer6 = ScannerUtils.scannerForWord();

                    if (answer6.equals("Y") || answer6.equals("y")) {
                        System.out.println("\nĮveskite gimimo datą: ");
                        String dateOfBirth = ScannerUtils.scannerForWord();
                        splited.set(7, dateOfBirth);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(dateOfBirth);
                    }

                    System.out.println("-------------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti elektroninį parašą? (Y/N)?");
                    System.out.println("-------------------------------------------------");
                    String answer7 = ScannerUtils.scannerForWord();

                    if (answer7.equals("Y") || answer7.equals("y")) {
                        System.out.println("\nĮveskite elektroninį parašą: ");
                        String email = ScannerUtils.scannerForWord();
                        splited.set(8, email);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(email);
                    }

                    System.out.println("--------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti mobilų numerį? (Y/N)?");
                    System.out.println("--------------------------------------------");
                    String answer8 = ScannerUtils.scannerForWord();

                    if (answer8.equals("Y") || answer8.equals("y")) {
                        System.out.println("\nĮveskite mobilų numerį: ");
                        String mobileNumber = ScannerUtils.scannerForWord();
                        splited.set(9, mobileNumber);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(mobileNumber);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti savo adresą? (Y/N)?");
                    System.out.println("------------------------------------------");
                    String answer9 = ScannerUtils.scannerForWord();

                    if (answer9.equals("Y") || answer9.equals("y")) {
                        System.out.println("\nĮveskite adresą: ");
                        String address = ScannerUtils.scannerForWord();
                        splited.set(11, address);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(address);
                    }
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
        System.out.println("\nJūsų duomenys atnaujinti!");
        Menu.menuForAllRolesValidation();
    }

    public static void getUserInformation() {

        System.out.println("--------------");
        System.out.println("Jūsų duomenys:");
        System.out.println("--------------");
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("usersFile.csv"));
            String read = null;

            in.readLine();
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
            System.out.println("getUserInformation" + e);
        }
    }
}