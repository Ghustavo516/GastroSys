package com.pos.restaurante.api.controller.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizaEnderecoRequestDTO(@NotBlank @NotNull String logradouro,
                                         @NotBlank @NotNull String complemento,
                                         @NotBlank @NotNull String unidade,
                                         @NotBlank @NotNull String bairro,
                                         @NotBlank @NotNull String localidade,
                                         @NotBlank @NotNull String uf,
                                         @NotBlank @NotNull String estado,
                                         @NotBlank @NotNull String regiao,
                                         @NotNull @NotNull Integer numero,
                                         @NotBlank @NotNull String cep) {
}
