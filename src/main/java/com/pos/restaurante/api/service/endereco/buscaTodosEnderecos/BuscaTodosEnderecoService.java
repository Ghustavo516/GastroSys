package com.pos.restaurante.api.service.endereco.buscaTodosEnderecos;

import com.pos.restaurante.api.controller.dto.endereco.BuscaTodosEnderecoResponseDTO;

import java.util.List;

public interface BuscaTodosEnderecoService {

    List<BuscaTodosEnderecoResponseDTO> findAll(int size, int offset);
}
