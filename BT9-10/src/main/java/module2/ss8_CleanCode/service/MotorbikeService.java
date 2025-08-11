package main.java.module2.ss8_CleanCode.service;

import main.java.module2.ss8_CleanCode.entity.Motorbike;
import main.java.module2.ss8_CleanCode.repository.MotorbikeRepoInterface;
import main.java.module2.ss8_CleanCode.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements MotorServicebikeInterface {
    private MotorbikeRepoInterface motorbikeRepository = new MotorbikeRepository();
    @Override
    public void addMotorbike(Motorbike car) {
        motorbikeRepository.add(car);
    }
    @Override
    public List<Motorbike> showAllMotorbikes() {
        return motorbikeRepository.findAllMotorbikes();
    }
    public boolean removeMotorbike(Motorbike motorbike) {
        return motorbikeRepository.remove(motorbike);
    }

    @Override
    public Motorbike findMotorbikeByPlate(String plate) {
        for (Motorbike motorbike : motorbikeRepository.findAllMotorbikes()) {
            if (motorbike.getLicensePlate().equals(plate)) {
                return motorbike;
            }
        }
        return null;
    }

}
