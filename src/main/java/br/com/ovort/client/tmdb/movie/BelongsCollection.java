package br.com.ovort.client.tmdb.movie;

public record BelongsCollection(
        Integer id,
        String name,
        String poster_path,
        String backdrop_path
) {
}
