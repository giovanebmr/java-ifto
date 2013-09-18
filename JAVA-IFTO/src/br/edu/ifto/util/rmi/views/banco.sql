Consulta de Títulos de Livros (por meio de diversos parâmetros: titulo,
autor, área conhecimento, etc.);
• Reserva de Títulos para um usuário;
• Consultas de Livros Reservados de usuário específico (apresentar os
dados da reserva);
• Consulta de empréstimos de livros de usuário especifico (apresentar os
dados do emprestimo);



CREATE TABLE livro
(
  id serial NOT NULL,
  titulo character varying(100),
  autor character varying(100),
  areadeconhecimento character varying(100),
  CONSTRAINT livro_pkey PRIMARY KEY (id )
)


CREATE TABLE aluno
(
  id serial NOT NULL,
  nome character varying(100),
  matricula integer NOT NULL,
  CONSTRAINT aluno_pkey PRIMARY KEY (matricula )
)

CREATE TABLE reserva
(
  id serial NOT NULL,
  livro integer NOT NULL,
  datainicio character varying(10),
  datafinal character varying(10),
  aluno integer NOT NULL,
  CONSTRAINT reserva_pkey PRIMARY KEY (id ),
  CONSTRAINT aluno FOREIGN KEY (aluno)
      REFERENCES aluno (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT livro_fk FOREIGN KEY (livro)
      REFERENCES livro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE emprestimo
(
  id serial NOT NULL,
  livro integer NOT NULL,
  aluno integer NOT NULL,
  datainicio character varying(10),
  datafinal character varying(10),
  CONSTRAINT emprestimo_pkey PRIMARY KEY (id ),
  CONSTRAINT aluno_fk FOREIGN KEY (aluno)
      REFERENCES aluno (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT livro_fk FOREIGN KEY (livro)
      REFERENCES livro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

