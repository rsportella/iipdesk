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
@Table(name = "tipo_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t")
    , @NamedQuery(name = "TipoEvento.findByCodigo", query = "SELECT t FROM TipoEvento t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoEvento.findByNome", query = "SELECT t FROM TipoEvento t WHERE t.nome = :nome")
    , @NamedQuery(name = "TipoEvento.findByDescricao", query = "SELECT t FROM TipoEvento t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TipoEvento.findByStatus", query = "SELECT t FROM TipoEvento t WHERE t.status = :status")})
public class TipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "status")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEvento")
    private Collection<Evento> eventoCollection;

    public TipoEvento() {
    }

    public TipoEvento(Integer codigo) {
        this.codigo = codigo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
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
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.TipoEvento[ codigo=" + codigo + " ]";
    }

}
