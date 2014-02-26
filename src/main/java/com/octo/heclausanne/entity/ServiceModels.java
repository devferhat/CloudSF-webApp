/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author ferhat
 */
@Entity
@Table(name = "ServiceModels", catalog = "CloudSF", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceModels.findAll", query = "SELECT s FROM ServiceModels s"),
    @NamedQuery(name = "ServiceModels.findBySMCode", query = "SELECT s FROM ServiceModels s WHERE s.sMCode = :sMCode"),
    @NamedQuery(name = "ServiceModels.findBySMDescription", query = "SELECT s FROM ServiceModels s WHERE s.sMDescription = :sMDescription")})
public class ServiceModels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SM_Code")
    private String sMCode;
    @Size(max = 200)
    @Column(name = "SM_Description")
    private String sMDescription;
    @ManyToMany(mappedBy = "serviceModelsCollection")
    private Collection<CloudProvider> cloudProviderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceModels")
    private Collection<FilterAppType> filterAppTypeCollection;

    public ServiceModels() {
    }

    public ServiceModels(String sMCode) {
        this.sMCode = sMCode;
    }

    public String getSMCode() {
        return sMCode;
    }

    public void setSMCode(String sMCode) {
        this.sMCode = sMCode;
    }

    public String getSMDescription() {
        return sMDescription;
    }

    public void setSMDescription(String sMDescription) {
        this.sMDescription = sMDescription;
    }

    @XmlTransient
    public Collection<CloudProvider> getCloudProviderCollection() {
        return cloudProviderCollection;
    }

    public void setCloudProviderCollection(Collection<CloudProvider> cloudProviderCollection) {
        this.cloudProviderCollection = cloudProviderCollection;
    }

    @XmlTransient
    public Collection<FilterAppType> getFilterAppTypeCollection() {
        return filterAppTypeCollection;
    }

    public void setFilterAppTypeCollection(Collection<FilterAppType> filterAppTypeCollection) {
        this.filterAppTypeCollection = filterAppTypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sMCode != null ? sMCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceModels)) {
            return false;
        }
        ServiceModels other = (ServiceModels) object;
        if ((this.sMCode == null && other.sMCode != null) || (this.sMCode != null && !this.sMCode.equals(other.sMCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ServiceModels[ sMCode=" + sMCode + " ]";
    }
    
}
