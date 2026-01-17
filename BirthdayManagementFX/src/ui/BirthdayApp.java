package ui;

import db.DBConnection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class BirthdayApp extends Application {

    TextField nameField = new TextField();
    DatePicker datePicker = new DatePicker();
    TableView<String> table = new TableView<>();

    @Override
    public void start(Stage stage) {

        Label title = new Label("জন্মদিন ব্যবস্থাপনা সিস্টেম");

        nameField.setPromptText("নাম লিখুন");
        datePicker.setPromptText("জন্ম তারিখ");

        Button addBtn = new Button("সংরক্ষণ করুন");
        Button updateBtn = new Button("আপডেট করুন");
        Button deleteBtn = new Button("মুছুন");
        Button viewBtn = new Button("সব দেখুন");
        Button todayBtn = new Button("আজকের জন্মদিন");

        addBtn.setOnAction(e -> addBirthday());
        updateBtn.setOnAction(e -> updateBirthday());
        deleteBtn.setOnAction(e -> deleteBirthday());
        viewBtn.setOnAction(e -> loadData());
        todayBtn.setOnAction(e -> todayBirthday());

        TableColumn<String, String> col = new TableColumn<>("তালিকা");
        col.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
        table.getColumns().add(col);

        VBox root = new VBox(10,
                title,
                new Label("নাম"), nameField,
                new Label("জন্ম তারিখ"), datePicker,
                addBtn, updateBtn, deleteBtn,
                viewBtn, todayBtn,
                table
        );

        stage.setScene(new Scene(root, 450, 550));
        stage.setTitle("Birthday App");
        stage.show();
    }

    private void addBirthday() {
        try {
            if (datePicker.getValue() == null || nameField.getText().isEmpty()) {
                alert("নাম এবং জন্ম তারিখ দিন");
                return; // stop execution
            }

            String sql = "INSERT INTO classmates(name, birth_date) VALUES (?, ?)";
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, nameField.getText());
            pst.setDate(2, Date.valueOf(datePicker.getValue()));
            pst.executeUpdate();
            alert("সফলভাবে সংরক্ষণ হয়েছে");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBirthday() {
        try {
            if (datePicker.getValue() == null || nameField.getText().isEmpty()) {
                alert("নাম এবং জন্ম তারিখ দিন");
                return;
            }

            String sql = "UPDATE classmates SET birth_date=? WHERE name=?";
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setDate(1, Date.valueOf(datePicker.getValue()));
            pst.setString(2, nameField.getText());
            pst.executeUpdate();
            alert("আপডেট সম্পন্ন হয়েছে");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteBirthday() {
        try {
            if (nameField.getText().isEmpty()) {
                alert("নাম লিখুন");
                return;
            }

            String sql = "DELETE FROM classmates WHERE name=?";
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, nameField.getText());
            pst.executeUpdate();
            alert("ডাটা মুছে ফেলা হয়েছে");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        ObservableList<String> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM classmates ORDER BY MONTH(birth_date), DAY(birth_date)";
            ResultSet rs = DBConnection.getConnection()
                    .prepareStatement(sql).executeQuery();

            while (rs.next()) {
                data.add(rs.getString("name") + " - " + rs.getDate("birth_date"));
            }
            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void todayBirthday() {
        try {
            LocalDate today = LocalDate.now();
            String sql = "SELECT name FROM classmates WHERE MONTH(birth_date)=? AND DAY(birth_date)=?";
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, today.getMonthValue());
            pst.setInt(2, today.getDayOfMonth());

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                alert(" আজ " + rs.getString("name") + " এর জন্মদিন!");
            } else {
                alert("আজ কারো জন্মদিন নেই");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void alert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
