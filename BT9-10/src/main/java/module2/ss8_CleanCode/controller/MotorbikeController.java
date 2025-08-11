package main.java.module2.ss8_CleanCode.controller;


import main.java.module2.ss8_CleanCode.entity.Motorbike;
import module2.ss8_CleanCode.service.*;

import java.util.List;

public class MotorbikeController {
    private MotorServicebikeInterface motorbikeService = new MotorbikeService();

    public void add(Motorbike motorbike){
        motorbikeService.addMotorbike(motorbike);
    }
    public List<Motorbike> showAllMotorbikes(){
        return motorbikeService.showAllMotorbikes();
    }
    public boolean remove(String plate){
        return motorbikeService.removeMotorbike(findMotorbikeByPlate(plate));
    }
    public Motorbike findMotorbikeByPlate(String plate){
        return motorbikeService.findMotorbikeByPlate(plate);
    }
}
