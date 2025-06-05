package com.pos.restaurante.api.controller.dto.endereco;

public record BuscaEnderecoResponseDTO(Long id,
                                       String logradouro,
                                       String complemento,
                                       String unidade,
                                       String bairro,
                                       String localidade,
                                       String uf,
                                       String estado,
                                       String regiao,
                                       Integer numero,
                                       String cep) {
}
