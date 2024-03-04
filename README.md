

# Objetivo do Projeto

O objetivo deste projeto é criar uma aplicação Java que faça uso de um ORM (Hibernate) para realizar operações CRUD com base no seguinte diagrama:

<img src="\\atividade2\\img.png" title="img"/>

Deve-se definir as entidades e criar métodos CRUD para as três tabelas apresentadas no diagrama. Adicionalmente, as buscas implementadas devem ser capazes de recuperar as seguintes informações:

- Quais autores por livro;
- Quais livros por autor;
- Quais editoras por livro;
- Quais livros por editora;
- Quais autores por editora;
- Quais editoras por autor.

Essas funcionalidades visam proporcionar uma ampla capacidade de consulta e interação com os dados armazenados no banco, promovendo uma aplicação robusta e flexível.

--- 

## Dependências do Projeto

O projeto foi configurado com base no arquivo `pom.xml`, que define as dependências e configurações necessárias para a construção e execução do projeto. Abaixo estão as principais dependências utilizadas:

- **Spring Boot Starter Data JPA:** Facilita a implementação de operações CRUD em bancos de dados relacionais usando o Spring Data JPA.

- **Spring Boot DevTools:** Fornece ferramentas de desenvolvimento automáticas para melhorar a experiência do desenvolvedor durante o ciclo de desenvolvimento.

- **H2 Database (Runtime):** Um banco de dados em memória para ambiente de desenvolvimento e teste.

- **MySQL Connector:** O conector JDBC para comunicação com o banco de dados MySQL.

- **Spring Boot Starter Test:** Contém as dependências necessárias para testes de unidade e integração em projetos Spring Boot.

- **Jakarta Validation API:** Fornece suporte para validação de dados usando as anotações de validação da especificação Jakarta Bean Validation.

## Configuração do Banco de Dados (H2)

O projeto está configurado para utilizar o banco de dados H2 em memória para facilitar o desenvolvimento e teste. As propriedades de configuração do H2 estão especificadas no arquivo de propriedades, como mostrado abaixo:

```properties
# Configuração do Banco de Dados H2
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 CLIENT
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Configuração do Perfil de Teste

A aplicação está configurada para utilizar o perfil de teste. Isso pode ser observado na propriedade abaixo:

```properties
# Perfil de Teste
spring.profiles.active=test
```

Além disso, a propriedade `spring.jpa.open-in-view=true` está configurada para facilitar o acompanhamento de consultas JPA.



---

## Testando a Aplicação com o Banco de Dados (H2)

O projeto está configurado para utilizar o banco de dados H2 em memória para facilitar o desenvolvimento e teste. Ao iniciar a aplicação, a classe de teste `TestConfig` executará automaticamente o método `insertDados()`, inserindo os seguintes dados no banco de dados:

### Dados Inseridos pela Classe de Teste

A classe de teste `TestApplication` insere automaticamente os seguintes dados para consulta:

#### Editoras

1. Companhia das Letras
2. Record
3. Intrínseca
4. Objetiva

#### Autores

1. Machado de Assis
2. Clarice Lispector
3. Guimarães Rosa
4. Cecília Meireles
5. Carlos Drummond de Andrade
6. Lya Luft

#### Livros

1. Dom Casmurro (ISBN: 9788574801412)
2. Grande Sertão: Veredas (ISBN: 9788535908068)
3. A Hora da Estrela (ISBN: 9788535908068)
4. Romanceiro da Inconfidência (ISBN: 9788535911587)
5. Sentimento do Mundo (ISBN: 9788520937603)
6. Reinações de Narizinho (ISBN: 9788520925709)
7. A Metamorfose (ISBN: 9788573261288)
8. O Cortiço (ISBN: 9788573261288)
9. Memórias Póstumas de Brás Cubas (ISBN: 9788520937078)
10. Quincas Borba (ISBN: 9788573262346)
11. O Alienista (ISBN: 9788572326101)
12. O Primo Basílio (ISBN: 9788525408167)

Esses dados fornecerão uma base para a realização de consultas e testes no banco de dados H2 ao executar a aplicação. Após a execução da aplicação, o sistema imprimirá as opções no console conforme solicitado.

---

## Utilizando o Sistema

Após iniciar a aplicação, as opções a seguir serão exibidas no console:

```plaintext
Faça uma escolha:

