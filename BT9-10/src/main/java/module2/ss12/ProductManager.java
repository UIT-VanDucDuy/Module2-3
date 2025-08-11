package main.java.module2.ss12;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductManager {
    private List<Product> products= new ArrayList<>();
    private final String FILE_PATH = "src/module2.ss12/products.csv";

    public ProductManager() {
        loadFromFile();
    }

    public void addProduct(Product product){
        products.add(product);
        saveToFile();
    }
    public boolean removeProduct(String id){
        Product product = findProduct(id);
        if(product != null){
            products.remove(product);
            saveToFile();
            return true;
        }
        return false;
    }
    public void printProducts(){
        for(Product product: products){
            System.out.println(product);
        }
    }
    public Product findProduct(String id){
        for(Product product: products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
    public void sortProducts(){
        Collections.sort(products);
        saveToFile();
    }
    public boolean updateProduct(String id,String Name,int newPrice){
        Product product = findProduct(id);
        if(product != null) {
            product.setName(Name);
            product.setPrice(newPrice);
            saveToFile();
            return true;
        }
        return false;
    }
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product p : products) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product p = Product.fromCSV(line);
                if (p != null) {
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}


