package courses;

public class Courses {

    private String tittle;
    private String desciption;
    private String startDate;
    private String credit;
    private String lecturerId;


    public String getTittle() {
        return tittle;
    }

    public String getDesciption() {
        return desciption;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getCredit() {
        return credit;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String setTittle(String tittle) {
        this.tittle = tittle;
        return tittle;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }
}