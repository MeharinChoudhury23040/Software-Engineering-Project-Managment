package dao;

import java.sql.*;
import java.util.*;
import model.Student;

public class StudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private String jdbcUser = "root";
    private String jdbcPass = "12345678"; // change to your MySQL password

    private static final String INSERT_SQL = "INSERT INTO students (name,email,department) VALUES (?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM students";
    private static final String DELETE_SQL = "DELETE FROM students WHERE id=?";

    public void insertStudent(Student s) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getDepartment());
            ps.executeUpdate();
        }
    }

    public List<Student> listStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setDepartment(rs.getString("department"));
                students.add(s);
            }
        }
        return students;
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}