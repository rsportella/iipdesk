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
    status      VARCHAR(45) DEFAULT 'A - Ativo',
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
    status  VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_pais PRIMARY KEY (codigo)
);

CREATE TABLE estado (
    codigo  SERIAL NOT NULL,
    nome    VARCHAR(75),
    uf      VARCHAR(2),
    pais    INT NOT NULL REFERENCES Pais,
    status  VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_estado PRIMARY KEY (codigo)
);

CREATE TABLE cidade (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    estado	INT NOT NULL REFERENCES Estado,
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_cidade PRIMARY KEY (codigo)
);

CREATE TABLE logradouro (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    sigla	VARCHAR(5),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_logradouro PRIMARY KEY (codigo)
);

CREATE TABLE tipo_endereco (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    sigla	VARCHAR(5),
    descricao	VARCHAR(150),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
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
    tipo_endereco   INT REFERENCES tipo_endereco,
    status          CHAR(1) DEFAULT 'A',
    CONSTRAINT pk_pendereco_composta PRIMARY KEY (cliente, endereco),
    CONSTRAINT fk_pendereco_cliente FOREIGN KEY (cliente) REFERENCES Pessoa (codigo),
    CONSTRAINT fk_pendereco_endereco FOREIGN KEY (endereco) REFERENCES Endereco (codigo)
);

-- Evento


CREATE TABLE tipo_evento (
    codigo	SERIAL NOT NULL,
    nome	VARCHAR(75),
    descricao	VARCHAR(150),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_tipoevento PRIMARY KEY (codigo)
);

CREATE TABLE sub_tipo_evento (
    codigo	SERIAL NOT NULL,
    tipo_evento	INT NOT NULL,
    nome	VARCHAR(75),
    descricao	VARCHAR(150),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_subtipoevento PRIMARY KEY (codigo),
    CONSTRAINT fk_subtipoevento_tipoevento FOREIGN KEY (tipo_evento) REFERENCES tipo_evento (codigo)
);

CREATE TABLE evento (
    codigo          SERIAL NOT NULL,
    tipo_evento     INT NOT NULL,
    titulo          VARCHAR(150),
    descricao       VARCHAR(150),
    status          VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_evento PRIMARY KEY (codigo),
    CONSTRAINT fk_evento_tipoevento FOREIGN KEY (tipo_evento) REFERENCES tipo_evento (codigo)
);

CREATE TABLE realizacao (
    evento          INT NOT NULL,
    endereco        INT NOT NULL,
    sub_tipo_evento INT NOT NULL,
    descricao       VARCHAR(150),
    data            DATE,
    hora_inicio     VARCHAR(5),
    hora_termino    VARCHAR(5),
    status          VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_realizacao_composta PRIMARY KEY (evento, endereco, sub_tipo_evento),
    CONSTRAINT fk_realizacao_evento FOREIGN KEY (evento) REFERENCES evento (codigo),
    CONSTRAINT fk_realizacao_endereco FOREIGN KEY (endereco) REFERENCES endereco (codigo),
    CONSTRAINT fk_realizacao_subtipoevento FOREIGN KEY (sub_tipo_evento) REFERENCES sub_tipo_evento (codigo)
);

CREATE TABLE responsavel (
    evento          INT NOT NULL,
    cliente         INT NOT NULL,
    tipo            VARCHAR(150),
    CONSTRAINT pk_responsavel_composta PRIMARY KEY (evento, cliente),
    CONSTRAINT fk_responsavel_evento FOREIGN KEY (evento) REFERENCES evento (codigo),
    CONSTRAINT fk_responsavel_pessoa FOREIGN KEY (cliente) REFERENCES pessoa (codigo)
);



-- Fim Evento

DROP TABLE contato;
CREATE TABLE contato (
    codigo    SERIAL NOT NULL,
    contato   VARCHAR(75),
    descricao VARCHAR(150),
    status    VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_contato PRIMARY KEY (codigo)
);

CREATE TABLE tipo_contato(
  codigo    SERIAL NOT NULL,
  nome      VARCHAR(75),
  sigla     CHAR(3),
  descricao VARCHAR(150),
    status          VARCHAR(45) DEFAULT 'A - Ativo',
  CONSTRAINT pk_tipo_contato PRIMARY KEY (codigo)
);

