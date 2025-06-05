package com.pos.restaurante.api.enums;

public enum TipoUsuario {
    CLIENTE("CLIENTE", "Cliente"),
    DONO_RESTAURANTE("DONO_RESTAURANTE", "Dono do Restaurante");

    private final String name;
    private final String nome;

    TipoUsuario(String name, String nome) {
        this.name = name;
        this.nome = nome;
    }

    public String getName() {
        return name;
    }

    public String getNome() {
        return nome;
    }
}

