package com.pos.restaurante.api.service.usuario.cadastrar;

import com.pos.restaurante.api.controller.dto.usuario.CadastrarUsuarioRequest;
import com.pos.restaurante.api.controller.dto.usuario.CadastroUsuarioResponseDTO;
import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.entity.Usuario;

import java.util.Date;

public final class CadastrarUsuarioMapper {

    private CadastrarUsuarioMapper() {
    }

    public static CadastroUsuarioResponseDTO toResponseDTO(Usuario usuario) {
        CadastroUsuarioResponseDTO response = new CadastroUsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getDataUltimaAlteracao(),
                usuario.getEndereco(),
                usuario.getTipo());
        return response;
    }

    public static Usuario toEntity(CadastrarUsuarioRequest request) {
       Usuario usuario = new Usuario();
       usuario.setNome(request.nome());
       usuario.setEmail(request.email());
       usuario.setLogin(request.login());
       usuario.setSenha(request.senha());
       usuario.setEndereco(new Endereco());
       usuario.getEndereco().setId(request.enderecoId());
       usuario.setDataUltimaAlteracao(new Date());
       usuario.setTipo(request.tipo());
       return usuario;
    }
}
