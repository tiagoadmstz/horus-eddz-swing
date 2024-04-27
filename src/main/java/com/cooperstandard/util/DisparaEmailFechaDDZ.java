package com.cooperstandard.util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class DisparaEmailFechaDDZ {

public void Email(String perfil, String linha, String enviar, String scrapkg, String scrapm, String scrapr, String percscrap, String metrosprod, String parada, byte[] pdfContent) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.ssl.trust", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.socketFactory.port", "25");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ddz@extrusao.com", "");
            }
        });
        session.setDebug(false);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ddz@extrusao.com")); // Remetente
            Address[] toUser = null; // Destinatário(s)
            toUser = InternetAddress.parse(enviar);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Fechamento de DDZ - '" + linha + "' - '" + perfil + "'");

            Multipart multipart = new MimeMultipart();

            // Texto do email
            String content = "<html><head><style>table {border-collapse: collapse; width: 100%;}"
                    + "table th, table td {text-align: center; padding: 8px;}"
                    + "table th {background-color: #4CAF50; color: white;}"
                    + "table tr:nth-child(even) {background-color: #f2f2f2;}"
                    + "h1 {font-size: 2em; text-align: center;}"
                    + "p {font-size: 1.5em; text-align: center;}"
                    + "div {padding: 10px;}"
                    + "</style></head><body><div>"
                    + "<h1>Fechamento de DDZ</h1>"
                    + "<p>Linha: <span style='color: green; font-weight: bold;'>" + linha + "</span></p>"
                    + "<p>Perfil: <span style='color: green; font-weight: bold;'>" + perfil + "</span></p>"
                    + "<table>"
                    + "<tr><th>Scrap KG</th><th>Scrap M</th><th>Scrap R$</th>"
                    + "<th>Percentual de scrap</th><th>Metros bons produzidos</th><th>Observação: Parada</th></tr>"
                    + "<tr><td>" + scrapkg + "</td><td>" + scrapm + "</td><td>" + scrapr + "</td>"
                    + "<td>" + percscrap + "</td><td>" + metrosprod + "</td><td>" + parada + "</td></tr>"
                    + "</table>"
                    + "<p><a href=\"L:\\E.P.E\\Sistema de Documentacao\\EDDZ.jar\">Clique aqui</a> para acessar o sistema com mais detalhes.</p>"
                    + "</div></body></html>";
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);

            // Anexar o PDF
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(pdfContent, "application/pdf")));
            attachmentBodyPart.setFileName("EDDZ.pdf");
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            // Enviar o email
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
