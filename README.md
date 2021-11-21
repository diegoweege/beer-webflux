# Projeto de teste com conexão ao Oracle com Webflux

## Criar imagem docker (oracle/database:18.4.0-xe)
```sh
git clone https://github.com/oracle/docker-images.git
cd docker-images/OracleDatabase/SingleInstance/dockerfiles
./buildContainerImage.sh -v 18.4.0 -t oracle/database:18.4.0-xe -x -i
```

## Provisionar ambiente
- Acessar a pasta `resources/database` e executar o comando `docker-compose up -d`.
- Aguardar até o database estar pronto (`docker-compose logs -f`).
- Em um client sql, conectar em `localhost:1521/xe` com `user: system` e `password: oracle`.
- Na versão inicial não foi adicionada a integração com o liquibase. Segue comandos para criar a tabela inicial com alguns registros:
```
create table beer(
    id NUMBER,
    name VARCHAR2(50) NOT NULL,
    type VARCHAR2(50) NOT NULL,
    PRIMARY KEY(id)
);
insert into beer values (1, 'Heineken', 'PILSEN'); 
insert into beer values (2, 'Brahma', 'PILSEN');
insert into beer values (3, 'Patagônia', 'IPA');
```
- Executar o projeto (`BeerWebfluxApplication.java`).

## Listar Cervejas
- Executar: `curl 'http://localhost:8080/beer'`
```json
[
    {
        "id": 1,
        "name": "Heineken",
        "type": "PILSEN"
    },
    {
        "id": 2,
        "name": "Brahma",
        "type": "PILSEN"
    },
    {
        "id": 3,
        "name": "Patagônia",
        "type": "IPA"
    }
]
```
