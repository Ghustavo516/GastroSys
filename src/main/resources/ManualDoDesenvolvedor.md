# 🍽️ Pos-Restaurante

Sistema desenvolvido durante a pós-graduação FIAP/Alura com foco em aplicar práticas modernas de desenvolvimento de software. A aplicação simula a gestão de um restaurante, com backend Java + Spring Boot e banco de dados MySQL.

---

## 🚀 Começando com o Projeto

### ✅ Pré-requisitos

Antes de iniciar o desenvolvimento, tenha instalado:

* [Docker](https://www.docker.com/)
* [Java 21](https://adoptium.net/)
* [Maven](https://maven.apache.org/)
* Uma IDE como IntelliJ ou VSCode

---

## 🔧 Ambiente de Desenvolvimento

Para trabalhar localmente no projeto, siga os passos abaixo:

### 1. Clonar o repositório

```bash
git clone https://gitlab.com/flaviojfreitas/pos-restaurante.git
cd pos-restaurante
```

### 2. Subir apenas o banco de dados com Docker

Utilizamos um container MySQL para facilitar o desenvolvimento local. Para iniciar **somente o banco de dados**, execute:

```bash
docker compose up mysql
```

Esse comando sobe o banco de dados configurado no `docker-compose.yml`. Com isso, você pode rodar a aplicação manualmente pela sua IDE.

### 3. Rodar o backend pela IDE

Abra o projeto em sua IDE (como IntelliJ ou VSCode), e execute a aplicação Spring Boot. Certifique-se de que o `application.properties` ou `application.yml` está apontando para:

```
spring.datasource.url=jdbc:mysql://localhost:3306/techchallenge
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=techchallenge
spring.datasource.password=techchallenge
```

---

## 📆 Fluxo de Desenvolvimento

### 1. Criar uma tarefa no GitLab

Antes de começar a codar, crie um card de tarefa em:

👉 [GitLab Issues](https://gitlab.com/flaviojfreitas/pos-restaurante/-/issues)

* Mude o status de **Open** para **Doing**
* Crie um branch a partir da `develop` com o nome da tarefa

### 2. Após o desenvolvimento

* Commit e push do branch com a funcionalidade
* Crie um *Merge Request* para a branch `develop`
* Mude o status do card para **Review**

### 3. Após a revisão

* Se aprovado, crie um *Merge Request* para a `master`
* Mude o status do card para **Closed**

---

## 📆 Convenções e Padrões

### Criar Tabela no Banco

Crie um arquivo de migration com o Flyway:

```bash
src/main/resources/db/migration/V{versao}__create_table_nome.sql
```

**Exemplo:**

`V1__create_table_endereco.sql`
`V2__create_table_usuario.sql`

### Criar Controller

Local:
`src/main/java/com/pos/restaurante/api/controller/`

**Exemplo:**
`UsuarioController.java`

### DTOs (Data Transfer Object)
**Exemplo:**

```java
CadastroUsuarioRequestDTO.java
CadastroUsuarioResponseDTO.java
```

### Criar Service (Interface e Implementação)

1. Interface:
   `api/service/CadastroUsuarioService.java`

2. Implementação:
   `api/service/impl/CadastroUsuarioServiceImpl.java`

3. Mapper auxiliar (se necessário):
   `api/service/impl/CadastroUsuarioServiceMapper.java`

### Criar Repository

1. Interface:
   `api/repository/UsuarioRepository.java`

2. Implementação (caso use JDBC):
   `api/repository/impl/UsuarioRepositoryImpl.java`

---

## 👨‍💼 Time

* Flávio Freitas
* Gustavo Rodrigues
* Mateus Pereira
* Thiago Henrique

---

## 🛍️ Roadmap

O sistema será evoluído conforme os módulos e entregas da pós-graduação.

---

## ❗ Contribuição

Este projeto é destinado ao uso interno do grupo da pós-graduação.
Não está aberto a contribuições externas no momento.

---

## 🛡️ Licença

Este projeto é de uso educacional. Não licenciado para uso comercial ou distribuição pública.
