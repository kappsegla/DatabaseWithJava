package org.example;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CountryCellFactory implements Callback<ListView<Country>, ListCell<Country>> {
    @Override
    public ListCell<Country> call(ListView<Country> countryListView) {
        return new ListCell<>(){
            @Override
            protected void updateItem(Country country, boolean empty) {
                super.updateItem(country, empty);
                if( empty || country == null)
                    setText("");
                else
                    setText(country.getName() + " : " + country.getPopulation());
            }
        };
    }
}