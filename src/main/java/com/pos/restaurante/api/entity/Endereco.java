package com.pos.restaurante.api.entity;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Endereco {

    private Long id;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private Integer numero;
    private String cep;

    public Endereco(String logradouro, String complemento, String unidade, String bairro, String localidade, String uf, String estado, String regiao, Integer numero, String cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.numero = numero;
        this.cep = cep;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
