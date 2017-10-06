package br.com.is.DAO;

import br.com.is.Entitys.Permissao;
import br.com.is.Entitys.PermissaoTela;
import br.com.is.Entitys.Tela;
import static br.com.is.View.Login.permissoes;
import static br.com.is.View.Login.usuarioLogado;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class GerenciarPermissao {

    public static List directPermissions() {
        List<PermissaoTela> pt = new ArrayList<>();

        List<Tela> telaQuery = new GenericoDAO<Tela>(new Tela()).Listar(null);

        for (Tela t : telaQuery) {
            PermissaoTela permissaoTela = new PermissaoTela(t.getDescricao());
            String[][] criterio = {
                {"node", "usuario1", "us"},
                {"node", "us.pessoa1", "pe"},
                {"node", "diretiva1", "di"},
                {"node", "di.campo", "ca"},
                {"node", "di.tela", "te"},
                {"equal", "te.codigo", String.valueOf(t.getCodigo())},
                {"equal", "pe.codigo", String.valueOf(usuarioLogado.getPessoa1().getCodigo())}
            };
            List<Permissao> CampoQuery = new GenericoDAO<Permissao>(new Permissao()).Listar(criterio);
            for (Permissao cDiretiva : CampoQuery) {
                permissaoTela.addCampo(cDiretiva.getDiretiva1().getCampo().getDescricao(), cDiretiva.getStatus());
            }
            pt.add(permissaoTela);
        }
        return pt;
    }

    public static PermissaoTela searchComponents(String tela) {
        PermissaoTela telAtual = null;
        for (PermissaoTela perTela : permissoes) {
            if (perTela.getTela().equals(tela)) {
                telAtual = perTela;
            }
        }
        return telAtual;
    }

    public static void sweepComponents(Container container, String tela) {
        if (searchComponents(tela) != null) {
            for (Component com : container.getComponents()) {
                if (com.getName() != null) {
                    for (PermissaoTela.Campo campo : searchComponents(tela).getCamposTela()) {
                        if (com.getName().equals(campo.getDescricao())) {
                            System.out.println(com.getName() + " - " + campo.getPermissao());
                            boolean permissao = ((campo.getPermissao() == null) ? false : campo.getPermissao());
                            com.setEnabled(campo.getPermissao());
                        }
                    }
                }
            }
        }
    }

}
