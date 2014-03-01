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
@Table(name = "application_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationType.findAll", query = "SELECT a FROM ApplicationType a"),
    @NamedQuery(name = "ApplicationType.findByAppCode", query = "SELECT a FROM ApplicationType a WHERE a.appCode = :appCode"),
    @NamedQuery(name = "ApplicationType.findByAppDescription", query = "SELECT a FROM ApplicationType a WHERE a.appDescription = :appDescription")})
public class ApplicationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "app_code")
    private String appCode;
    @Size(max = 100)
    @Column(name = "app_description")
    private String appDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationType")
    private Collection<FilterApptype> filterApptypeCollection;

    public ApplicationType() {
    }

    public ApplicationType(String appCode) {
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
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
        hash += (appCode != null ? appCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationType)) {
            return false;
        }
        ApplicationType other = (ApplicationType) object;
        if ((this.appCode == null && other.appCode != null) || (this.appCode != null && !this.appCode.equals(other.appCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ApplicationType[ appCode=" + appCode + " ]";
    }
    
}
