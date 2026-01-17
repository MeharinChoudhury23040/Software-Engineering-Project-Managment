package com.example.student;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private List<String[]> students = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        students.add(new String[]{name, email});

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Student Added!</h2>");
        out.println("<a href='index.html'>Go Back</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Student List</h2>");
        out.println("<table border='1'><tr><th>Name</th><th>Email</th></tr>");
        for (String[] s : students) {
            out.println("<tr><td>" + s[0] + "</td><td>" + s[1] + "</td></tr>");
        }
        out.println("</table>");
        out.println("<a href='index.html'>Go Back</a>");
    }
}