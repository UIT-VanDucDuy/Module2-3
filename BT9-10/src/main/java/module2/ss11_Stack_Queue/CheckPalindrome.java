package main.java.module2.ss11_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi muốn kiểm tra: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean result = isPalindrome(input);
        if (result) {
            System.out.println("Chuỗi đã cho là chuỗi Palindrome ");
        }else {
            System.out.println("Chuỗi đã cho không phải là chuỗi Palindrome ");
        }

    }

    public static boolean isPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        str = str.replaceAll("\\s+", "").toLowerCase();

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }
}
