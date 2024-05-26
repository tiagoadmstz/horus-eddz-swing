package com.cooperstandard.services.rest;

import com.cooperstandard.entitie.ReportGroup;
import com.cooperstandard.services.dtos.ReportGenerationDto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.swing.JOptionPane;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

public class ReportRestService extends AbstractRestService {

    public List<ReportGroup> findBySector(final String sector) {
        if (StringUtils.isNotBlank(sector)) {
            final ResponseEntity<List<ReportGroup>> response = restTemplate.exchange(
                    String.format("%s/reports/list/{sector}", BASE_URL),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ReportGroup>>() {
                    },
                    sector
            );
            return response.getBody();
        } else {
            JOptionPane.showMessageDialog(null, "User sector is null");
        }
        return Collections.emptyList();
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
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/tests/{sector}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                sector
        );
        return response.getBody();
    }

    public List<String> findMaterialByLine(final String line) {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/materials/{line}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                line
        );
        return response.getBody();
    }

    public List<String> findDdzByDateAndProfile(final Timestamp dataInicial, final Timestamp dataFinal, final String rcPerfil) {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/ddz/list?initialDate={dataInicial}&finalDate={dataFinal}&rcProfile={rcPerfil}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                dataInicial.toLocalDateTime(),
                dataFinal.toLocalDateTime(),
                Long.parseLong(rcPerfil)
        );
        return response.getBody();
    }

    public List<String> findAllEquip() {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/reports/equips/list", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }
        );
        return response.getBody();
    }

    public List<Long> findReportPermissionsByUserId(final Integer userId) {
        final ResponseEntity<List<Long>> response = restTemplate.exchange(
                String.format("%s/reports/permissions/{userId}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Long>>() {
                },
                userId
        );
        return response.getBody();
    }

    public JasperPrint generateReport(final ReportGenerationDto reportGenerationDto) {
        final ResponseEntity<byte[]> response = restTemplate.postForEntity(
                String.format("%s/reports/generate", BASE_URL),
                reportGenerationDto,
                byte[].class
        );
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            final byte[] jasperBytes = response.getBody();
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jasperBytes)) {
                return (JasperPrint) JRLoader.loadObject(byteArrayInputStream);
            } catch (IOException | JRException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    //TODO: see more about that
    /*public File generateReport(final ReportGenerationDto reportGenerationDto) {
        final ResponseEntity<byte[]> response = restTemplate.postForEntity(
                String.format("%s/reports/generate", BASE_URL),
                reportGenerationDto,
                byte[].class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            final byte[] pdfBytes = response.getBody();
            try {
                final File tempFile = Files.createTempFile("reportPdf", ".pdf").toFile();
                FileUtils.writeByteArrayToFile(tempFile, pdfBytes);
                return tempFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }*/
}
