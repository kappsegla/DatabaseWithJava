package org.example;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CountryCellFactory implements Callback<ListView<Country>, ListCell<Country>> {
    @Override
    public ListCell<Country> call(ListView<Country> countryListView) {
        return new ListCell<>(){
            @Override
            protected void updateItem(Country country, boolean empty) {
                super.updateItem(country, empty);
                if( empty || country == null) {
                    setText(null);
                    setGraphic(null);
                }
                else {
                    setText(null);
                    Image image = new Image("/"+country.getCode()+".png");
                    ImageView imageView = new ImageView(image);
                    HBox hBox = new HBox();
                    hBox.setSpacing(10.0);
                    hBox.getChildren().add(imageView);
                    VBox box = new VBox();
                    hBox.getChildren().add(box);
                    Label countryName = new Label(country.getName());
                    Label countryCapital = new Label(country.getCapital());
                    box.getChildren().add(countryName);
                    box.getChildren().add(countryCapital);
                    setGraphic(hBox);
                }
            }
        };
    }
}