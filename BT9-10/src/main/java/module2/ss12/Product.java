package main.java.module2.ss12;

public class Product implements Comparable<Product>{
    private String id;
    private String name;
    private int price;

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public static Product fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Product(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
        }
        return null;
    }
    @Override
    public String toString() {
        return   id+ ", " + name + ", " + price;
    }
    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }
}
