package br.com.ovort.dto.request.user;

import br.com.ovort.entity.user.UserRole;

public record UserRequest(
        String login,
        String password,
        UserRole role
) {
}
