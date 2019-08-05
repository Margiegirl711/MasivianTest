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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "ADDRESS_USER_MASIVIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressUserMasivian.findAll", query = "SELECT a FROM AddressUserMasivian a"),
    @NamedQuery(name = "AddressUserMasivian.findByAddressId", query = "SELECT a FROM AddressUserMasivian a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "AddressUserMasivian.findByStreet", query = "SELECT a FROM AddressUserMasivian a WHERE a.street = :street"),
    @NamedQuery(name = "AddressUserMasivian.findBySuite", query = "SELECT a FROM AddressUserMasivian a WHERE a.suite = :suite"),
    @NamedQuery(name = "AddressUserMasivian.findByCity", query = "SELECT a FROM AddressUserMasivian a WHERE a.city = :city"),
    @NamedQuery(name = "AddressUserMasivian.findByZipcode", query = "SELECT a FROM AddressUserMasivian a WHERE a.zipcode = :zipcode")})
public class AddressUserMasivian implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator="SeqAddress") 
    @SequenceGenerator(name="SeqAddress",sequenceName="SEQ_ADDRESS", allocationSize=1) 
    @Column(name = "ADDRESS_ID")
    private BigDecimal addressId;
    @Size(max = 2000)
    @Column(name = "STREET")
    private String street;
    @Size(max = 2000)
    @Column(name = "SUITE")
    private String suite;
    @Size(max = 2000)
    @Column(name = "CITY")
    private String city;
    @Size(max = 2000)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @OneToMany(mappedBy = "addressId")
    private Collection<GeoAddressUserMasivian> geoAddressUserMasivianCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserMasivian userId;

    public AddressUserMasivian() {
    }

    public AddressUserMasivian(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getAddressId() {
        return addressId;
    }

    public void setAddressId(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @XmlTransient
    public Collection<GeoAddressUserMasivian> getGeoAddressUserMasivianCollection() {
        return geoAddressUserMasivianCollection;
    }

    public void setGeoAddressUserMasivianCollection(Collection<GeoAddressUserMasivian> geoAddressUserMasivianCollection) {
        this.geoAddressUserMasivianCollection = geoAddressUserMasivianCollection;
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
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressUserMasivian)) {
            return false;
        }
        AddressUserMasivian other = (AddressUserMasivian) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masivian.test.testmasivian.AddressUserMasivian[ addressId=" + addressId + " ]";
    }
    
}
