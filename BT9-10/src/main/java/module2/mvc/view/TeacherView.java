package main.java.module2.mvc.view;

import main.java.module2.mvc.controller.TeacherController;
import main.java.module2.mvc.entity.Teacher;

import java.util.Scanner;

public class TeacherView {
    private static TeacherController teacherController = new TeacherController();
    public static void teacherMenu(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("--- Quản lý học sinh ---");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Xóa học sinh");
            System.out.println("3. Danh sách học sinh");
            System.out.println("4. Trở về");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addTeacherInput();
                    break;
                case 2:
                    removeTeacherInput();
                    break;
                case 3:
                    findAllTeachers();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Hãy nhập lựa chọn hợp lý");
            }
        }
    }
    private static Teacher addTeacherInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm học sinh:");
        System.out.print("Nhập mã học sinh: ");
        String code = sc.nextLine();
        System.out.print("Nhập tên học sinh: ");
        String name = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        int gender = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("Nhập môn học: ");
        String subject = sc.nextLine();
        return new Teacher(1, code, name, gender, address, subject);
    }
    private static Teacher removeTeacherInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã học sinh muốn xóa:");
        String code = sc.nextLine();
        return teacherController.getTeacherByCode(code);
    }
    private static void findAllTeachers() {
        for (Teacher teacher : teacherController.getTeachers()){
            System.out.println(teacher);
        }
    }

}
