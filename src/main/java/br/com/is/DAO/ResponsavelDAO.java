package br.com.is.DAO;

import br.com.is.Entitys.Responsavel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ResponsavelDAO extends Generico<Object> {
    
    public ResponsavelDAO(Object obj) {
        super(obj);
    }
    
    public void PopulaTabela(JTable tabela, int evento) {
        Object[][] dadosTabela = null;
        List<QueryCriteria> criterios = new ArrayList<QueryCriteria>();
        criterios.add(new QueryCriteria("node", "pessoa", "pe"));
        criterios.add(new QueryCriteria("node", "evento1", "evt"));
        criterios.add(new QueryCriteria("equal", "evt.codigo", String.valueOf(evento)));
        List resultQuery = Listar(criterios);
        // cabecalho da tabela
        Object[] cabecalho = {"Código", "Nome"};

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
                Responsavel s = (Responsavel) o;
                dadosTabela[row][0] = s.getPessoa().getCodigo();
                dadosTabela[row][1] = s.getPessoa().getNome();
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
