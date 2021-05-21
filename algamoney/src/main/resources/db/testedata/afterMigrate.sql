TRUNCATE categoria CASCADE;

TRUNCATE pessoa CASCADE;

TRUNCATE lancamento CASCADE;

ALTER SEQUENCE categoria_codigo_seq RESTART WITH 1;
ALTER SEQUENCE pessoa_codigo_seq RESTART WITH 1;
ALTER SEQUENCE lancamento_codigo_seq RESTART WITH 1;

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


INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Top Club', '2017-06-10', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('DMAE', '2017-06-10', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'RECEITA', 4, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Bahamas', '2017-06-10', null, 500, null, 'RECEITA', 1, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'DESPESA', 4, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'RECEITA', 5, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Café', '2017-06-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, categoria_codigo, pessoa_codigo) values ('Lanche', '2017-06-10', null, 10.20, null, 'DESPESA', 4, 1);

