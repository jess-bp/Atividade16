# Projeto MaisPraTi e Codifica: Criar uma APIRest utilizando Spring Boot e desenvolver Testes unitários com JUnit e Mockito
A Atividade 16 é um projeto desenvolvido como parte do curso Desenvolvedor Full-Stack da MaisPraTi e Codifica desenvolvido no módulo 7 do curso.
## :paperclips: Requisitos do Projeto

 - Utilize Spring Boot e as anotações do Spring (ex: @RestController, @Service, @Repository).
 - A API deverá se conectar a um banco de dados em memória (ex: H2 Database) para persistir os dados durante a execução.
 - Crie testes unitários para cada operação usando JUnit e Mockito, garantindo que todos os métodos sejam testados de forma isolada.
 - Implemente boas práticas de arquitetura em camadas: controller, service e repository.
 - A API deverá retornar respostas JSON.

## :pushpin: Atividade 16

É uma APIRest de Produtos com as funcionalidades Basicas de CRUD (CREATE, READ, UPDATE AND DELETE) com seus devidos endpoints. Além disso, contém testes unitários.

### :pushpin: Funcionalidades
- Cadastro, leitura, atualização e exclusão de Produtos.

## :man_technologist: Conhecimentos aplicados
- **Linguagem de Programação:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** H2
- **Módulos utilizadas:** JUnit, Mockito
- **Arquitetura:** O projeto segue os princípios de SOLID e adota o padrão de arquitetura MVC (Model-View-Controller).


## 📚 Documentação (endpoints)
### Observações

Abaixo seguem exemplos que podem ser inseridos em cada endpoint para testar a aplicação. 

## Testando os Endpoints:  
<summary> Cadastro (POST) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `POST` | Realiza o cadastro do Produto no sistema | `http://localhost:8080/produtos`    
  
  **Request Body**
```json
{
  "descricao": "Produto 1",
  "preco": 150.0,
  "quantidadeEmEstoque": 20
}

```
**Response**    
```json
{
  "id": 1
  "descricao": "Produto 1",
  "preco": 150.0,
  "quantidadeEmEstoque": 20
}
```
**HTTP status:** 201 CREATED or 400 BAD REQUEST  

<summary> Busca (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realiza a busca de produtos no sistema | `http://localhost:8080/produtos`   
  
**Response**    
```json
[
  {
    "id": 1
    "descricao": "Produto 1",
    "preco": 150.0,
    "quantidadeEmEstoque": 20
  }
]
```
**HTTP status:**: 200 OK or 400 BAD REQUEST

<summary> Atualização (PUT) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `PUT` | Realiza a atualização de produtos no sistema  | `http://localhost:8080/produtos/{id}`    

**Request Body**
```json
{
  "descricao": "Produto 1",
  "preco": 150.0,
  "quantidadeEmEstoque": 20
}
```
**Response**    
```json
{
  "id": 1
  "descricao": "Produto 1",
  "preco": 150.0,
  "quantidadeEmEstoque": 20
}
```
**HTTP status:** 200 OK or 400 BAD REQUEST    

<summary> Deletar (Delete) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `DELETE` | Realiza deleção de produtos no sistema | `http://localhost:8080/produtos/{id}`   
  
**Response**  
**HTTP status:** 200 OK or 400 BAD REQUEST
  
