package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class ResponsavelPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "evento")
    private int evento;
    @Basic(optional = false)
    @Column(name = "cliente")
    private int cliente;

    public ResponsavelPK() {
    }

    public ResponsavelPK(int evento, int cliente) {
        this.evento = evento;
        this.cliente = cliente;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evento;
        hash += (int) cliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsavelPK)) {
            return false;
        }
        ResponsavelPK other = (ResponsavelPK) object;
        if (this.evento != other.evento) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.ResponsavelPK[ evento=" + evento + ", cliente=" + cliente + " ]";
    }

}
