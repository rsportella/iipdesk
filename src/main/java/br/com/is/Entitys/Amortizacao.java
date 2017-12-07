package br.com.is.Entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "amortizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amortizacao.findAll", query = "SELECT a FROM Amortizacao a")
    , @NamedQuery(name = "Amortizacao.findByCodigo", query = "SELECT a FROM Amortizacao a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Amortizacao.findByValor", query = "SELECT a FROM Amortizacao a WHERE a.valor = :valor")
    , @NamedQuery(name = "Amortizacao.findByData", query = "SELECT a FROM Amortizacao a WHERE a.data = :data")
    , @NamedQuery(name = "Amortizacao.findByDesconto", query = "SELECT a FROM Amortizacao a WHERE a.desconto = :desconto")
    , @NamedQuery(name = "Amortizacao.findByFormaPagamento", query = "SELECT a FROM Amortizacao a WHERE a.formaPagamento = :formaPagamento")
    , @NamedQuery(name = "Amortizacao.findByStatus", query = "SELECT a FROM Amortizacao a WHERE a.status = :status")})
public class Amortizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Basic(optional = false)
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "pagamento", referencedColumnName = "evento")
    @ManyToOne(optional = false)
    private Pagamento pagamento;

    public Amortizacao() {
    }

    public Amortizacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Amortizacao(Integer codigo, BigDecimal valor, Date data, String formaPagamento, String status) {
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amortizacao)) {
            return false;
        }
        Amortizacao other = (Amortizacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Amortizacao{" + "codigo=" + codigo + ", valor=" + valor + ", data=" + data + ", desconto=" + desconto + ", formaPagamento=" + formaPagamento + ", status=" + status + ", pagamento=" + pagamento + '}';
    }


}
