package com.pos.restaurante.api.service.endereco.buscaEndereco;

import com.pos.restaurante.api.entity.Endereco;

import java.util.Optional;

public interface BuscaEnderecoService {

    Optional<Endereco> findById(Long id);
}
