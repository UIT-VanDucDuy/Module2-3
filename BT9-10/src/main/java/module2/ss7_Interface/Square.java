package main.java.module2.ss7_Interface;

public class Square implements Resizeable, Colorable {
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public void resize(double percent) {
        side += side * percent / 100.0;
    }

    @Override
    public void howToColor() {
     System.out.println("Color red for Square");
    }
}
