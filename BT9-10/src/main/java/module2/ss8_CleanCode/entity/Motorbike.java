package main.java.module2.ss8_CleanCode.entity;

public class Motorbike extends Vehicle {
    private int horsepower; // Công suất

    public Motorbike(String licensePlate, Brand brandName, int productionYear, String owner,
                     int horsepower) {
        super(licensePlate, brandName, productionYear, owner);
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        return licensePlate+", "+brandName.getBrandName()+", "+productionYear+", "+owner+", "+horsepower;
    }
}

