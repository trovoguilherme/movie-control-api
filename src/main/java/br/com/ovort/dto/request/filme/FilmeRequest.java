package br.com.ovort.dto.request.filme;

public record FilmeRequest(
        String titulo,
        Double nota,
        String descricao) {
}
