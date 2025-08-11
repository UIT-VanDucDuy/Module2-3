package main.java.module2.ss6_Inheritance.BT1;

public class Main {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(2.0, 5.0);
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Height: " + c.getHeight());
        System.out.println("Area of Base: " + c.getArea());
        System.out.println("Volume: " + c.getVolume());
    }
}
