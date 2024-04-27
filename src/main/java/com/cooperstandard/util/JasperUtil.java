package com.cooperstandard.util;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rafael
 */
public class JasperUtil {

    private static final String PATH = "/Relatorios/";

    public static void imprimirSqlReport(Connection conn, String title, String reportName, Map<String, Object> parameters) {
        try {
            JasperPrint print = getJasperPrint(conn, reportName, parameters);
            montReportView(title, print);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void imprimirRelatorioBean(InputStream relatorio, String titulo, Image image, Map parametros, List<?> listaResultados, boolean direct) {
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaResultados);
            JasperPrint jpPrint = JasperFillManager.fillReport(relatorio, parametros, ds);
            if (direct) {
                JasperPrintManager.printReport(jpPrint, false);
            } else {
                montReportView(titulo, jpPrint);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static JasperPrint getJasperPrint(Connection conn, String reportName, Map<String, Object> parameters) {
        try {
            InputStream input = reportName.getClass().getResourceAsStream(PATH.concat(reportName));
            return JasperFillManager.fillReport(input, parameters, conn);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void montReportView(String title, JasperPrint print) {
        try {
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle(title);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
	    JRViewer viewer = (JRViewer) ((JPanel) view.getContentPane().getComponents()[0]).getComponents()[0];
            Arrays.asList(viewer.getComponents()).stream().filter(cpt -> cpt.getClass().equals(JPanel.class))
                    .map(cpt -> (JPanel) cpt).forEach(cpt -> {
                Arrays.asList(cpt.getComponents()).stream().filter(cpt2 -> cpt2.getClass().equals(JButton.class))
                        .map(cpt2 -> (JButton) cpt2).filter(cpt2 -> ((ImageIcon) cpt2.getIcon()).getDescription().contains("print.GIF"))
                        .forEach(cpt2 -> viewer.registerKeyboardAction((event) -> cpt2.doClick(), KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), JRViewer.WHEN_IN_FOCUSED_WINDOW));
            });
            view.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, Object> getMapParameterDefault() {
        Map<String, Object> map = new HashMap();
        try {
            map.put("SUBREPORT_DIR", map.getClass().getResource(PATH));
            map.put("logo", map.getClass().getResourceAsStream("/images/logocooper.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}
