CREATE TABLE usuario (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(100) NOT NULL,
     email VARCHAR(150) NOT NULL UNIQUE,
     login VARCHAR(50) NOT NULL UNIQUE,
     senha VARCHAR(255) NOT NULL,
     data_ultima_alteracao TIMESTAMP NOT NULL,
     endereco_id BIGINT,
     tipo VARCHAR(20) NOT NULL,

     CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);
