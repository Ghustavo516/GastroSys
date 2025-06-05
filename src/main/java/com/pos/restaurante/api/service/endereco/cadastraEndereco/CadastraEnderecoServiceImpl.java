package com.pos.restaurante.api.service.endereco.cadastraEndereco;

import com.pos.restaurante.api.repository.EnderecoRepository;
import com.pos.restaurante.api.controller.dto.endereco.CadastraEnderecoRequestDTO;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CadastraEnderecoServiceImpl implements CadastraEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public CadastraEnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void save(CadastraEnderecoRequestDTO form) {
        var mapper = CadastraEnderecoMapper.toEntity(form);

        var endereco = enderecoRepository.save(mapper);
        if (endereco == 0) {
            throw new ResourceNotFoundException("Erro ao cadastrar o endereco");
        }
    }
}
