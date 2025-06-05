package com.pos.restaurante.api.controller.dto.usuario;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TrocarSenhaUsuarioRequestDTO(@NotNull @NotEmpty String senhaAtual,
                                           @NotNull @NotEmpty String novaSenha) {
}
