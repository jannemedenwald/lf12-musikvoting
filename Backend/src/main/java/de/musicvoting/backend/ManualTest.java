package de.musicvoting.backend;

import de.musicvoting.backend.domain.Gast;
import de.musicvoting.backend.domain.Song;
import de.musicvoting.backend.domain.Vote;
import de.musicvoting.backend.domain.Playlist;
import de.musicvoting.backend.repository.RepositoryInMemory;
import de.musicvoting.backend.service.Service;

public class ManualTest {
    public static void main(String[] args) {

        RepositoryInMemory<Gast> gastSpeicher = new RepositoryInMemory<>();
        RepositoryInMemory<Song> songSpeicher = new RepositoryInMemory<>();
        RepositoryInMemory<Vote> voteSpeicher = new RepositoryInMemory<>();
        RepositoryInMemory<Playlist> playlistSpeicher = new RepositoryInMemory<>();

        Service speicher = new Service(gastSpeicher, songSpeicher, voteSpeicher, playlistSpeicher);

        Gast g1 = speicher.gastRegistrieren("Mickey", "Mouse");
        Song s1 = speicher.songSpeichern(g1, "Yellow Submarine", "Beatles", "Pop");
        Song s2 = speicher.songSpeichern(g1, "Imagine", "John Lennon", "Pop");

        Gast g2 = speicher.gastRegistrieren("Donald", "Duck");
        Song s3 = speicher.songSpeichern(g2, "Anton aus Tirol", "DJ Ötzi", "Schlager");

        Gast g3 = speicher.gastRegistrieren("Daniel", "Düsentrieb");

        speicher.songVoten(g3, s1);
        verzoegern(10);
        speicher.songVoten(g2, s3);
        verzoegern(10);
        speicher.songVoten(g2, s1);
        verzoegern(10);
        speicher.songVoten(g2, s3);
        verzoegern(10);
        speicher.songVoten(g2, s2);
        verzoegern(10);
        speicher.songVoten(g2, s2);
        verzoegern(10);
        speicher.songVoten(g2, s3);
        verzoegern(10);
        speicher.songVoten(g2, s2);
        verzoegern(10);
        speicher.songVoten(g2, s2);
        verzoegern(10);
        speicher.songVoten(g3, s1);
        verzoegern(10);
        speicher.songVoten(g3, s1);
        verzoegern(10);
        speicher.songVoten(g3, s1);
        verzoegern(10);
        speicher.songVoten(g1, s1);
        verzoegern(10);
        speicher.songVoten(g2, s1);
        verzoegern(10);
        speicher.songVoten(g2, s3);
        verzoegern(10);
        speicher.songVoten(g1, s3);

        System.out.println(gastSpeicher.findAll());
        System.out.println(" ");
        System.out.println(songSpeicher.findAll());
        System.out.println(" ");
        System.out.println(voteSpeicher.findAll());

        System.out.println(" ");
        speicher.playlistErzeugen().playlistAusgeben();
        //speicher.playlistAusgeben(pl);
    }

    public static void verzoegern(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
