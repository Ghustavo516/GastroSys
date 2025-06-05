package com.pos.restaurante.api.service.usuario.buscar;

import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import com.pos.restaurante.api.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

@Service
@Slf4j
public class BuscarUsuarioServiceImpl implements BuscarUsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public BuscarUsuarioServiceImpl(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        enderecoRepository.findById(usuario.getEndereco().getId())
                .ifPresent(usuario::setEndereco);

        return Optional.of(usuario);
    }
}
