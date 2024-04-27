package com.cooperstandard.config;

/**
 *
 * @author rsouza10
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmailConfiguration {

    private static final String FILE_PATH = "config.txt"; // Caminho do arquivo externo

    public static void main(String[] args) {
        Map<String, String> emailLinhaMap = new HashMap<>();
        emailLinhaMap.put("L07", "lucas.coelho@cooperstandard.com");
        emailLinhaMap.put("L08", "lucas.coelho@cooperstandard.com");
        emailLinhaMap.put("L04", "ricardo.porto@cooperstandard.com");
        emailLinhaMap.put("L06", "ricardo.porto@cooperstandard.com");
        emailLinhaMap.put("L12", "carlos.marangon@cooperstandard.com");
        emailLinhaMap.put("L17", "raphael.vilela@cooperstandard.com");
        emailLinhaMap.put("L09", "carlos.ferreira2@cooperstandard.com");
        emailLinhaMap.put("L11", "carlos.ferreira2@cooperstandard.com");
        emailLinhaMap.put("L19", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L26", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L27", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L28", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");

        // Escrever os dados no arquivo externo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : emailLinhaMap.entrySet()) {
                String linha = entry.getKey();
                String email = entry.getValue();
                String line = linha + ":" + email; // Formato linha:email
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler os dados do arquivo externo
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String linha = parts[0];
                    String email = parts[1];
                    emailLinhaMap.put(linha, email);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exemplo de uso:
        String emaillinha = emailLinhaMap.getOrDefault("L07", "");
    }
}
