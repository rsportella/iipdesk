package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class PacotePossuiServicoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pacote")
    private int pacote;
    @Basic(optional = false)
    @Column(name = "servico")
    private int servico;

    public PacotePossuiServicoPK() {
    }

    public PacotePossuiServicoPK(int pacote, int servico) {
        this.pacote = pacote;
        this.servico = servico;
    }

    public int getPacote() {
        return pacote;
    }

    public void setPacote(int pacote) {
        this.pacote = pacote;
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
        hash += (int) pacote;
        hash += (int) servico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacotePossuiServicoPK)) {
            return false;
        }
        PacotePossuiServicoPK other = (PacotePossuiServicoPK) object;
        if (this.pacote != other.pacote) {
            return false;
        }
        if (this.servico != other.servico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.PacotePossuiServicoPK[ pacote=" + pacote + ", servico=" + servico + " ]";
    }

}
