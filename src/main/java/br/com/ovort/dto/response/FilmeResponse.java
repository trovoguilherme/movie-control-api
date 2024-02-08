package br.com.ovort.dto.response;

import br.com.ovort.entity.filme.Filme;

import java.time.LocalDateTime;
import java.util.List;

public record FilmeResponse(
        Integer id,
        String titulo,
        List<GeneroResponse> generos,
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
                filme.getFilmeGenero().stream().map(g -> new GeneroResponse(g.getGenero().getNome())).toList(),
                filme.getTituloOriginal(),
                filme.getSinopse(),
                filme.getDataLancamento(),
                filme.getTempo(),
                filme.getBudget(),
                filme.getNota(),
                filme.getComentario());
    }

}
