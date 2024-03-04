package br.com.ovort.remote.client.tmdb.response.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Genre implements Serializable {

        private Integer id;
        private String name;

}
