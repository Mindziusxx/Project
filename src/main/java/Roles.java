public class Roles {

    private String admin;
    private String lecturer;
    private String student;


    Roles roles = new Roles();


    public Roles(String admin, String lecturer, String student) {
        this.admin = admin;
        this.lecturer = lecturer;
        this.student = student;
    }


    public void checkRole(String role) {

        if (role.equals(Roles.this.admin)) {
            Menu.printMenuForAdmin();
        } else if (role.equals(this.lecturer)) {
            Menu.printMenuForLecturer();
        } else if (role.equals(this.roles.student)) {
            Menu.printMenuForStudent();
        } else {
            System.out.println("pagalvosiu");
        }
    }

    public Roles() {
    }
}
