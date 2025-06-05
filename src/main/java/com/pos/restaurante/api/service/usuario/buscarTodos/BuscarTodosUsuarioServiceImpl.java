package com.pos.restaurante.api.service.usuario.buscarTodos;

import java.util.List;

import com.pos.restaurante.api.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import com.pos.restaurante.api.controller.dto.usuario.BuscarTodosUsuarioResponseDTO;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BuscarTodosUsuarioServiceImpl implements BuscarTodosUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public BuscarTodosUsuarioServiceImpl(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<BuscarTodosUsuarioResponseDTO> buscarTodos(int page, int size) {
        log.info("Buscando todos os usuários com page: {} e size: {}", page, size);

        if (size <= 0) {
            throw new IllegalArgumentException("O tamanho deve ser maior que zero");
        }

        int offset = (page - 1) * size;

        if (offset < 0) {
            throw new IllegalArgumentException("O offset não pode ser menor que zero");
        }

        List<Usuario> usuarios = usuarioRepository.findAll(size, offset);

        for (Usuario usuario : usuarios) {
            Long enderecoId = usuario.getEndereco() != null ? usuario.getEndereco().getId() : null;

            if (enderecoId != null) {
                enderecoRepository.findById(enderecoId).ifPresent(usuario::setEndereco);
            }
        }
        return BuscarTodosUsuarioMapper.toDTO(usuarios);
    }
}
