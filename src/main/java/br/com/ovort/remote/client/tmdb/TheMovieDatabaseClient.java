package br.com.ovort.remote.client.tmdb;

import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.movie.SpokenLanguageResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import static br.com.ovort.remote.RemoteConstants.CB_RETRY_THE_MOVIE_DATABASE_FIND_BY_ID;
import static br.com.ovort.remote.RemoteConstants.CB_RETRY_THE_MOVIE_DATABASE_LIST_GENRES;
import static br.com.ovort.remote.RemoteConstants.CB_RETRY_THE_MOVIE_DATABASE_SEARCH_MOVIE_BY_QUERY;

@FeignClient(url = "${tmdb.url}", name = "tmdb")
public interface TheMovieDatabaseClient {

    @GetMapping("${tmdb.endpoint.search.movie}")
    @Retry(name = CB_RETRY_THE_MOVIE_DATABASE_SEARCH_MOVIE_BY_QUERY)
    @CircuitBreaker(name = CB_RETRY_THE_MOVIE_DATABASE_SEARCH_MOVIE_BY_QUERY)
    Optional<SearchMoviePaginationResponse> searchMovieByName(@RequestParam(name = "query", required = false) String title,
                                                              @RequestParam(name = "language", required = false) String language,
                                                              @RequestHeader(name = "Authorization") String authorization);

    @GetMapping("${tmdb.endpoint.movie.get-by-id}")
    @Retry(name = CB_RETRY_THE_MOVIE_DATABASE_FIND_BY_ID)
    @CircuitBreaker(name = CB_RETRY_THE_MOVIE_DATABASE_FIND_BY_ID)
    Optional<MovieResponse> findMovieById(@PathVariable(name = "id") Integer id,
                                          @RequestParam(name = "language", required = false) String language,
                                          @RequestHeader(name = "Authorization") String authorization);

    @GetMapping("${tmdb.endpoint.movie.genre.list}")
    @Retry(name = CB_RETRY_THE_MOVIE_DATABASE_LIST_GENRES)
    @CircuitBreaker(name = CB_RETRY_THE_MOVIE_DATABASE_LIST_GENRES)
    Optional<GenreResponse> findMovieGenres(@RequestParam(name = "language") String language,
                                            @RequestHeader(name = "Authorization") String authorization);

    @GetMapping("${tmdb.endpoint.languages}")
    @Retry(name = CB_RETRY_THE_MOVIE_DATABASE_LIST_GENRES)
    @CircuitBreaker(name = CB_RETRY_THE_MOVIE_DATABASE_LIST_GENRES)
    List<SpokenLanguageResponse> findAllLanguages(@RequestHeader(name = "Authorization") String authorization);
}
