package br.com.ovort.controller.request;

public record AuthenticationRequest(
        String login,
        String password
) {
}
