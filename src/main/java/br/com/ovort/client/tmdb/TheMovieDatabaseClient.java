package br.com.ovort.client.tmdb;

import br.com.ovort.client.tmdb.movie.GenreResponse;
import br.com.ovort.client.tmdb.movie.Movie;
import br.com.ovort.client.tmdb.search.movie.SearchMoviePagination;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(url = "${tmdb.url}", name = "tmdb")
@CircuitBreaker(name = "", fallbackMethod = "")
public interface TheMovieDatabaseClient {

    @GetMapping("${tmdb.endpoint.search.movie}")
    Optional<SearchMoviePagination> searchMovie(@RequestParam(name = "query", required = false) String title,
                                                @RequestParam(name = "language", required = false) String language,
                                                @RequestParam(name = "api_key", required = false) String key);

    @GetMapping("${tmdb.endpoint.movie.get-by-id}")
    Optional<Movie> findMovieById(@PathVariable(name = "id") Integer id,
                                  @RequestParam(name = "language", required = false) String language,
                                  @RequestParam(name = "api_key", required = false) String key);

    @GetMapping("${tmdb.endpoint.movie.genre.list}")
    Optional<GenreResponse> findMovieGenres(@RequestParam(name = "language") String language,
                                            @RequestHeader(name = "Authorization") String authorization);

}
