create schema jogodavelha

set search_path to jogodavelha


create table pessoa(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome varchar(80)
)

create table usuario(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
login varchar(30),
email varchar(80),
senha varchar(20)
)

------------------------------------------
-------------- atual --------------------- DigestUtils.sha512Hex

create table jogador(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome varchar(80),
login varchar(30),
email varchar(80),
senha varchar(512)
)

create table jogador(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
idUsuario integer
)

create table administrador(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
privilegio varchar(20),
idUsuario integer
)

create table mensagem(
id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
idRemetente integer,
idDestinatario integer,
mensagem varchar(500),
dataMensagem date,
horarioMensagem time
)

create table monitor(
    id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    idJogador1 integer,
    idJogador2 integer,
    jogadaJogador1x char(1),
    jogadaJogador1y char(1),
    jogadaJogador2x char(1),
    jogadaJogador2y char(1),
    jogador1jogou boolean default false,
    jogador2jogou boolean default false,
    aceiteJogoJogador1 boolean default false,
    aceiteJogoJogador2 boolean default false,
    mensagemDoJogo varchar(255),
    mensagemDoJogador varchar(255),
    mensagemDeDesafio varchar(255),
    iniciaJogandoJogador1 boolean default false,
    iniciaJogandoJogador2 boolean default false,
    bloqueadoParaDesafio boolean default false,  
    pontosJogador1 integer,
    pontosJogador2 integer
)
 









Banco de Dados, Derby, Autoincrement, Reset
Uma coisa que achei um pouco chata de encontrar.
Mas é só isso:


ALTER TABLE "<ALIAS>"."<NOME DA TABELA>" 
ALTER COLUMN ID RESTART WITH 1;

COMMIT;  (Se o seu cliente não estiver configurado para autocommit).




arrays

INSERT INTO jogodavelha.teste(
            teste, id)
    VALUES (ARRAY[1,2], 1);

INSERT INTO jogodavelha.teste(
            teste, id)
    VALUES ('{1,2}', 2);




java.sql.Time

hh: mm [: ss]
 hh.mm [. ss]
 hh [: mm] {AM | PM} 
O primeiro dos três formatos acima é o formato de java.sql.Time.

Exemplos
  Os valores de tempo ('15: 09:02 ') 
  VALORES '15: 09:02 ' 



java.sql.Date

  aaaa-mm-dd
 dd / mm / aaaa
 dd.mm.yyyy 
O primeiro dos três formatos acima é o formato java.sql.Date.

Exemplos
  Os valores de data ('1994-02-23 ') 

  VALORES '1993-09-01 '


create schema TESTE