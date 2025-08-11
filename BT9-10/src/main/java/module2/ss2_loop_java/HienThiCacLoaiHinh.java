package main.java.module2.ss2_loop_java;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int[] draw;
        System.out.print("Menu: \n" +
                "1. Print the rectangle\n" +
                "2. Print the square triangle\n" +
                "3. Print isosceles triangle\n" +
                "4. Exit\n" +
                "Your choice: ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("2") ) {
            System.out.print("2.1 top-left\n" +
                    "2.2 top-right\n" +
                    "2.3 bottom-left\n" +
                    "2.4 bottom-right\n" +
                    "Your choice: ");
            Scanner sc2 = new Scanner(System.in);
            choice = sc.nextLine();
        }
        switch (choice) {
            case "1":;
                for (int i = 0; i < 4; i++) {
                    System.out.println("* * * * * *");
                }
                break;
            case "3":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - i - 1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 2 * i + 1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.1":
                for (int i = 4; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.2":
                for (int i = 4; i >= 1; i--) {
                    for (int j = 1; j <= 4 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.3":
                for (int i = 1; i <= 4; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.4":
                for (int i = 1; i <= 4; i++) {
                    for (int j = 1; j <= 4 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
