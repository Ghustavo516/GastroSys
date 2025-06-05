package com.pos.restaurante.api.service.usuario.autenticaUsuario;

import com.pos.restaurante.api.controller.dto.LoginRequestDTO;
import com.pos.restaurante.api.controller.dto.LoginResponseDTO;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AutenticaUsuarioServiceImpl implements AutenticaUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public AutenticaUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public LoginResponseDTO autenticaUsuario(LoginRequestDTO loginRequestDTO) {
        Usuario usuario = this.usuarioRepository.findByLogin(loginRequestDTO.login())
                .orElseThrow(() -> new ResourceNotFoundException("Login inváilido"));

        if(usuario.getSenha().equals(loginRequestDTO.password())){
            return new LoginResponseDTO(true, "Login realizado com sucesso");
        }else{
            return new LoginResponseDTO(false, "Senha incorreta");
        }
    }
}
