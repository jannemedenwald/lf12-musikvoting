package de.musicvoting.backend.domain;

import java.util.ArrayList;
import java.util.Comparator;

public class Playlist implements Identifiable, Comparator<Song> {
    private String playlistID;
    private ArrayList<Song> songs = new ArrayList<>();

    public String getID() {
        return playlistID;
    }

    public void setID(String id) {     // soll nur vom Repository genutzt werden
        this.playlistID = id;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void songHinzufuegen(Song song) {
        songs.add(song);
    }

    public void songEntfernen(Song song) {
        songs.remove(song);
    }

    public void playlistLeeren() {
        songs.clear();
    }

    public void playlistAusgeben() {
        for (Song s : this.getSongs())
        { System.out.println( "Titel: " + s.getTitel() +
                ", Band: " + s.getBand() +
                ", Genre: " + s.getGenre() +
                ", Votes: " + s.countVotes() );
        }
    }

    public int compare(Song s1, Song s2) {
        return Integer.compare(s2.countVotes(), s1.countVotes());
    }

}
