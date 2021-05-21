CREATE TABLE lancamento (
	codigo SERIAL PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	categoria_codigo INT NOT NULL REFERENCES categoria(codigo),
        pessoa_codigo INT NOT NULL REFERENCES pessoa(codigo)
);