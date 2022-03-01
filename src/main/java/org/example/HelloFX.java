package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HelloFX extends Application {

    private ObservableList<Country> observableList;
    private ListView<Country> listView;

    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("_Name:");
        TextField textField = new TextField();
        label.setMnemonicParsing(true);
        label.setLabelFor(textField);
        Button button = new Button();
        button.setText("Add");
        button.setOnAction(actionEvent -> {
          //  observableList.add(textField.getText());
        });
        Button deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(actionEvent -> {
            var index = listView.getSelectionModel().getSelectedIndex();
            if( index >= 0)
                observableList.remove(index);
        });

        List<Country> stringList = new ArrayList<>(List.of(new Country("Sverige","Stockholm",10500000),
                new Country("Norge","Oslo",5500000)));

        listView = new ListView<>();
        observableList = FXCollections.observableList(stringList);
        listView.setItems(observableList);

        HBox hBox = new HBox();

        hBox.getChildren().add(label);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(button);
        hBox.getChildren().add(deleteButton);
        hBox.getChildren().add(listView);

        Scene scene = new Scene(hBox);

        stage.setScene(scene);
        stage.show();
    }
}
