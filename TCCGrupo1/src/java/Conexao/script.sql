DROP DATABASE IF EXISTS DB_TCCGRUPO1;
CREATE DATABASE DB_TCCGRUPO1;

USE DB_TCCGRUPO1;

CREATE TABLE USUARIO (
	IDUSUARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
	, EMAIL VARCHAR(100) NOT NULL
	, SENHA VARCHAR(45) NOT NULL
);


select * from usuario;