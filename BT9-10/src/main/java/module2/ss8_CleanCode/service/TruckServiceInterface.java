package main.java.module2.ss8_CleanCode.service;


import main.java.module2.ss8_CleanCode.entity.Truck;
import java.util.List;


public interface TruckServiceInterface {

    void addTruck(Truck truck);
    List<Truck> showAllTrucks();
    boolean removeTruck(Truck truck);
    Truck findTruckByPlate(String licensePlate);
}
