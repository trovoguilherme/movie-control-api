package br.com.ovort.client.tmdb.search.movie;

import java.util.List;

public record SearchMoviePagination(
        Integer page,
        List<SearchMovie> results,
        Integer total_pages,
        Integer total_results
) {
}
