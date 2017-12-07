package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class PossuiEnderecoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cliente")
    private int cliente;
    @Basic(optional = false)
    @Column(name = "endereco")
    private int endereco;

    public PossuiEnderecoPK() {
    }

    public PossuiEnderecoPK(int cliente, int endereco) {
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cliente;
        hash += (int) endereco;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiEnderecoPK)) {
            return false;
        }
        PossuiEnderecoPK other = (PossuiEnderecoPK) object;
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.endereco != other.endereco) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.PossuiEnderecoPK[ cliente=" + cliente + ", endereco=" + endereco + " ]";
    }

}
