package br.com.ovort.controller.request;

import br.com.ovort.entity.user.UserRole;

public record UserRequest(
        String login,
        String password,
        UserRole role
) {
}
