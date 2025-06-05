package com.pos.restaurante.api.service.endereco.buscaEndereco;

import com.pos.restaurante.api.controller.dto.endereco.BuscaEnderecoResponseDTO;
import com.pos.restaurante.api.entity.Endereco;

public class BuscaEnderecoMapper {

    public static BuscaEnderecoResponseDTO toDTO(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        return new BuscaEnderecoResponseDTO(endereco.getId(),
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
