CREATE DATABASE marketplace
GO
USE marketplace
GO
CREATE TABLE Usuario
(
id			INT					IDENTITY		NOT NULL,
nome		VARCHAR(255)						NOT NULL,
email		VARCHAR(50)			UNIQUE			NOT NULL,
senha		VARCHAR(20)							NOT NULL,
telefone	VARCHAR(11)			UNIQUE			NOT NULL,

PRIMARY KEY (id),
CONSTRAINT chk_telefone_tam CHECK((LEN(telefone) = 10) OR 
								(LEN(telefone) = 11))
)
GO

CREATE TABLE Vendedor
(
id			INT					IDENTITY		NOT NULL,
CPF			CHAR(11)			UNIQUE			NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id) REFERENCES Usuario(id)
)

CREATE TABLE Categoria
(
id			INT					IDENTITY		NOT NULL,
nome		VARCHAR(55)			UNIQUE			NOT NULL,
descricao	VARCHAR(255)						NOT NULL,

PRIMARY KEY (id)
)

GO

CREATE TABLE Anuncio
(
id				INT					IDENTITY		NOT NULL,
id_vendedor		INT									NOT NULL,
valor			DECIMAL(6,2)						NOT NULL,

PRIMARY KEY	(id),
FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id)
)

CREATE TABLE Avaliacao_Vendedor
(
id				INT					IDENTITY		NOT NULL,
id_comprador	INT									NOT NULL,
id_vendedor		INT									NOT NULL,
nota			TINYINT								NOT NULL,
descricao		VARCHAR(100)						NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id_comprador) REFERENCES Usuario(id),
FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id)
)
GO

CREATE TABLE Produto
(
id				INT					IDENTITY		NOT NULL,
id_anuncio		INT									NOT NULL,
id_categoria	INT									NOT NULL,
status			VARCHAR(50)							NOT NULL,
nome			VARCHAR(150)						NOT NULL,
descricao		VARCHAR(255)						NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id_anuncio) REFERENCES Anuncio(id),
FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
)

CREATE TABLE Favorito
(
id_anuncio		INT									NOT NULL,
id_usuario		INT									NOT NULL,

PRIMARY KEY(id_anuncio, id_usuario),
FOREIGN KEY (id_anuncio) REFERENCES Anuncio(id),
FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
)

CREATE TABLE Compra
(
id				INT					IDENTITY					NOT NULL,
id_usuario		INT												NOT NULL,
id_anuncio		INT												NOT NULL,
data_hora		DATETIME			DEFAULT(CURRENT_TIMESTAMP)	NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
FOREIGN KEY (id_anuncio) REFERENCES Anuncio(id)
)
