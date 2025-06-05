package com.pos.restaurante.api.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pos.restaurante.api.entity.Usuario;

public interface UsuarioRepository {
    
    Optional<Usuario> findById(Long id); 

    List<Usuario> findAll(int offset, int size);

    Integer save(Usuario usuario);

    Integer update(Usuario usuario, Long id);

    Integer delete(Long id);

    Integer trocaSenha(Long id, String novaSenha, Date dataAlteracao);

    Optional<Usuario> findByLogin(String login);
}
