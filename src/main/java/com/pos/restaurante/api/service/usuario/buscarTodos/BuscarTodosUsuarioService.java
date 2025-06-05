package com.pos.restaurante.api.service.usuario.buscarTodos;

import java.util.List;

import com.pos.restaurante.api.controller.dto.usuario.BuscarTodosUsuarioResponseDTO;

public interface BuscarTodosUsuarioService {

    List<BuscarTodosUsuarioResponseDTO> buscarTodos(int page, int size);

}
