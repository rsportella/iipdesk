package br.com.is.Entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "campo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campo.findAll", query = "SELECT c FROM Campo c")
    , @NamedQuery(name = "Campo.findByCodigo", query = "SELECT c FROM Campo c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Campo.findByDescricao", query = "SELECT c FROM Campo c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Campo.findByNome", query = "SELECT c FROM Campo c WHERE c.nome = :nome")})
public class Campo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "campo")
    private Collection<Diretiva> diretivaCollection;

    public Campo() {
    }

    public Campo(Integer codigo) {
        this.codigo = codigo;
    }

    public Campo(Integer codigo, String descricao) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(object instanceof Campo)) {
            return false;
        }
        Campo other = (Campo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Campo[ codigo=" + codigo + " ]";
    }

}
