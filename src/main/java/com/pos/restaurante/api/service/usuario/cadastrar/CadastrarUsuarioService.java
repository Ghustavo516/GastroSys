package com.pos.restaurante.api.service.usuario.cadastrar;

import com.pos.restaurante.api.controller.dto.usuario.CadastrarUsuarioRequest;

public interface CadastrarUsuarioService {
     
    void cadastrar(CadastrarUsuarioRequest request);
}
