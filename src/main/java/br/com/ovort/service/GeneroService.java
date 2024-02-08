package br.com.ovort.service;

import br.com.ovort.entity.Genero.Genero;
import br.com.ovort.exception.NotFoundException;
import br.com.ovort.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;

    public Genero findByName(String genero) {
        return generoRepository.findByNome(genero).orElseThrow(() -> new NotFoundException("Gênero não encontrado"));
    }

}
