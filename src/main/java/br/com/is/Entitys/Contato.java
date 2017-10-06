package br.com.is.Entitys;
// Generated 13/09/2017 20:17:35 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Contato generated by hbm2java
 */
@Entity
@Table(name = "contato",
        schema = "public"
)
public class Contato implements java.io.Serializable {

    private int codigo;
    private String contato;
    private String descricao;
    private Set<PossuiContato> possuiContatos = new HashSet<PossuiContato>(0);

    public Contato() {
    }

    public Contato(int codigo) {
        this.codigo = codigo;
    }

    public Contato(int codigo, String contato, String descricao, Set<PossuiContato> possuiContatos) {
        this.codigo = codigo;
        this.contato = contato;
        this.descricao = descricao;
        this.possuiContatos = possuiContatos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", unique = true, nullable = false)
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "contato", length = 75)
    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Column(name = "descricao", length = 150)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contato")
    public Set<PossuiContato> getPossuiContatos() {
        return this.possuiContatos;
    }

    public void setPossuiContatos(Set<PossuiContato> possuiContatos) {
        this.possuiContatos = possuiContatos;
    }

    @Override
    public String toString() {
        return "Contato{" + "codigo=" + codigo + ", contato=" + contato + ", descricao=" + descricao + ", possuiContatos=" + possuiContatos + '}';
    }

}
