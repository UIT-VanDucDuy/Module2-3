package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SumColum {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                Random random = new Random();
                a[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Mảng 2 chiều bất kỳ: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        Scanner sc = new Scanner(System.in);
        System.out.printf("Bạn muốn tính tổng ở cột:");
        int m = Integer.parseInt(sc.nextLine());
        System.out.printf("Tổng các phần tử trong cột: "+ sumColum(a,m));

    }
    public static int sumColum(int[][] a, int b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i][b];
        }
        return sum;
    }
}
