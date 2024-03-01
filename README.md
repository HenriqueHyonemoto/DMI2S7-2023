# DMI2S7-2023
Desenvolvimento para Dispositivos Móveis 2
--------------------------------------------------------------------
<h1>Ex1 SQLITE (https://sqlite.org/fiddle/index.html)</h1>
create table aluno(
nMatricula INTEGER,
nome TEXT,
curso TEXT,
semestre INTEGER,
PRIMARY KEY (nMatricula)
);

INSERT INTO aluno (nMatricula, nome, curso, semestre)
VALUES
(1001,'José','SI',5),
(1021,'Maria','SI',5),
(1045,'Claudio','SI',4),
(1010,'Luna','ADS',2),
(1031,'Herminia','ADS',1);

select * from aluno;

INSERT INTO aluno (nMatricula, nome, curso, semestre)
VALUES
(1045,'Marco','SI',5);
<hr>
<h1>Ex2 SQLITE (https://sqlite.org/fiddle/index.html)</h1>
PRAGMA foreign_keys = ON;

create table aluno(
nMatricula char(4),
nome TEXT,
curso TEXT,
semestre INTEGER,
PRIMARY KEY (nMatricula)
);

CREATE TABLE Monitoria (
disciplina char(15),
idAluno char(4), 
orientador char(30),
PRIMARY KEY (disciplina),
foreign key (idAluno) REFERENCES aluno (nMatricula));

INSERT INTO aluno (nMatricula, nome, curso, semestre)
VALUES
('1001','José','SI',5),
('1021','Maria','SI',5),
('1045','Claudio','SI',4),
('1010','Luna','ADS',2),
('1031','Herminia','ADS',1);

select * from aluno;

INSERT INTO aluno (nMatricula, nome, curso, semestre)
VALUES
(1045,'Marco','SI',5);

INSERT INTO Monitoria VALUES
('SI','5','Gobbi');
INSERT INTO Monitoria VALUES
('SI','9','Hugo');

SELECT * FROM MONITORIA;
