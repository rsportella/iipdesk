package br.com.is.Entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByPessoa", query = "SELECT u FROM Usuario u WHERE u.pessoa = :pessoa")
    , @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByUltimoAcesso", query = "SELECT u FROM Usuario u WHERE u.ultimoAcesso = :ultimoAcesso")
    , @NamedQuery(name = "Usuario.findByStatus", query = "SELECT u FROM Usuario u WHERE u.status = :status")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa")
    private Integer pessoa;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "ultimo_acesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcesso;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "pessoa", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa1;

    public Usuario() {
    }

    public Usuario(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public Usuario(Integer pessoa, String login) {
        this.pessoa = pessoa;
        this.login = login;
    }

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Pessoa getPessoa1() {
        return pessoa1;
    }

    public void setPessoa1(Pessoa pessoa1) {
        this.pessoa1 = pessoa1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoa != null ? pessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.pessoa == null && other.pessoa != null) || (this.pessoa != null && !this.pessoa.equals(other.pessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Usuario[ pessoa=" + pessoa + " ]";
    }

}
