package org.example;

import javafx.scene.Node;
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
        return new MyListCell();
    }
}

class MyListCell extends ListCell<Country> {

    private Image image;
    private ImageView imageView;
    private HBox hBox;
    private VBox box;
    private Label countryName;
    private Label countryCapital;
    private Node cellNode;

    static int counter = 0;

    public MyListCell() {
        super();
        imageView = new ImageView();
        hBox = new HBox();
        hBox.setSpacing(10.0);
        hBox.getChildren().add(imageView);
        box = new VBox();
        hBox.getChildren().add(box);
        countryName = new Label("");
        countryCapital = new Label("");
        box.getChildren().add(countryName);
        box.getChildren().add(countryCapital);
        cellNode = hBox;
        counter++;
       // System.out.println("Constructor for ListCell. Total count: " + counter);
    }

    @Override
    protected void updateItem(Country country, boolean empty) {
        super.updateItem(country, empty);
        if (empty || country == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            image = new Image("/" + country.getCode() + ".png");
            imageView.setImage(image);
            countryName.setText(country.getName());
            countryCapital.setText(country.getCapital());
            setGraphic(cellNode);
         //   System.out.println("updateItem : " +  getIndex());
        }
    }
}