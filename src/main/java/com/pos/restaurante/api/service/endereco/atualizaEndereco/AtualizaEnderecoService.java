package com.pos.restaurante.api.service.endereco.atualizaEndereco;

import com.pos.restaurante.api.controller.dto.endereco.AtualizaEnderecoRequestDTO;

public interface AtualizaEnderecoService {

    void update(AtualizaEnderecoRequestDTO enderecoForm, Long id);
}
