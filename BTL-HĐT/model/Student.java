package model;

public class Student extends User {
    private String major;

    public Student(String id, String name, int age, String major) {
        super(id, name, age);
        this.major = major;
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        return super.toString() + " -Nganh: " + major;
    }
}
