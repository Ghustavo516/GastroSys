package com.pos.restaurante.api.repository;

import com.pos.restaurante.api.entity.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository {

    Optional<Endereco> findById(Long id);

    List<Endereco> findAll(int size, int offset);

    Integer save(Endereco endereco);

    Integer update(Endereco endereco, Long id);

    Integer delete(Long id);
}
