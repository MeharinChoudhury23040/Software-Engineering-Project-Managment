package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.StudentDAO;
import model.Student;

public class StudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("add".equals(action)) {
                Student s = new Student();
                s.setName(req.getParameter("name"));
                s.setEmail(req.getParameter("email"));
                s.setDepartment(req.getParameter("department"));
                dao.insertStudent(s);
                resp.sendRedirect("listStudents.jsp");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deleteStudent(id);
                resp.sendRedirect("listStudents.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}