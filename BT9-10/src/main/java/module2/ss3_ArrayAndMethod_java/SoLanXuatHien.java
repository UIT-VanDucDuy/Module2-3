package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SoLanXuatHien {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                Random random = new Random();
                a[i][j] = random.nextInt(10);
            }
        }
        System.out.println("Mảng 2 chiều bất kỳ: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập phần tử bạn muốn đếm: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Số lần xuất hiện: " + countElement(a,n));
    }
    public static int countElement(int[][] a, int b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == b) {
                    count++;
                }
            }
        }
        return count;
    }
}
