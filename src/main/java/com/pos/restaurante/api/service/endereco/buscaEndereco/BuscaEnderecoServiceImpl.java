package com.pos.restaurante.api.service.endereco.buscaEndereco;

import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.repository.EnderecoRepository;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaEnderecoServiceImpl implements BuscaEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public BuscaEnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Optional<Endereco> findById(Long id) {
        return Optional.ofNullable(enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado")));
    }
}
