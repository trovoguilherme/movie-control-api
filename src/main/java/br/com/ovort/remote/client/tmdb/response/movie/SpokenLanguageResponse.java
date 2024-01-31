package br.com.ovort.remote.client.tmdb.response.movie;

public record SpokenLanguageResponse(
        String english_name,
        String iso_639_1,
        String name
) {
}
