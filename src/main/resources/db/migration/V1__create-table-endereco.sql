CREATE TABLE endereco (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      logradouro VARCHAR(100),
      complemento VARCHAR(200),
      unidade VARCHAR(50),
      bairro VARCHAR(50),
      localidade VARCHAR(100),
      uf CHAR(2),
      estado VARCHAR(50),
      regiao VARCHAR(50),
      numero INTEGER,
      cep VARCHAR(20)
);
