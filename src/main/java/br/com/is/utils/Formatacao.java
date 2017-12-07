package br.com.is.utils;

import java.math.BigDecimal;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.*;

public class Formatacao {

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    static String forDtEUA = "yyyy-MM-dd";
    static String forDtBR = "dd/MM/yyyy";
    static String forHr = "hh:mm";

    public static JFormattedTextField getFormatado(String formato) {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();

        format.setPlaceholderCharacter('_');
        format.setValueContainsLiteralCharacters(false);

        try {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return campoFormatado;
    }

    public static void formatarDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }


    public static JFormattedTextField getTelefone() {
        return getFormatado("(##) ####-####");
    }

    public static JFormattedTextField getCNPJ() {
        return getFormatado("##.###.###/####-##");
    }

    public static JFormattedTextField getCPF() {
        return getFormatado("###.###.###-##");
    }

    public static JFormattedTextField getData() {
        return getFormatado("##/##/####");
    }

    public static JFormattedTextField getCep() {
        return getFormatado("######-###");
    }

    public void formatoDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static void reformatarMonetario(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("R$ ##.###,##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarHora(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("##:##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarData(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("##/##/####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarSigla(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("**");
            m.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarCpf(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("###.###.###-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarCnpj(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("##.###.###/####-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarCep(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("######-###");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarTelefone(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter('_');
            m.setMask("(##)####-####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static Date dataSql(String data) throws ParseException {
        try {
            Date dataAMD = new SimpleDateFormat(forDtEUA).parse(data);
            return dataAMD;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            Date dataAMD = new SimpleDateFormat(forDtEUA).parse(data);
            dataFormatada = new SimpleDateFormat(forDtBR).format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String ajustaDataAMD(String data) {
        String dataFormatada = null;
        try {
            Date dataDMA = new SimpleDateFormat(forDtBR).parse(data);
            dataFormatada = new SimpleDateFormat(forDtEUA).format(dataDMA);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static java.sql.Date formataDataSql(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public static String removerFormatacao(String dado) {
        String retorno = "";
        for (int i = 0; i < dado.length(); i++) {
            if (dado.charAt(i) != '.' && dado.charAt(i) != '_' && dado.charAt(i) != '/' && dado.charAt(i) != '-') {
                retorno = retorno + dado.charAt(i);
            }
        }
        return (retorno);
    }

    public static String getDataAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat(forDtBR);
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static String getDataHoraAtual() {
        String data, hora;
        java.util.Date agora = new java.util.Date();

        SimpleDateFormat formata = new SimpleDateFormat(forDtBR);
        data = formata.format(agora);

        formata = new SimpleDateFormat(forHr);
        hora = formata.format(agora);

        return data + " " + hora;
    }
}
