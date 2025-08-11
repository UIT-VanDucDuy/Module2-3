package main.java.module2.ss8_CleanCode.view;

import main.java.module2.ss8_CleanCode.controller.BrandController;
import main.java.module2.ss8_CleanCode.controller.CarController;
import main.java.module2.ss8_CleanCode.controller.MotorbikeController;
import main.java.module2.ss8_CleanCode.controller.TruckController;
import main.java.module2.ss8_CleanCode.entity.Brand;
import main.java.module2.ss8_CleanCode.entity.Car;
import main.java.module2.ss8_CleanCode.entity.Motorbike;
import main.java.module2.ss8_CleanCode.entity.Truck;
import main.java.module2.ss8_CleanCode.util.CheckRegex;

import java.util.List;
import java.util.Scanner;

public class AddVehicleView {
    private static BrandController brandController = new BrandController();
    private static CarController carController = new CarController();
    private static MotorbikeController motorbikeController = new MotorbikeController();
    private static TruckController truckController = new TruckController();
    public static void addVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm mới phương tiện: ");
        System.out.println("1. Thêm xe tải,");
        System.out.println("2. Thêm ôtô, ");
        System.out.println("3. Thêm  xe máy.");
        System.out.print("Mời bạn nhập lựa chọn: ");
        int choice =  Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                truckController.add(addTruckInput());
                break;
            case 2:
                carController.add(addCarInput());
                break;
            case 3:
                motorbikeController.add(addMotorbikeInput());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ: " + choice);
                break;

        }
    }
    private static Car addCarInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Thêm mới ôtô: ");
        System.out.print("Biển kiểm soát (vd: 43A-123.45): ");
        String licensePlate = scanner.nextLine();
        while (!CheckRegex.checkLicensePlate(licensePlate)){
            System.out.println("Định dạng biển khiểm soát không đúng!");
            System.out.print("Nhập lại biển khiểm soát (vd: 43A-12345): ");
            licensePlate = scanner.nextLine();
        }
        Brand brand = inputBrand();
        System.out.print("Năm sản xuất: ");
        int productionYear = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Số chổ ngồi: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Kiểu xe: ");
        String carType = scanner.nextLine();
        return new Car(licensePlate, brand, productionYear, owner,numberOfSeats, carType);
    }
    private static Motorbike addMotorbikeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Thêm mới xe máy: ");
        System.out.print("Biển kiểm soát (vd: 43A-123.45): ");
        String licensePlate = scanner.nextLine();
        while (!CheckRegex.checkLicensePlate(licensePlate)){
            System.out.println("Định dạng biển khiểm soát không đúng!");
            System.out.print("Nhập lại biển khiểm soát (vd: 43A-12345): ");
            licensePlate = scanner.nextLine();
        }
        Brand brand = inputBrand();
        System.out.print("Năm sản xuất: ");
        int productionYear = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Công suất: ");
        int horsepower = Integer.parseInt(scanner.nextLine().trim());
        return new Motorbike(licensePlate, brand, productionYear, owner,horsepower);
    }
    private static Truck addTruckInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Thêm mới ôtô: ");
        System.out.print("Biển kiểm soát (vd: 43A-12345): ");
        String licensePlate = scanner.nextLine();
        while (!CheckRegex.checkLicensePlate(licensePlate)){
            System.out.println("Định dạng biển khiểm soát không đúng!");
            System.out.print("Nhập lại biển khiểm soát (vd: 43A-12345): ");
            licensePlate = scanner.nextLine();
        }
        Brand brand = inputBrand();
        System.out.print("Năm sản xuất: ");
        int productionYear = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Tải trọng: ");
        int loadCapacity = Integer.parseInt(scanner.nextLine().trim());
        return new Truck(licensePlate, brand, productionYear, owner, loadCapacity);
    }

    private static Brand inputBrand() {
        List<Brand> brands = brandController.showAllBrands();
        Scanner scanner = new Scanner(System.in);
        Brand selectedBrand = null;

        while (selectedBrand == null) {
            System.out.println("Danh sách hãng sản xuất:");
            for (Brand brand : brands) {
                System.out.println(brand.toString());
            }

            System.out.print("Hãng xe của bạn (Nhập ID hãng): ");
            String input = scanner.nextLine().trim();

            try {
                int id = Integer.parseInt(input);
                selectedBrand = brandController.findBrandById(id);

                if (selectedBrand == null) {
                    System.out.println("Không tìm thấy hãng với ID đã nhập. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }

        return selectedBrand;
    }
}
