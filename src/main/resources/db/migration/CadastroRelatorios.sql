
--CADASTRO DE GRUPOS
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Fluxo de Processo');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) DDZ');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Velocidades');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Comprimentos');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Equipamento/Perfil');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Ficha de controle');
INSERT INTO Report_Group (NOME) VALUES ('(Ext) Plano de controle');
INSERT INTO Report_Group (NOME) VALUES ('(Insp) Ficha de controle');
INSERT INTO Report_Group (NOME) VALUES ('(Insp) Teste reprovados');
INSERT INTO Report_Group (NOME) VALUES ('(Insp) Busca por resultados');
INSERT INTO Report_Group (NOME) VALUES ('(Insp) Capabilidade');


--CADASTRO DE RELATORIOS
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Fluxograma de processo', 'fluxograma.jasper', 'RDC0001', 'SQL', 1, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'DDZ rodada', 'ddzrodada.jasper', 'RDC0002', 'SQL', 2, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Velocidade por linha', 'VelocidadePerfil.jasper', 'RDC0003', 'SQL', 3, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Comprimento por linha', 'informativocomprimento.jasper', 'RDC0004', 'SQL', 4, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Perfil por equipamento', 'perfilequipamento.jasper', 'RDC0005', 'SQL', 5, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Equipamento por perfil', 'equipamentoperfil.jasper', 'RDC0006', 'SQL', 5, 2);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Extrusão', 'fichacontrole.jasper', 'RDC0007', 'SQL', 6, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Extrusão', 'fichacontrole.jasper', 'RDC0008', 'SQL', 7, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Top 5 R$', 'ddzTop_reais.jasper', 'RDC0009', 'SQL', 2, 2);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Teste registrado / perfil', 'insp_BTestePerfil.jasper', 'RDC0010', 'SQL', 10, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Testes registrados / perfil', 'insp_BPerfil.jasper', 'RDC0011', 'SQL', 10, 2);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Relação dos testes por perfil', 'insp_BFicha.jasper', 'RDC0012', 'SQL', 8, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Testes reprovados', 'insp_BTesteReprovado.jasper', 'RDC0013', 'SQL', 9, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Testes reprovados por período', 'insp_BQTDReprovado.jasper', 'RDC0014', 'SQL', 9, 2);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Qtd. testes por turno', 'insp_QtdTesteTurno.jasper', 'RDC0015', 'SQL', 10, 3);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Testes reprovados por data', 'insp_BTesteReprovadoData.jasper', 'RDC0016', 'SQL', 9, 3);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Testes por hora', 'insp_BTesteHora.jasper', 'RDC0017', 'SQL', 10, 4);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Re-Teste', 'insp_BReTeste.jasper', 'RDC0018', 'SQL', 10, 5);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Peso por metro por perfil', 'insp_BPesoMetro.jasper', 'RDC0019', 'SQL', 10, 6);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Carta CEP', 'insp_GraficoCep.jasper', 'RDC0020', 'SQL', 11, 1);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Perfis produzidos por período', 'insp_BPerfilProduzido.jasper', 'RDC0021', 'SQL', 10, 7);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'DDZ rodada (evidência)', 'ddzevidencia.jasper', 'RDC0022', 'SQL', 2, 3);
INSERT INTO Cad_Report (ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (CAST(1 AS BIT), 'Listagem de Lançamentos', 'ddzlancamento.jasper', 'RDC0023', 'SQL', 2, 4);

--CADASTRO DE FILTROS
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Datas', 'datas', 1);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Ordenação', 'combobox', 2);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Linha', 'combobox', 3);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Perfil', 'combobox', 4);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Lançamentos', 'combobox', 5);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Formato', 'combobox', 6);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Equipamento', 'combobox', 7);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Tipo de teste', 'combobox', 8);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Teste', 'combobox', 9);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Horas', 'horas', 10);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('texto', 'texto', 11);
INSERT INTO Report_Filter (NOME, TIPO, ORDEM) VALUES ('Entrada/Parada', 'combobox', 12);


--RELACIONAMENTOSxR
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (1,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (1,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2,5);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2,6);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (3,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (4,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (5,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (5,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (6,7);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (7,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (7,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (9,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (9,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10,8);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10,9);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11,8);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (12,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (12,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (13,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (13,10);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (14,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (15,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (16,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (17,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (17,10);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (19,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20,2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20,9);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (21,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,5);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,6);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22,11);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23,1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23,3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23,12);

--PERMISSÃO DE USUÁRIO
INSERT INTO Cad_Relatorios_Permissoes (Relatorio, Usuario) VALUES(1,1);