package main.java.module2.ss7_Interface;

public class Circle implements Resizeable, Colorable {
    private double radius ;
    private String color;

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

    @Override
    public void resize(double percent) {
        radius = radius + radius * percent / 100;
    }

    @Override
    public void howToColor() {
        System.out.println("Color green for Circle");
    }
}
