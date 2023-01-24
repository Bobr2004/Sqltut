package com.example.local2;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField age;

    @FXML
    private TextField colorhair;

    @FXML
    private Button registration;

    @FXML
    private TextField username;

    @FXML
    private Button login;
    @FXML
    private PasswordField userpassword;

    @FXML
    void initialize() {

        try {
            Statement statement =Conn.c().createStatement();

            registration.setOnAction(event -> {
                String susername1 =username.getText();
                String susername2 =userpassword.getText();
                int susername3 =Integer.parseInt(age.getText());
                String susername4 =colorhair.getText();


                try {
                    PreparedStatement preparedStatement =Conn.c().prepareStatement("insert into people(name,age,colorhair,password) value((?),(?),(?),(?))");
                    preparedStatement.setString(1,susername1);
                    preparedStatement.setInt(2,susername3);
                    preparedStatement.setString(3,susername4);
                    preparedStatement.setString(4,susername2);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        login.setOnAction(event -> {
            login.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/local2/Login.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root =loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });



    }

}

