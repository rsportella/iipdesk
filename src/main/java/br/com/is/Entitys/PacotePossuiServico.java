package br.com.is.Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "pacote_possui_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacotePossuiServico.findAll", query = "SELECT p FROM PacotePossuiServico p")
    , @NamedQuery(name = "PacotePossuiServico.findByPacote", query = "SELECT p FROM PacotePossuiServico p WHERE p.pacotePossuiServicoPK.pacote = :pacote")
    , @NamedQuery(name = "PacotePossuiServico.findByServico", query = "SELECT p FROM PacotePossuiServico p WHERE p.pacotePossuiServicoPK.servico = :servico")
    , @NamedQuery(name = "PacotePossuiServico.findByValorServico", query = "SELECT p FROM PacotePossuiServico p WHERE p.valorServico = :valorServico")
    , @NamedQuery(name = "PacotePossuiServico.findByPropostaEm", query = "SELECT p FROM PacotePossuiServico p WHERE p.propostaEm = :propostaEm")})
public class PacotePossuiServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacotePossuiServicoPK pacotePossuiServicoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_servico")
    private BigDecimal valorServico;
    @Column(name = "proposta_em")
    @Temporal(TemporalType.DATE)
    private Date propostaEm;
    @JoinColumn(name = "pacote", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipe equipe;
    @JoinColumn(name = "servico", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servico servico1;

    public PacotePossuiServico() {
    }

    public PacotePossuiServico(PacotePossuiServicoPK pacotePossuiServicoPK) {
        this.pacotePossuiServicoPK = pacotePossuiServicoPK;
    }

    public PacotePossuiServico(int pacote, int servico) {
        this.pacotePossuiServicoPK = new PacotePossuiServicoPK(pacote, servico);
    }

    public PacotePossuiServicoPK getPacotePossuiServicoPK() {
        return pacotePossuiServicoPK;
    }

    public void setPacotePossuiServicoPK(PacotePossuiServicoPK pacotePossuiServicoPK) {
        this.pacotePossuiServicoPK = pacotePossuiServicoPK;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public Date getPropostaEm() {
        return propostaEm;
    }

    public void setPropostaEm(Date propostaEm) {
        this.propostaEm = propostaEm;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Servico getServico1() {
        return servico1;
    }

    public void setServico1(Servico servico1) {
        this.servico1 = servico1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacotePossuiServicoPK != null ? pacotePossuiServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacotePossuiServico)) {
            return false;
        }
        PacotePossuiServico other = (PacotePossuiServico) object;
        if ((this.pacotePossuiServicoPK == null && other.pacotePossuiServicoPK != null) || (this.pacotePossuiServicoPK != null && !this.pacotePossuiServicoPK.equals(other.pacotePossuiServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.PacotePossuiServico[ pacotePossuiServicoPK=" + pacotePossuiServicoPK + " ]";
    }

}
