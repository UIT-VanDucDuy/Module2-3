package main.java.module2.mvc.view;

import main.java.module2.mvc.controller.StudentController;
import main.java.module2.mvc.entity.Student;

import java.util.Scanner;

public class StudentView {
    private static StudentController studentController = new StudentController();
    public static void studentMenu(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("--- Quản lý học sinh ---");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Xóa học sinh");
            System.out.println("3. Danh sách học sinh");
            System.out.println("4. Trở về");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addStudentInput();
                    break;
                case 2:
                    removeStudentInput();
                    break;
                case 3:
                    findAllStudent();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Hãy nhập lựa chọn hợp lý");
            }
        }

    }
    private static Student addStudentInput() {
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
        System.out.print("Nhập điểm số: ");
        long score = Long.parseLong(sc.nextLine());
        System.out.print("Nhập mã lớp học: ");
        String classCode = sc.nextLine();
        return new Student(1, code, name, gender, address,score, classCode);
    }
    private static Student removeStudentInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã học sinh muốn xóa:");
        String code = sc.nextLine();
        return studentController.getStudentByCode(code);
    }
    private static void findAllStudent() {
        for (Student student : studentController.getStudents()){
            System.out.println(student);
        }
    }
}
