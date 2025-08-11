package main.java.module2.ss5_AccessModifier.ProductMannager;

public class ProductManagement {
    private Product[] products = new Product[100];
    private int size;

    public ProductManagement() {}
    public ProductManagement(Product[] product) {
        this.products = product;
    }
    public void add(Product product) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId()== product.getId()) {
                System.out.println("ID đã tồn tại. Không thể thêm sản phẩm.");
                return;
            }
        }
        if (size < products.length) {
            products[size] = product;
            size++;
            System.out.println("thêm mới thành công");

        } else {
            System.out.println("Mảng đầy, không thể thêm sản phẩm mới.");
        }
    }
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId()==id) {
                for (int j = i; j < size - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--size] = null;
                System.out.println("Sản phẩm đã được xoá");
            }
        }
    }
    public void ListProducts() {
        if (size == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }else {
            System.out.println("STT    Name         Price");
            for (int i = 0; i < size; i++) {
                System.out.println(products[i].getId() + "       "
                        + products[i].getName() + "         " + products[i].getPrice());
            }
        }

    }
    public Product getProductById(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId()==id) {
                return products[i];
            }
        }
        return null;
    }
}
