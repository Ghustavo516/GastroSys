package com.pos.restaurante.api.service.usuario.buscar;

import com.pos.restaurante.api.entity.Usuario;
import java.util.Optional;

public interface BuscarUsuarioService {

    Optional<Usuario> findById(Long id);
}
