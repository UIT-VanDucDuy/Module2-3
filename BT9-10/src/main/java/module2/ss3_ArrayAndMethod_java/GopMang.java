package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.printf("Chuỗi số 1: ");
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a));

        System.out.printf("Chuỗi số 2: ");
        int[] b = new int[5];
        for (int i = 0; i < b.length; i++) {
            Random random = new Random();
            b[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(b));

        System.out.printf("Chuỗi sau khi gộp: ");
        System.out.println(Arrays.toString(insertArray(a,b)));

    }
    public static int[] insertArray(int[] a,int[]b) {
        int[] temp = new int[a.length + b.length];
        int index = 0;
        for (int num : a) {
            temp[index] = num;
            index++;
        }
        for (int num : b) {
            temp[index] = num;
            index++;
        }
        return temp;
    }
}
