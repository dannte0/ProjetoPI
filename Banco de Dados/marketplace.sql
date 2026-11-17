CREATE DATABASE marketplace
GO
USE marketplace
GO
CREATE TABLE Usuario
(
id				INT				IDENTITY				NOT NULL,
nome			VARCHAR(150)							NOT NULL,
email			VARCHAR(150)	UNIQUE					NOT NULL,
senha			VARCHAR(100)							NOT NULL,
CPF				CHAR(11)		CHECK(LEN(CPF) = 11)	NOT NULL,
telefone		VARCHAR(11)		UNIQUE					NOT NULL,

PRIMARY KEY (id),
CONSTRAINT chk_fone_len CHECK((LEN(telefone) = 10) OR (LEN(telefone) = 11))
)

CREATE TABLE Categoria
(
id				INT				IDENTITY				NOT NULL,
nome			VARCHAR(255)							NOT NULL

PRIMARY KEY (id)
)

GO

CREATE TABLE Produto
(
id				INT				IDENTITY				NOT NULL,
nome			VARCHAR(150)							NOT NULL,
descricao		VARCHAR(255)							NOT NULL,
marca			VARCHAR(150)							NOT NULL,
condicao		VARCHAR(10)		DEFAULT('USADO')		NOT NULL,
cor				VARCHAR(50)								NOT NULL,
id_categoria	INT										NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
)

GO
CREATE TABLE Anuncio
(
id_produto			INT											NOT NULL,
id_vendedor			INT											NOT NULL,
valor				DECIMAL(7,2)								NOT NULL,
status				VARCHAR(50)		DEFAULT('ATIVO')			NOT NULL,
data_criacao		DATE			DEFAULT(GETDATE())			NOT NULL,

PRIMARY KEY (id_produto),
FOREIGN KEY (id_produto) REFERENCES Produto(id),
FOREIGN KEY (id_vendedor) REFERENCES Usuario(id)
)

GO

CREATE TABLE Compra
(
id_anuncio			INT											NOT NULL,
id_comprador		INT											NOT NULL,
data_hora			DATETIME2		DEFAULT(SYSDATETIME())		NOT NULL,

PRIMARY KEY (id_anuncio),
FOREIGN KEY (id_anuncio) REFERENCES Anuncio(id_produto),
FOREIGN KEY (id_comprador) REFERENCES Usuario(id)
)

CREATE TABLE Favorito
(
id_usuario			INT							NOT NULL,
id_anuncio			INT							NOT NULL,

PRIMARY KEY (id_usuario, id_anuncio),
FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
FOREIGN KEY (id_anuncio) REFERENCES Anuncio(id_produto),
)

GO
CREATE TABLE AvaliacaoVendedor
(
id_compra	INT											NOT NULL,
nota		TINYINT										NOT NULL,
descricao	VARCHAR(255)								NULL,
data_hora	DATETIME2		DEFAULT(SYSDATETIME())		NOT NULL,

PRIMARY KEY (id_compra),
FOREIGN KEY (id_compra) REFERENCES Compra(id_anuncio),
CONSTRAINT chk_tam_nota CHECK((nota >= 0) OR (nota < 6))
)