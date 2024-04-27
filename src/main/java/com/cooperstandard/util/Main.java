/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

/**
 *
 * @author rsouza10
 */
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        new Main().testeCalculo();
    }

    /**
     * resultado esperado: 6.640 m
     * velocidade: 16
     * calculo:(somatória de horas produzidas em minutos * velocidade)
     */
    public void testeCalculo() {
        String[] valores = {
                "1900-01-01 21:45:00.0",
                "1900-01-01 22:45:00.0",
                "1900-01-01 23:45:00.0",
                "1900-01-01 00:45:00.0",
                "1900-01-01 01:45:00.0",
                "1900-01-01 02:45:00.0",
                "1900-01-01 03:45:00.0",
                "1900-01-01 04:40:00.0"
        };
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime horaInicial = LocalDateTime.parse("2021-05-11 21:45:00.0", formatter);
        LocalDateTime horaFinal = LocalDateTime.parse("2021-05-12 04:40:00.0", formatter);
        Integer velocidade = 16;
        System.out.print("\nExemplo 1:\n\t" + Duration.between(horaInicial, horaFinal));
        System.out.print("\n\nExemplo 2:\n\t" + horaInicial.until(horaFinal, ChronoUnit.MINUTES) + " minutos");
        System.out.print("\n\nExemplo 3 (Conta):\n\t" + (horaInicial.until(horaFinal, ChronoUnit.MINUTES) * velocidade) + " m");
        System.out.print("\n\nExemplo 4 (Conta com método):\n\t" + calcularMinutosProduzidos(new JLabel("11/05/2021 - 21:45:00.0"), new JLabel("12/05/2021 - 04:40:00.0"), velocidade));
        System.out.print("\n\nMétodo Rafael:\n\t");
        calculahora(new JLabel("01/01/1900 - 04:40:00.0"), new JLabel("01/01/1900 - 21:45:00.0"));
    }

    public String calcularMinutosProduzidos(JLabel labelDataInicial, JLabel labelDataFinal, Integer velocidade){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss.S");
        Long minutosProduzidos = LocalDateTime.parse(labelDataInicial.getText(), formatter).until(LocalDateTime.parse(labelDataFinal.getText(), formatter), ChronoUnit.MINUTES);
        return String.format("%s m", (minutosProduzidos * velocidade));
    }

    private void calculahora(JLabel jLabel6, JLabel jLabel19) {
        LocalTime horaInicio = LocalTime.parse(jLabel6.getText().split(" - ")[1]);
        LocalTime horaFim = LocalTime.parse(jLabel19.getText().split(" - ")[1]);

        Duration diferenca = Duration.between(horaInicio, horaFim);
        LocalTime localTimeDiferenca = LocalTime.ofNanoOfDay(diferenca.toNanos());
        System.out.println(localTimeDiferenca);
    }
    
}
