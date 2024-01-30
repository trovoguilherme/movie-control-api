package br.com.ovort.service;

import br.com.ovort.client.tmdb.movie.Movie;
import br.com.ovort.client.tmdb.TheMovieDatabaseClient;
import br.com.ovort.client.tmdb.search.movie.SearchMoviePagination;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final TheMovieDatabaseClient theMovieDatabaseClient;

    public MovieService(TheMovieDatabaseClient theMovieDatabaseClient) {
        this.theMovieDatabaseClient = theMovieDatabaseClient;
    }

    public SearchMoviePagination search(String title) {
        return theMovieDatabaseClient.searchMovie(title, "pt-BR", "ce6047be362c9ee238245147b61f2d66").get();
    }

    public Movie findById(Integer movieId) {
        return theMovieDatabaseClient.findMovieById(movieId, "pt-BR", "ce6047be362c9ee238245147b61f2d66").get();
    }
}
