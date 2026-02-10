package de.musicvoting.backend.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vote implements Identifiable {
    private String voteID;
    //private ArrayList<Gast> gaeste = new ArrayList<>();
    private Gast gast;
    //private ArrayList<Song> songs = new ArrayList<>();
    private Song song;
    private LocalDateTime zeitstempel;

    public Vote(Gast gast, Song song) {
        this.voteID = null;
        this.gast = gast;
        this.song = song;
        this.zeitstempel = LocalDateTime.now();
    }

    public String getID() {
        return voteID;
    }

    public void setID(String id) {     // soll nur vom Repository genutzt werden
        this.voteID = id;
    }

    public Song getSong() { return this.song; }

    public LocalDateTime getZeitstempel() {
        return zeitstempel;
    }

    @Override
    public String toString() {
        return "\nVote{" +
                "voteID='" + voteID + '\'' +
                ", gastID='" + gast.getID() + '\'' +
                ", Name='" + gast.getName() + '\'' +
                ", songID='" + song.getID() + '\'' +
                ", zeitstempel=" + zeitstempel +
                '}';
    }
}
