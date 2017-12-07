package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class ServicoPertenceEventoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "evento")
    private int evento;
    @Basic(optional = false)
    @Column(name = "servico")
    private int servico;

    public ServicoPertenceEventoPK() {
    }

    public ServicoPertenceEventoPK(int evento, int servico) {
        this.evento = evento;
        this.servico = servico;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evento;
        hash += (int) servico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoPertenceEventoPK)) {
            return false;
        }
        ServicoPertenceEventoPK other = (ServicoPertenceEventoPK) object;
        if (this.evento != other.evento) {
            return false;
        }
        if (this.servico != other.servico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.ServicoPertenceEventoPK[ evento=" + evento + ", servico=" + servico + " ]";
    }

}
