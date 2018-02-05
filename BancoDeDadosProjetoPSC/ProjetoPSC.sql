-- create database PSC;
-- use PSC;

create table Pessoa(
	id int primary key not null,
	nome varchar(100),
	telefone int,
    cep int,
    bairro varchar(100),
    rua varchar(100),
    numero int,
    cpf varchar(100),
    nacionalidade varchar(100)
);

create table Empresa(
	id int primary key not null,
	nome varchar(100),
	telefone int,
    cep int,
    bairro varchar(100),
    rua varchar(100),
    numero int,
    cnpj varchar(100)
);

create table Escola(
	id int primary key not null,
	nome varchar(100),
	telefone int,
    cep int,
    bairro varchar(100),
    rua varchar(100),
    numero int,
    cnpj varchar(100)
);

create table OfertaEmprego(
	id int primary key not null,
    nome varchar(100),
    edital varchar(100),
    qtd int,
    descricao varchar(100)
);

create table Auxilio(
	id int primary key not null,
    nome varchar(100),
    edital varchar(100),
    qtd int,
    descricao varchar(100)
);

create table Concurso(
	id int primary key not null,
    nome varchar(100),
    edital varchar(100),
    qtd int,
    descricao varchar(100)
);

create table Estagio(
	id int primary key not null,
    nome varchar(100),
    edital varchar(100),
    qtd int,
    descricao varchar(100),
    remuneracao numeric(8,2)
);

create table BolsaEstudantil(
	id int primary key not null,
    nome varchar(100),
    edital varchar(100),
    qtd int,
    descricao varchar(100),
    desconto numeric(8,2)
);

create table Curriculo(
	id int primary key not null,
    descricao varchar(1000),
    pessoafk int,
    foreign key (pessoafk) references Pessoa(id)
);