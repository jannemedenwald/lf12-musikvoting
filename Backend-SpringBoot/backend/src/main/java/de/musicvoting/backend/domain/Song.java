package de.musicvoting.backend.domain;

import java.util.ArrayList;

public class Song implements Identifiable {
    private String songID;
    private String titel;
    private String band;
    private String genre;
    private ArrayList<Vote> votes = new ArrayList<>();

    public Song(String titel, String band, String genre) {
        this.songID = null;
        this.titel = titel;
        this.band = band;
        this.genre = genre;
    }

    public String getID() {
        return songID;
    }

    public void setID(String id) {     // soll nur vom Repository genutzt werden
        this.songID = id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBand() {
        return band;
    }

    public String getGenre() {
        return genre;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public int countVotes() {
        return votes.size();
    }

    public int getVoteCount() {
        return votes.size();
    }


    public void removeVote(Vote vote) {
        votes.remove(vote);
    }

    @Override
    public String toString() {
        return "\nSong{" +
                "songID='" + songID + '\'' +
                ", titel='" + titel + '\'' +
                ", band='" + band + '\'' +
                ", genre='" + genre + '\'' +
                ",\n votes='" + votes + '\'' +
                ",\n Anzahl='" + countVotes() + '\'' +
                "}\n";
    }
}
