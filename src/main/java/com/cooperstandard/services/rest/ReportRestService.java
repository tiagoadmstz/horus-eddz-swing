package com.cooperstandard.services.rest;

import com.cooperstandard.entitie.ReportGroup;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public class ReportRestService extends AbstractRestService {

    public List<ReportGroup> findBySector(final String sector) {
        final ResponseEntity<List<ReportGroup>> response = restTemplate.exchange(
                String.format("%s/reports/list/{sector}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReportGroup>>() {
                },
                sector
        );
        return response.getBody();
    }

    public List<String> findLinesBySector(final String sector) {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/lines/{sector}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                sector
        );
        return response.getBody();
    }

    public List<String> findTestsByEquip(final String sector) {
        //"SELECT DESC_TESTE FROM Cad_Teste where TES_EQUIPAMENTO=? ORDER BY ORDEM"
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/test/{sector}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                sector
        );
        return response.getBody();
    }

    public List<String> findMaterialByLine(final String line) {
        /*
        if (line == null) {
                rs = getResultSet(conn, "Select MATERIAL, BPCS from Cad_Material  order by BPCS ASC");
            } else {
                rs = getResultSet(conn, "Select MATERIAL, BPCS from Cad_Material where  MAT_LINHA= ? order by BPCS ASC", line);
            }
         */
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/material/{line}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                line
        );
        return response.getBody();
    }

    public List<String> findDdzByDateAndProfile(final Timestamp dataInicial, final Timestamp dataFinal, final String rcPerfil) {
        //"SELECT convert(varchar, data_hora_input, 120) as DATA_COMPLETA from dbo.VW_DDZ_DATAHORA WHERE (FLAG = 'E') AND convert(datetime,DATA_INPUT,103)BETWEEN  '" + dataInicial + "' and '" + dataFinal + "' AND ID_M_MATERIAL = '" + rcPerfil + "'"
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/ddz/list?{dataInicial}&{dataFinal}&{rcPerfil}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                dataInicial, dataFinal, rcPerfil
        );
        return response.getBody();
    }

    public List<String> findAllEquip() {
        //"Select * from Cad_Equipamento order by EQUIPAMENTO ASC"
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/equip/list", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }
        );
        return response.getBody();
    }

    public List<Long> findReportPermissionsByUserId(final Integer userId) {
        //"Select Relatorio from Cad_Relatorios_Permissoes where Usuario = ? "
        final ResponseEntity<List<Long>> response = restTemplate.exchange(
                String.format("%s/reports/permission/{userId}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Long>>() {
                },
                userId
        );
        return response.getBody();
    }
}
