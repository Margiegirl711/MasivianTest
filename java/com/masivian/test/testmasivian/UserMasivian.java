/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "USER_MASIVIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMasivian.findAll", query = "SELECT u FROM UserMasivian u"),
    @NamedQuery(name = "UserMasivian.findById", query = "SELECT u FROM UserMasivian u WHERE u.id = :id"),
    @NamedQuery(name = "UserMasivian.findByName", query = "SELECT u FROM UserMasivian u WHERE u.name = :name"),
    @NamedQuery(name = "UserMasivian.findByUsername", query = "SELECT u FROM UserMasivian u WHERE u.username = :username"),
    @NamedQuery(name = "UserMasivian.findByEmail", query = "SELECT u FROM UserMasivian u WHERE u.email = :email"),
    @NamedQuery(name = "UserMasivian.findByPhone", query = "SELECT u FROM UserMasivian u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserMasivian.findByWebsite", query = "SELECT u FROM UserMasivian u WHERE u.website = :website")})
public class UserMasivian implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 2000)
    @Column(name = "NAME")
    private String name;
    @Size(max = 2000)
    @Column(name = "USERNAME")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2000)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 2000)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 2000)
    @Column(name = "WEBSITE")
    private String website;
    @OneToMany(mappedBy = "userId")
    private Collection<GeoAddressUserMasivian> geoAddressUserMasivianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<CompanyUserMasivian> companyUserMasivianCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<AddressUserMasivian> addressUserMasivianCollection;

    public UserMasivian() {
    }

    public UserMasivian(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public Collection<GeoAddressUserMasivian> getGeoAddressUserMasivianCollection() {
        return geoAddressUserMasivianCollection;
    }

    public void setGeoAddressUserMasivianCollection(Collection<GeoAddressUserMasivian> geoAddressUserMasivianCollection) {
        this.geoAddressUserMasivianCollection = geoAddressUserMasivianCollection;
    }

    @XmlTransient
    public Collection<CompanyUserMasivian> getCompanyUserMasivianCollection() {
        return companyUserMasivianCollection;
    }

    public void setCompanyUserMasivianCollection(Collection<CompanyUserMasivian> companyUserMasivianCollection) {
        this.companyUserMasivianCollection = companyUserMasivianCollection;
    }

    @XmlTransient
    public Collection<AddressUserMasivian> getAddressUserMasivianCollection() {
        return addressUserMasivianCollection;
    }

    public void setAddressUserMasivianCollection(Collection<AddressUserMasivian> addressUserMasivianCollection) {
        this.addressUserMasivianCollection = addressUserMasivianCollection;
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
        if (!(object instanceof UserMasivian)) {
            return false;
        }
        UserMasivian other = (UserMasivian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masivian.test.testmasivian.UserMasivian[ id=" + id + " ]";
    }
    
}
