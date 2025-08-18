package com.example.bt1112.repo;

import com.example.bt1112.entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from classes;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category classes = new Category(id,name);
                categories.add(classes);
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return categories;
    }
}
