/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingru
 */
@Entity
@Table(name = "GEO_ADDRESS_USER_MASIVIAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeoAddressUserMasivian.findAll", query = "SELECT g FROM GeoAddressUserMasivian g"),
    @NamedQuery(name = "GeoAddressUserMasivian.findByGeoId", query = "SELECT g FROM GeoAddressUserMasivian g WHERE g.geoId = :geoId"),
    @NamedQuery(name = "GeoAddressUserMasivian.findByLat", query = "SELECT g FROM GeoAddressUserMasivian g WHERE g.lat = :lat"),
    @NamedQuery(name = "GeoAddressUserMasivian.findByLng", query = "SELECT g FROM GeoAddressUserMasivian g WHERE g.lng = :lng")})
public class GeoAddressUserMasivian implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator="SeqGeo") 
    @SequenceGenerator(name="SeqGeo",sequenceName="SEQ_GEO", allocationSize=1) 
    @Column(name = "GEO_ID")
    private BigDecimal geoId;
    @Column(name = "LAT")
    private String lat;
    @Column(name = "LNG")
    private String lng;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private AddressUserMasivian addressId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserMasivian userId;

    public GeoAddressUserMasivian() {
    }

    public GeoAddressUserMasivian(BigDecimal geoId) {
        this.geoId = geoId;
    }

    public BigDecimal getGeoId() {
        return geoId;
    }

    public void setGeoId(BigDecimal geoId) {
        this.geoId = geoId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public AddressUserMasivian getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressUserMasivian addressId) {
        this.addressId = addressId;
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
        hash += (geoId != null ? geoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoAddressUserMasivian)) {
            return false;
        }
        GeoAddressUserMasivian other = (GeoAddressUserMasivian) object;
        if ((this.geoId == null && other.geoId != null) || (this.geoId != null && !this.geoId.equals(other.geoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masivian.test.testmasivian.GeoAddressUserMasivian[ geoId=" + geoId + " ]";
    }
    
}
