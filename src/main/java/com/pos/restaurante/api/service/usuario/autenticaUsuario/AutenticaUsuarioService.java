package com.pos.restaurante.api.service.usuario.autenticaUsuario;

import com.pos.restaurante.api.controller.dto.LoginRequestDTO;
import com.pos.restaurante.api.controller.dto.LoginResponseDTO;

public interface AutenticaUsuarioService {

    LoginResponseDTO autenticaUsuario(LoginRequestDTO loginRequestDTO);
}
