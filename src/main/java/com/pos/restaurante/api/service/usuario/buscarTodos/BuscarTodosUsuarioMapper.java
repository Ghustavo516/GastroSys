package com.pos.restaurante.api.service.usuario.buscarTodos;

import java.util.List;

import com.pos.restaurante.api.controller.dto.usuario.BuscarTodosUsuarioResponseDTO;
import com.pos.restaurante.api.entity.Usuario;

public final class BuscarTodosUsuarioMapper {

    public static List<BuscarTodosUsuarioResponseDTO> toDTO(List<Usuario> usuarios) {

        return usuarios.stream()
                .map(usuario -> new BuscarTodosUsuarioResponseDTO(usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getLogin(),
                        usuario.getSenha(),
                        usuario.getDataUltimaAlteracao(),
                        usuario.getEndereco(),
                        usuario.getTipo()))
                .toList();
    }
}
