package com.pos.restaurante.api.service.usuario.atualizar;

import com.pos.restaurante.api.controller.dto.usuario.AtualizarUsuarioRequestDTO;
import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.entity.Usuario;

import java.util.Date;

public class AtualizarUsuarioMapper {

    public static Usuario toEntity(AtualizarUsuarioRequestDTO update) {
        Usuario usuario = new Usuario();
        usuario.setNome(update.nome());
        usuario.setEmail(update.email());
        usuario.setLogin(update.login());
        usuario.setSenha(update.senha());
        usuario.setDataUltimaAlteracao(new Date());
        usuario.setEndereco(new Endereco());
        usuario.getEndereco().setId(update.enderecoId());
        usuario.setTipo(update.tipo());
        return usuario;
    }

    public static AtualizarUsuarioRequestDTO toDTO(Usuario usuario) {
        var request = new AtualizarUsuarioRequestDTO(usuario.getNome(),
                usuario.getEmail(), usuario.getLogin(), usuario.getSenha(), usuario.getEndereco().getId(), usuario.getTipo());
        return request;
    }
}
