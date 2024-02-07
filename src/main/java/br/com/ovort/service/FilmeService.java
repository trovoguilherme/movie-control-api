package br.com.ovort.service;

import br.com.ovort.dto.request.filme.FilmeRequest;
import br.com.ovort.entity.filme.Filme;
import br.com.ovort.entity.user.User;
import br.com.ovort.exception.SearchMovieNotFoundException;
import br.com.ovort.repository.FilmeRepository;
import br.com.ovort.repository.UserRepository;
import br.com.ovort.util.MovieUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final UserRepository userRepository;
    private final MovieService movieService;

    public Filme create(FilmeRequest filmeRequest) throws SearchMovieNotFoundException {
        var moviesfound = movieService.search(filmeRequest.titulo());

        var movie = movieService.findById(MovieUtils.findMovieIdByMostSimilarTitle(filmeRequest.titulo(), moviesfound.results()));

        var user = findActualUser();

        return filmeRepository.save(new Filme(movie.title(), movie.original_title(), movie.overview(), LocalDateTime.parse(movie.release_date() + "T00:00:00"), movie.runtime(), movie.budget(), filmeRequest.nota(), filmeRequest.comentario(), user));
    }

    public List<Filme> findAll() {
        return filmeRepository.findAllByUser(findActualUser());
    }

    private User findActualUser() {
        return (User) userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
