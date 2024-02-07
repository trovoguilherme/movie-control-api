package br.com.ovort.repository;

import br.com.ovort.entity.filme.Filme;
import br.com.ovort.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findAllByUser(User user);

}
