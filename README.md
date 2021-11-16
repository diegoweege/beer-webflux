# Projeto de teste com conexão ao Oracle com Webflux

- Para subir um container do Docker com uma instância do Oracle, acessar a pasta `resources/database` e rodar o comando `docker-compose up -d`

- Na versão inicial não foi adicionada a integração com o liquibase. Segue comandos para criar a tabela inicial com alguns registros:

``
create table beer(
    id NUMBER,
    name VARCHAR2(50) NOT NULL,
    type VARCHAR2(50) NOT NULL,
    PRIMARY KEY(id)
);
``

````
insert into beer values (1, 'Heineken', 'PILSEN');
 
insert into beer values (2, 'Brahma', 'PILSEN');

insert into beer values (3, 'Patagônia', 'IPA');
