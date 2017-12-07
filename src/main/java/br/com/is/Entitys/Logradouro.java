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
@Table(name = "logradouro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouro.findAll", query = "SELECT l FROM Logradouro l")
    , @NamedQuery(name = "Logradouro.findByCodigo", query = "SELECT l FROM Logradouro l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "Logradouro.findByNome", query = "SELECT l FROM Logradouro l WHERE l.nome = :nome")
    , @NamedQuery(name = "Logradouro.findBySigla", query = "SELECT l FROM Logradouro l WHERE l.sigla = :sigla")
    , @NamedQuery(name = "Logradouro.findByStatus", query = "SELECT l FROM Logradouro l WHERE l.status = :status")
    , @NamedQuery(name = "Logradouro.findByAtivo", query = "SELECT l FROM Logradouro l WHERE l.ativo = :ativo")})
public class Logradouro implements Serializable {

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
    @Column(name = "status")
    private Boolean status;
    @Column(name = "ativo")
    private Boolean ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logradouro")
    private Collection<Endereco> enderecoCollection;

    public Logradouro() {
    }

    public Logradouro(Integer codigo) {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
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
        if (!(object instanceof Logradouro)) {
            return false;
        }
        Logradouro other = (Logradouro) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Logradouro[ codigo=" + codigo + " ]";
    }

}
