package main.java.module2.mvc.controller;

import main.java.module2.mvc.view.MainView;
import main.java.module2.mvc.view.StudentView;
import main.java.module2.mvc.view.TeacherView;

public class MainController {
    public static void main(String[] args) {
        boolean isPassed = true;
        while (isPassed) {
            switch (MainView.mainView()) {
                case 1:
                    StudentView.studentMenu();
                    break;
                case 2:
                    TeacherView.teacherMenu();
                    break;
                case 3:
                    isPassed = false;
                default:
                    break;
            }
        }
    }
}
