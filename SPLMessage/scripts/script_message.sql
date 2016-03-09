#create schema messageDB;

#drop table status_usuario;
#drop table grupo;
#drop table usuario;

create table status_usuario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id) 
);

create table sobre (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id) 
);

create table grupo (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

create table usuario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(50) NOT NULL,
	id_status INTEGER NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_status) REFERENCES status_usuario(id)
);

create table contato (
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_usuario INTEGER NOT NULL,
	id_contato INTEGER NOT NULL,
	id_grupo INTEGER NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id),
	FOREIGN KEY(id_contato) REFERENCES usuario(id),
	FOREIGN KEY(id_grupo) REFERENCES grupo(id)
);

create table mensagem (
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_usuario INTEGER NOT NULL,
	id_contato INTEGER NOT NULL,
	mensagem VARCHAR(500) NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id),
	FOREIGN KEY(id_contato) REFERENCES usuario(id)
);

create table comentario (
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_usuario INTEGER NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	data_inclusao DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id)
);

create table politica_privacidade (
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id) 
);