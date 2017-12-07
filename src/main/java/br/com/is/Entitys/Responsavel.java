package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "responsavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsavel.findAll", query = "SELECT r FROM Responsavel r")
    , @NamedQuery(name = "Responsavel.findByEvento", query = "SELECT r FROM Responsavel r WHERE r.responsavelPK.evento = :evento")
    , @NamedQuery(name = "Responsavel.findByCliente", query = "SELECT r FROM Responsavel r WHERE r.responsavelPK.cliente = :cliente")
    , @NamedQuery(name = "Responsavel.findByTipo", query = "SELECT r FROM Responsavel r WHERE r.tipo = :tipo")})
public class Responsavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsavelPK responsavelPK;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "evento", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento1;
    @JoinColumn(name = "cliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Responsavel() {
    }

    public Responsavel(ResponsavelPK responsavelPK) {
        this.responsavelPK = responsavelPK;
    }

    public Responsavel(int evento, int cliente) {
        this.responsavelPK = new ResponsavelPK(evento, cliente);
    }

    public ResponsavelPK getResponsavelPK() {
        return responsavelPK;
    }

    public void setResponsavelPK(ResponsavelPK responsavelPK) {
        this.responsavelPK = responsavelPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsavelPK != null ? responsavelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsavel)) {
            return false;
        }
        Responsavel other = (Responsavel) object;
        if ((this.responsavelPK == null && other.responsavelPK != null) || (this.responsavelPK != null && !this.responsavelPK.equals(other.responsavelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Responsavel[ responsavelPK=" + responsavelPK + " ]";
    }

}
