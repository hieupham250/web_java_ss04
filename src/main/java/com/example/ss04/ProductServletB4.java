package com.example.ss04;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServletB4", value = "/bai4")
public class ProductServletB4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "TV", 0.0, "TV siêu nét"));
        productList.add(new Product(2, "Laptop", 1500.00, "Máy tính xách tay mạnh mẽ với RAM 16GB"));
        productList.add(new Product(3, "Smartphone", 799.99, "Điện thoại thông minh Android mới nhất"));
        productList.add(new Product(4, "Headphones", 199.99, "Tai nghe chống ồn"));

        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
        dispatcher.forward(request, response);
    }
}