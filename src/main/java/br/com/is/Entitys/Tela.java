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
@Table(name = "tela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tela.findAll", query = "SELECT t FROM Tela t")
    , @NamedQuery(name = "Tela.findByCodigo", query = "SELECT t FROM Tela t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tela.findByDescricao", query = "SELECT t FROM Tela t WHERE t.descricao = :descricao")})
public class Tela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tela")
    private Collection<Auditoria> auditoriaCollection;
    @OneToMany(mappedBy = "tela")
    private Collection<Diretiva> diretivaCollection;

    public Tela() {
    }

    public Tela(Integer codigo) {
        this.codigo = codigo;
    }

    public Tela(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Auditoria> getAuditoriaCollection() {
        return auditoriaCollection;
    }

    public void setAuditoriaCollection(Collection<Auditoria> auditoriaCollection) {
        this.auditoriaCollection = auditoriaCollection;
    }

    @XmlTransient
    public Collection<Diretiva> getDiretivaCollection() {
        return diretivaCollection;
    }

    public void setDiretivaCollection(Collection<Diretiva> diretivaCollection) {
        this.diretivaCollection = diretivaCollection;
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
        if (!(object instanceof Tela)) {
            return false;
        }
        Tela other = (Tela) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Tela[ codigo=" + codigo + " ]";
    }

}
