---------- Deleta a tabela se ela já existir ----------

drop table if exists Usuario cascade;
drop table if exists Resposta cascade;

-------------------- TABELAS --------------------

create table Usuario(
cpf varchar(20) primary key,
senha varchar(20),
login varchar(50),
nome varchar(100),
cep varchar(11),
rua varchar(50),
bairro varchar(50),
cidade varchar(50),
numero varchar(5),
constraint ru01 unique(login,senha));

create table Resposta(
codigo serial primary key,
cpfuser varchar(20) not null references usuario(cpf),
r1 char(1),
r2 char(1),
r3 char(1));

-------------------- Inserção na Tabela --------------------

----- Usuário 1 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('12345678901', 'adm', 'adm', 'TESTE', '12345678', 'r', 'b', 'c', 'n');
insert into Resposta (cpfuser, r1, r2, r3)
values ('12345678901', '1', '3', '4');

----- Usuário 2 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('09876543210', 'senha2', 'lucas_silva', 'Lucas Silva', '12345678', 'Avenida Rio Claro', 'Centro', 'São Paulo', '101');
insert into Resposta (cpfuser, r1, r2, r3)
values ('09876543210', '1', '2', '4');

----- Usuário 3 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('98765432100', 'senha3', 'ana_clara', 'Ana Clara', '87654321', 'Avenida das Palmeiras', 'Jardins', 'Rio de Janeiro', '202');
insert into Resposta (cpfuser, r1, r2, r3)
values ('98765432100', '3', '1', '4');

----- Usuário 4 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('11223344556', 'senha4', 'joao_pereira', 'João Pereira', '11223344', 'Av. Brasil', 'Liberdade', 'Belo Horizonte', '303');
insert into Resposta (cpfuser, r1, r2, r3)
values ('11223344556', '2', '3', '4');

----- Usuário 5 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('22334455667', 'senha5', 'maria_silva', 'Maria Silva', '22334455', 'Rua dos Três Corações', 'Vila Nova', 'Salvador', '404');
insert into Resposta (cpfuser, r1, r2, r3)
values ('22334455667', '1', '3', '4');

----- Usuário 6 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('55667788990', 'senha6', 'luan_oliveira', 'Luan Oliveira', '55667788', 'Travessa São José', 'Centro', 'Fortaleza', '505');
insert into Resposta (cpfuser, r1, r2, r3)
values ('55667788990', '1', '2', '4');

----- Usuário 7 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('99887766554', 'senha7', 'pedro_souza', 'Pedro Souza', '99887766', 'Rua do Sol', 'Vila Maria', 'Recife', '606');
insert into Resposta (cpfuser, r1, r2, r3)
values ('99887766554', '2', '3', '4');

----- Usuário 8 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('11223344557', 'senha8', 'laura_costa', 'Laura Costa', '11223355', 'Rua das Flores', 'Jardim das Flores', 'São Luís', '707');
insert into Resposta (cpfuser, r1, r2, r3)
values ('11223344557', '5', '6', '7');

----- Usuário 9 -----
insert into Usuario (cpf, senha, login, nome, cep, rua, bairro, cidade, numero)
values ('33445566778', 'senha9', 'novo_user', 'Novo Usuário', '33445566', 'Rua do Horizonte', 'Bairro Novo', 'Curitiba', '808');
insert into Resposta (cpfuser, r1, r2, r3)
values ('33445566778', '1', '2', '4');


-------------------- AUX --------------------

 select * from Usuario;
-- select * from Resposta;