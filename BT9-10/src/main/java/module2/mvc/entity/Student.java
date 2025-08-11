package main.java.module2.mvc.entity;

public class Student extends Person {
    private long score;
    private String classCode;

    public Student(int id, String code, String name, int gender, String address,long score,String classCode) {
        super(id, code, name, gender, address);
        this.classCode = classCode;
        this.score = score;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return super.getId() + ", " + super.getCode() + ", "
                + super.getName() + ", " + super.getGender() + ", " + super.getAddress() + ", "+ classCode + ", " + score;
    }
}
