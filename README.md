# Pos-Restaurante

Projeto destinado a demonstrar nossas habilidades técnicas em desenvolvimento de software como parte da avaliação do curso de pós-graduação FIAP-Alura.

---

## 📦 Clone do Projeto

Para baixar o projeto:

1. Crie uma conta no GitLab: [https://about.gitlab.com](https://about.gitlab.com)
2. Em seguida, com suas credenciais em mãos, execute os seguintes comandos no terminal:

```bash
git config --system --unset credential.helper
git clone https://gitlab.com/flaviojfreitas/pos-restaurante.git
```

---

## 📝 Descrição do Projeto

Este projeto foi desenvolvido durante a primeira fase do curso de pós-graduação da FIAP. O objetivo é criar um sistema para gerenciamento de restaurante utilizando as tecnologias abordadas em aula, com foco em boas práticas, arquitetura limpa e automação de ambiente.

---

## 🚀 Ambiente de Produção

Para iniciar o projeto em produção via Docker Compose:

1. Certifique-se de ter o Docker e Docker Compose instalados.
2. Na raiz do projeto, execute:

```bash
sudo docker compose up
```

Este comando irá:

* Baixar todas as dependências necessárias;
* Inicializar o banco de dados (`MySQL`);
* Compilar e executar o projeto Spring Boot.

> ⚠️ Observação: Na primeira execução, o processo pode demorar um pouco, pois o Docker irá baixar as imagens e compilar a aplicação.

---

## 🧪 Ambiente de Desenvolvimento

Se você deseja trabalhar com o projeto diretamente pela sua IDE (como IntelliJ ou VSCode), siga os passos abaixo para subir apenas o banco de dados com Docker:

1. Na raiz do projeto, execute:

```bash
docker compose up mysql
```

2. Isso irá subir **apenas o container do MySQL**, permitindo que você:

* Execute a aplicação pela IDE (Spring Boot);
* Desenvolva e teste funcionalidades em tempo real;
* Trabalhe com um banco real em container.

> 📌 O `application.properties` já está configurado para conectar-se ao banco de dados do container. Certifique-se de que a aplicação está apontando para `localhost:3306`.

3. Caso deseja zerar tudo dentro do containers, execute:

```bash
docker compose down -v
```
---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* MySQL
* Docker
* Docker Compose
* GitLab

---

## 😀 Suporte

Caso tenha dúvidas ou precise de ajuda:

* Envie uma mensagem no Discord do time.
* Ou envie um e-mail diretamente para um dos integrantes.

---

## 🛃️ Roadmap

Este sistema será evoluído conforme o andamento das etapas da pós-graduação, incorporando novos módulos e funcionalidades a cada entrega.

---

## 🤝 Como Contribuir

Este projeto é fechado ao grupo de desenvolvimento e professores da FIAP. A colaboração externa não está disponível no momento.

Desenvolvedores:

* Flávio Freitas
* Gustavo Rodrigues
* Mateus Pereira
* Thiago Henrique

---

## 👏 Agradecimentos

Agradecimento especial aos professores e à equipe da FIAP/Alura pela orientação durante o desenvolvimento.

---

## 📄 Licença

Este projeto é de uso acadêmico e não possui uma licença de código aberto pública.
