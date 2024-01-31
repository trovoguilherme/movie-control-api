package br.com.ovort.entity;

public record AuthenticationRequest(
        String login,
        String password
) {
}
