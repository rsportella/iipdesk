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
@Table(name = "sub_tipo_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubTipoEvento.findAll", query = "SELECT s FROM SubTipoEvento s")
    , @NamedQuery(name = "SubTipoEvento.findByCodigo", query = "SELECT s FROM SubTipoEvento s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "SubTipoEvento.findByTipoEvento", query = "SELECT s FROM SubTipoEvento s WHERE s.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "SubTipoEvento.findByTitulo", query = "SELECT s FROM SubTipoEvento s WHERE s.titulo = :titulo")
    , @NamedQuery(name = "SubTipoEvento.findByDescricao", query = "SELECT s FROM SubTipoEvento s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "SubTipoEvento.findByStatus", query = "SELECT s FROM SubTipoEvento s WHERE s.status = :status")})
public class SubTipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipo_evento")
    private int tipoEvento;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subTipoEvento1")
    private Collection<Realizacao> realizacaoCollection;

    public SubTipoEvento() {
    }

    public SubTipoEvento(Integer codigo) {
        this.codigo = codigo;
    }

    public SubTipoEvento(Integer codigo, int tipoEvento, boolean status) {
        this.codigo = codigo;
        this.tipoEvento = tipoEvento;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    public Collection<Realizacao> getRealizacaoCollection() {
        return realizacaoCollection;
    }

    public void setRealizacaoCollection(Collection<Realizacao> realizacaoCollection) {
        this.realizacaoCollection = realizacaoCollection;
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
        if (!(object instanceof SubTipoEvento)) {
            return false;
        }
        SubTipoEvento other = (SubTipoEvento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.SubTipoEvento[ codigo=" + codigo + " ]";
    }

}
