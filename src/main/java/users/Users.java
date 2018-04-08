package users;

import java.io.BufferedReader;
import java.io.FileReader;

public class Users {
    private String ID, password, firstName, secondName, userName, role, personalNumber, dateOfBirth, email, mobileNumber, gender, address;


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
                    System.out.println((i++) + ". " + splited[1] + " " + splited[2] + " (" + splited[4] + ")");
                }
            }
        } catch (Exception e) {
        }
    }
}