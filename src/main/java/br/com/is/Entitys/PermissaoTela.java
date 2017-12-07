package br.com.is.Entitys;

import java.util.ArrayList;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class PermissaoTela {

    public class Campo {

        private String descricao;
        private Boolean permissao;

        public Campo(String descricao, Boolean permissao) {
            this.descricao = descricao;
            this.permissao = permissao;
        }

        public String getDescricao() {
            return descricao;
        }

        public Boolean getPermissao() {
            return permissao;
        }
    }

    private String tela;
    private ArrayList<Campo> camposTela;

    public PermissaoTela(String tela) {
        this.tela = tela;
        camposTela = new ArrayList<>();
    }

    public void addCampo(String descricao, Boolean permissao) {
        this.camposTela.add(new Campo(descricao, permissao));
    }

    public ArrayList<Campo> getCamposTela() {
        return camposTela;
    }

    @Override
    public String toString() {
        return "PermissaoTela{" + "tela=" + tela + ", camposTela=" + camposTela + '}';
    }

    public String getTela() {
        return tela;
    }

}
