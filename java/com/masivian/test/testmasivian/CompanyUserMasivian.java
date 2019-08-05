/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COMPANY_USER_MASIVIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyUserMasivian.findAll", query = "SELECT c FROM CompanyUserMasivian c"),
    @NamedQuery(name = "CompanyUserMasivian.findByCompanyId", query = "SELECT c FROM CompanyUserMasivian c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "CompanyUserMasivian.findByName", query = "SELECT c FROM CompanyUserMasivian c WHERE c.name = :name"),
    @NamedQuery(name = "CompanyUserMasivian.findByCatchphrase", query = "SELECT c FROM CompanyUserMasivian c WHERE c.catchphrase = :catchphrase"),
    @NamedQuery(name = "CompanyUserMasivian.findByBs", query = "SELECT c FROM CompanyUserMasivian c WHERE c.bs = :bs")})
public class CompanyUserMasivian implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator="SeqCompany") 
    @SequenceGenerator(name="SeqCompany",sequenceName="SEQ_COMPANY", allocationSize=1) 
    @Column(name = "COMPANY_ID")
    private BigDecimal companyId;
    @Size(max = 2000)
    @Column(name = "NAME")
    private String name;
    @Size(max = 2000)
    @Column(name = "CATCHPHRASE")
    private String catchphrase;
    @Size(max = 2000)
    @Column(name = "BS")
    private String bs;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserMasivian userId;

    public CompanyUserMasivian() {
    }

    public CompanyUserMasivian(BigDecimal companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigDecimal companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchphrase() {
        return catchphrase;
    }

    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public UserMasivian getUserId() {
        return userId;
    }

    public void setUserId(UserMasivian userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyUserMasivian)) {
            return false;
        }
        CompanyUserMasivian other = (CompanyUserMasivian) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masivian.test.testmasivian.CompanyUserMasivian[ companyId=" + companyId + " ]";
    }
    
}
