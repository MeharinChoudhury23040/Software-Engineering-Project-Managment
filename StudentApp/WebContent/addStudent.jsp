<html>
<head><title>Add Student</title></head>
<body>
    <h2>Add Student</h2>
    <form action="student" method="post">
        <input type="hidden" name="action" value="add"/>
        Name: <input type="text" name="name"/><br>
        Email: <input type="text" name="email"/><br>
        Department: <input type="text" name="department"/><br>
        <input type="submit" value="Add"/>
    </form>
</body>
</html>