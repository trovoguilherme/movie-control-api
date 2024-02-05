package br.com.ovort.controller.filme;

public record FilmeRequest(
        String titulo,
        Double nota,
        String descricao) {
}
