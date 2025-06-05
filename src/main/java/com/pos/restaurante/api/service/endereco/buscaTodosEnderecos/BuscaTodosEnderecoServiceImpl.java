package com.pos.restaurante.api.service.endereco.buscaTodosEnderecos;

import com.pos.restaurante.api.controller.dto.endereco.BuscaTodosEnderecoResponseDTO;
import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuscaTodosEnderecoServiceImpl implements BuscaTodosEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public BuscaTodosEnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<BuscaTodosEnderecoResponseDTO> findAll(int size, int offset) {
        List<Endereco> enderecos = enderecoRepository.findAll(size, offset);
        return enderecos.stream()
                .map(BuscaTodosEnderecoMapper::findAllToDTO)
                .toList();
    }
}
