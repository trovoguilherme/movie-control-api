package br.com.ovort.service;

import br.com.ovort.entity.FilmeGenero;
import br.com.ovort.repository.FilmeGeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmeGeneroService {

    private final FilmeGeneroRepository filmeGeneroRepository;
    private final FilmeService filmeService;
    private final GeneroService generoService;

    public FilmeGenero assignFilmeToGenero(String titulo, String genero) {
        var foundGenero = generoService.findByName(genero);
        var foundTitulo = filmeService.findByTitulo(titulo);

        return filmeGeneroRepository.save(new FilmeGenero(foundTitulo, foundGenero));
    }

}
