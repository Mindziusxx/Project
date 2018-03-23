public enum RoleNew {
    ADMIN("admin"), LECTURER("lecturer"), STUDENT("student");

    private String roleName;
    int number;


    RoleNew (String number) {
        this.roleName = number;
    }

    public String getroleName() {
        return roleName;
    }
}
