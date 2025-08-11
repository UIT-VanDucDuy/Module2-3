package main.java.module2.ss13;

import java.util.Scanner;

public class IncreasingString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();
        System.out.print("Chuỗi tăng dần liên tiếp lớn nhất: " + increasingStringLongest(input));
    }

    public static String increasingStringLongest(String input) {
        StringBuilder result = new StringBuilder();
        String longest = "";
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i)>input.charAt(i-1)  ) {
                result.append(input.charAt(i));
            }else {
                if (longest.length() < result.length()) {
                    longest = result.toString();
                }
                result.delete(0, result.length());
                result.append(input.charAt(i));
            }
        }
        return longest;
    }
}
