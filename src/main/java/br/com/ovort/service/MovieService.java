package br.com.ovort.service;

import br.com.ovort.exception.NotFoundException;
import br.com.ovort.remote.client.tmdb.MovieServiceClient;
import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.movie.SpokenLanguageResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieServiceClient movieServiceClient;

    public SearchMoviePaginationResponse search(String title) throws NotFoundException {
        return movieServiceClient.searchMovieByName(title).orElseThrow(() -> new NotFoundException("Filme não encontrado"));
    }

    public MovieResponse findById(Integer movieId) {
        return movieServiceClient.findMovieById(movieId).get();
    }

    public GenreResponse findMovieGenres(String language) {
        return movieServiceClient.findMovieGenres().get();
    }

    public List<SpokenLanguageResponse> findAllLanguages() {
        return movieServiceClient.findAllLanguages();
    }

}
