package br.com.ovort.remote.client.tmdb.response.movie;

public record BelongsCollectionResponse(
        Integer id,
        String name,
        String poster_path,
        String backdrop_path
) {
}
