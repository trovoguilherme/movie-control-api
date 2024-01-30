package br.com.ovort.client.tmdb.movie;

public record ProdutionCompanie(
        Integer id,
        String logo_path,
        String name,
        String origin_country
) {
}
