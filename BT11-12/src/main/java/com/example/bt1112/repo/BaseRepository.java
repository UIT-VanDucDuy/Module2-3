package com.example.bt1112.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/product?serverTimezone=UTC"; // sửa lại tên của csdl
    private static final String USER ="root";// mặc định của mysql
    private static final String PASS ="123123";// do cài đặt khi cài đặt mysql
    public static Connection getConnectDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}