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
@Table(name = "ApplicationTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationTypes.findAll", query = "SELECT a FROM ApplicationTypes a"),
    @NamedQuery(name = "ApplicationTypes.findByAPPCode", query = "SELECT a FROM ApplicationTypes a WHERE a.aPPCode = :aPPCode"),
    @NamedQuery(name = "ApplicationTypes.findByAPPDescription", query = "SELECT a FROM ApplicationTypes a WHERE a.aPPDescription = :aPPDescription")})
public class ApplicationTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APP_Code")
    private String aPPCode;
    @Size(max = 100)
    @Column(name = "APP_Description")
    private String aPPDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationTypes")
    private Collection<FilterAppType> filterAppTypeCollection;

    public ApplicationTypes() {
    }

    public ApplicationTypes(String aPPCode) {
        this.aPPCode = aPPCode;
    }

    public String getAPPCode() {
        return aPPCode;
    }

    public void setAPPCode(String aPPCode) {
        this.aPPCode = aPPCode;
    }

    public String getAPPDescription() {
        return aPPDescription;
    }

    public void setAPPDescription(String aPPDescription) {
        this.aPPDescription = aPPDescription;
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
        hash += (aPPCode != null ? aPPCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationTypes)) {
            return false;
        }
        ApplicationTypes other = (ApplicationTypes) object;
        if ((this.aPPCode == null && other.aPPCode != null) || (this.aPPCode != null && !this.aPPCode.equals(other.aPPCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ApplicationTypes[ aPPCode=" + aPPCode + " ]";
    }
    
}
