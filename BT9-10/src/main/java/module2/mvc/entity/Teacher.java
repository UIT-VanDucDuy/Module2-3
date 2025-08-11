package main.java.module2.mvc.entity;

public class Teacher extends Person {
    private String subject;

    public Teacher(int id, String code, String name, int gender, String address, String subject) {
        super(id, code, name, gender, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.getId() + ", " + super.getCode() + ", "
                + super.getName() + ", " + super.getGender() + ", "+ super.getAddress() + ", " + subject;
    }
}
