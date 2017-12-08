package br.com.is.iipdesk;

import br.com.is.utils.ConexaoBD;
import static br.com.is.utils.Funcoes.geraParcelas;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class teste {

    public static void main(String[] args) {
        try {
            File arq = new File("C:\\Projeto\\news\\iipdesk\\src\\main\\java\\br\\com\\is\\View\\report\\report1.jrxml");
            JasperReport relatorio = JasperCompileManager.compileReport(arq.getPath());
            Map parametros = new HashMap();
            parametros.put("evento", 4);
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }
}
