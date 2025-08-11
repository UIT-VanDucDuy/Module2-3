package main.java.module2.ss8_CleanCode.entity;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(String licensePlate, Brand brandName, int productionYear, String owner,
                 int loadCapacity) {
        super(licensePlate, brandName, productionYear, owner);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    @Override
    public String toString() {
        return licensePlate+", "+brandName.getBrandName()+", "+productionYear+", "+owner+", "+loadCapacity;
    }
}
