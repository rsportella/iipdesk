package br.com.is.Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
@Entity
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
    , @NamedQuery(name = "Pagamento.findByEvento", query = "SELECT p FROM Pagamento p WHERE p.evento = :evento")
    , @NamedQuery(name = "Pagamento.findByDesconto", query = "SELECT p FROM Pagamento p WHERE p.desconto = :desconto")
    , @NamedQuery(name = "Pagamento.findByValorTotal", query = "SELECT p FROM Pagamento p WHERE p.valorTotal = :valorTotal")
    , @NamedQuery(name = "Pagamento.findByQuantidadeParcela", query = "SELECT p FROM Pagamento p WHERE p.quantidadeParcela = :quantidadeParcela")
    , @NamedQuery(name = "Pagamento.findByDataInicial", query = "SELECT p FROM Pagamento p WHERE p.dataInicial = :dataInicial")
    , @NamedQuery(name = "Pagamento.findByFormaPagamento", query = "SELECT p FROM Pagamento p WHERE p.formaPagamento = :formaPagamento")
    , @NamedQuery(name = "Pagamento.findByDataContrato", query = "SELECT p FROM Pagamento p WHERE p.dataContrato = :dataContrato")
    , @NamedQuery(name = "Pagamento.findByStatus", query = "SELECT p FROM Pagamento p WHERE p.status = :status")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "evento")
    private Integer evento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "quantidade_parcela")
    private Integer quantidadeParcela;
    @Column(name = "data_inicial")
    @Temporal(TemporalType.DATE)
    private Date dataInicial;
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @Column(name = "data_contrato")
    @Temporal(TemporalType.DATE)
    private Date dataContrato;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamento")
    private Collection<Amortizacao> amortizacaoCollection;
    @JoinColumn(name = "evento", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Evento evento1;

    public Pagamento() {
    }

    public Pagamento(Integer evento) {
        this.evento = evento;
    }

    public Pagamento(Integer evento, BigDecimal desconto, BigDecimal valorTotal, Character status) {
        this.evento = evento;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Integer getEvento() {
        return evento;
    }

    public void setEvento(Integer evento) {
        this.evento = evento;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Amortizacao> getAmortizacaoCollection() {
        return amortizacaoCollection;
    }

    public void setAmortizacaoCollection(Collection<Amortizacao> amortizacaoCollection) {
        this.amortizacaoCollection = amortizacaoCollection;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evento != null ? evento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.evento == null && other.evento != null) || (this.evento != null && !this.evento.equals(other.evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Pagamento[ evento=" + evento + " ]";
    }

}
