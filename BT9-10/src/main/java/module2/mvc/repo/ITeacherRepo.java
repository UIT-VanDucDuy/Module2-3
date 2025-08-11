package main.java.module2.mvc.repo;

import main.java.module2.mvc.entity.Teacher;

import java.util.List;

public interface ITeacherRepo {
    void add(Teacher teacher);
    boolean remove(Teacher teacher);
    List<Teacher> getTeachers();
}
