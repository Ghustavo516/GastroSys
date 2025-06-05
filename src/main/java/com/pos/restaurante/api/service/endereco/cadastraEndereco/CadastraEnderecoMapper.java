package com.pos.restaurante.api.service.endereco.cadastraEndereco;

import com.pos.restaurante.api.controller.dto.endereco.CadastraEnderecoRequestDTO;
import com.pos.restaurante.api.entity.Endereco;

public class CadastraEnderecoMapper {

    public static Endereco toEntity(CadastraEnderecoRequestDTO form) {
        if (form == null) {
            return null;
        }
        return new Endereco(form.logradouro(),
                form.complemento(),
                form.unidade(),
                form.bairro(),
                form.localidade(),
                form.uf(),
                form.estado(),
                form.regiao(),
                form.numero(),
                form.cep());
    }
}
