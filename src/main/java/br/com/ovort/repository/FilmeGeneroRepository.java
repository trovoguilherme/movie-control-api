package br.com.ovort.repository;

import br.com.ovort.entity.FilmeGenero;
import br.com.ovort.entity.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeGeneroRepository extends JpaRepository<FilmeGenero, Integer> {
    void deleteByFilme(Filme filme);

}
