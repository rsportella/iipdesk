package br.com.is.Entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "diretiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diretiva.findAll", query = "SELECT d FROM Diretiva d")
    , @NamedQuery(name = "Diretiva.findByCodigo", query = "SELECT d FROM Diretiva d WHERE d.codigo = :codigo")})
public class Diretiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "campo", referencedColumnName = "codigo")
    @ManyToOne
    private Campo campo;
    @JoinColumn(name = "tela", referencedColumnName = "codigo")
    @ManyToOne
    private Tela tela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diretiva1")
    private Collection<Permissao> permissaoCollection;

    public Diretiva() {
    }

    public Diretiva(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    @XmlTransient
    public Collection<Permissao> getPermissaoCollection() {
        return permissaoCollection;
    }

    public void setPermissaoCollection(Collection<Permissao> permissaoCollection) {
        this.permissaoCollection = permissaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diretiva)) {
            return false;
        }
        Diretiva other = (Diretiva) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Diretiva[ codigo=" + codigo + " ]";
    }

}
