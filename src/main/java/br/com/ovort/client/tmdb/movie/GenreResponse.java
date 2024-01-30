package br.com.ovort.client.tmdb.movie;

import java.util.List;

public record GenreResponse(
        List<Genre> genres
) {
}
