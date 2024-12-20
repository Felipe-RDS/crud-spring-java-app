# CRUD Spring Java App

## Descrição
Este é um projeto de aplicação CRUD desenvolvido com **Java**, **Spring Boot**, **PostgreSQL** e **Thymeleaf**. Ele permite o gerenciamento de produtos e usuários com controle de acesso baseado em roles (USER e ADMIN). O projeto inclui criptografia de senha no banco de dados e está configurado para rodar em contêineres Docker.

---

## Funcionalidades
- **CRUD de Produtos:** Criação, leitura, atualização e exclusão de produtos.
- **Listagem de Usuários:** Visualização de usuários cadastrados (apenas para ADMIN).
- **Controle de Acesso Baseado em Roles:**
    - ADMIN: Permissões completas (CRUD de produtos e listagem de usuários).
    - USER: Acesso apenas à listagem de produtos.
- **Autenticação e Autorização:** Login e registro de usuários com criptografia de senha.
- **Docker:** Configuração para rodar em ambiente Docker.

---

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Security**
- **PostgreSQL**
- **Thymeleaf**
- **Flyway** (Migrations)
- **Docker e Docker Compose**

---

## Requisitos
1. **Docker** e **Docker Compose** instalados.
2. **Java 21** instalado (recomendado [Amazon Corretto](https://aws.amazon.com/corretto/)).

---

## Configuração do Ambiente
1. Clone este repositório:
   ```bash
   git clone https://github.com/Felipe-RDS/crud-spring-java-app.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd crud-spring-java-app
   ```
3. Renomear o arquivo `.env.example` para `.env` e preencher com suas credenciais de acesso ao banco:

   ```bash
   SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/product
   SPRING_DATASOURCE_USERNAME=seu_usuario
   SPRING_DATASOURCE_PASSWORD=sua_senha
   ```
   **Observação:** O nome do banco de dados padrão é **`product`**, conforme definido na variável `SPRING_DATASOURCE_URL`. Caso deseje utilizar outro nome, edite também esta variável no arquivo `.env`.
---

## Execução com Docker
1. Inicie os contêineres:
   ```bash
   docker-compose up -d
   ```
2. A aplicação estará disponível em:
   [http://localhost:8080/](http://localhost:8080/)

---

## Scripts Úteis
- Parar os contêineres Docker mantendo os dados armazenados:
  ```bash
  docker-compose down
  ```
- Limpar os dados e reconstruir os contêineres:
  ```bash
  docker-compose down -v
  docker-compose up -d --build
  ```

---

