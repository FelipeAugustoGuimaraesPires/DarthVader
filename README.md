P.I - 4 semestre 

Script Banco de dados

CREATE CACHED TABLE "PUBLIC"."USUARIO"(

    "ID" INT PRIMARY KEY AUTO_INCREMENT,

    "NOME" CHARACTER VARYING(50),

    "CPF" CHARACTER VARYING(14),

    "EMAIL" CHARACTER VARYING(50),

    "SENHA" CHARACTER VARYING(255),

    "ESTATUS" CHARACTER VARYING(20),

    "GRUPO" CHARACTER VARYING(50),

    "BACKOFFICE" BOOLEAN

);

insert into usuario (nome, cpf, email, senha, estatus, grupo, backoffice) values ('Gabriel Aron', '12234567890','gabriel#gmail.com','senha123','Ativo','ADM', true)