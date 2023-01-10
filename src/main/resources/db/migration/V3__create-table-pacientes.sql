CREATE TABLE paciente
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(100)          NULL,
    email       VARCHAR(100)          NULL,
    telefone    VARCHAR(20)          NULL,
    cpf         VARCHAR(255)          NULL,
    logradouro  VARCHAR(255)          NULL,
    bairro      VARCHAR(255)          NULL,
    cep         VARCHAR(9)          NULL,
    numero      VARCHAR(20)          NULL,
    complemento VARCHAR(255)          NULL,
    cidade      VARCHAR(255)          NULL,
    uf          VARCHAR(2)          NULL,
    CONSTRAINT pk_paciente PRIMARY KEY (id)
);
