package de.musicvoting.backend.dto;

public record VoteRequest(
        String gastId,
        String songId
) {}
