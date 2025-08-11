package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;

public class MaxIn2DArray {
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
        System.out.printf("Phần tử lớn nhất trong mảng: "+ maxIn2DArray(a));
    }
    public static int maxIn2DArray(int[][] a) {
        int max = 0;
        for (int[] num :a) {
            for (int num1 : num) {
                if (num1> max) {
                    max = num1;
                }
            }
        }
        return max;
    }
}
