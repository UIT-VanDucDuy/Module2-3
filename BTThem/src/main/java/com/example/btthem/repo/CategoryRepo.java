package com.example.btthem.repo;

import com.example.btthem.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo{
    private final String INSERT = "INSERT INTO Category (Name) VALUES (?)";
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from loaihanghoa;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("MaLoai");
                String name = resultSet.getString("TenLoai");
                Category category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return categories;
    }
}