DROP TABLE possui_contato;
CREATE TABLE possui_contato (
    cliente         INT NOT NULL,
    contato         INT NOT NULL,
    tipo_contato    INT,
    status          CHAR(1) DEFAULT 'A',
    CONSTRAINT pk_pcontato_composta PRIMARY KEY (cliente, contato),
    CONSTRAINT fk_pcontato_cliente FOREIGN KEY (cliente) REFERENCES Pessoa (codigo),
    CONSTRAINT fk_pcontato_contato FOREIGN KEY (contato) REFERENCES Contato (codigo),
    CONSTRAINT fk_pcontato_tipocontato FOREIGN KEY (tipo_contato) REFERENCES Tipo_contato (codigo)
);

-- Equipe -- 

CREATE TABLE equipe(
    codigo      SERIAL NOT NULL,
    titulo      VARCHAR(75),
    descricao   TEXT,
    responsavel INT,
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_equipe PRIMARY KEY (codigo),
    CONSTRAINT fk_equipe_responsavel FOREIGN KEY (responsavel) REFERENCES pessoa (codigo)
);

CREATE TABLE servico(
    codigo      SERIAL NOT NULL,
    equipe      INT,
    titulo      VARCHAR(75),
    descricao   TEXT,
    valor       DECIMAL(5,2),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_servico PRIMARY KEY (codigo),
    CONSTRAINT fk_servico_equipe FOREIGN KEY (equipe) REFERENCES equipe (codigo)
);

CREATE TABLE pacote(
    codigo      SERIAL NOT NULL,
    titulo      VARCHAR(75),
    descricao   TEXT,
    descobnto   DECIMAL(5,2),
    status      VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_pacote PRIMARY KEY (codigo)
);

CREATE TABLE pacote_possui_servico(
    pacote          INT NOT NULL,
    servico         INT NOT NULL,
    valor_servico   DECIMAL(5,2),
    proposta_em     DATE,
    status          VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_pacote_possui_servico_composta PRIMARY KEY (pacote, servico),
    CONSTRAINT fk_pacote_possui_servico_pacote FOREIGN KEY (pacote) REFERENCES equipe (codigo),
    CONSTRAINT fk_pacote_possui_servico_servico FOREIGN KEY (servico) REFERENCES servico (codigo)
);

CREATE TABLE servico_pertence_evento(
    evento          INT NOT NULL,
    servico         INT NOT NULL,
    valor_original  DECIMAL(5,2) NOT NULL,
    valor_final     DECIMAL(5,2) NOT NULL,
    status          VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_servico_pertence_evento_composta PRIMARY KEY (evento, servico),
    CONSTRAINT fk_servico_pertence_evento_evento FOREIGN KEY (evento) REFERENCES evento (codigo),
    CONSTRAINT fk_servico_pertence_evento_servico FOREIGN KEY (servico) REFERENCES servico (codigo)
);

-- Pagamento

CREATE TABLE pagamento(
    evento              INT NOT NULL,
    desconto            DECIMAL(5,2) NOT NULL,
    valor_total         DECIMAL(5,2) NOT NULL,
    quantidade_parcela  INT,
    data_inicial        DATE,
    forma_pagamento     VARCHAR(45),
    data_contrato       DATE,
    status              VARCHAR(45) DEFAULT 'A - Ativo',
    CONSTRAINT pk_pagamento PRIMARY KEY (evento),
    CONSTRAINT fk_pagamento_evento FOREIGN KEY (evento) REFERENCES evento (codigo)
);

CREATE TABLE amortizacao(
    codigo              SERIAL NOT NULL,
    pagamento           INT NOT NULL,
    valor               DECIMAL(5,2) NOT NULL,
    data                DATE NOT NULL,
    desconto            DECIMAL(5,2),
    forma_pagamento     VARCHAR(45) NOT NULL,
    status              VARCHAR(45) NOT NULL DEFAULT 'A - Em aberto',
    CONSTRAINT pk_amortizacao PRIMARY KEY (codigo),
    CONSTRAINT fk_amortizacao_pagamento FOREIGN KEY (pagamento) REFERENCES pagamento (evento)
);


CREATE schema audit;
REVOKE CREATE ON schema audit FROM public;
 
CREATE TABLE audit.logged_actions (
    schema_name text NOT NULL,
    TABLE_NAME text NOT NULL,
    user_id text,
    action_tstamp TIMESTAMP WITH TIME zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    action TEXT NOT NULL CHECK (action IN ('I','D','U')),
    original_data text,
    new_data text,
    query text
) WITH (fillfactor=100);
 
