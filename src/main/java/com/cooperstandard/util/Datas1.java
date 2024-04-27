/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tiago.teixeira
 */
public abstract class Datas1 {

    private static final SimpleDateFormat DAY = new SimpleDateFormat("dd");
    private static final SimpleDateFormat MONTH = new SimpleDateFormat("MM");
    private static final SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat DATE = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DATETIME = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S");

    public static String calcularIdade(String dataNascimento) {
        Date dataAtual = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        Format format = new SimpleDateFormat("MM");
        BigDecimal temp;
        String strData[];

        strData = dataNascimento.split("/");
        Integer anoNascimento = Integer.parseInt(strData[2]);

        if ((Integer.parseInt(format.format(c.getTime())) + 1) > Integer.parseInt(strData[1])) {
            BigDecimal anoAtual = new BigDecimal(Year.now().toString());
            temp = anoAtual.subtract(new BigDecimal(anoNascimento));
            return temp.toString();
        } else {
            BigDecimal anoAtual = new BigDecimal(Year.now().toString());
            anoAtual = anoAtual.subtract(new BigDecimal("1"));
            temp = anoAtual.subtract(new BigDecimal(anoNascimento));
            return temp.toString();
        }
    }

    /**
     * 30a 8m 21d
     * @param data_nascimento
     * @return 
     */
    public static String calcularIdade(LocalDate data_nascimento){
        try {
            String idade = "";
            Period p = data_nascimento.until(LocalDate.now());
            idade = p.getYears() + "a " + p.getMonths() + "m " + p.getDays() + "d";
            return idade;
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * Função que manipula String no formato de hora "HH:mm" facilitando para o
     * usuário no momento da digitação ou retorna a hora atual.
     * <br>
     * Exemplo: <br>
     * Entrada do usuário: 1:12 ou 112<br>
     * Devolve: 01:12<br>
     *
     * @param hora valor do campo de hora
     * @return String Hora Formatada
     * @param solicitacao int <br><b>0</b> para hora atual<br><b>1</b> para
     * manipulação de hora
     */
    public static String getHour(String hora, int solicitacao) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        String[] h = null;
        String resultado = "";

        try {
            //verifica a solicitação do usuário
            if (solicitacao == 0) {
                return f.format(date);
            } else {
                //verifica se a variável passada é nula ou vazia
                if (hora != null || !"".equals(hora)) {
                    //verifica se a variável contêm o ponto de separação
                    if (hora.contains(":")) {
                        h = hora.split(":");
                        //verifica a quantidade de digitos e se a posição do dois pontos
                        resultado = hora.indexOf(":") == 1 ? "0" : "";
                        //loop para setar a variável de saída
                        for (int i = 0; i < h.length; i++) {
                            if (i == 1 && hora.indexOf(":") == 1 && hora.length() == 3 || i == 1 && hora.indexOf(":") == 2 & hora.length() == 4) {
                                resultado += ":0";
                            } else if (i == 1 && hora.length() == 5 && hora.indexOf(":") == 2) {
                                resultado += ":";
                            }
                            resultado += h[i];
                        }
                    } else {
                        char[] letras = hora.toCharArray();
                        resultado = hora.length() == 2 ? "0" : hora.indexOf("0") != 0 && hora.length() == 3 ? "0" : hora.indexOf("0") == 2 && hora.length() == 3 ? "0" : "";
                        for (int i = 0; i < letras.length; i++) {
                            if (hora.length() == 2 && i == 1 && hora.length() < 4) {
                                resultado += ":0";
                            } else if (i == 2 && hora.length() == 3 && hora.indexOf("0") == 0) {
                                resultado += ":0";
                            } else if (i == 2 && hora.length() == 4) {
                                resultado += ":";
                            } else if (i == 1 && letras.length == 3 && hora.indexOf("0") != 0) {
                                resultado += ":";
                            }
                            resultado += String.valueOf(letras[i]);
                        }
                    }
                }
                return verificaHora(resultado) ? resultado : f.format(date);
            }
        } catch (Exception ex) {
            return f.format(date);
        }
    }

    private static boolean verificaHora(String hora) {
        String hm[] = hora.split(":");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        boolean resultado;

        resultado = h >= 0 && h <= 24;
        if (resultado) {
            if (h == 24 && m == 0) {
                resultado = true;
            } else if (h <= 23) {
                resultado = m >= 0 && m <= 59;
            } else {
                resultado = false;
            }
        }

        return resultado;
    }

    /**
     * Função que manipula String no formato de data "dd/MM/yyyy" facilitando
     * para o usuário no momento da digitação ou retorna a data atual.
     * <br>
     * Exemplo: <br>
     * Entrada do usuário: 1/1/15<br>
     * Devolve: 01/01/2015<br>
     *
     * @param data
     * @return String data
     * @param solicitacao int <br><b>0</b> para data atual<br><b>1</b> para
     * manipulação de data
     */
    public static String getDateString(String data, int solicitacao) {

        String temp = "";
        String strData[] = null;
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date x = new Date();

        if (data != null || !"".equals(data) && solicitacao == 1) {
            try {

                if (data.contains("/")) {
                    strData = data.split("/");
                } else {
                    strData = new String[1];
                    strData[0] = "";
                }

                if (strData.length != 3) {
                    if (strData.length == 2) {
                        temp = dinamicDate(strData[0], strData[1], "0");
                    } else {
                        temp = DATE.format(x);
                    }
                } else {
                    temp = dinamicDate(strData[0], strData[1], !"".equals(strData[2]) ? strData[2] : "0");
                }
            } catch (Exception excep) {
                temp = DATE.format(x);
            }
        } else if (solicitacao == 0) {
            temp = DATE.format(x);
        }

        return temp;
    }

    public static String getDateString(Date data) {
        try {
            return DATE.format(data);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDateTimeString(Date data) {
        try {
            return DATETIME.format(data);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Este método converte uma data informada como String em um objeto do tipo
     * Date.
     *
     * @param data String contendo a data no formato "dd/MM/yyyy"
     * @return Objecto do tipo Date
     */
    public static Date getDate(String data) {
        try {
            return DATE.parse(data);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Este método converte uma data informada como String em um objeto do tipo
     * Date.
     *
     * @param data String contendo a data no formato "dd/MM/yyyy HH:mm:ss.S"
     * @return Objecto do tipo Date
     */
    public static Date getDateTime(String data) {
        try {
            return DATETIME.parse(data);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String dinamicDate(String dia, String mes, String ano) {
        return verificarDia(dia) + "/" + verificarMes(mes) + "/" + verificarAno(ano);
    }

    public static String verificarDia(String dia) {
        try {
            String result = "";
            int dia_int = Integer.parseInt(dia);
            if (dia_int > 0 && dia_int < 31) {
                result = dia_int < 10 ? result + "0" + dia_int : result + dia_int;
            } else {
                result = result + "31";
            }
            return result;
        } catch (Exception ex) {
            return MonthDay.now().format(DateTimeFormatter.ofPattern("dd"));
        }
    }

    public static String verificarMes(String mes) {
        try {
            String result = "";
            int mes_int = Integer.parseInt(mes);
            if (mes_int > 0 && mes_int < 13) {
                result = mes_int < 10 ? result + "0" + mes_int : result + mes_int;
            } else {
                result = result + "12";
            }
            return result;
        } catch (Exception ex) {
            return YearMonth.now().format(DateTimeFormatter.ofPattern("MM"));
        }
    }

    public static String verificarAno(String ano) {
        try {
            String result = "";
            int ano_int = Integer.parseInt(ano);
            long ano_atual = Long.parseLong(Year.now().toString());
            String ano_user = ano_int != 0 ? Integer.toString(ano_int) : Year.now().toString();
            long diferenca_atual_user = ano_atual - ano_int;

            if (ano_user.length() > 0 && ano_user.length() == 2) {
                result = diferenca_atual_user >= 2000 ? result + "20" + ano_user : result + "19" + ano_user;
            } else if (ano_user.length() > 0 && ano_user.length() == 1) {
                result = diferenca_atual_user >= 2000 ? result + "200" + ano_user : result + "190" + ano_user;
            } else if (ano_user.length() == 3 || ano_user.length() >= 5) {
                result = result + Year.now().toString();
            } else {
                result = result + ano_user;
            }
            return result;
        } catch (Exception ex) {
            return Year.now().toString();
        }
    }

    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.parse(Datas1.getDateString(date), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static Integer splitDay(Date date) {
        return Integer.valueOf(DAY.format(date));
    }

    public static Integer splitMonth(Date date) {
        return Integer.valueOf(MONTH.format(date));
    }

    public static Integer splitYear(Date date) {
        return Integer.valueOf(YEAR.format(date));
    }

    public static String getMesExtenso(int mes) {
        return getMesExtenso(String.valueOf(mes));
    }

    public static String getMesExtenso(String mes) {
        if (mes != null) {
            switch (mes) {
                case "1":
                case "01":
                    return "Janeiro";
                case "2":
                case "02":
                    return "Fevereiro";
                case "3":
                case "03":
                    return "Março";
                case "4":
                case "04":
                    return "Abril";
                case "5":
                case "05":
                    return "Maio";
                case "6":
                case "06":
                    return "Junho";
                case "7":
                case "07":
                    return "Julho";
                case "8":
                case "08":
                    return "Agosto";
                case "9":
                case "09":
                    return "Setembro";
                case "10":
                    return "Outubro";
                case "11":
                    return "Novembro";
                case "12":
                    return "Dezembro";
            }
        }
        return null;
    }

    public static String getDiaSemanaExtenso(int dia) {
        return getDiaSemanaExtenso(String.valueOf(dia));
    }

    public static String getDiaSemanaExtenso(String dia) {
        switch (dia) {
            case "1":
            case "01":
                return "Segunda-feira";
            case "2":
            case "02":
                return "Terça-feira";
            case "3":
            case "03":
                return "Quarta-feira";
            case "4":
            case "04":
                return "Quinta-feira";
            case "5":
            case "05":
                return "Sexta-feira";
            case "6":
            case "06":
                return "Sábado-feira";
            case "7":
            case "07":
                return "Domingo";
            default:
                return null;
        }
    }

}
