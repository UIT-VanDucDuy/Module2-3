package com.example.btthem.controller;


import com.example.btthem.dto.ProductDto;
import com.example.btthem.entity.Category;
import com.example.btthem.repo.CategoryRepo;
import com.example.btthem.repo.ICategoryRepo;
import com.example.btthem.service.CategoryService;
import com.example.btthem.service.ICategoryService;
import com.example.btthem.service.IProductService;
import com.example.btthem.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                //showFormAdd(request,response);
                break;
            case "delete":
                break;
            case "search":
                searchByNameAndCategory(request,response);
                break;
            default:
                showList(request,response);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDto> productList = productService.findAll();
        req.setAttribute("productList", productList);
        List<Category> categoryList = categoryService.getAll();
        req.setAttribute("categoryList", categoryList);
        try {
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<ProductDto> productList = productService.findAll();
        req.setAttribute("productList", productList);
        try {
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void searchByNameAndCategory(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        String classId = req.getParameter("categoryId");
        List<ProductDto> productList = productService.searchByNameAndCategory(searchName,classId);
        req.setAttribute("productList", productList);
        req.setAttribute("categoryList", categoryService.getAll());
        try {
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
