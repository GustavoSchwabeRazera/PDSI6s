CREATE DATABASE IF NOT EXISTS trainup CHARACTER SET utf8mb4;


CREATE USER IF NOT EXISTS 'aluno_cd'@'localhost' IDENTIFIED BY 'aluno_pw';
GRANT ALL PRIVILEGES ON trainup.* TO 'aluno_cd'@'localhost';
FLUSH PRIVILEGES;


USE trainup;
CREATE TABLE IF NOT EXISTS usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    idade INT
);

CREATE TABLE IF NOT EXISTS treino (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    foco VARCHAR(100),
    usuario_id INT NOT NULL,

    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS exercicio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    repeticoes VARCHAR(100),
    carga FLOAT
);

CREATE TABLE IF NOT EXISTS treino_exercicio (
    treino_id INT NOT NULL,
    exercicio_id INT NOT NULL,

    PRIMARY KEY (treino_id, exercicio_id),

    FOREIGN KEY (treino_id) REFERENCES treino(id),
    FOREIGN KEY (exercicio_id) REFERENCES exercicio(id)
);


SELECT * FROM usuario;
