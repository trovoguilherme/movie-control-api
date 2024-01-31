package br.com.ovort.remote.client.tmdb;

import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;

import java.util.Optional;

public interface MovieService {

    Optional<SearchMoviePaginationResponse> searchMovieByName(String title);

    Optional<MovieResponse> findMovieById(Integer id);

}
