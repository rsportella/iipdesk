package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "possui_contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PossuiContato.findAll", query = "SELECT p FROM PossuiContato p")
    , @NamedQuery(name = "PossuiContato.findByCliente", query = "SELECT p FROM PossuiContato p WHERE p.possuiContatoPK.cliente = :cliente")
    , @NamedQuery(name = "PossuiContato.findByContato", query = "SELECT p FROM PossuiContato p WHERE p.possuiContatoPK.contato = :contato")
    , @NamedQuery(name = "PossuiContato.findByStatus", query = "SELECT p FROM PossuiContato p WHERE p.status = :status")})
public class PossuiContato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossuiContatoPK possuiContatoPK;
    @Basic(optional = true)
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "contato", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contato contato1;
    @JoinColumn(name = "cliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "tipo_contato", referencedColumnName = "codigo")
    @ManyToOne(optional = true)
    private TipoContato tipoContato;

    public PossuiContato() {
    }

    public PossuiContato(PossuiContatoPK possuiContatoPK) {
        this.possuiContatoPK = possuiContatoPK;
    }

    public PossuiContato(PossuiContatoPK possuiContatoPK, Character status) {
        this.possuiContatoPK = possuiContatoPK;
        this.status = status;
    }

    public PossuiContato(int cliente, int contato) {
        this.possuiContatoPK = new PossuiContatoPK(cliente, contato);
    }

    public PossuiContatoPK getPossuiContatoPK() {
        return possuiContatoPK;
    }

    public void setPossuiContatoPK(PossuiContatoPK possuiContatoPK) {
        this.possuiContatoPK = possuiContatoPK;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Contato getContato1() {
        return contato1;
    }

    public void setContato1(Contato contato1) {
        this.contato1 = contato1;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possuiContatoPK != null ? possuiContatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiContato)) {
            return false;
        }
        PossuiContato other = (PossuiContato) object;
        if ((this.possuiContatoPK == null && other.possuiContatoPK != null) || (this.possuiContatoPK != null && !this.possuiContatoPK.equals(other.possuiContatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PossuiContato{" + "possuiContatoPK=" + possuiContatoPK + ", status=" + status + ", contato1=" + contato1 + ", pessoa=" + pessoa + ", tipoContato=" + tipoContato + '}';
    }

}
