package com.pos.restaurante.api.service.usuario.trocarSenhaUsuario;

import com.pos.restaurante.api.controller.dto.usuario.TrocarSenhaUsuarioRequestDTO;


public interface TrocaSenhaUsuarioService {

    void trocaSenhaUsuario(TrocarSenhaUsuarioRequestDTO requestDTO, Long idUsuario);
}
