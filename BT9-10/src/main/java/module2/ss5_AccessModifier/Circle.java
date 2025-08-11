package main.java.module2.ss5_AccessModifier;

public class Circle {
    private double radius =1.0;
    private String color= "red";

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle() {}

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
