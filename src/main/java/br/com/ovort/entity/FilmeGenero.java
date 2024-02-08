package br.com.ovort.entity;

import br.com.ovort.entity.Genero.Genero;
import br.com.ovort.entity.filme.Filme;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filme_genero")
public class FilmeGenero {

    @Id
    @Column(name = "id_filme_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public FilmeGenero(Filme filme, Genero genero) {
        this.filme = filme;
        this.genero = genero;
    }

}
