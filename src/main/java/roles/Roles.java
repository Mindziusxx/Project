package roles;

public enum Roles {
    ADMIN("admin"), LECTURER("lecturer"), STUDENT("student");

    public String roleName;

    Roles(String number) {
        this.roleName = number;
    }

    public String getroleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

