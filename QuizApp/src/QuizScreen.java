import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class QuizScreen {
    private String studentId;
    private int score = 0;

    public QuizScreen(String studentId) {
        this.studentId = studentId;
    }

    public void start(Stage stage) {
        // Question 1
        Label q1 = new Label("প্রশ্ন ১: ৫ + ৩ কত?");
        RadioButton q1o1 = new RadioButton("৭");
        RadioButton q1o2 = new RadioButton("৮"); // correct
        RadioButton q1o3 = new RadioButton("৯");
        RadioButton q1o4 = new RadioButton("৬");
        ToggleGroup group1 = new ToggleGroup();
        q1o1.setToggleGroup(group1);
        q1o2.setToggleGroup(group1);
        q1o3.setToggleGroup(group1);
        q1o4.setToggleGroup(group1);

        // Question 2
        Label q2 = new Label("প্রশ্ন ২: ১০ - ৪ কত?");
        RadioButton q2o1 = new RadioButton("৬"); // correct
        RadioButton q2o2 = new RadioButton("৫");
        RadioButton q2o3 = new RadioButton("৭");
        RadioButton q2o4 = new RadioButton("৮");
        ToggleGroup group2 = new ToggleGroup();
        q2o1.setToggleGroup(group2);
        q2o2.setToggleGroup(group2);
        q2o3.setToggleGroup(group2);
        q2o4.setToggleGroup(group2);

        // Submit Button
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            if (q1o2.isSelected()) score += 1;
            if (q2o1.isSelected()) score += 1;

            saveScore();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "আপনার স্কোর: " + score);
            alert.show();
            stage.close();
        });

        VBox root = new VBox(10, q1, q1o1, q1o2, q1o3, q1o4,
                q2, q2o1, q2o2, q2o3, q2o4, submitBtn);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Arithmetic Quiz");
        stage.setScene(scene);
        stage.show();
    }

    private void saveScore() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quiz_db", "root", "12345678")) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO quiz_score(student_id, score) VALUES (?, ?)");
            ps.setString(1, studentId);
            ps.setInt(2, score);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
