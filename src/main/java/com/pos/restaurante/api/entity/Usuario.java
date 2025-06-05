package com.pos.restaurante.api.entity;

import java.util.Date;

import com.pos.restaurante.api.enums.TipoUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Date dataUltimaAlteracao;
    private Endereco endereco;
    private TipoUsuario tipo;

    public Usuario(String nome, String email, String login, String senha, Date dataUltimaAlteracao, Endereco endereco, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.endereco = endereco;
        this.tipo = tipo;
    }
}
