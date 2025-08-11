package main.java.module2.ss8_CleanCode.view;

import main.java.module2.ss8_CleanCode.controller.CarController;
import main.java.module2.ss8_CleanCode.controller.MotorbikeController;
import main.java.module2.ss8_CleanCode.controller.TruckController;

import java.util.Scanner;

public class RemoveVehicleView {
    private static CarController carController = new CarController();
    private static MotorbikeController motorbikeController = new MotorbikeController();
    private static TruckController truckController = new TruckController();
    public static void removeVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biển kiểm soát xe: ");
        String licensePlate= scanner.nextLine();
        if (truckController.remove(licensePlate)){
            System.out.println("Đã xóa xe tải mang biến kiểm soát: "+licensePlate);
        }else if(motorbikeController.remove(licensePlate)){
            motorbikeController.remove(licensePlate);
            System.out.println("Đã xóa xe moto mang biến kiểm soát: "+licensePlate);
        }else if(carController.remove(licensePlate)){
            carController.remove(licensePlate);
            System.out.println("Đã xóa xe ô tô mang biến kiểm soát: "+licensePlate);
        }else {
            System.out.println("Không tìm thấy xe mang biển kiểm soát: "+licensePlate);
        }
    }
}
