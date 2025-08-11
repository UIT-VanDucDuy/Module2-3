package main.java.module2.ss8_CleanCode.service;


import main.java.module2.ss8_CleanCode.entity.Motorbike;

import java.util.List;

public interface MotorServicebikeInterface {
    void addMotorbike(Motorbike motorbike);
    List<Motorbike> showAllMotorbikes();
    boolean removeMotorbike(Motorbike motorbike);
    Motorbike findMotorbikeByPlate(String plate);
}
