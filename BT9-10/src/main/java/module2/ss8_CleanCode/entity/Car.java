package main.java.module2.ss8_CleanCode.entity;

public class Car extends Vehicle {
    private int numberOfSeats;  // Số chỗ ngồi
    private String carType;     // Kiểu xe (du lịch, xe khách)

    public Car(String licensePlate, Brand brandName, int yearOfManufacture, String owner,
               int numberOfSeats, String carType) {
        super(licensePlate, brandName, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.carType = carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getCarType() {
        return carType;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return licensePlate+", "+brandName.getBrandName()+", "+productionYear+", "+owner+", "+numberOfSeats+", "+carType;
    }
}
