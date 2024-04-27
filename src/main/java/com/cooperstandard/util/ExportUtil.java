/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Rafael
 */
public class ExportUtil {

    public void test() {
        //a,b,c,d,e
        File xls = new File("C:\\Users\\".concat(System.getProperty("user.name")).concat("\\Desktop\\ColetaDados.xls"));
        System.out.println(tratarCelulas(xls) ? "Tratamento finalizado com sucesso!" : "Erro ao tratar células!");
    }

    /**
     * Método para tratar células númericas de arquivos .xls
     *
     * @param xls
     * @return booleano informante resultado do método
     */
    public static boolean tratarCelulas(File xls) {
        try {
            FileInputStream input = new FileInputStream(xls);
            //pega a pasta de trabalho
            HSSFWorkbook pastaTrabalho = new HSSFWorkbook(input);
            //escolhe a primeira planilha da pasta
            HSSFSheet planilha = pastaTrabalho.getSheetAt(0);
            //pega todas as linhas do arquivo
            Iterator<Row> iterator = planilha.rowIterator();
            //passa linha a linha
            while (iterator.hasNext()) {
                //pega a linha atual
                Row row = iterator.next();
                //pega todas as celulas da linha
                Iterator<Cell> cellIterator = row.cellIterator();
                //passa celula a celula
                while (cellIterator.hasNext()) {
                    //pega a celula atual
                    Cell c = cellIterator.next();
                    //verifica se é do tipo string
                    if (c.getCellType() == Cell.CELL_TYPE_STRING) {
                        //if (c.getCellType() == 0) {
                        //pega o conteudo da celula
                        String valor = c.getStringCellValue();
                        //troca virgula para ponto
                        valor = valor.replace(",", ".");
                        //cria regex para garantir que o conteudo é um número com ponto flutuando
                        Pattern p = Pattern.compile("(\\d+).(\\d+)");
                        Matcher m = p.matcher(valor);
                        if (m.find()) {
                            //seta novo valor na célula como um double
                            c.setCellValue(Double.valueOf(valor));
                            //seta a célula como numérica
                            c.setCellType(Cell.CELL_TYPE_NUMERIC);
                        }
                    }

                }
            }
            //cria um stream de saida
            FileOutputStream fileOut = new FileOutputStream(xls);
            //escreve as alterações na pasta de trabalho
            pastaTrabalho.write(fileOut);
            //salva o arquivo modificado
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void exportToXls(File file, JasperPrint jasperPrint) {
        try {
            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
            configuration.setOnePagePerSheet(false);
            configuration.setDetectCellType(false);
            configuration.setCollapseRowSpan(false);
            configuration.setWhitePageBackground(false);
            configuration.setWrapText(true);
            FileOutputStream fos = new FileOutputStream(file, true);

            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(fos));
            exporterXLS.setConfiguration(configuration);
            exporterXLS.exportReport();

            fos.flush();
            fos.close();
        } catch (Exception e) {
        }

    }

}
