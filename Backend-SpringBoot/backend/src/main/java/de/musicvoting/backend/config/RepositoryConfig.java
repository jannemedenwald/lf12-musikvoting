package de.musicvoting.backend.config;

import de.musicvoting.backend.domain.*;
import de.musicvoting.backend.repository.RepositoryInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public RepositoryInMemory<Gast> gastRepository() {
        return new RepositoryInMemory<>();
    }

    @Bean
    public RepositoryInMemory<Song> songRepository() {
        return new RepositoryInMemory<>();
    }

    @Bean
    public RepositoryInMemory<Vote> voteRepository() {
        return new RepositoryInMemory<>();
    }

    @Bean
    public RepositoryInMemory<Playlist> playlistRepository() {
        return new RepositoryInMemory<>();
    }
}
