package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("_Name:");
        TextField textField = new TextField();
        label.setMnemonicParsing(true);
        label.setLabelFor(textField);
        Button button = new Button();
        button.setText("Click on me!");
        button.setOnAction(actionEvent -> {
            button.setText(textField.getText());
        });

        HBox hBox = new HBox();

        hBox.getChildren().add(label);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(button);

        Scene scene = new Scene(hBox, 400, 400);

        stage.setScene(scene);
        stage.show();
    }
}
