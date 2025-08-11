package main.java.module2.ss8_CleanCode.repository;

import main.java.module2.ss8_CleanCode.controller.BrandController;
import main.java.module2.ss8_CleanCode.entity.Brand;
import main.java.module2.ss8_CleanCode.entity.Motorbike;
import main.java.module2.ss8_CleanCode.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements MotorbikeRepoInterface {
    private static BrandController brandController=new BrandController();
    private final String File_Motobike_Path = "src/module2.ss8_CleanCode/data/Motobike.csv";
    @Override
    public void add(Motorbike motorbike) {
        List<String> motobikeList = new ArrayList<>();
        motobikeList.add(motorbike.toString());
        ReadAndWriteFile.writeListToCSV(File_Motobike_Path,motobikeList,true);
    }
    @Override
    public boolean remove(Motorbike motorbike){
        boolean isDeleted = false;
        List<Motorbike> motorbikeList = findAllMotorbikes();
        for(int i = 0; i<motorbikeList.size(); i++){
            if (motorbikeList.get(i).getLicensePlate().equals(motorbike.getLicensePlate())){
                motorbikeList.remove(i);
                isDeleted = true;
                break;
            }
        }
        List<String> StringList = new ArrayList<>();
        for(Motorbike m : motorbikeList){
            StringList.add(m.toString());
        }
        ReadAndWriteFile.writeListToCSV(File_Motobike_Path,StringList,false);
        return isDeleted;
    }
    @Override
    public List<Motorbike> findAllMotorbikes(){
        List<Motorbike> motobikeList = new ArrayList<>();
        List<String> StringList = ReadAndWriteFile.readFileCSV(File_Motobike_Path);
        String[] array=null;
        for(String line : StringList){
            array = line.split("\\s*,\\s*");
            Brand brand = brandController.findBrandByName(array[1]);
            Motorbike motobike = new Motorbike(array[0],brand,Integer.parseInt(array[2]),array[3],Integer.parseInt(array[4]));
            motobikeList.add(motobike);
        }
        return motobikeList;
    }
}
