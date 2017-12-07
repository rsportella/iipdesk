package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class RealizacaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "evento")
    private int evento;
    @Basic(optional = false)
    @Column(name = "endereco")
    private int endereco;
    @Basic(optional = false)
    @Column(name = "sub_tipo_evento")
    private int subTipoEvento;

    public RealizacaoPK() {
    }

    public RealizacaoPK(int evento, int endereco, int subTipoEvento) {
        this.evento = evento;
        this.endereco = endereco;
        this.subTipoEvento = subTipoEvento;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getSubTipoEvento() {
        return subTipoEvento;
    }

    public void setSubTipoEvento(int subTipoEvento) {
        this.subTipoEvento = subTipoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evento;
        hash += (int) endereco;
        hash += (int) subTipoEvento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RealizacaoPK)) {
            return false;
        }
        RealizacaoPK other = (RealizacaoPK) object;
        if (this.evento != other.evento) {
            return false;
        }
        if (this.endereco != other.endereco) {
            return false;
        }
        if (this.subTipoEvento != other.subTipoEvento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.RealizacaoPK[ evento=" + evento + ", endereco=" + endereco + ", subTipoEvento=" + subTipoEvento + " ]";
    }

}
