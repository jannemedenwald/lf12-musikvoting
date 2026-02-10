package de.musicvoting.backend.service;

import de.musicvoting.backend.domain.Gast;
import de.musicvoting.backend.domain.Playlist;
import de.musicvoting.backend.domain.Song;
import de.musicvoting.backend.domain.Vote;
import de.musicvoting.backend.repository.RepositoryInMemory;

import java.util.ArrayList;

public class Service {
    private final RepositoryInMemory<Gast> gastSpeicher;
    private final RepositoryInMemory<Song> songSpeicher;
    private final RepositoryInMemory<Vote> voteSpeicher;
    private final RepositoryInMemory<Playlist> playlistSpeicher;

    public Service(RepositoryInMemory<Gast> gastSpeicher,
                   RepositoryInMemory<Song> songSpeicher,
                   RepositoryInMemory<Vote> voteSpeicher,
                   RepositoryInMemory<Playlist> playlistSpeicher) {
        this.gastSpeicher = gastSpeicher;
        this.songSpeicher = songSpeicher;
        this.voteSpeicher = voteSpeicher;
        this.playlistSpeicher = playlistSpeicher;
    }

    public Gast gastRegistrieren(String vorname, String nachname) {
        Gast gast = new Gast(vorname, nachname);
        gastSpeicher.save(gast);
        return gast;
    }

    public Song songSpeichern(Gast gast, String titel, String band, String genre) {
        // Schritt 1: Prüfen, ob vorschlagener Gast im System angemeldet wurde
        Gast g = gastSpeicher.findById(gast.getID());
        if (g != null) {
            // falls Gast im System registriert ist -> Schritt 2: Song anlegen
            Song song = g.songVorschlagen(titel, band, genre);
            // Schritt 3: Song speichern
            songSpeicher.save(song);
            return song;
        } else {
            throw new IllegalArgumentException("Gast existiert nicht");
        }
    }

    public Vote songVoten(Gast gast, Song song) {
        // Schritt 1: Prüfen, ob votender Gast im System angemeldet wurde
        Gast g = gastSpeicher.findById(gast.getID());
        if (g == null) {
            throw new IllegalArgumentException("Gast existiert nicht");
        }
        // Schritt 2: Prüfen, ob der Song zum Voten existiert
        Song s = songSpeicher.findById(song.getID());
        if (s == null) {
            throw new IllegalArgumentException("Song existiert nicht");
        }
        // Schritt 3: Vote anlegen
        Vote vote = g.songVoten(s);
        // Schritt 4 Vote speichern
        voteSpeicher.save(vote);
        return vote;
    }

    public Playlist playlistErzeugen() {
        Playlist playlist = new Playlist();
        // alle Songs aus dem Speicher holen
        ArrayList<Song> songs = new ArrayList<>(songSpeicher.findAll());
        // Songs nach Anzahl der Votes sortieren
        songs.sort(playlist);
        // Songs in Playlist einfügen
        for (Song song : songs) {
            playlist.songHinzufuegen(song);
        }
        return playlist;
    }

}
