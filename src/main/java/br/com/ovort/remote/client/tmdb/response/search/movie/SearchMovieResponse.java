package br.com.ovort.remote.client.tmdb.response.search.movie;

import java.util.List;

public record SearchMovieResponse(
    Boolean adult,
    String backdrop_path,
    List<Integer> genre_ids,
    Integer id,
    String original_language,
    String original_title,
    String overview,
    Double popularity,
    String poster_path,
    String release_date,
    String title,
    Double vote_average,
    Double vote_count
) {
}
