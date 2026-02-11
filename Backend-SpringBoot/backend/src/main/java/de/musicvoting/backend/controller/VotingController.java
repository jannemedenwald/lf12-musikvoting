package de.musicvoting.backend.controller;

import de.musicvoting.backend.domain.*;
import de.musicvoting.backend.dto.*;
import de.musicvoting.backend.service.VotingService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class VotingController {

    private final VotingService service;

    public VotingController(VotingService service) {
        this.service = service;
    }

    @PostMapping("/gast")
    public Gast register(@RequestBody Gast gast) {
        return service.gastRegistrieren(gast.getVorname(), gast.getNachname());
    }

    @PostMapping("/song")
    public Song addSong(@RequestBody SongRequest req) {
        Gast g = service.getGast(req.gastId());
        return service.songSpeichern(g, req.titel(), req.band(), req.genre());
    }

    @PostMapping("/vote")
    public Vote vote(@RequestBody VoteRequest req) {
        Gast g = service.getGast(req.gastId());
        Song s = service.getSong(req.songId());
        return service.songVoten(g, s);
    }

    @GetMapping("/playlist")
    public Playlist playlist() {
        return service.playlistErzeugen();
    }

    @GetMapping("/songs")
    public Collection<Song> allSongs() {
        return service.getAllSongs();
    }

    @GetMapping("/gaeste")
    public Collection<Gast> allGaeste() {
        return service.getAllGaeste();
    }
}
