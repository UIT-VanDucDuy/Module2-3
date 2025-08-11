package com.example.bt101;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyễn Văn A", "1995-02-15", "Hà Nội", "anh.png"));
        customers.add(new Customer("Trần Thị B", "1998-06-20", "Hồ Chí Minh", "anh.png"));
        customers.add(new Customer("Lê Văn C", "2000-12-01", "Đà Nẵng", "anh.png"));
        return customers;
    }

}
