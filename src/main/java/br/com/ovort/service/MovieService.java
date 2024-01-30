package br.com.ovort.service;

import br.com.ovort.client.tmdb.movie.GenreResponse;
import br.com.ovort.client.tmdb.movie.Movie;
import br.com.ovort.client.tmdb.TheMovieDatabaseClient;
import br.com.ovort.client.tmdb.search.movie.SearchMoviePagination;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final TheMovieDatabaseClient theMovieDatabaseClient;

    @Value("${tmdb.language}")
    private String defaultLanguage;

    @Value("${tmdb.api-key}")
    private String key;

    @Value("${tmdb.token}")
    private String token;

    public MovieService(TheMovieDatabaseClient theMovieDatabaseClient) {
        this.theMovieDatabaseClient = theMovieDatabaseClient;
    }

    public SearchMoviePagination search(String title) {
        return theMovieDatabaseClient.searchMovie(title, "pt-BR", "ce6047be362c9ee238245147b61f2d66").get();
    }

    public Movie findById(Integer movieId) {
        return theMovieDatabaseClient.findMovieById(movieId, "pt-BR", "ce6047be362c9ee238245147b61f2d66").get();
    }

    public GenreResponse findMovieGenres(String language) {
        if (language == null || language.isBlank()) {
            language = defaultLanguage;
        }
        return theMovieDatabaseClient.findMovieGenres(language, token).get();
    }
}
