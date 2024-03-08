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
('SI2','1021','Gobbi');

INSERT INTO Monitoria VALUES
('ADS','9','Hugo');

INSERT INTO Monitoria VALUES
('ADS3',1,'sans');

SELECT * FROM MONITORIA;

-----------------------------------------
Ex1 Aula 08/03/24
PRAGMA FOREIGN_KEYS = ON;

--DROP TABLE Alunos
create table Alunos (
idAluno char(4),
nome char(50),
curso char(50),
semestre chat(50),
PRIMARY KEY (idAluno));

select * from Alunos;

insert into Alunos values
('0001','Rick','BSI','7SEM'),
('0002','Dimas','BSI','7SEM');

--DROP TABLE Monitoria
create table Monitoria(
disciplina char(30),
idAluno char(4),
orientador char(50),
PRIMARY KEY (disciplina),
FOREIGN KEY (idAluno) REFERENCES Alunos (idAluno)
--ON DELETE CASCADE --Para o primeiro EX
--ON UPDATE SET DEFAULT -- Para o ultimo EX);

select * from Monitoria

insert into Monitoria values 
('Android','0001','Hugo'),
('HTML','0002','Eder'),
('Gestao','0001','Murari'),
('Economia','0002','Evandro');

--------------------------------
Delete from Alunos where idAluno = '0002';

Update Alunos set idAluno = '0009' WHERE idAluno = '0001'; 
