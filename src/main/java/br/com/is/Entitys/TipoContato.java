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
@Table(name = "tipo_contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContato.findAll", query = "SELECT t FROM TipoContato t")
    , @NamedQuery(name = "TipoContato.findByCodigo", query = "SELECT t FROM TipoContato t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoContato.findByNome", query = "SELECT t FROM TipoContato t WHERE t.nome = :nome")
    , @NamedQuery(name = "TipoContato.findBySigla", query = "SELECT t FROM TipoContato t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "TipoContato.findByDescricao", query = "SELECT t FROM TipoContato t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TipoContato.findByStatus", query = "SELECT t FROM TipoContato t WHERE t.status = :status")})
public class TipoContato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContato")
    private Collection<PossuiContato> possuiContatoCollection;

    public TipoContato() {
    }

    public TipoContato(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoContato(Integer codigo, boolean status) {
        this.codigo = codigo;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<PossuiContato> getPossuiContatoCollection() {
        return possuiContatoCollection;
    }

    public void setPossuiContatoCollection(Collection<PossuiContato> possuiContatoCollection) {
        this.possuiContatoCollection = possuiContatoCollection;
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
        if (!(object instanceof TipoContato)) {
            return false;
        }
        TipoContato other = (TipoContato) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.TipoContato[ codigo=" + codigo + " ]";
    }

}
