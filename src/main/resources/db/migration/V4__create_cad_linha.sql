CREATE TABLE Cad_Linha (
    ID_LINHA            INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ORDEM               INT             NULL,
    LINHA               VARCHAR(50)     NOT NULL,
    TIPO_LINHA          VARCHAR(50)     NULL,
    SETOR               VARCHAR(50)     NULL,
    N_PLANO             VARCHAR(50)     NULL,
    CONTATO_CHAVE       VARCHAR(100)    NULL,
    EQUIPE_PRINCIPAL    VARCHAR(100)    NULL,
    DATA_INICIAL        VARCHAR(50)     NULL,
    UNIQUE KEY UNQ_LINHA (LINHA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
