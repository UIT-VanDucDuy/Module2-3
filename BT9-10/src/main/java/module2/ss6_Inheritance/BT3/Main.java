package main.java.module2.ss6_Inheritance.BT3;

public class Main {
    public static void main(String[] args) {
        MoveablePoint m = new MoveablePoint(1.0f, 2.0f, 0.5f, 1.0f);
        System.out.println("Ban đầu: " + m);
        m.move();
        System.out.println("Sau khi di chuyển: " + m);
    }
}
