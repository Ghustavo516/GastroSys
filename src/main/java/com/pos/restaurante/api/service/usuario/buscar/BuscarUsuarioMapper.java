package com.pos.restaurante.api.service.usuario.buscar;

import com.pos.restaurante.api.controller.dto.usuario.BuscarUsuarioResponseDTO;
import com.pos.restaurante.api.entity.Usuario;

public final class BuscarUsuarioMapper {

    public static BuscarUsuarioResponseDTO toDTO(Usuario usuario) {
        return new BuscarUsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getLogin(), usuario.getSenha(), usuario.getDataUltimaAlteracao(), usuario.getEndereco(),
                usuario.getTipo());
    }
}
