package com.cooperstandard.util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DisparaEmailMatrizaria {

    public String Email(String perfil, String linha, String enviar, String matriz, float meta, float m_produzidos) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.ssl.trust", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ddz@extrusao.com", "");
            }
        });
        session.setDebug(false);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ddz@extrusao.com")); //Remetente
            Address[] toUser = null; //Destinatário(s)
            toUser = InternetAddress.parse(enviar);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Revitalização necessária - '" + linha + "' - '" + perfil + "' - '" + matriz + "' ");//Assunto
            message.setContent("<center><p style=\"font-size:2em;\">Revitalização</p></center>"
                    + " Linha:<font color=\"green\">&nbsp<b>" + linha + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + " Perfil:<font color=\"green\">&nbsp<b>" + perfil + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + " Matriz:<font color=\"green\">&nbsp<b>" + matriz + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + "<br/>"
                    + "<b> Detalhes:"
                    + " Meta:<font color=\"red\">&nbsp<b>" + meta + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + " Metros produzidos:<font color=\"green\">&nbsp<b>" + m_produzidos + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + " <a href=\"J:\\Sistema de Documentacao\\FichaControle.jar\">Clique aqui</a> &nbsp para acessar o sistema com mais detalhes.",
                    "text/html; charset=utf-8");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
