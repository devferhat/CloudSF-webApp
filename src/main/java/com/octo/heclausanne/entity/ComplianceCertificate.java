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
@Table(name = "compliance_certificate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplianceCertificate.findAll", query = "SELECT c FROM ComplianceCertificate c"),
    @NamedQuery(name = "ComplianceCertificate.findByComplianceCode", query = "SELECT c FROM ComplianceCertificate c WHERE c.complianceCode = :complianceCode"),
    @NamedQuery(name = "ComplianceCertificate.findByComplianceDescription", query = "SELECT c FROM ComplianceCertificate c WHERE c.complianceDescription = :complianceDescription")})
public class ComplianceCertificate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "compliance_code")
    private String complianceCode;
    @Size(max = 100)
    @Column(name = "compliance_description")
    private String complianceDescription;
    @ManyToMany(mappedBy = "complianceCertificateCollection")
    private Collection<CloudProvider> cloudProviderCollection;

    public ComplianceCertificate() {
    }

    public ComplianceCertificate(String complianceCode) {
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
        if (!(object instanceof ComplianceCertificate)) {
            return false;
        }
        ComplianceCertificate other = (ComplianceCertificate) object;
        if ((this.complianceCode == null && other.complianceCode != null) || (this.complianceCode != null && !this.complianceCode.equals(other.complianceCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.ComplianceCertificate[ complianceCode=" + complianceCode + " ]";
    }
    
}
