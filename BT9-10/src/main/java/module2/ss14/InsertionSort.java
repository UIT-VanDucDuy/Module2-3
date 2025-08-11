package main.java.module2.ss14;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        insertionSortSteps(arr);
    }
    public static void insertionSortSteps(int[] array){
        System.out.println("Mảng ban đầu: "+Arrays.toString(array));
        int pos, x;
        int n=1;
        for(int i = 1; i < array.length; i++){
            x = array[i];
            pos = i;
            int m=1;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1];
                pos--;
                System.out.println("Mảng lúc dịch phần tử "+ n +"-" + m++ +": " + Arrays.toString(array)+ "  X = " + x) ;
            }
            n++;
            array[pos] = x;
            System.out.println("Mảng sau khi dịch phần tử: " + Arrays.toString(array));
        }
        System.out.println("Mảng sau khi sắp xếp: "+Arrays.toString(array));

    }
}
