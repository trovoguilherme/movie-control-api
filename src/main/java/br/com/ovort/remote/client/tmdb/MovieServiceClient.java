package br.com.ovort.remote.client.tmdb;

import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.movie.SpokenLanguageResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieServiceClient implements MovieService {

    private final TheMovieDatabaseClient theMovieDatabaseClient;

    @Value("${tmdb.language}")
    private String defaultLanguage;

    @Value("${tmdb.api-key}")
    private String key;

    @Value("${tmdb.token}")
    private String token;

    @Override
    public Optional<SearchMoviePaginationResponse> searchMovieByName(String title) {
        return theMovieDatabaseClient.searchMovieByName(title, defaultLanguage, token);
    }

    @Override
    public Optional<MovieResponse> findMovieById(Integer id) {
        return theMovieDatabaseClient.findMovieById(id, defaultLanguage, token);
    }

    public Optional<GenreResponse> findMovieGenres() {
        return theMovieDatabaseClient.findMovieGenres(defaultLanguage, token);
    }

    public List<SpokenLanguageResponse> findAllLanguages() {
        return theMovieDatabaseClient.findAllLanguages(token);
    }
}
