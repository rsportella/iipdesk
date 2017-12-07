package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
    , @NamedQuery(name = "Permissao.findByUsuario", query = "SELECT p FROM Permissao p WHERE p.permissaoPK.usuario = :usuario")
    , @NamedQuery(name = "Permissao.findByDiretiva", query = "SELECT p FROM Permissao p WHERE p.permissaoPK.diretiva = :diretiva")
    , @NamedQuery(name = "Permissao.findByStatus", query = "SELECT p FROM Permissao p WHERE p.status = :status")})
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermissaoPK permissaoPK;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "diretiva", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diretiva diretiva1;
    @JoinColumn(name = "usuario", referencedColumnName = "pessoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Permissao() {
    }

    public Permissao(PermissaoPK permissaoPK) {
        this.permissaoPK = permissaoPK;
    }

    public Permissao(PermissaoPK permissaoPK, boolean status) {
        this.permissaoPK = permissaoPK;
        this.status = status;
    }

    public Permissao(int usuario, int diretiva) {
        this.permissaoPK = new PermissaoPK(usuario, diretiva);
    }

    public PermissaoPK getPermissaoPK() {
        return permissaoPK;
    }

    public void setPermissaoPK(PermissaoPK permissaoPK) {
        this.permissaoPK = permissaoPK;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Diretiva getDiretiva1() {
        return diretiva1;
    }

    public void setDiretiva1(Diretiva diretiva1) {
        this.diretiva1 = diretiva1;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissaoPK != null ? permissaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.permissaoPK == null && other.permissaoPK != null) || (this.permissaoPK != null && !this.permissaoPK.equals(other.permissaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Permissao[ permissaoPK=" + permissaoPK + " ]";
    }

}
