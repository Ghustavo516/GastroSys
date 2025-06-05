package com.pos.restaurante.api.repository.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.enums.TipoUsuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository  {

    private final JdbcClient jdbcClient;
    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepositoryImpl(JdbcClient jdbcClient, JdbcTemplate jdbcTemplate) {
        this.jdbcClient = jdbcClient;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        String sql = """
            SELECT id, nome, email, login, senha, data_ultima_alteracao, endereco_id, tipo
            FROM usuario
            WHERE id = ?
        """;

        try {
            Usuario usuario = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setDataUltimaAlteracao(rs.getDate("data_ultima_alteracao"));

                u.setTipo(TipoUsuario.valueOf(rs.getString("tipo")));

                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("endereco_id"));
                u.setEndereco(endereco);

                return u;
            });
            return Optional.of(usuario);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Usuario> findAll(int size, int offset) {
        String sql = """
            SELECT id, nome, email, login, senha, data_ultima_alteracao, endereco_id, tipo
            FROM usuario
            LIMIT ? OFFSET ?
        """;

        return jdbcTemplate.query(sql, new Object[]{size, offset}, (rs, rowNum) -> {
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setDataUltimaAlteracao(rs.getDate("data_ultima_alteracao"));

            u.setTipo(TipoUsuario.valueOf(rs.getString("tipo")));

            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco_id"));
            u.setEndereco(endereco);

            return u;
        });
    }


    @Override
    public Integer save(Usuario usuario) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = this.jdbcClient.sql("""
            INSERT INTO usuario (nome, email, login, senha, data_ultima_alteracao, endereco_id, tipo) 
            VALUES (:nome, :email, :login, :senha, :dataUltimaAlteracao, :enderecoId, :tipo)
        """)
                .param("nome", usuario.getNome())
                .param("email", usuario.getEmail())
                .param("login", usuario.getLogin())
                .param("senha", usuario.getSenha())
                .param("dataUltimaAlteracao", LocalDateTime.now())
                .param("enderecoId", usuario.getEndereco().getId())
                .param("tipo", usuario.getTipo().getName())
                .update(keyHolder);

        if (rowsAffected > 0) {
            usuario.setId(keyHolder.getKey().longValue());
            return 1;
        }
        return 0;
    }

    @Override
    public Integer update(Usuario usuario, Long id) {
        return this.jdbcClient.sql("""
            UPDATE usuario SET 
                nome = :nome, 
                email = :email, 
                login = :login, 
                senha = :senha, 
                data_ultima_alteracao = :dataUltimaAlteracao, 
                endereco_id = :enderecoId, 
                tipo = :tipo
            WHERE id = :id
        """)
                .param("nome", usuario.getNome())
                .param("email", usuario.getEmail())
                .param("login", usuario.getLogin())
                .param("senha", usuario.getSenha())
                .param("dataUltimaAlteracao", LocalDateTime.now())
                .param("enderecoId", usuario.getEndereco() != null ? usuario.getEndereco().getId() : null)
                .param("tipo", usuario.getTipo().getName())
                .param("id", id)
                .update();
    }


    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("DELETE FROM usuario WHERE id = :id")
        .param("id", id)
        .update();
    }

    @Override
    public Integer trocaSenha(Long id, String novaSenha, Date dataAlteracao) {
        return this.jdbcClient.sql("UPDATE usuario SET senha = :senha, data_ultima_alteracao = :dataAlteracao WHERE id = :id")
                .param("senha", novaSenha)
                .param("dataAlteracao", dataAlteracao)
                .param("id", id)
                .update();
    }

    @Override
    public Optional<Usuario> findByLogin(String login) {
        return this.jdbcClient.sql("SELECT * FROM usuario WHERE login = :login")
                .param("login", login)
                .query(Usuario.class)
                .optional();
    }
}
