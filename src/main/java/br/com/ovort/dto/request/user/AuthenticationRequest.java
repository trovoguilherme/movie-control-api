package br.com.ovort.dto.request.user;

public record AuthenticationRequest(
        String login,
        String password
) {
}
