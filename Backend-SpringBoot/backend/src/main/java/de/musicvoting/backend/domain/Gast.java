package de.musicvoting.backend.domain;

import java.util.ArrayList;

public class Gast implements Identifiable {
    private String gastID;
    private String vorname;
    private String nachname;
    private int maxVotes = 5;
    private ArrayList<Vote> votes = new ArrayList<>();

    // Konstruktor
    public Gast(String vorname, String nachname) {
        this.gastID = null;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getID() {
        return gastID;
    }

    public void setID(String id) {     // soll nur vom Repository genutzt werden
        this.gastID = id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Song songVorschlagen(String titel, String band, String genre) {
        return new Song(titel, band, genre);
    }

    public Vote songVoten(Song song) {
        Vote newVote = new Vote(this, song);
        // Vote dem Gast hinzufügen
        votes.add(newVote);
        // Vote dem Song hinzufügen
        song.addVote(newVote);

        while (votes.size() > maxVotes) {
            Vote voteToDelete = votes.get(0);
            // ältesten Vote vom Gast entfernen
            votes.remove(voteToDelete);
            // ältesten Vote auch beim Song entfernen
            voteToDelete.getSong().removeVote(voteToDelete);
        }
        return newVote;
    }

    @Override
    public String toString() {
        return "\nGast{" +
                "gastID='" + gastID + '\'' +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ",\n votes='" + votes + '\'' +
                ",\n abgestimmt='" + votes.size() + '\'' +
                "}\n";
    }
}
