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
@Table(name = "service_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceModel.findAll", query = "SELECT s FROM ServiceModel s"),
    @NamedQuery(name = "ServiceModel.findBySmCode", query = "SELECT s FROM ServiceModel s WHERE s.smCode = :smCode"),
    @NamedQuery(name = "ServiceModel.findBySmDescription", query = "SELECT s FROM ServiceModel s WHERE s.smDescription = :smDescription")})
public class ServiceModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sm_code")
    private String smCode;
    @Size(max = 200)
    @Column(name = "sm_description")
    private String smDescription;
    @ManyToMany(mappedBy = "serviceModelCollection")
    private Collection<CloudProvider> cloudProviderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceModel")
    private Collection<FilterApptype> filterApptypeCollection;

    public ServiceModel() {
    }

    public ServiceModel(String smCode) {
        this.smCode = smCode;
    }

    public String getSmCode() {
        return smCode;
    }

    public void setSmCode(String smCode) {
        this.smCode = smCode;
    }

    public String getSmDescription() {
        return smDescription;
    }

    public void setSmDescription(String smDescription) {
        this.smDescription = smDescription;
    }

    @XmlTransient
    public Collection<CloudProvider> getCloudProviderCollection() {
        return cloudProviderCollection;
    }

    public void setCloudProviderCollection(Collection<CloudProvider> cloudProviderCollection) {
        this.cloudProviderCollection = cloudProviderCollection;
    }

    @XmlTransient
    public Collection<FilterApptype> getFilterApptypeCollection() {
        return filterApptypeCollection;
    }

    public void setFilterApptypeCollection(Collection<FilterApptype> filterApptypeCollection) {
        this.filterApptypeCollection = filterApptypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smCode != null ? smCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceModel)) {
            return false;
        }
        ServiceModel other = (ServiceModel) object;
        if ((this.smCode == null && other.smCode != null) || (this.smCode != null && !this.smCode.equals(other.smCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ServiceModel[ smCode=" + smCode + " ]";
    }
    
}
