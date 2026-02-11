package de.musicvoting.backend.dto;

public record SongRequest(
        String gastId,
        String titel,
        String band,
        String genre
) {}

