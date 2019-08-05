/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingru
 */
@Entity
@Table(name = "OPERACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o"),
    @NamedQuery(name = "Operaciones.findByOperacionId", query = "SELECT o FROM Operaciones o WHERE o.operacionId = :operacionId"),
    @NamedQuery(name = "Operaciones.findByDescripcion", query = "SELECT o FROM Operaciones o WHERE o.descripcion = :descripcion")})
public class Operaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERACION_ID")
    private Long operacionId;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "operacionId")
    private Collection<Calculadora> calculadoraCollection;

    public Operaciones() {
    }

    public Operaciones(Long operacionId) {
        this.operacionId = operacionId;
    }

    public Long getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(Long operacionId) {
        this.operacionId = operacionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Calculadora> getCalculadoraCollection() {
        return calculadoraCollection;
    }

    public void setCalculadoraCollection(Collection<Calculadora> calculadoraCollection) {
        this.calculadoraCollection = calculadoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operacionId != null ? operacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.operacionId == null && other.operacionId != null) || (this.operacionId != null && !this.operacionId.equals(other.operacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + operacionId + "]"+this.descripcion;
    }
    
}
