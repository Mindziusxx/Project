public enum Roles {
    ADMIN("admin"), LECTURER("lecturer"), STUDENT("student");

    public String roleName;
    int number;


    Roles(String number) {
        this.roleName = number;
    }

    public String getroleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
