package main.java.module2.ss8_CleanCode.view;

import main.java.module2.ss8_CleanCode.controller.CarController;
import main.java.module2.ss8_CleanCode.controller.MotorbikeController;
import main.java.module2.ss8_CleanCode.controller.TruckController;
import main.java.module2.ss8_CleanCode.entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class ShowVehicleView {
    private static CarController carController = new CarController();
    private static MotorbikeController motorbikeController = new MotorbikeController();
    private static TruckController truckController = new TruckController();
    public static void showVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hiển thị phương tiện: ");
        System.out.println("1. Hiển thị xe tải,");
        System.out.println("2. Hiển thị ôtô, ");
        System.out.println("3. Hiển thị  xe máy.");
        System.out.print("Mời bạn nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: showVehicle(truckController.showAllTrucks());break;
            case 2: showVehicle(carController.showAllCars());break;
            case 3: showVehicle(motorbikeController.showAllMotorbikes());break;
        }
    }
    private static <T extends Vehicle> void showVehicle(List<T> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}
