package main.java.module2.ss8_CleanCode.controller;

import main.java.module2.ss8_CleanCode.entity.Brand;
import main.java.module2.ss8_CleanCode.service.BrandServiceInterface;
import main.java.module2.ss8_CleanCode.service.BrandService;

import java.util.List;

public class BrandController {
    private BrandServiceInterface brandService = new BrandService();

    public List<Brand> showAllBrands(){
        return brandService.getBrandList();
    }
    public Brand findBrandById(int id){
        return brandService.findBrandById(id);
    }
    public Brand findBrandByName(String brandName){
        return brandService.findBrandByName(brandName);
    }
}
