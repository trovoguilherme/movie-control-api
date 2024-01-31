package br.com.ovort.remote.client.tmdb.response.movie;

public record ProdutionCompanieResponse(
        Integer id,
        String logo_path,
        String name,
        String origin_country
) {
}
