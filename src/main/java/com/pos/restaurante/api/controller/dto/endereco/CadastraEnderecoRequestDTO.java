package com.pos.restaurante.api.controller.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastraEnderecoRequestDTO(@NotBlank String logradouro,
                                         @NotBlank String complemento,
                                         @NotBlank String unidade,
                                         @NotBlank String bairro,
                                         @NotBlank String localidade,
                                         @NotBlank String uf,
                                         @NotBlank String estado,
                                         @NotBlank String regiao,
                                         @NotNull Integer numero,
                                         @NotBlank String cep) {
}
