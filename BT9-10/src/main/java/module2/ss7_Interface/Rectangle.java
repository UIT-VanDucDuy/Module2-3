package main.java.module2.ss7_Interface;

public class Rectangle implements Resizeable, Colorable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public void resize(double percent) {
        width += width * percent / 100.0;
        height += height * percent / 100.0;
    }

    @Override
    public void howToColor() {
        System.out.println("Color blue for Rectangle");
    }
}
