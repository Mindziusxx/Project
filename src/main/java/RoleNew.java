public enum RoleNew {
    ADMIN("admin"), LECTURER("lecturer"), STUDENT("student");

    public String roleName;
    int number;


    RoleNew (String number) {
        this.roleName = number;
    }

    public String getroleName() {
        return roleName;
    }

    public String setRoleName(String roleName) {
        this.roleName = roleName;
        return roleName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getNumber() {
        return number;
    }
}
