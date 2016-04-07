drop schema messageDB;
create schema messageDB;
use messageDB;

#drop table politica_privacidade;
#drop table status_usuario;
#drop table sobre;
#drop table grupo;
#drop table usuario;
#drop table contato;
#drop table mensagem;

create table politica_privacidade (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(2500) NOT NULL,
	PRIMARY KEY(id) 
);

create table status_usuario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id) 
);

create table sobre (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(2500) NOT NULL,
	PRIMARY KEY(id) 
);

create table grupo (
	id INTEGER NOT NULL AUTO_INCREMENT,
	email_usuario VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(email_usuario) REFERENCES usuario(email),
);

create table usuario (
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	id_status INTEGER NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(email),
	FOREIGN KEY(id_status) REFERENCES status_usuario(id)
);

create table contato (
	email_usuario VARCHAR(255) NOT NULL,
	email_contato VARCHAR(255) NOT NULL,
	id_grupo INTEGER NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(email_usuario, email_contato),
	FOREIGN KEY(email_usuario) REFERENCES usuario(email),
	FOREIGN KEY(email_contato) REFERENCES usuario(email),
	FOREIGN KEY(id_grupo) REFERENCES grupo(id)
);

create table mensagem (
	id INTEGER NOT NULL AUTO_INCREMENT,
	email_usuario VARCHAR(255) NOT NULL,
	email_contato VARCHAR(255) NOT NULL,
	mensagem VARCHAR(1000) NOT NULL,
	enviada INTEGER NOT NULL,
	lida INTEGER NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id, email_usuario, email_contato),
	FOREIGN KEY(email_usuario) REFERENCES usuario(email),
	FOREIGN KEY(email_contato) REFERENCES usuario(email)
);

create table comentario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	email_usuario VARCHAR(255) NOT NULL,
	assunto VARCHAR(255) NOT NULL,
	tipo INTEGER NOT NULL,
	descricao VARCHAR(1000) NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(email_usuario) REFERENCES usuario(email)
);