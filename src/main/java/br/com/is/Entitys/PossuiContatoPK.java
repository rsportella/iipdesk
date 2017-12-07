package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class PossuiContatoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cliente")
    private int cliente;
    @Basic(optional = false)
    @Column(name = "contato")
    private int contato;

    public PossuiContatoPK() {
    }

    public PossuiContatoPK(int cliente, int contato) {
        this.cliente = cliente;
        this.contato = contato;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cliente;
        hash += (int) contato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiContatoPK)) {
            return false;
        }
        PossuiContatoPK other = (PossuiContatoPK) object;
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.contato != other.contato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.PossuiContatoPK[ cliente=" + cliente + ", contato=" + contato + " ]";
    }

}
