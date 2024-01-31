package br.com.ovort.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SearchMovieNotFoundException extends Exception {

    private final String message;

}
