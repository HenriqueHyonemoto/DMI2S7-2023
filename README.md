# DMI2S7-2023
Desenvolvimento para Dispositivos Móveis 2

Ex1 SQLITE (https://sqlite.org/fiddle/index.html)
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
