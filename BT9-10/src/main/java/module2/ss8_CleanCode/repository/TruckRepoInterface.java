package main.java.module2.ss8_CleanCode.repository;

import main.java.module2.ss8_CleanCode.entity.Truck;

import java.util.List;

public interface TruckRepoInterface {
    public void add(Truck truck) ;
    public boolean remove(Truck truck);
    public List<Truck> findAllTrucks() ;
}
