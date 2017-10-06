package br.com.is.Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Embeddable
public class PermissaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario")
    private int usuario;
    @Basic(optional = false)
    @Column(name = "diretiva")
    private int diretiva;

    public PermissaoPK() {
    }

    public PermissaoPK(int usuario, int diretiva) {
        this.usuario = usuario;
        this.diretiva = diretiva;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getDiretiva() {
        return diretiva;
    }

    public void setDiretiva(int diretiva) {
        this.diretiva = diretiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuario;
        hash += (int) diretiva;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissaoPK)) {
            return false;
        }
        PermissaoPK other = (PermissaoPK) object;
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.diretiva != other.diretiva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.PermissaoPK[ usuario=" + usuario + ", diretiva=" + diretiva + " ]";
    }

}
