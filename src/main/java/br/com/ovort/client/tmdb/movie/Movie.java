package br.com.ovort.client.tmdb.movie;

import java.util.List;

public record Movie(
        Boolean adult,
        String backdrop_path,
        BelongsCollection belongs_to_collection,
        Integer budget,
        List<MovieGenre> genres,
        String homepage,
        Integer id,
        String imdb_id,
        String original_language,
        String original_title,
        String overview,
        Double popularity,
        String poster_path,
        List<ProdutionCompanie> production_companies,
        List<ProdutionCountrie> production_countries,
        String release_date,
        Integer revenue,
        Integer runtime,
        List<SpokenLinguage> spoken_languages,
        String status,
        String tagline,
        String title,
        String video,
        Double vote_average,
        Double vote_count
) {
}
