package main.java.module2.ss8_CleanCode.repository;

import main.java.module2.ss8_CleanCode.controller.BrandController;
import main.java.module2.ss8_CleanCode.entity.Brand;
import main.java.module2.ss8_CleanCode.entity.Car;
import main.java.module2.ss8_CleanCode.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements CarRepoInterface{
    private static BrandController brandController=new BrandController();
    private final String File_Car_Path = "src/module2.ss8_CleanCode/data/Car.csv";
    @Override
    public void add(Car car) {
        List<String> motobikeList = new ArrayList<>();
        motobikeList.add(car.toString());
        ReadAndWriteFile.writeListToCSV(File_Car_Path,motobikeList,true);
    }
    @Override
    public boolean remove(Car car){
        boolean isDeleted = false;
        List<Car> carList = findAllCars();
        for(int i = 0; i<carList.size(); i++){
            if (carList.get(i).getLicensePlate().equals(car.getLicensePlate())){
                carList.remove(i);
                isDeleted = true;
                break;
            }
        }
        List<String> StringList = new ArrayList<>();
        for(Car c : carList){
            StringList.add(c.toString());
        }
        ReadAndWriteFile.writeListToCSV(File_Car_Path,StringList,false);
        return isDeleted;
    }
    @Override
    public List<Car> findAllCars(){
        List<Car> carList = new ArrayList<>();
        List<String> StringList = ReadAndWriteFile.readFileCSV(File_Car_Path);
        String[] array=null;
        for(String line : StringList){
            array = line.split("\\s*,\\s*");
            Brand brand = brandController.findBrandByName(array[1]);
            Car car = new Car(array[0],brand,Integer.parseInt(array[2]),array[3],Integer.parseInt(array[4]),array[5]);
            carList.add(car);
        }
        return carList;
    }
}
