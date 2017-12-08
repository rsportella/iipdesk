/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.is.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Grafico extends ApplicationFrame {

    int parametro = 0;
    static String titulo;
    static TreeMap<String, Integer> dados;

    public void windowClosed(WindowEvent e) {
        System.out.println("Fechado!!!");
    }

    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    private static final long serialVersionUID = 1L;

    public Grafico(String titulo, TreeMap<String, Integer> dados) {
        super(null);
        this.titulo = titulo;
        this.dados = dados;
        this.setTitle(titulo);
        this.parametro = parametro;
        JPanel jpanel = PanelDemostracao();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static PieDataset GeraDados() {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        for (String dado : dados.keySet()) {
            defaultpiedataset.setValue(dado, dados.get(dado));
        }
        return defaultpiedataset;
    }

    private static JFreeChart criaGrafico(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart(
                titulo, piedataset, true, true, false);
        PiePlot plotagem = (PiePlot) jfreechart.getPlot();
        plotagem.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0} ({2})"));//define porcentagem no gráfico
        plotagem.setLabelBackgroundPaint(new Color(220, 220, 220));
        return jfreechart;
    }

    public static JPanel PanelDemostracao() {
        JFreeChart jfreechart = criaGrafico(GeraDados());
        return new ChartPanel(jfreechart);
    }

    public static void gerarGrafico(String titulo, TreeMap<String, Integer> dados) {
        Grafico grafico = new Grafico(titulo, dados);
        grafico.pack();
        RefineryUtilities.centerFrameOnScreen(grafico);
        grafico.setVisible(true);
    }
}
