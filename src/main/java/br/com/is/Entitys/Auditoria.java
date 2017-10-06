package br.com.is.Entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByCodigo", query = "SELECT a FROM Auditoria a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Auditoria.findByAcontecimento", query = "SELECT a FROM Auditoria a WHERE a.acontecimento = :acontecimento")
    , @NamedQuery(name = "Auditoria.findBySql", query = "SELECT a FROM Auditoria a WHERE a.sql = :sql")
    , @NamedQuery(name = "Auditoria.findByObservacoes", query = "SELECT a FROM Auditoria a WHERE a.observacoes = :observacoes")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "acontecimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acontecimento;
    @Column(name = "sql")
    private String sql;
    @Basic(optional = false)
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "tela", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Tela tela;
    @JoinColumn(name = "usuario", referencedColumnName = "pessoa")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Auditoria() {
    }

    public Auditoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Auditoria(Integer codigo, Date acontecimento, String observacoes) {
        this.codigo = codigo;
        this.acontecimento = acontecimento;
        this.observacoes = observacoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getAcontecimento() {
        return acontecimento;
    }

    public void setAcontecimento(Date acontecimento) {
        this.acontecimento = acontecimento;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Auditoria[ codigo=" + codigo + " ]";
    }

}
