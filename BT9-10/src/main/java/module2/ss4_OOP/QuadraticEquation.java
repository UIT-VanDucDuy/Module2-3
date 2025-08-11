package main.java.module2.ss4_OOP;

import java.util.Scanner;

public class QuadraticEquation {
    private int a,b,c;
    public QuadraticEquation() {
    }
    public QuadraticEquation(int a,int b,int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    public Double getRoot1() {
        double delta = getDiscriminant();
        if (delta < 0) return null;
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public Double getRoot2() {
        double delta = getDiscriminant();
        if (delta < 0) return null;
        return (-b - Math.sqrt(delta)) / (2 * a);
    }
    public void printSolution() {
        double delta = getDiscriminant();
        System.out.println("\nPhương trình: " + a + "x² + " + b + "x + " + c + " = 0");

        if (delta > 0) {
            System.out.printf("Có 2 nghiệm phân biệt: x1 = %.2f, x2 = %.2f\n", getRoot1(), getRoot2());
        } else if (delta == 0) {
            System.out.printf("Có nghiệm kép: x = %.2f\n", getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm (delta < 0).");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter b: ");
        int b = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter c: ");
        int c = Integer.parseInt(sc.nextLine());

        QuadraticEquation qe = new QuadraticEquation(a,b,c);
        qe.printSolution();
    }
}
