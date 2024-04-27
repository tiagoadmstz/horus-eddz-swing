CREATE TABLE Velocidade_Perfil (
    ID              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    DATA_CADASTRO   DATETIME        NULL,
    VELOCIDADE      REAL            NULL,
    ID_MATERIAL_ID  INT             NULL,
    CUSTO           FLOAT           NULL,
    PESO            FLOAT           NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
