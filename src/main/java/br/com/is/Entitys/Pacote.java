package br.com.is.Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pacote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacote.findAll", query = "SELECT p FROM Pacote p")
    , @NamedQuery(name = "Pacote.findByCodigo", query = "SELECT p FROM Pacote p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pacote.findByTitulo", query = "SELECT p FROM Pacote p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Pacote.findByDescricao", query = "SELECT p FROM Pacote p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Pacote.findByDescobnto", query = "SELECT p FROM Pacote p WHERE p.descobnto = :descobnto")})
public class Pacote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descobnto")
    private BigDecimal descobnto;

    public Pacote() {
    }

    public Pacote(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public BigDecimal getDescobnto() {
        return descobnto;
    }

    public void setDescobnto(BigDecimal descobnto) {
        this.descobnto = descobnto;
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
        if (!(object instanceof Pacote)) {
            return false;
        }
        Pacote other = (Pacote) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Pacote[ codigo=" + codigo + " ]";
    }

}