REVOKE ALL ON audit.logged_actions FROM public;
 
GRANT SELECT ON audit.logged_actions TO public;
 
CREATE INDEX logged_actions_schema_table_idx 
ON audit.logged_actions(((schema_name||'.'||TABLE_NAME)::TEXT));
 
CREATE INDEX logged_actions_action_tstamp_idx 
ON audit.logged_actions(action_tstamp);
 
CREATE INDEX logged_actions_action_idx 
ON audit.logged_actions(action);


CREATE OR REPLACE FUNCTION audit.if_modified_func() RETURNS TRIGGER AS $body$
DECLARE
    v_old_data TEXT;
    v_new_data TEXT;
BEGIN
 IF (current_setting('iip.auditoria') = 'ON') THEN
    IF (TG_OP = 'UPDATE') THEN
        v_old_data := ROW(OLD.*);
        v_new_data := ROW(NEW.*);
        INSERT INTO audit.logged_actions (schema_name,table_name,user_id,action,original_data,new_data,query) 
        VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,current_setting('iip.userid'),substring(TG_OP,1,1),v_old_data,v_new_data, current_query());
        RETURN NEW;
    ELSIF (TG_OP = 'DELETE') THEN
        v_old_data := ROW(OLD.*);
        INSERT INTO audit.logged_actions (schema_name,table_name,user_id,action,original_data,query)
        VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,current_setting('iip.userid'),substring(TG_OP,1,1),v_old_data, current_query());
        RETURN OLD;
    ELSIF (TG_OP = 'INSERT') THEN
        v_new_data := ROW(NEW.*);
        INSERT INTO audit.logged_actions (schema_name,table_name,user_id,action,new_data,query)
        VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,current_setting('iip.userid'),substring(TG_OP,1,1),v_new_data, current_query());
        RETURN NEW;
    ELSE
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now();
        RETURN NULL;
    END IF;
  END IF;
 EXCEPTION
    WHEN data_exception THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [DATA EXCEPTION] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN unique_violation THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [UNIQUE] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN OTHERS THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [OTHER] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
END;
$body$
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = pg_catalog, audit;

CREATE TRIGGER logradouro_audit
AFTER INSERT OR UPDATE OR DELETE ON logradouro
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER pais_audit
AFTER INSERT OR UPDATE OR DELETE ON pais
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER campo_audit
AFTER INSERT OR UPDATE OR DELETE ON campo
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER pacote_audit
AFTER INSERT OR UPDATE OR DELETE ON pacote
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER tela_audit
AFTER INSERT OR UPDATE OR DELETE ON tela
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER contato_audit
AFTER INSERT OR UPDATE OR DELETE ON contato
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER servico_audit
AFTER INSERT OR UPDATE OR DELETE ON servico
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER evento_audit
AFTER INSERT OR UPDATE OR DELETE ON evento
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER pessoa_audit
AFTER INSERT OR UPDATE OR DELETE ON pessoa
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER tipo_contato_audit
AFTER INSERT OR UPDATE OR DELETE ON tipo_contato
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER permissao_audit
AFTER INSERT OR UPDATE OR DELETE ON permissao
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER diretiva_audit
AFTER INSERT OR UPDATE OR DELETE ON diretiva
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER pacote_possui_servico_audit
AFTER INSERT OR UPDATE OR DELETE ON pacote_possui_servico
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER possui_endereco_audit
AFTER INSERT OR UPDATE OR DELETE ON possui_endereco
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER equipe_audit
AFTER INSERT OR UPDATE OR DELETE ON equipe
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER possui_contato_audit
AFTER INSERT OR UPDATE OR DELETE ON possui_contato
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER servico_pertence_evento_audit
AFTER INSERT OR UPDATE OR DELETE ON servico_pertence_evento
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER tipo_endereco_audit
AFTER INSERT OR UPDATE OR DELETE ON tipo_endereco
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER cidade_audit
AFTER INSERT OR UPDATE OR DELETE ON cidade
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER usuario_audit
AFTER INSERT OR UPDATE OR DELETE ON usuario
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER estato_audit
AFTER INSERT OR UPDATE OR DELETE ON estado
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER tipo_evento_audit
AFTER INSERT OR UPDATE OR DELETE ON tipo_evento
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER endereco_audit
AFTER INSERT OR UPDATE OR DELETE ON endereco
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();