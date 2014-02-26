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
@Table(name = "ComplianceCertificates", catalog = "CloudSF", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplianceCertificates.findAll", query = "SELECT c FROM ComplianceCertificates c"),
    @NamedQuery(name = "ComplianceCertificates.findByComplianceCode", query = "SELECT c FROM ComplianceCertificates c WHERE c.complianceCode = :complianceCode"),
    @NamedQuery(name = "ComplianceCertificates.findByComplianceDescription", query = "SELECT c FROM ComplianceCertificates c WHERE c.complianceDescription = :complianceDescription")})
public class ComplianceCertificates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Compliance_Code")
    private String complianceCode;
    @Size(max = 100)
    @Column(name = "Compliance_Description")
    private String complianceDescription;
    @ManyToMany(mappedBy = "complianceCertificatesCollection")
    private Collection<CloudProvider> cloudProviderCollection;

    public ComplianceCertificates() {
    }

    public ComplianceCertificates(String complianceCode) {
        this.complianceCode = complianceCode;
    }

    public String getComplianceCode() {
        return complianceCode;
    }

    public void setComplianceCode(String complianceCode) {
        this.complianceCode = complianceCode;
    }

    public String getComplianceDescription() {
        return complianceDescription;
    }

    public void setComplianceDescription(String complianceDescription) {
        this.complianceDescription = complianceDescription;
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
        hash += (complianceCode != null ? complianceCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplianceCertificates)) {
            return false;
        }
        ComplianceCertificates other = (ComplianceCertificates) object;
        if ((this.complianceCode == null && other.complianceCode != null) || (this.complianceCode != null && !this.complianceCode.equals(other.complianceCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ComplianceCertificates[ complianceCode=" + complianceCode + " ]";
    }
    
}
