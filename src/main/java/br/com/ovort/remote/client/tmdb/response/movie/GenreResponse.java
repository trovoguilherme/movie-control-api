package br.com.ovort.remote.client.tmdb.response.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenreResponse implements Serializable {

        private List<Genre> genres;

}
