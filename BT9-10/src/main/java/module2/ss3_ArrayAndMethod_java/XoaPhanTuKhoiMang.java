package main.java.module2.ss3_ArrayAndMethod_java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        System.out.println("Chuỗi ban đầu:"+Arrays.toString(a));
        System.out.printf("Nhập phần tử bạn muốn xóa:");
        int b= Integer.parseInt(sc.nextLine());
        System.out.printf("Chuỗi sau khi xóa:"+Arrays.toString(delete(a,b)));
    }
    public static int[] delete(int[] a,int b) {
        int count=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b) count++;
        }
        int[]  temp = new int[a.length-count];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b) {
                temp[index] = a[i];
                index++;
            }
        }
        return temp;
    }
}
