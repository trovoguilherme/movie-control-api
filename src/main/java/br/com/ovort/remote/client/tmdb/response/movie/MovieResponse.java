package br.com.ovort.remote.client.tmdb.response.movie;

import java.util.List;

public record MovieResponse(
        Boolean adult,
        String backdrop_path,
        BelongsCollectionResponse belongs_to_collection,
        Integer budget,
        List<MovieGenreResponse> genres,
        String homepage,
        Integer id,
        String imdb_id,
        String original_language,
        String original_title,
        String overview,
        Double popularity,
        String poster_path,
        List<ProdutionCompanieResponse> production_companies,
        List<ProdutionCountrieResponse> production_countries,
        String release_date,
        Integer revenue,
        Integer runtime,
        List<SpokenLanguageResponse> spoken_languages,
        String status,
        String tagline,
        String title,
        String video,
        Double vote_average,
        Double vote_count
) {
}
