package com.pos.restaurante.api.service.endereco.excluiEndereco;

import com.pos.restaurante.api.repository.EnderecoRepository;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExcluiEnderecoServiceImpl implements ExcluiEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public ExcluiEnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void delete(Long id) {
        var deleteEndereco = this.enderecoRepository.delete(id);
        if(deleteEndereco == 0){
            throw new ResourceNotFoundException("Endereco não encontrado");
        }
    }
}
