CREATE TABLE mercadoria (
id_mercadoria INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
tipo_mercadoria VARCHAR(100) NOT NULL,
nome_mercadoria VARCHAR(100) NOT NULL,
quantidade_mercadoria INTEGER NOT NULL,
preco_unidade_mercadoria DOUBLE NOT NULL
);

CREATE TABLE negocio (
id_negocio INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
tipo_negocio VARCHAR(6) NOT NULL,
telefone_negociador VARCHAR(15) NOT NULL,
nome_negociador VARCHAR(50) NOT NULL,
id_mercadoria INTEGER NOT NULL,
  FOREIGN KEY (id_mercadoria) REFERENCES mercadoria (id_mercadoria) ON DELETE CASCADE
);	