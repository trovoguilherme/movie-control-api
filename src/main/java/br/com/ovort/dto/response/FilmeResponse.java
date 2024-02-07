package br.com.ovort.dto.response;

import br.com.ovort.entity.filme.Filme;

import java.time.LocalDateTime;

public record FilmeResponse(
        Integer id,
        String titulo,
        String tituloOriginal,
        String sinopse,
        LocalDateTime dataLancamento,
        int tempo,
        Integer budget,
        Double nota,
        String comentario
) {

    public static FilmeResponse from(Filme filme) {
        return new FilmeResponse(
                filme.getId(),
                filme.getTitulo(),
                filme.getTituloOriginal(),
                filme.getSinopse(),
                filme.getDataLancamento(),
                filme.getTempo(),
                filme.getBudget(),
                filme.getNota(),
                filme.getComentario());
    }

}
