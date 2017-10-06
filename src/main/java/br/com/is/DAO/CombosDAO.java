package DAO;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import utils.ComboItens;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;
    ComboItens item;

    public void popularCombo(String campo, JComboBox combo) {
        combo.removeAllItems();
        item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione um " + campo + "!");
        combo.addItem(item);
    }

    public void definirItemCombo(JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
