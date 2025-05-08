package com.example.ss04;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/bai1")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1500.00, "Máy tính xách tay mạnh mẽ với RAM 16GB"));
        productList.add(new Product(2, "Smartphone", 799.99, "Điện thoại thông minh Android mới nhất"));
        productList.add(new Product(3, "Headphones", 199.99, "Tai nghe chống ồn"));

        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
    }
}