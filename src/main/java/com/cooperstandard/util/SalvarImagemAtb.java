/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rsouza10
 */
public class SalvarImagemAtb {

    public String selecionarArquivoSalvarOutraPastaEPegarPathNovo(String titulo) {
        //variável local para armazenar o arquivo selecionado
        File arquivoSelecionado = null;
        //Selecionador de arquivo
        JFileChooser fileChooser = new JFileChooser();
        //filtro para aparecer somente imagens jpg
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens JPEG", "jpg", "jpeg"));
        fileChooser.setDialogTitle(titulo);
        // abre o selecionador de arquivo e passa o resultado da ação para variável local
        int acao = fileChooser.showDialog(null, "Selecionar");
        //caso a seleção seja aprovada o arquivo é recuparado na variável local
        if (acao == JFileChooser.APPROVE_OPTION) {
            arquivoSelecionado = fileChooser.getSelectedFile();
        }

        try {
            // variável local que representa a pasta de destino
            File pathDestino = new File("Z:\\Processo\\Ficha de Controle/imagensSistema/");
            //caso a pasta não exista o sistema criará
            if (!pathDestino.exists()) {
                pathDestino.mkdir();
            }
            //variável local que representa o novo arquivo que será gravado em disco
            File arquivoDestino = new File("Z:\\Processo\\Ficha de Controle/imagensSistema/".concat(arquivoSelecionado.getName()));
            // executa o método para copiar o arquivo
            copyFile(arquivoSelecionado, arquivoDestino);
            //imprimi o caminho do arquivo copiado
//            System.out.println(arquivoDestino);
            return arquivoDestino.toString();
//            CadperfilImagem.setText(arquivoDestino.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void copyFile(File source, File destination) throws IOException {
        // verifica se o arquivo destino já existe na pasta e o deleta
        if (destination.exists()) {
            destination.delete();

        }
        //cria duas variáveis Locais que representam os arquivos 
        FileChannel soucerChannel = null;
        FileChannel destiChannel = null;
        try {
            // recupera o channel do arquivo selecionado por meio de um inputStream
            soucerChannel = new FileInputStream(source).getChannel();
            //recupera o channel do arquivo de destino por meio de um outputstrem
            destiChannel = new FileOutputStream(destination).getChannel();
            // realiza a transferência de bytes de um channel para o outro
            soucerChannel.transferTo(0, soucerChannel.size(), destiChannel);

        } finally {
            //fecha os channels utilizandos no método
            if (soucerChannel != null && soucerChannel.isOpen()) {
                soucerChannel.close();
            }
            if (destiChannel != null && destiChannel.isOpen()) {
                destiChannel.close();
            }
        }
    }
}
