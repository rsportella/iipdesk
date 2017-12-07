package br.com.is.Entitys;

import java.io.Serializable;
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
@Table(name = "realizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realizacao.findAll", query = "SELECT r FROM Realizacao r")
    , @NamedQuery(name = "Realizacao.findByEvento", query = "SELECT r FROM Realizacao r WHERE r.realizacaoPK.evento = :evento")
    , @NamedQuery(name = "Realizacao.findByEndereco", query = "SELECT r FROM Realizacao r WHERE r.realizacaoPK.endereco = :endereco")
    , @NamedQuery(name = "Realizacao.findBySubTipoEvento", query = "SELECT r FROM Realizacao r WHERE r.realizacaoPK.subTipoEvento = :subTipoEvento")
    , @NamedQuery(name = "Realizacao.findByDescricao", query = "SELECT r FROM Realizacao r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Realizacao.findByData", query = "SELECT r FROM Realizacao r WHERE r.data = :data")
    , @NamedQuery(name = "Realizacao.findByHoraInicio", query = "SELECT r FROM Realizacao r WHERE r.horaInicio = :horaInicio")
    , @NamedQuery(name = "Realizacao.findByHoraTermino", query = "SELECT r FROM Realizacao r WHERE r.horaTermino = :horaTermino")
    , @NamedQuery(name = "Realizacao.findByStatus", query = "SELECT r FROM Realizacao r WHERE r.status = :status")})
public class Realizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RealizacaoPK realizacaoPK;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_termino")
    private String horaTermino;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "endereco", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Endereco endereco1;
    @JoinColumn(name = "evento", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento1;
    @JoinColumn(name = "sub_tipo_evento", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SubTipoEvento subTipoEvento1;

    public Realizacao() {
    }

    public Realizacao(RealizacaoPK realizacaoPK) {
        this.realizacaoPK = realizacaoPK;
    }

    public Realizacao(int evento, int endereco, int subTipoEvento) {
        this.realizacaoPK = new RealizacaoPK(evento, endereco, subTipoEvento);
    }

    public RealizacaoPK getRealizacaoPK() {
        return realizacaoPK;
    }

    public void setRealizacaoPK(RealizacaoPK realizacaoPK) {
        this.realizacaoPK = realizacaoPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Endereco getEndereco1() {
        return endereco1;
    }

    public void setEndereco1(Endereco endereco1) {
        this.endereco1 = endereco1;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
    }

    public SubTipoEvento getSubTipoEvento1() {
        return subTipoEvento1;
    }

    public void setSubTipoEvento1(SubTipoEvento subTipoEvento1) {
        this.subTipoEvento1 = subTipoEvento1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (realizacaoPK != null ? realizacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realizacao)) {
            return false;
        }
        Realizacao other = (Realizacao) object;
        if ((this.realizacaoPK == null && other.realizacaoPK != null) || (this.realizacaoPK != null && !this.realizacaoPK.equals(other.realizacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.is.Entitys.Realizacao[ realizacaoPK=" + realizacaoPK + " ]";
    }

}
