package br.com.is.Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "servico_pertence_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicoPertenceEvento.findAll", query = "SELECT s FROM ServicoPertenceEvento s")
    , @NamedQuery(name = "ServicoPertenceEvento.findByEvento", query = "SELECT s FROM ServicoPertenceEvento s WHERE s.servicoPertenceEventoPK.evento = :evento")
    , @NamedQuery(name = "ServicoPertenceEvento.findByServico", query = "SELECT s FROM ServicoPertenceEvento s WHERE s.servicoPertenceEventoPK.servico = :servico")
    , @NamedQuery(name = "ServicoPertenceEvento.findByValorOriginal", query = "SELECT s FROM ServicoPertenceEvento s WHERE s.valorOriginal = :valorOriginal")
    , @NamedQuery(name = "ServicoPertenceEvento.findByValorFinal", query = "SELECT s FROM ServicoPertenceEvento s WHERE s.valorFinal = :valorFinal")
    , @NamedQuery(name = "ServicoPertenceEvento.findByStatus", query = "SELECT s FROM ServicoPertenceEvento s WHERE s.status = :status")})
public class ServicoPertenceEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicoPertenceEventoPK servicoPertenceEventoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_original")
    private BigDecimal valorOriginal;
    @Basic(optional = false)
    @Column(name = "valor_final")
    private BigDecimal valorFinal;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "evento", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento1;
    @JoinColumn(name = "servico", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servico servico1;

    public ServicoPertenceEvento() {
    }

    public ServicoPertenceEvento(ServicoPertenceEventoPK servicoPertenceEventoPK) {
        this.servicoPertenceEventoPK = servicoPertenceEventoPK;
    }

    public ServicoPertenceEvento(ServicoPertenceEventoPK servicoPertenceEventoPK, BigDecimal valorOriginal, BigDecimal valorFinal, Character status) {
        this.servicoPertenceEventoPK = servicoPertenceEventoPK;
        this.valorOriginal = valorOriginal;
        this.valorFinal = valorFinal;
        this.status = status;
    }

    public ServicoPertenceEvento(int evento, int servico) {
        this.servicoPertenceEventoPK = new ServicoPertenceEventoPK(evento, servico);
    }

    public ServicoPertenceEvento(Integer codigo, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ServicoPertenceEventoPK getServicoPertenceEventoPK() {
        return servicoPertenceEventoPK;
    }

    public void setServicoPertenceEventoPK(ServicoPertenceEventoPK servicoPertenceEventoPK) {
        this.servicoPertenceEventoPK = servicoPertenceEventoPK;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
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
        hash += (servicoPertenceEventoPK != null ? servicoPertenceEventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoPertenceEvento)) {
            return false;
        }
        ServicoPertenceEvento other = (ServicoPertenceEvento) object;
        if ((this.servicoPertenceEventoPK == null && other.servicoPertenceEventoPK != null) || (this.servicoPertenceEventoPK != null && !this.servicoPertenceEventoPK.equals(other.servicoPertenceEventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServicoPertenceEvento{" + "servicoPertenceEventoPK=" + servicoPertenceEventoPK + ", valorOriginal=" + valorOriginal + ", valorFinal=" + valorFinal + ", status=" + status + ", evento1=" + evento1 + ", servico1=" + servico1 + '}';
    }

}
