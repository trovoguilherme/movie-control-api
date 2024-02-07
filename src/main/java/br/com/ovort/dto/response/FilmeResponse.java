package br.com.ovort.dto.response;

import br.com.ovort.entity.filme.Filme;

public record FilmeResponse(
        Integer id,
        String titulo,
        Double nota,
        String descricao
) {

    public static FilmeResponse from(Filme filme) {
        return new FilmeResponse(filme.getId(), filme.getTitulo(), filme.getNota(), filme.getDescricao());
    }

}
