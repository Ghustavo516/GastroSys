package com.pos.restaurante.api.repository.impl;

import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.repository.EnderecoRepository;
import com.pos.restaurante.api.repository.mapper.EnderecoRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    private final JdbcClient jdbcClient;

    public EnderecoRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Endereco> findById(Long id) {
        return this.jdbcClient.sql("SELECT * FROM endereco WHERE ID = :id")
                .param("id", id)
                .query(EnderecoRowMapper.getInstance())
                .optional();
    }

    @Override
    public List<Endereco> findAll(int size, int offset) {
        return this.jdbcClient.sql("SELECT * FROM endereco LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(EnderecoRowMapper.getInstance())
                .list();
    }

    @Override
    public Integer save(Endereco endereco) {
        return this.jdbcClient.sql("INSERT INTO endereco (logradouro, complemento, unidade, bairro, localidade, uf, estado, regiao, numero, cep) " +
                        "VALUES(:logradouro, :complemento, :unidade, :bairro, :localidade, :uf, :estado, :regiao, :numero, :cep)")
                .param("logradouro", endereco.getLogradouro())
                .param("complemento", endereco.getComplemento())
                .param("unidade", endereco.getUnidade())
                .param("bairro", endereco.getBairro())
                .param("localidade", endereco.getLocalidade())
                .param("uf", endereco.getUf())
                .param("estado", endereco.getEstado())
                .param("regiao", endereco.getRegiao())
                .param("numero", endereco.getNumero())
                .param("cep", endereco.getCep())
                .update();
    }

    @Override
    public Integer update(Endereco endereco, Long id) {
        return this.jdbcClient.sql("UPDATE endereco SET logradouro = :logradouro, complemento = :complemento," +
                        " unidade = :unidade, bairro = :bairro, localidade = :localidade, uf = :uf, estado = :estado," +
                        " regiao = :regiao, numero = :numero, cep = :cep  WHERE id = :id")
                .param("logradouro", endereco.getLogradouro())
                .param("complemento", endereco.getComplemento())
                .param("unidade", endereco.getUnidade())
                .param("bairro", endereco.getBairro())
                .param("localidade", endereco.getLocalidade())
                .param("uf", endereco.getUf())
                .param("estado", endereco.getEstado())
                .param("regiao", endereco.getRegiao())
                .param("numero", endereco.getNumero())
                .param("cep", endereco.getCep())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("DELETE FROM endereco WHERE ID = :id")
                .param("id", id)
                .update();
    }
}
