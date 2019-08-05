/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingru
 */
@Entity
@Table(name = "CALCULADORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculadora.findAll", query = "SELECT c FROM Calculadora c"),
    @NamedQuery(name = "Calculadora.findByCalculadoraId", query = "SELECT c FROM Calculadora c WHERE c.calculadoraId = :calculadoraId"),
    @NamedQuery(name = "Calculadora.findByValora", query = "SELECT c FROM Calculadora c WHERE c.valora = :valora"),
    @NamedQuery(name = "Calculadora.findByValorb", query = "SELECT c FROM Calculadora c WHERE c.valorb = :valorb"),
    @NamedQuery(name = "Calculadora.findByResultado", query = "SELECT c FROM Calculadora c WHERE c.resultado = :resultado"),
    @NamedQuery(name = "Calculadora.findByMensaje", query = "SELECT c FROM Calculadora c WHERE c.mensaje = :mensaje")})
public class Calculadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator="SeqCalculator") 
    @SequenceGenerator(name="SeqCalculator",sequenceName="SEQ_Calculator", allocationSize=1) 
    @Column(name = "CALCULADORA_ID")
    private Long calculadoraId;
    @Column(name = "VALORA")
    private Long valora;
    @Column(name = "VALORB")
    private Long valorb;
    @Column(name = "RESULTADO")
    private Long resultado;
    @Size(max = 2000)
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumn(name = "OPERACION_ID", referencedColumnName = "OPERACION_ID")
    @ManyToOne
    private Operaciones operacionId;

    public Calculadora() {
    }

    public Calculadora(Long calculadoraId) {
        this.calculadoraId = calculadoraId;
    }

    public Long getCalculadoraId() {
        return calculadoraId;
    }

    public void setCalculadoraId(Long calculadoraId) {
        this.calculadoraId = calculadoraId;
    }

    public Long getValora() {
        return valora;
    }

    public void setValora(Long valora) {
        this.valora = valora;
    }

    public Long getValorb() {
        return valorb;
    }

    public void setValorb(Long valorb) {
        this.valorb = valorb;
    }

    public Long getResultado() {
        return resultado;
    }

    public void setResultado(Long resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Operaciones getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(Operaciones operacionId) {
        this.operacionId = operacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calculadoraId != null ? calculadoraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculadora)) {
            return false;
        }
        Calculadora other = (Calculadora) object;
        if ((this.calculadoraId == null && other.calculadoraId != null) || (this.calculadoraId != null && !this.calculadoraId.equals(other.calculadoraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masivian.test.testmasivian.Calculadora[ calculadoraId=" + calculadoraId + " ]";
    }
    
}
