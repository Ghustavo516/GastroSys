package com.pos.restaurante.api.service.usuario.cadastrar;

import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.pos.restaurante.api.controller.dto.usuario.CadastrarUsuarioRequest;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CadastrarUsuarioServiceImpl implements CadastrarUsuarioService {
    
    private UsuarioRepository usuarioRepository;

    public CadastrarUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public void cadastrar(CadastrarUsuarioRequest request) {
        log.info("Cadastrando usuário: {}", request.nome());
        Usuario usuario = CadastrarUsuarioMapper.toEntity(request);
        var usuarioCreate = usuarioRepository.save(usuario);

        if (usuarioCreate == 0) {
            throw new ResourceNotFoundException("Erro ao cadastrar o usuario");
        }
    }
}
