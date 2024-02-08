
CREATE TABLE genero (
    id_genero INT PRIMARY KEY,
    nome TEXT UNIQUE
);

CREATE TABLE filme_genero (
    id_filme_genero SERIAL PRIMARY KEY,
    id_filme INT,
    id_genero INT,
    FOREIGN KEY (id_filme) REFERENCES filme(id_filme),
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero)
);