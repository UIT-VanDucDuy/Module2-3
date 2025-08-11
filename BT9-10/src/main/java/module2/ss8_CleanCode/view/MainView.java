package main.java.module2.ss8_CleanCode.view;

import java.util.Scanner;

public class MainView {
    public static int displayMainView() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            try {
                System.out.println("------ MENU ------");
                System.out.println("1. Thêm phương tiện");
                System.out.println("2. Hiển thị phương tiện");
                System.out.println("3. Xóa phương tiện");
                System.out.println("4. Thoát");
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine().trim());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một lựa chọn hợp lệ!");
            }
        }
    }
}

