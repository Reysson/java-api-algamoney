TRUNCATE categoria CASCADE;

TRUNCATE pessoa CASCADE;

ALTER SEQUENCE categoria_codigo_seq RESTART WITH 1;
ALTER SEQUENCE pessoa_codigo_seq RESTART WITH 1;

INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Andre',true,'Rua das Carmélias','1234','Apt','Distrito 11','49785123','Sp','Sp');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Marcos',true,'Av das Guianas','4125','Casa','Mecejana','1521036','Belo Horizonte','MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Zé Felipe',false,'Rua das Flores','5520','Condominio','Pricumã','985236650','Boa Vista','RR');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Lorena',true,'Rua Dragon Ball Super','7777','Casa Oval','Planeta 11','7412365','São Jorge','AC');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('Claudia',true,'Av Brasil','3652','Muro Alto','Campos Novos','1110236','Porto Alegre','RS');

