package br.com.is.DAO;

import br.com.is.Entitys.Diretiva;
import br.com.is.Entitys.Permissao;
import br.com.is.Entitys.PermissaoPK;
import br.com.is.Entitys.Tela;
import br.com.is.Entitys.Usuario;
import br.com.is.utils.ComboItens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PermissaoDAO extends Generico<Object> {
    
    public PermissaoDAO(Object obj) {
        super(obj);
    }
    
    public void PopulaTabela(JTable tabela, int tela, Usuario user) {
        Object[][] dadosTabela = null;
        
        List<QueryCriteria> criterios = new ArrayList<>();
        criterios.add(new QueryCriteria("node", "campo", "c"));
        criterios.add(new QueryCriteria("node", "tela", "t"));
        criterios.add(new QueryCriteria("equal", "t.codigo", String.valueOf(tela)));
        
        List<String> resultQuery = Listar(criterios);
        criterios.removeAll(criterios);
        
        criterios.add(new QueryCriteria("node", "diretiva1", "d"));
        criterios.add(new QueryCriteria("node", "usuario1", "u"));
        criterios.add(new QueryCriteria("node", "d.tela", "t"));
        criterios.add(new QueryCriteria("equal", "t.codigo", String.valueOf(tela)));
        criterios.add(new QueryCriteria("equal", "u.pessoa", String.valueOf(user.getPessoa1().getCodigo())));

        List<String> resultSubQuery = new Generico<Permissao>(new Permissao()).Listar(criterios);

        // cabecalho da tabela
        Object[] cabecalho = {"Código", "Titulo", "Status"};

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
                Diretiva s = (Diretiva) o;
                dadosTabela[row][0] = s.getCodigo();
                dadosTabela[row][1] = s.getCampo().getDescricao();
                boolean achou = false;
                for (Object sq : resultSubQuery) {
                    Permissao p = (Permissao) sq;
                    if (s.getCodigo().equals(p.getDiretiva1().getCodigo())) {
                        dadosTabela[row][2] = p.getStatus();
                        achou = true;
                    }
                }
                if (!achou) {
                    dadosTabela[row][2] = Boolean.FALSE;
                }
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
            public boolean isCellEditable(int row, int column) {
                if (column == 2) {
                    return true;
                }
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {
                if (column == 2) {
                    return Boolean.class;
                }
                return Object.class;
            }
            
            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                super.setValueAt(aValue, rowIndex, columnIndex);
                Permissao per = new Permissao();
                per.setStatus((boolean) aValue);
                per.setPermissaoPK(new PermissaoPK(user.getPessoa1().getCodigo(),
                        (int) getValueAt(rowIndex, 0)));
                new Generico<Permissao>(per).Gravar();
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
    
    public void popularCombo(JComboBox combo) {
        ComboItens item;
        combo.removeAllItems();
        List<Object> resultQuery = Listar(null);
        try {
            if (!resultQuery.isEmpty()) {
                item = new ComboItens();
                item.setCodigo(0);
                item.setDescricao("-- Selecione uma opção --");
                combo.addItem(item);
                for (Object o : resultQuery) {
                    Tela s = (Tela) o;
                    item = new ComboItens();
                    item.setCodigo(s.getCodigo());
                    item.setDescricao(s.getDescricao());
                    combo.addItem(item);
                }
            } else {
                item = new ComboItens();
                item.setCodigo(0);
                item.setDescricao("-- Nenhuma opção cadastrada --");
                combo.addItem(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
}
