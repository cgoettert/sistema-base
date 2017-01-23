/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kopp.sistrak.base.servicos.origem;

import br.com.kopp.sistrak.base.servicos.departamento.UsuarioDepartamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cgoettert
 */
@Entity
@Table(name = "usuario_origem")
@NamedQueries({
    @NamedQuery(name = "UsuarioOrigem.findAll", query = "SELECT u FROM UsuarioOrigem u")})
public class UsuarioOrigem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "usuarioOrigem")
    private List<UsuarioDepartamento> usuarioDepartamentoList;

    public UsuarioOrigem() {
    }

    public UsuarioOrigem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<UsuarioDepartamento> getUsuarioDepartamentoList() {
        return usuarioDepartamentoList;
    }

    public void setUsuarioDepartamentoList(List<UsuarioDepartamento> usuarioDepartamentoList) {
        this.usuarioDepartamentoList = usuarioDepartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioOrigem)) {
            return false;
        }
        UsuarioOrigem other = (UsuarioOrigem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kopp.sistrak.base.UsuarioOrigem[ id=" + id + " ]";
    }
    
}
