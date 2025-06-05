package com.pos.restaurante.api.service.usuario.trocarSenhaUsuario;

import com.pos.restaurante.api.controller.dto.usuario.TrocarSenhaUsuarioRequestDTO;
import com.pos.restaurante.api.controller.handler.exception.BusinessException;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TrocarSenhaUsuarioServiceImpl implements TrocaSenhaUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public TrocarSenhaUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void trocaSenhaUsuario(TrocarSenhaUsuarioRequestDTO requestDTO, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if(!requestDTO.senhaAtual().equals(usuario.getSenha())) {
            throw new IllegalArgumentException("Senha atual incorreta. Tente novamente!");
        }

        var trocaSenha = usuarioRepository.trocaSenha(idUsuario, requestDTO.novaSenha(), new Date());
        if(trocaSenha == 0) {
            throw new BusinessException("Ocorreu um erro ao trocar a senha do usuario: " + usuario.getNome());
        }
    }
}
