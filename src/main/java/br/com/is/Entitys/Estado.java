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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado",
        schema = "public"
)
public class Estado implements java.io.Serializable {

    private int codigo;
    private Pais pais;
    private String nome;
    private String uf;
    private Set<Cidade> cidades = new HashSet<Cidade>(0);

    public Estado() {
    }

    public Estado(int codigo, Pais pais) {
        this.codigo = codigo;
        this.pais = pais;
    }

    public Estado(int codigo, Pais pais, String nome, String uf, Set<Cidade> cidades) {
        this.codigo = codigo;
        this.pais = pais;
        this.nome = nome;
        this.uf = uf;
        this.cidades = cidades;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais", nullable = false)
    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Column(name = "nome", length = 75)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "uf", length = 2)
    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Cidade> getCidades() {
        return this.cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }

}
