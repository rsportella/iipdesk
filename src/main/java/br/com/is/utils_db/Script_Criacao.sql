CREATE TABLE pessoa(
    codigo      SERIAL NOT NULL,
    nome        VARCHAR(75) NOT NULL,
    apelido     VARCHAR(50),
    cpf         VARCHAR(11),
    rg          VARCHAR(15),
    nascimento  DATE NOT NULL,
    orgexp      VARCHAR(10),
    genero      CHAR(2),
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pessoa PRIMARY KEY (codigo)
);

CREATE TABLE usuario(
    pessoa          INT NOT NULL,
    login           VARCHAR(50) NOT NULL,
    senha           VARCHAR(50) NOT NULL,
    ultimo_acesso   TIMESTAMP NOT NULL DEFAULT NOW(),
    status          CHAR(1) NOT NULL DEFAULT '1',
    CONSTRAINT pk_usuario_pessoa PRIMARY KEY (pessoa),
    CONSTRAINT fk_usuario_pessoa FOREIGN KEY (pessoa) REFERENCES pessoa (codigo)
);

CREATE TABLE tela(
    codigo          SERIAL NOT NULL,
    descricao       VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tela PRIMARY KEY (codigo)
);

CREATE TABLE campo(
    codigo      SERIAL NOT NULL,
    descricao   VARCHAR(50) NOT NULL,
    nome        VARCHAR(50) NOT NULL,
    CONSTRAINT pk_campo PRIMARY KEY (codigo)
);

CREATE TABLE diretiva(
    codigo      SERIAL NOT NULL,
    tela        INT,
    campo       INT,
    CONSTRAINT pk_diretiva PRIMARY KEY (codigo),
    CONSTRAINT fk_diretiva_tela FOREIGN KEY (tela) REFERENCES tela (codigo),
    CONSTRAINT fk_diretiva_campo FOREIGN KEY (campo) REFERENCES campo (codigo)
);

CREATE TABLE permissao(
    usuario     INT NOT NULL,
    diretiva    INT NOT NULL,
    status      BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT pk_permissao_composta PRIMARY KEY (usuario, diretiva),
    CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario) REFERENCES usuario (pessoa),
    CONSTRAINT fk_permissao_campo FOREIGN KEY (diretiva) REFERENCES diretiva (codigo)
);

CREATE TABLE auditoria(
    codigo          INT NOT NULL,
    usuario         INT NOT NULL,
    tela            INT NOT NULL,
    acontecimento   TIMESTAMP NOT NULL DEFAULT NOW(),
    sql             TEXT,
    observacoes     TEXT NOT NULL,
    CONSTRAINT pk_auditoria PRIMARY KEY (codigo),
    CONSTRAINT fk_auditoria_usuario FOREIGN KEY (usuario) REFERENCES usuario (pessoa),
    CONSTRAINT fk_auditoria_tela FOREIGN KEY (tela) REFERENCES tela (codigo)
);

CREATE TABLE pais (
    codigo  SERIAL NOT NULL,
    nome    VARCHAR(75),
    sigla   VARCHAR(3),
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pais PRIMARY KEY (codigo)
);

CREATE TABLE estado (
    codigo  SERIAL NOT NULL,
    nome    VARCHAR(75),
    uf      VARCHAR(2),
    pais    INT NOT NULL REFERENCES Pais,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_estado PRIMARY KEY (codigo)
);

CREATE TABLE cidade (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    estado	INT NOT NULL REFERENCES Estado,
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_cidade PRIMARY KEY (codigo)
);

CREATE TABLE logradouro (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    sigla	VARCHAR(5),
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_logradouro PRIMARY KEY (codigo)
);

CREATE TABLE tipo_endereco (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    sigla	VARCHAR(5),
    descricao	VARCHAR(150),
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_tipo_endereco PRIMARY KEY (codigo)
);

CREATE TABLE endereco (
    codigo	SERIAL NOT NULL,
    rua 	VARCHAR(150),
    numero	VARCHAR(45),
    bairro	VARCHAR(75),
    cep		VARCHAR(10),
    complemento	VARCHAR(150),
    logradouro	INT NOT NULL REFERENCES Logradouro,
    cidade	INT NOT NULL REFERENCES Cidade,
    CONSTRAINT pk_endereco PRIMARY KEY (codigo)
);

