import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class QuizApp extends Application {

    public Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/quiz_db";
        String user = "root";
        String password = "12345678";

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Enter Student ID:");
        TextField studentIdField = new TextField();
        Button loginBtn = new Button("Start Quiz");

        loginBtn.setOnAction(e -> {
            String studentId = studentIdField.getText();
            try (Connection conn = connectDB()) {
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM student WHERE student_id=?");
                ps.setString(1, studentId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    new QuizScreen(studentId).start(new Stage());
                    primaryStage.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Student ID not found!");
                    alert.show();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(10, label, studentIdField, loginBtn);
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("Student Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
