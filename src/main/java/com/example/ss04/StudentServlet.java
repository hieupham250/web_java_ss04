package com.example.ss04;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/bai6")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", 20, 8.0));
        students.add(new Student(2, "Trần Thị B", 21, 6.5));
        students.add(new Student(3, "Phạm Văn C", 22, 7.5));
        students.add(new Student(4, "Lê Thị D", 20, 9.0));
        students.add(new Student(5, "Hoàng Văn E", 23, 5.5));

        int count = 0;
        for (Student student : students) {
            if (student.getGpa() > 7.0) {
                count++;
            }
        }

        request.setAttribute("students", students);
        request.setAttribute("highGpaCount", count);

        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }
}