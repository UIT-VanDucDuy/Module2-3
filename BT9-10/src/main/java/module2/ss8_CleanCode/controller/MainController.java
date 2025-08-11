package main.java.module2.ss8_CleanCode.controller;

import main.java.module2.ss8_CleanCode.view.AddVehicleView;
import main.java.module2.ss8_CleanCode.view.MainView;
import main.java.module2.ss8_CleanCode.view.RemoveVehicleView;
import main.java.module2.ss8_CleanCode.view.ShowVehicleView;

public class MainController {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        boolean isPause = true;
        while (isPause) {
            int choice = MainView.displayMainView();
            switch (choice) {
                case 1:
                    AddVehicleView.addVehicleMenu();
                    break;
                case 2:
                    ShowVehicleView.showVehicleMenu();
                    break;
                case 3:
                    RemoveVehicleView.removeVehicleMenu();
                    break;
                case 4:
                    isPause = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }

    }
}
