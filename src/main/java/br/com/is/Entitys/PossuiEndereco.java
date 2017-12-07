package br.com.is.Entitys;

import java.io.Serializable;
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
@Table(name = "possui_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PossuiEndereco.findAll", query = "SELECT p FROM PossuiEndereco p")
    , @NamedQuery(name = "PossuiEndereco.findByCliente", query = "SELECT p FROM PossuiEndereco p WHERE p.possuiEnderecoPK.cliente = :cliente")
    , @NamedQuery(name = "PossuiEndereco.findByEndereco", query = "SELECT p FROM PossuiEndereco p WHERE p.possuiEnderecoPK.endereco = :endereco")})
public class PossuiEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossuiEnderecoPK possuiEnderecoPK;
    @JoinColumn(name = "endereco", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Endereco endereco1;
    @JoinColumn(name = "cliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "tipoendereco", referencedColumnName = "codigo")
    @ManyToOne(optional = true)
    private TipoEndereco tipoendereco;

    public PossuiEndereco() {
    }

    public PossuiEndereco(PossuiEnderecoPK possuiEnderecoPK) {
        this.possuiEnderecoPK = possuiEnderecoPK;
    }

    public PossuiEndereco(int cliente, int endereco) {
        this.possuiEnderecoPK = new PossuiEnderecoPK(cliente, endereco);
    }

    public PossuiEnderecoPK getPossuiEnderecoPK() {
        return possuiEnderecoPK;
    }

    public void setPossuiEnderecoPK(PossuiEnderecoPK possuiEnderecoPK) {
        this.possuiEnderecoPK = possuiEnderecoPK;
    }

    public Endereco getEndereco1() {
        return endereco1;
    }

    public void setEndereco1(Endereco endereco1) {
        this.endereco1 = endereco1;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possuiEnderecoPK != null ? possuiEnderecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossuiEndereco)) {
            return false;
        }
        PossuiEndereco other = (PossuiEndereco) object;
        if ((this.possuiEnderecoPK == null && other.possuiEnderecoPK != null) || (this.possuiEnderecoPK != null && !this.possuiEnderecoPK.equals(other.possuiEnderecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.PossuiEndereco[ possuiEnderecoPK=" + possuiEnderecoPK + " ]";
    }

}
