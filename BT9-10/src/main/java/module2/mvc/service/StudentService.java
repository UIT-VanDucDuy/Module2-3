package main.java.module2.mvc.service;

import main.java.module2.mvc.entity.Student;
import main.java.module2.mvc.repo.IStudentRepo;
import main.java.module2.mvc.repo.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepo studentRepo = new StudentRepo();

    @Override
    public void addStudent(Student student) {
        studentRepo.add(student);
    }

    @Override
    public boolean removeStudent(Student student) {
        return studentRepo.delete(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    @Override
    public Student findStudentByCode(String code) {
        for (Student student : studentRepo.getStudents()) {
            if (student.getCode().equals(code)) {
                return student;
            }
        }
        return null;
    }
}
