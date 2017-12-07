package br.com.is.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class Layouts {

    public static String setData(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(data);
        return dataFormatada;
    }

    public static String setDataHora(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = formatador.format(data);
        return dataFormatada;
    }

    public static String setMonetario(BigDecimal valor) {
        NumberFormat moeda = NumberFormat.getNumberInstance();
        moeda.setMinimumFractionDigits(2);
        return moeda.format(valor);
    }

    public static String setCpf(String cpf) {
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(3, 6);
        String bloco3 = cpf.substring(6, 9);
        String bloco4 = cpf.substring(9, 11);
        return bloco1 + "." + bloco2 + "." + bloco3 + "-" + bloco4;
    }
}
