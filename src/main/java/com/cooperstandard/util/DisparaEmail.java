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

public class DisparaEmail {

    public String Email(String perfil, String bpcs, String linha, String enviar, String scrapkg, String scrapm, String scrapr,
            String data_plano, String problema, String causa, String observacao, String responsavel, String participantes, String acao, int prioridade, String data_problema) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.ssl.trust", "SMTPVAR.csaid.cooperintra.ctb");
        props.put("mail.smtp.socketFactory.port", "25");
//      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kanban@kanban.com", "");
            }
        });
        session.setDebug(false);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ddz@extrusao.com")); //Remetente
            Address[] toUser = null; //Destinatário(s)
            toUser = InternetAddress.parse(enviar);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Tomada de ação - '" + linha + "'");//Assunto
            message.setContent("<center><p style=\"font-size:2em;\">Tomada de ação DDZ</p></center>"
                    + " Perfil:<font color=\"green\">&nbsp<b>" + perfil + "  - " + bpcs + "</font> &nbsp &nbsp &nbsp &nbsp</b><br/></font>"
                    + " Responsável:<font color=\"green\">&nbsp<b>" + responsavel + "</font></b><br/>"
                    + "<table border=\"1\">"
                    + "<tr>"
                    + "<th>Problema</th>"
                    + "<th>Causa</th>"
                    + "<th>Observação</th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + problema + "</td>"
                    + "<td>" + causa + "</td>"
                    + "<td>" + observacao + "</td>"
                    + "</tr>"
                    + "</table>"
                    + "<br/>"
                    + "<b> Detalhes:"
                    + "<table border=\"1\">"
                    + "<th>Plano</th>"
                    + "<th>Scrap KG</th>"
                    + "<th>Scrap m</th>"
                    + "<th>Scrap R$</th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + data_plano + "</td>"
                    + "<td>" + scrapkg + "</td>"
                    + "<td>" + scrapm + "</td>"
                    + "<td>" + scrapr + "</td>"
                    + "</tr>"
                    + "</table>"
                    + "<br/>"
                    + "<b> Ação:"
                    + "<table border=\"1\">"
                    + "<tr>"
                    + "<th>Solução</th>"
                    + "<th>Prioridade</th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + acao + "</td>"
                    + "<td>" + prioridade + "</td>"
                    + "</tr>"
                    + "</table>"
                    + "</b>"
                    + "Participantes:<font color=\"green\">&nbsp<b><u>" + participantes + "</b></u></font> &nbsp &nbsp &nbsp &nbsp Data do problema:<font color=\"green\">&nbsp<b>" + data_problema + "<br/><br/>"
                    + " <a href=\"L:\\E.P.E\\Sistema de Documentacao\\FichaControle.jar\">Clique aqui</a> &nbsp para acessar o sistema",
                    "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
