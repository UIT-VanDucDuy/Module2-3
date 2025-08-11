package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        System.out.printf("Chuỗi ban đầu:"+ Arrays.toString(a));
        System.out.printf("Nhập phần tử bạn muốn thêm:");
        int b= Integer.parseInt(sc.nextLine());
        System.out.printf("Nhập index bạn muốn thêm:");
        int c= Integer.parseInt(sc.nextLine());
        System.out.printf("Chuỗi sau khi thêm:"+ Arrays.toString(insert(a,b,c)));

    }
    public static int[] insert(int[] a,int b,int c) {
        int[]  temp = new int[a.length+1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (c==i) {
                temp[index] = b;
                index++;
            }else {
                temp[index] = a[i];
                index++;
            }
        }
        return temp;
    }
}
