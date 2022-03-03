package org.example.cellfactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.example.entity.Song;

public class SongCellFactory implements Callback<ListView<Song>, ListCell<Song>> {
    @Override
    public ListCell<Song> call(ListView<Song> songListView) {
        return null;
    }
}

class MyListCell extends ListCell<Song> {

    @Override
    protected void updateItem(Song country, boolean empty) {
        super.updateItem(country, empty);
        if (empty || country == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            setGraphic(null);
        }
    }
}