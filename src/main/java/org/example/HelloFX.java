package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Button button = new Button();
        button.setText("Click on me!");

        VBox vBox = new VBox();
        vBox.getChildren().add(button);

        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();
    }
}
