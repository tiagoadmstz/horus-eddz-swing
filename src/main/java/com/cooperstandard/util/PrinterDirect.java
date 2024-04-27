package com.cooperstandard.util;

import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;



/**
 *
 * @author rsouza10
 */
public class PrinterDirect {

    public void printFromJasperPrint(PrintService service, JasperPrint jasperPrint, int copies) {
        try {
            if (service != null) {
                PrinterJob job = PrinterJob.getPrinterJob();
                //job.setPageable(new DefaultPageable(jasperPrint));
                PDDocument document = PDDocument.load(JasperExportManager.exportReportToPdf(jasperPrint));
                PDFPrintable printable = new PDFPrintable(document, Scaling.SHRINK_TO_FIT);
                job.setPrintable(printable);
                job.setPrintService(service);
                job.setCopies(copies);
                job.print(getAttributes(jasperPrint));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PrintService getDefaultPrinter() {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(service.getName());
        //Arrays.asList(service.getSupportedAttributeCategories()).forEach(c -> System.out.println(c.getName()));
        return service;
    }

    private PrintRequestAttributeSet getAttributes(JasperPrint jasperPrint) {
        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
        if (jasperPrint.getOrientationValue() == OrientationEnum.LANDSCAPE) {
            set.add(OrientationRequested.LANDSCAPE);
        } else {
            set.add(OrientationRequested.PORTRAIT);
        }
        int height = jasperPrint.getPageHeight();
        int width = jasperPrint.getPageWidth();
        int imgHeight = height - (jasperPrint.getTopMargin() + jasperPrint.getBottomMargin());
        int imgWidth = width - (jasperPrint.getRightMargin() + jasperPrint.getLeftMargin());
        set.add(new MediaPrintableArea(0, 0, imgWidth, imgHeight, MediaPrintableArea.MM));
        return set;
    }
}