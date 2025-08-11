package main.java.module2.ss8_CleanCode.repository;

import main.java.module2.ss8_CleanCode.entity.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements BrandRepoInterface{
    private static List<Brand> brands= new ArrayList<>();
    static {
        brands.add(new Brand(1,"HSX-001", "Yamaha", "Nhật Bản"));
        brands.add(new Brand(2,"HSX-002", "Honda", "Nhật Bản"));
        brands.add(new Brand(3,"HSX-003", "Dongfeng", "Trung Quốc"));
        brands.add(new Brand(4,"HSX-004", "Huyndai", "Hàn Quốc"));
        brands.add(new Brand(5,"HSX-005", "Ford", "Mỹ"));
        brands.add(new Brand(6,"HSX-006", "Toyota", "Nhật Bản"));
        brands.add(new Brand(7,"HSX-007", "Hino", "Nhật Bản"));
    }

    public List<Brand> getBrands() {
        return brands;
    }
}
