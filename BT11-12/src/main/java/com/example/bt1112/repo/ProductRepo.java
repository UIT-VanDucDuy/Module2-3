package com.example.bt1112.repo;

import com.example.bt1112.dto.ProductDto;
import com.example.bt1112.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private final String SELECT_ALL = "select p.id,p.name,p.price,p.description,p.manufacturer,c.categoryName from products p join categories c on p.categoryId=c.Id;";
    private final String INSERT_INTO = "insert into account(name,price,description, manufacturer) values(?,?,?,?);";
    private final String DELETE = "DELETE FROM products WHERE id = ?;";
    private final String FIND_BY_CATEGORY = "select p.id, p.name, p.price, p.description, p.manufacturer, c.categoryname\n" +
            "from products p\n" +
            "join categories c on p.categoryid = c.id\n" +
            "where c.categoryname like ?;";


    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");
                String category = resultSet.getString("categoryName");
                ProductDto product = new ProductDto(id,name,price,description,manufacturer,category);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return productList;
    }

    @Override
    public boolean add(Product product) {
        try( Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setString(4,product.getManufacturer());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi query");
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try( Connection connection = BaseRepository.getConnectDB();) {
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1,id);
            int effectRow = callableStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi query");
            return false;
        }
    }

    @Override
    public List<ProductDto> findByCategory(String category) {
        List<ProductDto> productList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CATEGORY);
            preparedStatement.setString(1, "%" + category.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");
                String categoryName = resultSet.getString("categoryName");
                ProductDto product = new ProductDto(id,name,price,description,manufacturer,categoryName);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return productList;
    }
}
