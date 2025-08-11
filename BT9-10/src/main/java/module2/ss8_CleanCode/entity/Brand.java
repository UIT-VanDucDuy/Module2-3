package main.java.module2.ss8_CleanCode.entity;

public class Brand {
    private int id;
    private String BrandCode;
    private String BrandName;
    private String Country;

    public Brand(int id,String brandCode, String brandName, String country) {
        this.id = id;
        this.BrandCode = brandCode;
        this.BrandName = brandName;
        this.Country = country;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String getBrandCode() {
        return BrandCode;
    }

    public String getCountry() {
        return Country;
    }
    public int getId() {
        return id;
    }

    public void setBrandCode(String brandCode) {
        BrandCode = brandCode;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setBrandName(String brandName) {
        this.BrandName = brandName;
    }
    @Override
    public String toString() {
        return id+", "+BrandCode + ", " + BrandName + ", " + Country;
    }
}
