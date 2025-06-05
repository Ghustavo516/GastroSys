package com.pos.restaurante.api.service.endereco.cadastraEndereco;

import com.pos.restaurante.api.controller.dto.endereco.CadastraEnderecoRequestDTO;

public interface CadastraEnderecoService {

    void save(CadastraEnderecoRequestDTO form);
}
