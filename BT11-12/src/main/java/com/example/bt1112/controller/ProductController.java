package com.example.bt1112.controller;

import com.example.bt1112.entity.Product;
import com.example.bt1112.service.IProductService;
import com.example.bt1112.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {

    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req,resp);
                break;
            case "delete":
                break;
            default:
                showList(req,resp);
        }

    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // phải lấy dữ liệu  nêu cần gọi service
            req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = productService.findAll();
        req.setAttribute("productList", productList);
        try {
            req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            default:
        }

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
//        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Product product = new Product(name, price, description, manufacturer, categoryId);
        boolean isAddSuccess = productService.add(product);
        String mess = "";
        if (isAddSuccess){
            mess = "Add success";
        }else {
            mess = "No success";
        }
        try {
            resp.sendRedirect("/products?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("deleteId"));
        boolean isDeleteSuccess = productService.delete(id);
        String mess = "";
        if (isDeleteSuccess){
            mess = "Delete success";
        }else {
            mess = "No success";
        }
        try {
            resp.sendRedirect("/products?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
