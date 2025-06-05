package com.pos.restaurante.api.controller.dto.usuario;

import com.pos.restaurante.api.enums.TipoUsuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CadastrarUsuarioRequest (
        @NotNull @NotEmpty String nome,
        @NotNull @NotEmpty String email,
        @NotNull @NotEmpty String login,
        @NotNull @NotEmpty String senha,
        @NotNull Long enderecoId,
        @NotNull TipoUsuario tipo) {
}
