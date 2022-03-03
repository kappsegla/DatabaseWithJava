package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.entity.Song;
import org.example.service.SongService;

import java.util.List;


public class HelloFX extends Application {

    private ObservableList<Song> observableList;
    private ListView<Song> listView;

    private SongService songService;
    private TextField songName;
    private TextField artistName;
    private Button addButton;
    private Button deleteButton;

    @Override
    public void start(Stage stage) throws Exception {
        songService = new SongService();

        Label labelForSongName = new Label("_Name:");
        songName = new TextField();
        labelForSongName.setMnemonicParsing(true);
        labelForSongName.setLabelFor(songName);

        Label labelForArtistName = new Label("_Artist:");
        artistName = new TextField();
        labelForArtistName.setMnemonicParsing(true);
        labelForSongName.setLabelFor(artistName);

        addButton = new Button();
        addButton.setText("Add");
        addButton.setOnAction(actionEvent -> createNewSong());

        deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(actionEvent -> deleteSelectedSong());

        listView = new ListView<>();
        var songs = songService.queryForSongs();
        observableList = FXCollections.observableList(songs);
        listView.setItems(observableList);

        GridPane gridPane = new GridPane();

        HBox root = new HBox();
        root.getChildren().add(gridPane);
        root.getChildren().add(listView);

        gridPane.addRow(0,labelForSongName,songName);
        gridPane.addRow(1, labelForArtistName, artistName);
        gridPane.addRow(2, addButton, deleteButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void deleteSelectedSong() {
        var song = listView.getSelectionModel().getSelectedItem();
        if( song != null) {
            songService.removeSong(song);
            observableList.clear();
            observableList.addAll(songService.queryForSongs());
        }
    }

    private void createNewSong() {
        //skapa nytt Song objekt med data från textfälten
        Song song = new Song();
        song.setName(songName.getText());
        song.setArtist(artistName.getText());
        //Spara i databasen
        songService.saveSong(song);
        //Uppdatera listView från Databasen
        observableList.clear();
        observableList.addAll(songService.queryForSongs());
    }
}
