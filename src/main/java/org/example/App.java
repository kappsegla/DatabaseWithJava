package org.example;

import org.example.entity.Song;

public class App {
    public static void main(String[] args) {

        SongService songService = new SongService();

        Song song = new Song();
        song.setName("Ring ring");
        song.setArtist("Abba");

        var songs = songService.queryForSongs();
        songs.forEach(System.out::println);

        var songById = songService.getSongById(2L);
        System.out.println(songById);

        songById.setName("Ring Ring");
        songService.updateSong(songById);

        //songService.removeSong(songById);

        SongService.factory.close();
    }
}
