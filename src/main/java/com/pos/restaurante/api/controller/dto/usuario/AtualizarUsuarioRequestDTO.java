package com.pos.restaurante.api.controller.dto.usuario;

import com.pos.restaurante.api.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;

public record AtualizarUsuarioRequestDTO (@NotBlank String nome,
                                          @NotBlank String email,
                                          @NotBlank String login,
                                          @NotBlank String senha,
                                          Long enderecoId,
                                          TipoUsuario tipo) {
}
