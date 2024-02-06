package br.com.ovort.util;

import br.com.ovort.exception.NotFoundException;
import br.com.ovort.remote.client.tmdb.response.search.movie.SearchMovieResponse;
import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;

import static org.apache.commons.text.similarity.LevenshteinDistance.getDefaultInstance;

@UtilityClass
public class MovieUtils {

    public static Integer findMovieIdByMostSimilarTitle(String targetTitle, List<SearchMovieResponse> titlesFound) {
        return titlesFound.stream()
                .min(Comparator.comparingInt(m -> getDefaultInstance().apply(targetTitle, m.title().toLowerCase())))
                .orElseThrow(() -> new NotFoundException("Título similar não encontrado")).id();
    }

}
