package main.java.module2.ss5_AccessModifier;

public class Student {
    private String name;
    private String classes;

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
    public Student(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
