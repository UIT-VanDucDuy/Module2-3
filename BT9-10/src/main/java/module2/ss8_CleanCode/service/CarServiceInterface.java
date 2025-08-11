package main.java.module2.ss8_CleanCode.service;

import main.java.module2.ss8_CleanCode.entity.Car;

import java.util.List;

public interface CarServiceInterface {
    void addCar(Car car);
    List<Car> showAllCars();
    boolean removeCar(Car car);
    Car findCarByPlate(String plate);

}
