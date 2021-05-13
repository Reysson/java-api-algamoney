CREATE TABLE pessoa(
    codigo SERIAL,
    nome VARCHAR(100),
    ativo BOOLEAN,
    logradouro VARCHAR(100),
    numero VARCHAR(5),
    complemento VARCHAR(50),
    bairro VARCHAR(100),
    cep VARCHAR(9),
    cidade VARCHAR(50),
    estado VARCHAR(50),
    PRIMARY KEY(codigo)
);