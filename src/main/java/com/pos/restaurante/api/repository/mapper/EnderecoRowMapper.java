package com.pos.restaurante.api.repository.mapper;

import com.pos.restaurante.api.entity.Endereco;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoRowMapper implements RowMapper<Endereco> {

    private EnderecoRowMapper() {}

    private static final EnderecoRowMapper INSTANCE = new EnderecoRowMapper();

    public static EnderecoRowMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getLong("id"));
        endereco.setLogradouro(rs.getString("logradouro"));
        endereco.setComplemento(rs.getString("complemento"));
        endereco.setUnidade(rs.getString("unidade"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setLocalidade(rs.getString("localidade"));
        endereco.setUf(rs.getString("uf"));
        endereco.setEstado(rs.getString("estado"));
        endereco.setRegiao(rs.getString("regiao"));
        endereco.setNumero(rs.getInt("numero"));
        endereco.setCep(rs.getString("cep"));
        return endereco;
    }
}
