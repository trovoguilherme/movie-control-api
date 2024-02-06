package br.com.ovort.service;

import br.com.ovort.configs.security.TokenService;
import br.com.ovort.dto.request.filme.FilmeRequest;
import br.com.ovort.entity.filme.Filme;
import br.com.ovort.entity.user.User;
import br.com.ovort.exception.SearchMovieNotFoundException;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMovieResponse;
import br.com.ovort.repository.FilmeRepository;
import br.com.ovort.repository.UserRepository;
import br.com.ovort.util.MovieUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final UserRepository userRepository;
    private final MovieService movieService;
    private final TokenService tokenService;

    public Filme create(FilmeRequest filmeRequest) throws SearchMovieNotFoundException {
        var moviesfound = movieService.search(filmeRequest.titulo());

        var movie = movieService.findById(MovieUtils.findMovieIdByMostSimilarTitle(filmeRequest.titulo(), moviesfound.results()));

        var user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        return filmeRepository.save(new Filme(movie.title(), filmeRequest.nota(), filmeRequest.descricao(), (User) user));
    }

}
