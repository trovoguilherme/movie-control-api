package br.com.ovort.controller;

import br.com.ovort.client.tmdb.movie.Movie;
import br.com.ovort.client.tmdb.search.movie.SearchMovie;
import br.com.ovort.client.tmdb.search.movie.SearchMoviePagination;
import br.com.ovort.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
//@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{titleName}/name")
    public ResponseEntity<SearchMoviePagination> findByName(@PathVariable(name = "titleName") String titleName) {
        return ResponseEntity.ok(movieService.search(titleName));
    }

    @GetMapping("/{movieId}/id")
    public ResponseEntity<Movie> findById(@PathVariable(name = "movieId") Integer movieId) {


        return ResponseEntity.ok(movieService.findById(movieId));
    }

}
