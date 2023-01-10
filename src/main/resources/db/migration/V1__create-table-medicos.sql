CREATE TABLE medico
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(100)          NULL,
    email         VARCHAR(100)          NULL,
    crm           VARCHAR(6)          NULL,
    especialidade VARCHAR(100)          NULL,
    logradouro    VARCHAR(255)          NULL,
    bairro        VARCHAR(255)          NULL,
    cep           VARCHAR(9)          NULL,
    numero        VARCHAR(20)          NULL,
    complemento   VARCHAR(255)          NULL,
    cidade        VARCHAR(255)          NULL,
    uf            VARCHAR(2)          NULL,
    CONSTRAINT pk_medico PRIMARY KEY (id)
);
