package br.com.ovort.remote.client.tmdb.response.movie;

import java.util.List;

public record GenreResponse(
        List<Genre> genres
) {
}
