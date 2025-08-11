package main.java.module2.mvc.view;

import java.util.Scanner;

public class MainView {
    public static int mainView(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Quản lý giáo vụ ---");
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giáo viên");
        System.out.println("3. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
}
