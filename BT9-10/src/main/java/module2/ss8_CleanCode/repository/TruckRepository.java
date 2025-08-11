package main.java.module2.ss8_CleanCode.repository;


import main.java.module2.ss8_CleanCode.controller.BrandController;
import main.java.module2.ss8_CleanCode.entity.Brand;
import main.java.module2.ss8_CleanCode.entity.Truck;
import main.java.module2.ss8_CleanCode.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements TruckRepoInterface {
    private BrandController brandController=new BrandController();
    private final String File_Truck_Path = "src/module2.ss8_CleanCode/data/Truck.csv";
    @Override
    public void add(Truck truck) {
        List<String> truckList = new ArrayList<>();
        truckList.add(truck.toString());
        ReadAndWriteFile.writeListToCSV(File_Truck_Path,truckList,true);
    }
    @Override
    public boolean remove(Truck truck) {
        boolean isDeleted = false;
        List<Truck> truckList = findAllTrucks();
        for(int i = 0; i<truckList.size(); i++){
            if (truckList.get(i).getLicensePlate().equals(truck.getLicensePlate())){
                truckList.remove(i);
                isDeleted = true;
                break;
            }
        }
        List<String> StringList = new ArrayList<>();
        for(Truck t : truckList){
            StringList.add(t.toString());
        }
        ReadAndWriteFile.writeListToCSV(File_Truck_Path,StringList,false);
        return isDeleted;
    }
    @Override
    public List<Truck> findAllTrucks() {
//        String licensePlate, Brand brandName, int productionYear, String owner,int loadCapacity
        List<Truck> truckList = new ArrayList<>();
        List<String> StringList = ReadAndWriteFile.readFileCSV(File_Truck_Path);
        String[] array=null;
        for(String line : StringList){
            array = line.split("\\s*,\\s*");
            Brand brand = brandController.findBrandByName(array[1]);
            Truck truck = new Truck(array[0],brand,Integer.parseInt(array[2]),array[3],Integer.parseInt(array[4]));
            truckList.add(truck);
        }
        return truckList;
    }
}
