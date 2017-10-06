package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "permissoes_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissoesView.findAll", query = "SELECT p FROM PermissoesView p")
    , @NamedQuery(name = "PermissoesView.findByCampoDescricao", query = "SELECT p FROM PermissoesView p WHERE p.campoDescricao = :campoDescricao")
    , @NamedQuery(name = "PermissoesView.findByDiretivaCodigo", query = "SELECT p FROM PermissoesView p WHERE p.diretivaCodigo = :diretivaCodigo")
    , @NamedQuery(name = "PermissoesView.findByTelaDescricao", query = "SELECT p FROM PermissoesView p WHERE p.telaDescricao = :telaDescricao")
    , @NamedQuery(name = "PermissoesView.findByPermissaoStatus", query = "SELECT p FROM PermissoesView p WHERE p.permissaoStatus = :permissaoStatus")})
public class PermissoesView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "campo_descricao")
    private String campoDescricao;
    @Column(name = "diretiva_codigo")
    @Id
    private Integer diretivaCodigo;
    @Column(name = "tela_descricao")
    private String telaDescricao;
    @Column(name = "permissao_status")
    private Boolean permissaoStatus;

    public PermissoesView() {
    }

    public String getCampoDescricao() {
        return campoDescricao;
    }

    public void setCampoDescricao(String campoDescricao) {
        this.campoDescricao = campoDescricao;
    }

    public Integer getDiretivaCodigo() {
        return diretivaCodigo;
    }

    public void setDiretivaCodigo(Integer diretivaCodigo) {
        this.diretivaCodigo = diretivaCodigo;
    }

    public String getTelaDescricao() {
        return telaDescricao;
    }

    public void setTelaDescricao(String telaDescricao) {
        this.telaDescricao = telaDescricao;
    }

    public Boolean getPermissaoStatus() {
        return permissaoStatus;
    }

    public void setPermissaoStatus(Boolean permissaoStatus) {
        this.permissaoStatus = permissaoStatus;
    }

}
