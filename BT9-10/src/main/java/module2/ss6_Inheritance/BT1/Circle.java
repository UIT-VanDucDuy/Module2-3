package main.java.module2.ss6_Inheritance.BT1;

public class Circle {
    private double radius ;

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle() {}

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }

}
