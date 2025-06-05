package com.pos.restaurante.api.service.usuario.atualizar;

import com.pos.restaurante.api.controller.dto.usuario.AtualizarUsuarioRequestDTO;

public interface AtualizarUsuarioService {

   void atualizar(AtualizarUsuarioRequestDTO request, Long id);

}
