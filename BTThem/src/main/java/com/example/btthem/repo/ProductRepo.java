package com.example.btthem.repo;

import com.example.btthem.dto.ProductDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private final String SELECT_ALL = "select hh.*,lhh.TenLoai " +
            "from HangHoa hh join loaihanghoa lhh on lhh.MaLoai = hh.MaLoai;";
    private final String DELETE = "DELETE FROM products WHERE id = ?;";
    private final String SEARCH_NAME_CATEGORY = "select hh.*,lhh.TenLoai " +
            "from HangHoa hh " +
            "join loaihanghoa lhh on lhh.MaLoai = hh.MaLoai " +
            "where hh.TenHang like concat('%',?,'%') and hh.MaLoai = ?;";
    private final String SEARCH_NAME = "select hh.*,lhh.TenLoai " +
            "from HangHoa hh " +
            "join loaihanghoa lhh on lhh.MaLoai = hh.MaLoai " +
            "where hh.TenHang like concat('%',?,'%');";
    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("MaHang");
                String name = resultSet.getString("TenHang");
                double price = resultSet.getDouble("Gia");
                String unit = resultSet.getString("DonViTinh");
                String date  = resultSet.getString("NgayThuHoach");
                String category = resultSet.getString("TenLoai");
                ProductDto product = new ProductDto(id,name,unit,price,category,date);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return productList;
    }

    @Override
    public List<ProductDto> findByName(String searchName) {
        List<ProductDto> productList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);
            preparedStatement.setString(1,searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("MaHang");
                String name = resultSet.getString("TenHang");
                double price = resultSet.getDouble("Gia");
                String unit = resultSet.getString("DonViTinh");
                String date  = resultSet.getString("NgayThuHoach");
                String category = resultSet.getString("TenLoai");
                ProductDto product = new ProductDto(id,name,unit,price,category,date);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return productList;
    }

    @Override
    public List<ProductDto> findByNameAndCategory(String searchName,String searchCategory) {
        List<ProductDto> productList = new ArrayList<>();
        // keets nối DB

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_CATEGORY);
            preparedStatement.setString(1,searchName);
            preparedStatement.setString(2,searchCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("MaHang");
                String name = resultSet.getString("TenHang");
                double price = resultSet.getDouble("Gia");
                String unit = resultSet.getString("DonViTinh");
                String date  = resultSet.getString("NgayThuHoach");
                String category = resultSet.getString("TenLoai");
                ProductDto product = new ProductDto(id,name,unit,price,category,date);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("lỗi querry");
        }
        return productList;
    }

//    @Override
//    public boolean add(Product product) {
//        try( Connection connection = BaseRepository.getConnectDB();) {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
//            preparedStatement.setString(1,product.getName());
//            preparedStatement.setInt(2,product.getPrice());
//            preparedStatement.setString(3,product.getDescription());
//            preparedStatement.setString(4,product.getManufacturer());
//            int effectRow = preparedStatement.executeUpdate();
//            return effectRow==1;
//        } catch (SQLException e) {
//            System.out.println("lỗi query");
//            return false;
//        }
//    }
//
//    @Override
//    public boolean delete(int id) {
//        try( Connection connection = BaseRepository.getConnectDB();) {
//            CallableStatement callableStatement = connection.prepareCall(DELETE);
//            callableStatement.setInt(1,id);
//            int effectRow = callableStatement.executeUpdate();
//            return effectRow==1;
//        } catch (SQLException e) {
//            System.out.println("lỗi query");
//            return false;
//        }
//    }
//
//    @Override
//    public List<ProductDto> findByCategory(String category) {
//        List<ProductDto> productList = new ArrayList<>();
//        // keets nối DB
//
//        try(Connection connection = BaseRepository.getConnectDB();) {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CATEGORY);
//            preparedStatement.setString(1, "%" + category.toLowerCase() + "%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int price = resultSet.getInt("price");
//                String description = resultSet.getString("description");
//                String manufacturer = resultSet.getString("manufacturer");
//                String categoryName = resultSet.getString("categoryName");
//                ProductDto product = new ProductDto(id,name,price,description,manufacturer,categoryName);
//                productList.add(product);
//            }
//        } catch (SQLException e) {
//            System.out.println("lỗi querry");
//        }
//        return productList;
//    }
}
