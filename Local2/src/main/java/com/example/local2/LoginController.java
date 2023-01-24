package com.example.local2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField age;

    @FXML
    private TextField colorhair;

    @FXML
    private Button login;

    @FXML
    private Button registration;

    @FXML
    private TextField username;

    @FXML
    private PasswordField userpassword;

    @FXML
    void initialize() {
        login.setOnAction(event -> {
            String susername1 =username.getText();
            String susername2 =userpassword.getText();
            int susername3 =Integer.parseInt(age.getText());
            String susername4 =colorhair.getText();
            try {
                Statement statement =Conn.c().createStatement();
                ResultSet resultSet =statement.executeQuery("select * from people");
                while (resultSet.next()){
                    String ch =resultSet.getString("colorhair");
                    String pw =resultSet.getString("password");
                    String nm =resultSet.getString("name");
                    int ag =resultSet.getInt("age");
                    if(susername2.equals(pw) && susername1.equals(nm) && susername4.equals(ch) && susername3 ==ag){
                        System.out.println("Hello "+nm);
                        File file =new File("download.jpg");
                        File file2 =new File("Joji_Tick_Tock.mp3");
                        Desktop desktop =Desktop.getDesktop();
                        desktop.open(file2);
                        desktop.open(file);
                        
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    registration.setOnAction(event -> {
        registration.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/local2/hello-view.fxml"));
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