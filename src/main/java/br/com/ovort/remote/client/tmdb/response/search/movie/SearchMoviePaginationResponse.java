package br.com.ovort.remote.client.tmdb.response.search.movie;

import java.util.List;

public record SearchMoviePaginationResponse(
        Integer page,
        List<SearchMovieResponse> results,
        Integer total_pages,
        Integer total_results
) {
}
