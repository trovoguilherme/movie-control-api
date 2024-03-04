package br.com.ovort.controller;

import br.com.ovort.dto.request.movie.GenreRequest;
import br.com.ovort.exception.NotFoundException;
import br.com.ovort.remote.client.tmdb.response.movie.GenreResponse;
import br.com.ovort.remote.client.tmdb.response.movie.MovieResponse;
import br.com.ovort.remote.client.tmdb.response.movie.SpokenLanguageResponse;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMoviePaginationResponse;
import br.com.ovort.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{titleName}/name")
    public ResponseEntity<SearchMoviePaginationResponse> findByName(@PathVariable(name = "titleName") String titleName) throws NotFoundException {
        return ResponseEntity.ok(movieService.search(titleName));
    }

    @GetMapping("/{movieId}/id")
    public ResponseEntity<MovieResponse> findById(@PathVariable(name = "movieId") Integer movieId) {
        return ResponseEntity.ok(movieService.findById(movieId));
    }

    @GetMapping("/genres")
    public ResponseEntity<GenreResponse> findMovieGenre(@RequestParam(name = "language", required = false) GenreRequest language) {
        return ResponseEntity.ok(movieService.findMovieGenres(language.name()));
    }

    @GetMapping("/languages")
    public ResponseEntity<List<SpokenLanguageResponse>> findAllLanguages() {
        return ResponseEntity.ok(movieService.findAllLanguages());
    }

}
