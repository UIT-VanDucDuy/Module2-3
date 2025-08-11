package main.java.module2.ss11_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhâp số bạn muốn chuyển: ");
        int decimal= Integer.parseInt(scanner.nextLine());
        String binary = convertToBinary(decimal);
        System.out.println("Số " + decimal + " trong hệ nhị phân là: " + binary);

    }

    public static String convertToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();

        if (decimal == 0) {
            return "0";
        }

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}
