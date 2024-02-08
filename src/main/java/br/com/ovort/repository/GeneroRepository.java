package br.com.ovort.repository;

import br.com.ovort.entity.Genero.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Optional<Genero> findByNome(String nome);

}
