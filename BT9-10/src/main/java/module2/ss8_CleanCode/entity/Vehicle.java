package main.java.module2.ss8_CleanCode.entity;

public abstract class Vehicle {
    protected String licensePlate;
    protected Brand brandName;
    protected int productionYear;
    protected String owner;

    public Vehicle(String licensePlate, Brand BrandName, int productionYear, String owner) {
        this.licensePlate = licensePlate;
        this.brandName =BrandName;
        this.productionYear = productionYear;
        this.owner = owner;
    }
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwner() {
        return owner;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }
}
