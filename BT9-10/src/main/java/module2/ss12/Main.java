package main.java.module2.ss12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm theo ID");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm theo Id");
            System.out.println("6. Sắp xếp theo giá tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Giá: ");
                    int price = Integer.parseInt(sc.nextLine());
                    manager.addProduct(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Nhập ID cần sửa: ");
                    String updateId = sc.nextLine();
                    System.out.print("Tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Giá mới: ");
                    int newPrice = Integer.parseInt(sc.nextLine());
                    if (manager.updateProduct(updateId, newName, newPrice)) {
                        System.out.println("Sửa thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID cần xoá: ");
                    String deleteId = sc.nextLine();
                    if (manager.removeProduct(deleteId)) {
                        System.out.println("Xoá thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 4:
                    manager.printProducts();
                    break;
                case 5:
                    System.out.print("Nhập id sản phẩm cần tìm: ");
                    String findId = sc.nextLine();
                    System.out.println(manager.findProduct(findId));
                    break;
                case 6:
                    manager.sortProducts();
                    System.out.println("Sắp xếp tăng dần:");
                    manager.printProducts();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
