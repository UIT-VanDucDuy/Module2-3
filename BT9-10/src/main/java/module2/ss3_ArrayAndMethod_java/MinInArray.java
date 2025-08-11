package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MinInArray {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        System.out.println("Chuỗi bất kỳ:"+ Arrays.toString(a));
        System.out.printf("Giá trị nhỏ nhất trong mảng: "+ minIn2DArray(a));
    }
    public static int minIn2DArray(int[] a) {
        int min = a[0];
        for (int num : a) {
            if (num < min) {
                min = num;
            }

        }
        return min;
    }
}
