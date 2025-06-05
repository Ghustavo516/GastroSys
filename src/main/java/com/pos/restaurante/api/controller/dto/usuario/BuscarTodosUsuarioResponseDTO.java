package com.pos.restaurante.api.controller.dto.usuario;

import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.enums.TipoUsuario;

import java.util.Date;

public record BuscarTodosUsuarioResponseDTO(Long id,
                                            String nome,
                                            String email,
                                            String login,
                                            String senha,
                                            Date dataUltimaAlteracao,
                                            Endereco endereco,
                                            TipoUsuario tipo) {
}
