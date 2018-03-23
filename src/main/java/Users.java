public class Users  {

    private String firstName;
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

    public Users(String firstName, String secondName, String userName, String role, String personalNumber,
                 String dateOfBirth, String email, String mobileNumber, String gender, String address, String runningCourses) {

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
}

