package br.com.is.DAO;

import br.com.is.Entitys.Equipe;
import br.com.is.Entitys.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ServicoDAO extends Generico<Object> {

    public ServicoDAO(Object obj) {
        super(obj);
    }

    public void PopulaTabela(JTable tabela, Equipe equipe) {
        Object[][] dadosTabela = null;
        List<QueryCriteria> criterio = new ArrayList<QueryCriteria>();
        criterio.add(new QueryCriteria("node", "equipe", "eq"));
        criterio.add(new QueryCriteria("equal", "eq.codigo", String.valueOf(equipe.getCodigo())));
        List resultQuery = Listar(criterio);
        // cabecalho da tabela
        Object[] cabecalho = {"Código", "Nome", "Valor"};

        // cria matriz de acordo com nº de registros da tabela
        try {
            dadosTabela = new Object[resultQuery.size()][cabecalho.length];
        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX1: " + e);
        }

        // efetua consulta na tabela
        try {
            int row = 0;
            for (Object o : resultQuery) {
                Servico s = (Servico) o;
                dadosTabela[row][0] = s.getCodigo();
                dadosTabela[row][1] = s.getTitulo();
                dadosTabela[row][2] = "R$ " + s.getValor();
                row++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(
                new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column
            ) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column
            ) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        }
        );

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(
                0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0;
                i < tabela.getColumnCount();
                i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }

}
