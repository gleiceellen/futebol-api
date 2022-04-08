# futebol-api
Api Kotlin para controle de um torneio de futebol - Trabalho da disciplina APIs e Web Services do curso. de Arquitetura de Software Distribuído 

# Equipe
- Vitor de Oliveira Batista - 145179
- Gleice Elen da Silva Oliveira - 145185

# Stack
Spring Framework
Framework para criacao de aplicações backend baseada em java

* Kotlin  
Linguagem baseada em java com codificacao mais enxuta

* JPA  
API Java para operacoes sonre bancos de dados relacionais

* H2  
Banco de dados relacional in-memory

# Arquitetura
A aplicação foi desenvolvida em um único microserviço devido o tamanho reduzido do dominio.

A estrutura da aplicação é baseada em mvc contendo os princpais pacotes conforme a seguir:

 * controllers  
    classes para exportação dos endpoints REST


 * exceptions  
    classes de exceções de negócio


 * services  
    Serviços com iplementação das reggras de negocio e chamadas a operações sobre dados


 * repositories  
    Componentes de acesso ao dados


 * model  
    Representação do recursos conforme armazenado no banco de dados

   - Request  
   Representacao dos dados de entrada

   - Response  
   Representacao dos dados de saida



