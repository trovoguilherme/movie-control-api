package br.com.ovort.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AlreadyExistsException extends RuntimeException {

    private final String message;

}