(1) Quais autores por livro
(2) Quais livros por autor
(3) Quais editoras por livro
(4) Quais livros por editora
(5) Quais autores por editora
(6) Quais editoras por autor
(7) Listar todos os livros
(8) Listar todos os autores
(9) Listar todas as editoras
(10) Sair
```

Essas opções são fornecidas para permitir a interação e exploração das funcionalidades do sistema. Selecione a opção desejada digitando o número correspondente e pressionando Enter. O sistema processará a escolha e fornecerá as informações solicitadas.

Agora, basta se divertir explorando as consultas disponíveis no sistema!

---
## Configuração do Banco de Dados (MySQL)

Se preferir utilizar seu próprio banco de dados MySQL, siga os passos abaixo:

1. **Altere o Perfil para Dev:**
   No arquivo `application.properties`, altere a propriedade `spring.profiles.active` para `dev`. Isso ativará a configuração do MySQL.

    ```properties
    # Perfil de Desenvolvimento com MySQL
    spring.profiles.active=dev
    ```

2. **Crie o Banco de Dados no MySQL:**
   Certifique-se de que seu banco de dados MySQL esteja instalado e em execução. Execute os seguintes comandos no console do MySQL ou utilizando uma ferramenta de administração, substituindo `sua_base_de_dados` pelo nome desejado para o banco de dados:

    ```sql
    CREATE DATABASE sua_base_de_dados;
    ```

3. **Configurações do Banco de Dados MySQL:**
   Edite o arquivo `application-dev.properties` e insira as configurações do seu banco de dados MySQL:

    ```properties
    # Configurações do banco de dados MySQL com o schema "sua_base_de_dados"
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/sua_base_de_dados?user=seu_usuario&password=sua_senha

    # Configurações adicionais (opcional)
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    ```

   Lembre-se de substituir `sua_base_de_dados`, `seu_usuario` e `sua_senha` pelos valores específicos do seu ambiente.

4. **Inicie a Aplicação:**
   Com as configurações ajustadas, você pode iniciar a aplicação. Certifique-se de ter as dependências do Maven instaladas e execute:

    ```bash
    mvn spring-boot:run
    ```

   A aplicação será iniciada utilizando as configurações do perfil de desenvolvimento com MySQL.



---

## Conclusão

Agradeço por considerar este projeto, que está sendo submetido como parte do trabalho acadêmico. Espero sinceramente que esta aplicação atenda aos critérios estabelecidos e sirva como um exemplo sólido de implementação utilizando o framework Spring Boot e o ORM Hibernate, mesmo sem a utilização de endpoints REST.

### Principais Realizações

- **Experiência com ORM (Hibernate):** A utilização do Hibernate como ORM proporcionou uma maneira eficiente de interagir com o banco de dados, simplificando a manipulação de entidades e a execução de consultas avançadas.

- **Simplicidade do Spring Boot:** O Spring Boot ofereceu uma estrutura intuitiva e fácil de configurar, acelerando o processo de desenvolvimento.

- **Testes e Inserção de Dados:** A automação da inserção de dados para teste, realizada pela classe `TestConfig`, tornou os processos de teste mais eficazes e compreensíveis.

### Próximos Passos

- **Otimização de Desempenho:** Estamos abertos a oportunidades de otimização de desempenho na aplicação, especialmente em consultas mais complexas.

- **Aprimoramento da Interface:** Consideramos a possibilidade de implementar uma interface gráfica ou adicionar endpoints REST adicionais para melhorar a interação com a aplicação.

- **Feedback e Contribuições:** Agradecemos por qualquer feedback ou sugestões que o professor possa ter para aprimorar ainda mais este projeto.

Mais uma vez, obrigado pela revisão deste trabalho e pela oportunidade de apresentar este projeto como parte de nossa avaliação acadêmica.

---
