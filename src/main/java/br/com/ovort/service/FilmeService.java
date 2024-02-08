package br.com.ovort.service;

import br.com.ovort.dto.request.filme.FilmeRequest;
import br.com.ovort.entity.FilmeGenero;
import br.com.ovort.entity.Genero.Genero;
import br.com.ovort.entity.filme.Filme;
import br.com.ovort.entity.user.User;
import br.com.ovort.exception.AlreadyExistsException;
import br.com.ovort.exception.NotFoundException;
import br.com.ovort.repository.FilmeGeneroRepository;
import br.com.ovort.repository.FilmeRepository;
import br.com.ovort.util.MovieUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final FilmeGeneroRepository filmeGeneroRepository;
    private final MovieService movieService;
    private final GeneroService generoService;

    @Transactional
    public Filme create(FilmeRequest filmeRequest) throws NotFoundException {
        var moviesfound = movieService.search(filmeRequest.titulo());
        var movie = movieService.findById(MovieUtils.findMovieIdByMostSimilarTitle(filmeRequest.titulo(), moviesfound.results()));

        if (filmeRepository.existsByTitulo(movie.title())) {
            throw new AlreadyExistsException("Filme já cadastrado");
        }

        var filmeGeneros = new ArrayList<FilmeGenero>();
        movie.genres().forEach(mg -> filmeGeneros.add(new FilmeGenero(new Filme(movie.title()), new Genero(mg.id(), mg.name()))));

        var filmeSave = filmeRepository.save(new Filme(movie.title(), movie.original_title(), movie.overview(), LocalDateTime.parse(movie.release_date() + "T00:00:00"), movie.runtime(), movie.budget(), filmeRequest.nota(), filmeRequest.comentario(), findActualUser(), filmeGeneros));

        for (FilmeGenero g : filmeGeneros) {
            g.setFilme(filmeSave);
        }
        filmeGeneroRepository.saveAll(filmeGeneros);

        return filmeSave;
    }

    public List<Filme> findAll() {
        return filmeRepository.findAllByUser(findActualUser());
    }

    public Filme findByTitulo(String titulo) {
        return filmeRepository.findByTitulo(titulo).orElseThrow(() -> new NotFoundException("Titulo não encontrado"));
    }

    private User findActualUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
