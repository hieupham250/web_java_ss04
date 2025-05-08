package com.example.ss04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RevenueServlet", value = "/bai8")
public class RevenueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> revenueList = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            Map<String, Object> revenue = new HashMap<>();
            revenue.put("month", i);
            revenue.put("revenue", 1000 * i);
            revenueList.add(revenue);
        }
        request.setAttribute("revenueList", revenueList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/revenue.jsp");
        dispatcher.forward(request, response);
    }
}