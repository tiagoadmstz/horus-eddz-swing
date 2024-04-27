package com.cooperstandard.reports.factorys;

import com.cooperstandard.frames.seletores.ManipulaFrames;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author tiago.teixeira
 */
public class PrintTest {

    public static void main(String[] args) {
        PrintTest pt = new PrintTest();
        pt.testSelfLife();
    }

    public void testEtiquetaEmergencia() {
        Factory_EtiquetaEmergencia factory = new Factory_EtiquetaEmergencia();
        InputStream relatorio = getClass().getResourceAsStream("/Relatorios/EtiquetaEmergencia.jasper");
        Map<String, Object> parametros = new HashMap();
        try {
            imprimirRelatorio(relatorio, "Teste", null, parametros, factory.generateCollection("30044915", 10), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testSelfLife() {
        Factory_SelfLife factory = new Factory_SelfLife();
        InputStream relatorio = getClass().getResourceAsStream("/Relatorios/shelflife.jasper");
        Map<String, Object> parametros = new HashMap();
        try {
            imprimirRelatorio(relatorio, "Teste", null, parametros, factory.generateCollection("01/09/2019", "10/09/2019", "123456789", "shausha"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imprimirRelatorio(InputStream relatorio, String titulo, Image image, Map parametros, List<?> listaResultados, boolean direct) {
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaResultados);
            JasperPrint jpPrint = JasperFillManager.fillReport(relatorio, parametros, ds);
            if (direct) {
                JasperPrintManager.printReport(jpPrint, false);
            } else {
                viewReportFrame(jpPrint, image);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private static void viewReportFrame(JasperPrint print, Image image) {
        JRViewer viewer = new JRViewer(print);
        ManipulaFrames frameReport = new ManipulaFrames() {
            private static final long serialVersionUID = 3109256773218160485L;
        };
        if (image != null) {
            frameReport.setIconImage(image);
        }
        frameReport.add(viewer, BorderLayout.CENTER);
        frameReport.setSize(500, 500);
        frameReport.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameReport.setVisible(true);
    }

}
