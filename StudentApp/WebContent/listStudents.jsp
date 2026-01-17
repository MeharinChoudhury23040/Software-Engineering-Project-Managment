<%@ page import="java.util.*,dao.StudentDAO,model.Student" %>
<html>
<head><title>Student List</title></head>
<body>
    <h2>All Students</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Action</th></tr>
        <%
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.listStudents();
            for(Student s : list){
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getDepartment() %></td>
            <td>
                <form action="student" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="<%= s.getId() %>"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>