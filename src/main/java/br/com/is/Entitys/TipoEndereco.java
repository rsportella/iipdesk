package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "tipo_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEndereco.findAll", query = "SELECT t FROM TipoEndereco t")
    , @NamedQuery(name = "TipoEndereco.findByCodigo", query = "SELECT t FROM TipoEndereco t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoEndereco.findByNome", query = "SELECT t FROM TipoEndereco t WHERE t.nome = :nome")
    , @NamedQuery(name = "TipoEndereco.findBySigla", query = "SELECT t FROM TipoEndereco t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "TipoEndereco.findByDescricao", query = "SELECT t FROM TipoEndereco t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TipoEndereco.findByStatus", query = "SELECT t FROM TipoEndereco t WHERE t.status = :status")})
public class TipoEndereco implements Serializable {

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
    private Character status;

    public TipoEndereco() {
    }

    public TipoEndereco(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoEndereco(Integer codigo, Character status) {
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
        if (!(object instanceof TipoEndereco)) {
            return false;
        }
        TipoEndereco other = (TipoEndereco) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.TipoEndereco[ codigo=" + codigo + " ]";
    }

}
