
CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(50),
    data_criacao TIMESTAMP
);

CREATE TABLE filme (
    id_filme SERIAL PRIMARY KEY,
    titulo VARCHAR(255) UNIQUE,
    nota DOUBLE PRECISION,
    descricao VARCHAR(255),
    data_criacao TIMESTAMP,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);
