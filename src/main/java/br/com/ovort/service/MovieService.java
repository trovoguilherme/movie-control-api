package br.com.ovort.service;

import br.com.ovort.exception.SearchMovieNotFoundException;
import br.com.ovort.remote.client.tmdb.MovieServiceClient;
import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.movie.SpokenLanguageResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMovieResponse;
import br.com.ovort.util.MovieUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ovort.util.MovieUtils.getSimilarTitle;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieServiceClient movieServiceClient;

    public SearchMoviePaginationResponse search(String title) throws SearchMovieNotFoundException {

        var moviePaginationResponse = movieServiceClient.searchMovieByName(title).orElseThrow(() -> new SearchMovieNotFoundException("Não encontrei os filmes"));

//        String similar = getSimilarTitle(title, moviePaginationResponse.results().stream().map(SearchMovieResponse::title).toList());

//        System.out.println("aquiiiiii: "+similar);

        return moviePaginationResponse;
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
