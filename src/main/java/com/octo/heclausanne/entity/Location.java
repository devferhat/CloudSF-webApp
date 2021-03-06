/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferhat
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocaCode", query = "SELECT l FROM Location l WHERE l.locaCode = :locaCode"),
    @NamedQuery(name = "Location.findByLocaDescription", query = "SELECT l FROM Location l WHERE l.locaDescription = :locaDescription")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loca_code")
    private String locaCode;
    @Size(max = 50)
    @Column(name = "loca_description")
    private String locaDescription;
    @ManyToMany(mappedBy = "locationCollection")
    private Collection<CloudProvider> cloudProviderCollection;

    public Location() {
    }

    public Location(String locaCode) {
        this.locaCode = locaCode;
    }

    public String getLocaCode() {
        return locaCode;
    }

    public void setLocaCode(String locaCode) {
        this.locaCode = locaCode;
    }

    public String getLocaDescription() {
        return locaDescription;
    }

    public void setLocaDescription(String locaDescription) {
        this.locaDescription = locaDescription;
    }

    @XmlTransient
    public Collection<CloudProvider> getCloudProviderCollection() {
        return cloudProviderCollection;
    }

    public void setCloudProviderCollection(Collection<CloudProvider> cloudProviderCollection) {
        this.cloudProviderCollection = cloudProviderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locaCode != null ? locaCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locaCode == null && other.locaCode != null) || (this.locaCode != null && !this.locaCode.equals(other.locaCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.Location[ locaCode=" + locaCode + " ]";
    }
    
}
