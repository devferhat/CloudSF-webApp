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
@Table(name = "filter_apptype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FilterApptype.findAll", query = "SELECT f FROM FilterApptype f"),
    @NamedQuery(name = "FilterApptype.findBySmCode", query = "SELECT f FROM FilterApptype f WHERE f.filterApptypePK.smCode = :smCode"),
    @NamedQuery(name = "FilterApptype.findByAppCode", query = "SELECT f FROM FilterApptype f WHERE f.filterApptypePK.appCode = :appCode")})
public class FilterApptype implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilterApptypePK filterApptypePK;
    @JoinColumn(name = "sm_code", referencedColumnName = "sm_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServiceModel serviceModel;
    @JoinColumn(name = "provider_code", referencedColumnName = "provider_code")
    @ManyToOne(optional = false)
    private CloudProvider providerCode;
    @JoinColumn(name = "app_code", referencedColumnName = "app_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ApplicationType applicationType;

    public FilterApptype() {
    }

    public FilterApptype(FilterApptypePK filterApptypePK) {
        this.filterApptypePK = filterApptypePK;
    }

    public FilterApptype(String smCode, String appCode) {
        this.filterApptypePK = new FilterApptypePK(smCode, appCode);
    }

    public FilterApptypePK getFilterApptypePK() {
        return filterApptypePK;
    }

    public void setFilterApptypePK(FilterApptypePK filterApptypePK) {
        this.filterApptypePK = filterApptypePK;
    }

    public ServiceModel getServiceModel() {
        return serviceModel;
    }

    public void setServiceModel(ServiceModel serviceModel) {
        this.serviceModel = serviceModel;
    }

    public CloudProvider getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(CloudProvider providerCode) {
        this.providerCode = providerCode;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filterApptypePK != null ? filterApptypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilterApptype)) {
            return false;
        }
        FilterApptype other = (FilterApptype) object;
        if ((this.filterApptypePK == null && other.filterApptypePK != null) || (this.filterApptypePK != null && !this.filterApptypePK.equals(other.filterApptypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.FilterApptype[ filterApptypePK=" + filterApptypePK + " ]";
    }
    
}
