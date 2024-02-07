package br.com.ovort.entity.filme;

import br.com.ovort.entity.user.User;
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
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FILME")
public class Filme {

    @Id
    @Column(name = "ID_FILME")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "TITULO_ORIGINAL")
    private String tituloOriginal;

    @Column(name = "SINOPSE")
    private String sinopse;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "TEMPO")
    private int tempo;

    @Column(name = "BUDGET")
    private Integer budget;

    @Column(name = "NOTA")
    private Double nota;

    @Column(name = "comentario")
    private String comentario;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    public Filme(String titulo, String tituloOriginal, String sinopse, LocalDateTime dataLancamento, int tempo, Integer budget, Double nota, String comentario, User user) {
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
        this.tempo = tempo;
        this.budget = budget;
        this.nota = nota;
        this.comentario = comentario;
        this.user = user;
    }

}
