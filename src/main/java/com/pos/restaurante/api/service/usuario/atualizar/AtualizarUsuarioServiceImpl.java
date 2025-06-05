package com.pos.restaurante.api.service.usuario.atualizar;

import com.pos.restaurante.api.controller.handler.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.pos.restaurante.api.controller.dto.usuario.AtualizarUsuarioRequestDTO;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AtualizarUsuarioServiceImpl implements AtualizarUsuarioService {


    private final UsuarioRepository usuarioRepository;

    public AtualizarUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void atualizar(AtualizarUsuarioRequestDTO atualizarUsuarioRequestDTO, Long id) {
        Usuario usuario = AtualizarUsuarioMapper.toEntity(atualizarUsuarioRequestDTO);

        var update = usuarioRepository.update(usuario, id);
        if (update == 0) {
            throw new BusinessException("Erro ao atualizar o usuario " + usuario.getNome());
        }
    }
}
