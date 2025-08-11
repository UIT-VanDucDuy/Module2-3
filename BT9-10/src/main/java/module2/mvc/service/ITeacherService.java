package main.java.module2.mvc.service;

import main.java.module2.mvc.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    void addTeacher(Teacher teacher);
    boolean removeTeacher(Teacher teacher);
    List<Teacher> getTeachers();
    Teacher findTeacherByCode(String code);
}
