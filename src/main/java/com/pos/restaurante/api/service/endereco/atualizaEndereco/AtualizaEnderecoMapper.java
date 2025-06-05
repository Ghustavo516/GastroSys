package com.pos.restaurante.api.service.endereco.atualizaEndereco;

import com.pos.restaurante.api.controller.dto.endereco.AtualizaEnderecoRequestDTO;
import com.pos.restaurante.api.entity.Endereco;

public class AtualizaEnderecoMapper {

    public static Endereco toEntity(AtualizaEnderecoRequestDTO enderecoForm) {
        if (enderecoForm == null) {
            return null;
        }

        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoForm.logradouro());
        endereco.setComplemento(enderecoForm.complemento());
        endereco.setUnidade(enderecoForm.unidade());
        endereco.setBairro(enderecoForm.bairro());
        endereco.setLocalidade(enderecoForm.localidade());
        endereco.setUf(enderecoForm.uf());
        endereco.setEstado(enderecoForm.estado());
        endereco.setRegiao(enderecoForm.regiao());
        endereco.setNumero(enderecoForm.numero());
        endereco.setCep(enderecoForm.cep());
        return endereco;
    }
}
