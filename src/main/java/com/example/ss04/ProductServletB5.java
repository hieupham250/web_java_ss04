package com.example.ss04;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServletB5", value = "/bai5")
public class ProductServletB5 extends HttpServlet {
    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "TV", 0.0, "TV siêu nét"));
        productList.add(new Product(2, "Laptop", 1500.00, "Máy tính xách tay mạnh mẽ với RAM 16GB"));
        productList.add(new Product(3, "Smartphone", 799.99, "Điện thoại thông minh Android mới nhất"));
        productList.add(new Product(4, "Headphones", 199.99, "Tai nghe chống ồn"));
        return productList;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = getProductList();
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product_search.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = getProductList();

        String searchIdParam = request.getParameter("searchId");
        Product foundProduct = null;

        try {
            int searchId = Integer.parseInt(searchIdParam);
            for (Product p : productList) {
                if (p.getId() == searchId) {
                    foundProduct = p;
                    break;
                }
            }
        } catch (NumberFormatException ignored) {
        }

        request.setAttribute("products", productList);
        request.setAttribute("searchResult", foundProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product_search.jsp");
        dispatcher.forward(request, response);
    }
}