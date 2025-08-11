package main.java.module2.ss1_tongquan_java.baitap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        System.out.printf("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello: " + name);
    }
}