CREATE TABLE possui_endereco(
    cliente         INT NOT NULL,
    endereco        INT NOT NULL,
    tipo_endereco   INT NOT NULL REFERENCES tipo_endereco,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pendereco_composta PRIMARY KEY (cliente, endereco),
    CONSTRAINT fk_pendereco_cliente FOREIGN KEY (cliente) REFERENCES Pessoa (codigo),
    CONSTRAINT fk_pendereco_endereco FOREIGN KEY (endereco) REFERENCES Endereco (codigo)
);

CREATE TABLE tipo_evento (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    descricao	VARCHAR(150),
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_tipo_evento PRIMARY KEY (codigo)
);

CREATE TABLE evento (
    codigo	SERIAL NOT NULL,
    horaInicio  DATE,
    horaTermino DATE,
    descricao	VARCHAR(150),
    tipo_evento	INT NOT NULL,
    endereco	INT NOT NULL,
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_evento PRIMARY KEY (codigo),
    CONSTRAINT fk_evento_tipoevento FOREIGN KEY (tipo_evento) REFERENCES tipo_evento (codigo),
    CONSTRAINT fk_evento_endereco FOREIGN KEY (endereco) REFERENCES endereco (codigo)
);

DROP TABLE contato;
CREATE TABLE contato (
    codigo    SERIAL NOT NULL,
    contato   VARCHAR(75),
    descricao VARCHAR(150),
    status    BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_contato PRIMARY KEY (codigo)
);

CREATE TABLE tipo_contato(
  codigo    SERIAL NOT NULL,
  nome      VARCHAR(75),
  sigla     CHAR(3),
  descricao VARCHAR(150),
  status    BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT pk_tipo_contato PRIMARY KEY (codigo)
);

DROP TABLE possui_contato;
CREATE TABLE possui_contato (
    cliente         INT NOT NULL,
    contato         INT NOT NULL,
    tipo_contato    INT NOT NULL REFERENCES tipo_contato,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pcontato_composta PRIMARY KEY (cliente, contato),
    CONSTRAINT fk_pcontato_cliente FOREIGN KEY (cliente) REFERENCES Pessoa (codigo),
    CONSTRAINT fk_pcontato_contato FOREIGN KEY (contato) REFERENCES Contato (codigo)
);

-- Equipe -- 

CREATE TABLE equipe(
    codigo      SERIAL NOT NULL,
    titulo      VARCHAR(75),
    descricao   TEXT,
    responsavel INT,
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_equipe PRIMARY KEY (codigo),
    CONSTRAINT fk_equipe_responsavel FOREIGN KEY (responsavel) REFERENCES pessoa (codigo)
);

CREATE TABLE servico(
    codigo      SERIAL NOT NULL,
    equipe      INT,
    titulo      VARCHAR(75),
    descricao   TEXT,
    valor       DECIMAL(5,2),
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_servico PRIMARY KEY (codigo),
    CONSTRAINT fk_servico_equipe FOREIGN KEY (equipe) REFERENCES equipe (codigo)
);

CREATE TABLE pacote(
    codigo      SERIAL NOT NULL,
    titulo      VARCHAR(75),
    descricao   TEXT,
    descobnto   DECIMAL(5,2),
    status      BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pacote PRIMARY KEY (codigo)
);

CREATE TABLE pacote_possui_servico(
    pacote          INT NOT NULL,
    servico         INT NOT NULL,
    valor_servico   DECIMAL(5,2),
    proposta_em     DATE,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_pacote_possui_servico_composta PRIMARY KEY (pacote, servico),
    CONSTRAINT fk_pacote_possui_servico_pacote FOREIGN KEY (pacote) REFERENCES equipe (codigo),
    CONSTRAINT fk_pacote_possui_servico_servico FOREIGN KEY (servico) REFERENCES servico (codigo)
);

CREATE TABLE servico_pertence_evento(
    evento_cod      INT NOT NULL,
    servico         INT NOT NULL,
    valor_original  DECIMAL(5,2) NOT NULL,
    valor_final     DECIMAL(5,2) NOT NULL,
    status          BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_servico_pertence_evento PRIMARY KEY (evento_cod),
    CONSTRAINT fk_servico_pertence_evento_evento FOREIGN KEY (evento_cod) REFERENCES evento (codigo),
    CONSTRAINT fk_servico_pertence_evento_servico FOREIGN KEY (servico) REFERENCES servico (codigo)
);