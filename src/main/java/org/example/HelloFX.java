package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        TextField textField = new TextField();

        Button button = new Button();
        button.setText("Click on me!");
        button.setOnAction(actionEvent -> {
            button.setText(textField.getText());
        });


        VBox vBox = new VBox();

        vBox.getChildren().add(textField);
        vBox.getChildren().add(button);

        Scene scene = new Scene(vBox,400,400);

        stage.setScene(scene);
        stage.show();
    }
}
