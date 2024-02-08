package br.com.ovort.repository;

import br.com.ovort.entity.FilmeGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeGeneroRepository extends JpaRepository<FilmeGenero, Integer> {
}
