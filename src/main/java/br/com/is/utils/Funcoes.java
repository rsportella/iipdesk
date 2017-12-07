package br.com.is.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class Funcoes {

    public static TreeMap geraParcelas(Date dataInicial, BigDecimal valorTotal, int qntParcelas) {
        BigDecimal valorParcela = valorTotal;
        BigDecimal parcela = new BigDecimal(qntParcelas);
        BigDecimal valorRestante = valorParcela;
        TreeMap<Date, BigDecimal> parcelas = new TreeMap<Date, BigDecimal>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInicial);
        cal.add(Calendar.MONTH, 1);
        cal.setTime(dataInicial);

        for (int i = qntParcelas; i > 0; i--) {
            cal.setTime(cal.getTime());

            BigDecimal restante = new BigDecimal(i);

            valorParcela = valorRestante.divide(restante, MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
            valorRestante = valorRestante.subtract(valorParcela);

            parcelas.put(cal.getTime(), valorParcela);

            cal.add(Calendar.MONTH, 1);

        }
        return parcelas;
    }
}
