package com.pos.restaurante.api.service.usuario.excluir;

import org.springframework.stereotype.Service;

import com.pos.restaurante.api.controller.handler.exception.BusinessException;
import com.pos.restaurante.api.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExcluirUsuarioServiceImpl implements ExcluirUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public ExcluirUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void excluir(Long id) {
        log.info("Excluindo usuário com id: {}", id);

        if (id == null) {
            throw new IllegalArgumentException("O id não pode ser nulo");
        }

        var delete = usuarioRepository.delete(id);
        if (delete == 0) {
            throw new BusinessException("Usuário não encontrado");
        }
    }
    
}
