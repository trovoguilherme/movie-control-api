package br.com.ovort.util;

import lombok.experimental.UtilityClass;

import java.util.List;

import static org.apache.commons.text.similarity.LevenshteinDistance.getDefaultInstance;

@UtilityClass
public class MovieUtils {

    public static String getSimilarTitle(String targetTitle, List<String> titlesFound) {
        int menorDistancia = Integer.MAX_VALUE;
        String titleMaisSimilar = "";

        for (String t : titlesFound) {
            int distancia = getDefaultInstance().apply(targetTitle, t.toLowerCase());

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                titleMaisSimilar = t;
            }
        }

        return titleMaisSimilar;
    }

}
