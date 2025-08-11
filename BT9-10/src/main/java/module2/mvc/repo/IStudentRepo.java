package main.java.module2.mvc.repo;

import main.java.module2.mvc.entity.Student;

import java.util.List;

public interface IStudentRepo {
    void add(Student student);
    boolean delete(Student student);
    List<Student> getStudents();
}
