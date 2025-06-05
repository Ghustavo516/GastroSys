package com.pos.restaurante.api.service.endereco.atualizaEndereco;

import com.pos.restaurante.api.repository.EnderecoRepository;
import com.pos.restaurante.api.controller.dto.endereco.AtualizaEnderecoRequestDTO;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AtualizaEnderecoServiceImpl implements AtualizaEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public AtualizaEnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void update(AtualizaEnderecoRequestDTO enderecoForm, Long id) {
        var updateMapper = AtualizaEnderecoMapper.toEntity(enderecoForm);
        var update = this.enderecoRepository.update(updateMapper, id);
        if (update == 0) {
            throw new ResourceNotFoundException(
                    "Erro ao atualizar Endereco " + updateMapper.getLogradouro());
        }
    }
}
