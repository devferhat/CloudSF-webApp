/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferhat
 */
@Entity
@Table(name = "FilterAppType", catalog = "CloudSF", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FilterAppType.findAll", query = "SELECT f FROM FilterAppType f"),
    @NamedQuery(name = "FilterAppType.findBySMCode", query = "SELECT f FROM FilterAppType f WHERE f.filterAppTypePK.sMCode = :sMCode"),
    @NamedQuery(name = "FilterAppType.findByAppCode", query = "SELECT f FROM FilterAppType f WHERE f.filterAppTypePK.appCode = :appCode")})
public class FilterAppType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilterAppTypePK filterAppTypePK;
    @JoinColumn(name = "SM_Code", referencedColumnName = "SM_Code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServiceModels serviceModels;
    @JoinColumn(name = "Provider_Code", referencedColumnName = "Provider_Code")
    @ManyToOne(optional = false)
    private CloudProvider providerCode;
    @JoinColumn(name = "App_Code", referencedColumnName = "APP_Code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ApplicationTypes applicationTypes;

    public FilterAppType() {
    }

    public FilterAppType(FilterAppTypePK filterAppTypePK) {
        this.filterAppTypePK = filterAppTypePK;
    }

    public FilterAppType(String sMCode, String appCode) {
        this.filterAppTypePK = new FilterAppTypePK(sMCode, appCode);
    }

    public FilterAppTypePK getFilterAppTypePK() {
        return filterAppTypePK;
    }

    public void setFilterAppTypePK(FilterAppTypePK filterAppTypePK) {
        this.filterAppTypePK = filterAppTypePK;
    }

    public ServiceModels getServiceModels() {
        return serviceModels;
    }

    public void setServiceModels(ServiceModels serviceModels) {
        this.serviceModels = serviceModels;
    }

    public CloudProvider getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(CloudProvider providerCode) {
        this.providerCode = providerCode;
    }

    public ApplicationTypes getApplicationTypes() {
        return applicationTypes;
    }

    public void setApplicationTypes(ApplicationTypes applicationTypes) {
        this.applicationTypes = applicationTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filterAppTypePK != null ? filterAppTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilterAppType)) {
            return false;
        }
        FilterAppType other = (FilterAppType) object;
        if ((this.filterAppTypePK == null && other.filterAppTypePK != null) || (this.filterAppTypePK != null && !this.filterAppTypePK.equals(other.filterAppTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.FilterAppType[ filterAppTypePK=" + filterAppTypePK + " ]";
    }
    
}
