package com.example.local2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 617, 340);
        stage.setTitle("dbTest");
        stage.setResizable(false);
//        File file =new File("download.jpg");
//        Desktop desktop =Desktop.getDesktop();
//        desktop.open(file);
         Image image =new Image("download.jpg");


        stage.getIcons().add(image);
//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent we) {
//                Desktop desktop =Desktop.getDesktop();
//                File file2 =new File("Joji_Tick_Tock.mp3");
//                try {
//                    desktop.open(file2);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//                    for (int j = 0; j <30; j++) {
//
//
//                        File file = new File("download.jpg");
//
//
//                        try {
//
//                            desktop.open(file);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
////
////                FXMLLoader loader=new FXMLLoader();
////                loader.setLocation(getClass().getResource("/com/example/local2/Login.fxml"));
////                try {
////                    loader.load();
////                } catch (IOException e) {
////                    throw new RuntimeException(e);
////                }
////                Parent root =loader.getRoot();
////                Stage stage =new Stage();
////                    stage.setTitle("dbTest");
////                    stage.setResizable(false);
////
////                    Image image =new Image("C:/phj/download.jpg");
////                    stage.getIcons().add(image);
////                stage.setScene(new Scene(root));
////                stage.showAndWait();
////
////            }
//        }});

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}