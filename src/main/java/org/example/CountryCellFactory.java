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

import java.util.HashMap;
import java.util.Map;

public class CountryCellFactory implements Callback<ListView<Country>, ListCell<Country>> {
    @Override
    public ListCell<Country> call(ListView<Country> countryListView) {
        return new MyListCell();
    }
}

class MyListCell extends ListCell<Country> {

    static int counter = 0;
    private final ImageView imageView;
    private final Label countryName;
    private final Label countryCapital;
    private final Node cellNode;

    public MyListCell() {
        super();
        imageView = new ImageView();
        HBox hBox = new HBox();
        hBox.setSpacing(10.0);
        hBox.getChildren().add(imageView);
        VBox box = new VBox();
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
            Image image = FlagFactory.getFlag(country.getCode());
            imageView.setImage(image);
            countryName.setText(country.getName());
            countryCapital.setText(country.getCapital());
            setGraphic(cellNode);
            //System.out.println("updateItem : " +  getIndex());
        }
    }
}

class FlagFactory {
    //Only use this when the same image is used many times. Never when an image is mapped one to one in a scrolling flow.
    //Images will be stored for all future here, can be optimized with limiting number of images stored.
    //Replace with https://github.com/K1rakishou/Caching-Image-Loader ???
    private final static Map<String, Image> flags = new HashMap<>();

    static Image getFlag(String countryCode) {
        return flags.computeIfAbsent(countryCode, code -> new Image("/" + code + ".png"));
        //return flags.computeIfAbsent(countryCode, code -> new Image("https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Flag_of_Sweden.svg/1200px-Flag_of_Sweden.svg.png",80, 80, false, false));

//        if( flags.containsKey(countryCode))
//            return flags.get(countryCode);
//        else {
//            flags.put(countryCode, new Image("/" + countryCode + ".png"));
//            return flags.get(countryCode);
//        }
    }
}