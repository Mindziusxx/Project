public class Users {


    private int ID;
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

    public int getID() {
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

    public void setID(int ID) {
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
}

