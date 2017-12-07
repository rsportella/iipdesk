package br.com.is.utils;

import java.awt.Color;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Grafico {

    static String titulo;
    static TreeMap<String, Integer> dados;

    public Grafico(String titulo, TreeMap<String, Integer> dados) {
        this.titulo = titulo;
        this.dados = dados;
    }

    private static PieDataset GeraDados() {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        for (String dado : dados.keySet()) {
            defaultpiedataset.setValue(dado, dados.get(dado));
        }
        return defaultpiedataset;
    }

    private static JFreeChart criaGrafico(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart(Grafico.titulo, piedataset, true, true, false);
        PiePlot plotagem = (PiePlot) jfreechart.getPlot();
        plotagem.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0} ({2})"));//define porcentagem no gráfico
        plotagem.setLabelBackgroundPaint(new Color(220, 220, 220));
        return jfreechart;
    }

    public static JPanel GraficoPanel() {
        JFreeChart jfreechart = criaGrafico(GeraDados());
        return new ChartPanel(jfreechart);
    }

}
