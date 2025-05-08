package com.example.ss04;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServletB7", value = "/bai7")
public class ProductServletB7 extends HttpServlet {

    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "TV", 90.0, "TV siêu nét"));
        productList.add(new Product(2, "Laptop", 1500.00, "Máy tính xách tay mạnh mẽ với RAM 16GB"));
        productList.add(new Product(3, "Smartphone", 799.99, "Điện thoại thông minh Android mới nhất"));
        productList.add(new Product(4, "Headphones", 199.99, "Tai nghe chống ồn"));
        return productList;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = getProductList();
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        Double minPrice = (minPriceStr != null && !minPriceStr.isEmpty()) ? Double.parseDouble(minPriceStr) : 0.0;
        Double maxPrice = (maxPriceStr != null && !maxPriceStr.isEmpty()) ? Double.parseDouble(maxPriceStr) : Double.MAX_VALUE;

        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }

        request.setAttribute("products", filteredProducts);
        request.getRequestDispatcher("/productListB7.jsp").forward(request, response);
    }
}
