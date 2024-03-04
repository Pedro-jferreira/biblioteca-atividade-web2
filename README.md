**Projeto Spring Boot com Banco de Dados H2 e MySQL - README**

# Configuração Inicial

Este é um projeto Spring Boot que utiliza o banco de dados H2 por padrão. Todas as dependências necessárias estão configuradas no arquivo `pom.xml`, portanto, basta baixar as dependências para iniciar o projeto.

**Configuração do H2 Database**

Para acessar o console do H2 Database, após iniciar a aplicação, visite [http://localhost:8080/h2-console](http://localhost:8080/h2-console). Certifique-se de que o JDBC URL esteja configurado como `jdbc:h2:mem:testdb`.

![Configuração H2](path/to/screenshot-h2-config.png)

# Inserção de Dados Iniciais

Uma classe de teste (`DataInitializer`) foi implementada para inserir dados iniciais assim que a aplicação for executada. Esses dados podem ser visualizados através das seguintes consultas SQL.

![Dados Iniciais](path/to/screenshot-dados-iniciais.png)

```sql
-- Consulta de Todos os Usuários
SELECT * FROM user;

-- Consulta de Todos os Produtos
SELECT * FROM product;
```

# Configuração do Banco de Dados MySQL

Caso prefira utilizar um banco de dados MySQL, você pode configurar o arquivo `application-dev.properties`. Abaixo está um exemplo de configuração para um banco chamado "dados".

```properties
# Configurações do banco de dados MySQL com o schema "dados"
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/dados?user=root
spring.datasource.username=root
spring.datasource.password=

# Configurações adicionais (opcional)
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

Para personalizar e utilizar seu próprio banco de dados, altere as configurações de URL, nome de usuário e senha conforme necessário.

Agora, sua aplicação está pronta para ser executada com seu banco de dados personalizado. Lembre-se de ajustar as configurações de acordo com suas preferências. Boa codificação!
