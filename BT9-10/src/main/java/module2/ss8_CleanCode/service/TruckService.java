package main.java.module2.ss8_CleanCode.service;

import main.java.module2.ss8_CleanCode.entity.Truck;
import main.java.module2.ss8_CleanCode.repository.TruckRepoInterface;
import main.java.module2.ss8_CleanCode.repository.TruckRepository;

import java.util.List;

public class TruckService implements TruckServiceInterface {
    private static TruckRepoInterface truckRepository = new TruckRepository();

    @Override
    public void addTruck(Truck truck) {
        truckRepository.add(truck);
    }

    @Override
    public List<Truck> showAllTrucks() {
        return truckRepository.findAllTrucks();
    }

    @Override
    public boolean removeTruck(Truck truck) {
        return truckRepository.remove(truck);
    }

    @Override
    public Truck findTruckByPlate(String plate) {
        for (Truck truck : truckRepository.findAllTrucks()) {
            if (truck.getLicensePlate().equals(plate)) {
                return truck;
            }
        }
        return null;
    }
}

