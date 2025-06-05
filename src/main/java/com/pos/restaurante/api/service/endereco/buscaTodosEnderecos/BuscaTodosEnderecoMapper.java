package com.pos.restaurante.api.service.endereco.buscaTodosEnderecos;

import com.pos.restaurante.api.controller.dto.endereco.BuscaTodosEnderecoResponseDTO;
import com.pos.restaurante.api.entity.Endereco;

public class BuscaTodosEnderecoMapper {

    public static BuscaTodosEnderecoResponseDTO findAllToDTO(Endereco endereco) {
        return new BuscaTodosEnderecoResponseDTO(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getComplemento(),
                endereco.getUnidade(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getUf(),
                endereco.getEstado(),
                endereco.getRegiao(),
                endereco.getNumero(),
                endereco.getCep());
    }
}
