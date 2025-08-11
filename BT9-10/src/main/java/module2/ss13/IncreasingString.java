package main.java.module2.ss13;

import java.util.Scanner;

public class IncreasingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();
        System.out.print("Chuỗi tăng dần lớn nhất: " + increasingString(input));
    }
    public static String increasingString(String input) {
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) > result.charAt(result.length() - 1)) {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
