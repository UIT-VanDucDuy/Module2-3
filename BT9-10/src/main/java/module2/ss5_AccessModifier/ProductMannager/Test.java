package main.java.module2.ss5_AccessModifier.ProductMannager;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();

        boolean isPause = true;
        while (isPause){
            System.out.printf("======== Quản lý sản phầm ========\n" +
                    " 1.Thêm sản phầm mới \n" +
                    " 2. Danh sách sản phẩm\n" +
                    " 3. Xóa sản phẩm\n" +
                    " 4. Tìm sản phẩm\n" +
                    " 5. Thoát \n");
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Chọn chức năng: ");
            String input= scanner.nextLine();
            int choice=0;
            if (input == "") {
                System.out.println("Hãy nhập chức năng !!");
            }else {
                try {
                    choice= Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Giá trị không hợp lệ.");
                }
            }
            switch (choice){
                case 1:
                    System.out.println("==== Thêm mới ====");
                    System.out.printf("Nhập id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.printf("Nhập giá sản phẩm: ");
                    double price=0;
                    String priceString=scanner.nextLine();
                    if (priceString =="") {
                        System.out.println("Hãy nhập giá trị cho Price !!");
                    }else {
                        try{
                        price = Double.parseDouble(priceString);
                        Product product = new Product(id,name,price);
                        productManagement.add(product);
                    } catch (NumberFormatException e) {
                            System.out.println("Giá trị không hợp lệ.");
                        }
                    }
                    break;
                case 2:
                    productManagement.ListProducts();
                    break;
                case 3:
                    System.out.printf("==== Xóa sản phẩm ====\n");
                    System.out.printf("Nhập id sản phẩm muốn xóa: ");
                    productManagement.delete(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.printf("==== Tìm kiếm sản phẩm ====\n" +
                            "Nhập id sản phẩm muốn tìm: ");
                    int findId = Integer.parseInt(scanner.nextLine());
                    if(productManagement.getProductById(findId) != null){
                        System.out.println("Sản phẩm tìm được:\n " + productManagement.getProductById(findId).getId() +" "+
                                        productManagement.getProductById(findId).getName()+ " "+
                                        productManagement.getProductById(findId).getPrice());
                    }else {
                        System.out.printf("Sản phẩm không tồn tại");
                    }
                    break;
                case 5:
                    isPause = false;
                    break;
            }
        }
    }
}
