package main.java.module2.ss15_Exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cạnh thứ nhất: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cạnh thứ hai: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cạnh thứ ba: ");
        int c = Integer.parseInt(scanner.nextLine());

        try{
            checkTriangle(a,b,c);
            System.out.println("Tam giác có 3 cạnh: " +a + ", " + b + ", " + c);
        }catch(IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        if(a<0 || b<0 || c<0) {
            throw new IllegalTriangleException("Các cạnh của một tam giác phải lớn hơn 0.");
        }else if (a+b<c || b+c<a || c+a<b) {
            throw new IllegalTriangleException("Tổng 2 cạnh của một tam giác phải lớn hơn cạnh còn lại.");
        }
    }
}
