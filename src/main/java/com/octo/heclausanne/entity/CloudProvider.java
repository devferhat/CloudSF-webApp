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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "CloudProvider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CloudProvider.findAll", query = "SELECT c FROM CloudProvider c"),
    @NamedQuery(name = "CloudProvider.findByProviderName", query = "SELECT c FROM CloudProvider c WHERE c.providerName = :providerName"),
    @NamedQuery(name = "CloudProvider.findByProviderURL", query = "SELECT c FROM CloudProvider c WHERE c.providerURL = :providerURL"),
    @NamedQuery(name = "CloudProvider.findByProviderCode", query = "SELECT c FROM CloudProvider c WHERE c.providerCode = :providerCode"),
    @NamedQuery(name = "CloudProvider.findByProviderDescription", query = "SELECT c FROM CloudProvider c WHERE c.providerDescription = :providerDescription")})
public class CloudProvider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "Provider_Name")
    private String providerName;
    @Size(max = 300)
    @Column(name = "Provider_URL")
    private String providerURL;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Provider_Code")
    private Integer providerCode;
    @Size(max = 2147483647)
    @Column(name = "Provider_Description")
    private String providerDescription;
    @JoinTable(name = "FilterServiceModels", joinColumns = {
        @JoinColumn(name = "Provider_Code", referencedColumnName = "Provider_Code")}, inverseJoinColumns = {
        @JoinColumn(name = "SM_Code", referencedColumnName = "SM_Code")})
    @ManyToMany
    private Collection<ServiceModels> serviceModelsCollection;
    @ManyToMany(mappedBy = "cloudProviderCollection")
    private Collection<Certificates> certificatesCollection;
    @JoinTable(name = "FilterCompliance", joinColumns = {
        @JoinColumn(name = "Code_Providers", referencedColumnName = "Provider_Code")}, inverseJoinColumns = {
        @JoinColumn(name = "Code_Compliance", referencedColumnName = "Compliance_Code")})
    @ManyToMany
    private Collection<ComplianceCertificates> complianceCertificatesCollection;
    @JoinTable(name = "FilterLocations", joinColumns = {
        @JoinColumn(name = "Provider_Code", referencedColumnName = "Provider_Code")}, inverseJoinColumns = {
        @JoinColumn(name = "Location_Code", referencedColumnName = "Location_Code")})
    @ManyToMany
    private Collection<Locations> locationsCollection;
    @JoinTable(name = "FilterDeploymentModel", joinColumns = {
        @JoinColumn(name = "Code_Provider", referencedColumnName = "Provider_Code")}, inverseJoinColumns = {
        @JoinColumn(name = "Code_Deploy", referencedColumnName = "Deploy_Code")})
    @ManyToMany
    private Collection<DeploymentModels> deploymentModelsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerCode")
    private Collection<FilterAppType> filterAppTypeCollection;

    public CloudProvider() {
    }

    public CloudProvider(Integer providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderURL() {
        return providerURL;
    }

    public void setProviderURL(String providerURL) {
        this.providerURL = providerURL;
    }

    public Integer getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderDescription() {
        return providerDescription;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    @XmlTransient
    public Collection<ServiceModels> getServiceModelsCollection() {
        return serviceModelsCollection;
    }

    public void setServiceModelsCollection(Collection<ServiceModels> serviceModelsCollection) {
        this.serviceModelsCollection = serviceModelsCollection;
    }

    @XmlTransient
    public Collection<Certificates> getCertificatesCollection() {
        return certificatesCollection;
    }

    public void setCertificatesCollection(Collection<Certificates> certificatesCollection) {
        this.certificatesCollection = certificatesCollection;
    }

    @XmlTransient
    public Collection<ComplianceCertificates> getComplianceCertificatesCollection() {
        return complianceCertificatesCollection;
    }

    public void setComplianceCertificatesCollection(Collection<ComplianceCertificates> complianceCertificatesCollection) {
        this.complianceCertificatesCollection = complianceCertificatesCollection;
    }

    @XmlTransient
    public Collection<Locations> getLocationsCollection() {
        return locationsCollection;
    }

    public void setLocationsCollection(Collection<Locations> locationsCollection) {
        this.locationsCollection = locationsCollection;
    }

    @XmlTransient
    public Collection<DeploymentModels> getDeploymentModelsCollection() {
        return deploymentModelsCollection;
    }

    public void setDeploymentModelsCollection(Collection<DeploymentModels> deploymentModelsCollection) {
        this.deploymentModelsCollection = deploymentModelsCollection;
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
        hash += (providerCode != null ? providerCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CloudProvider)) {
            return false;
        }
        CloudProvider other = (CloudProvider) object;
        if ((this.providerCode == null && other.providerCode != null) || (this.providerCode != null && !this.providerCode.equals(other.providerCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.CloudProvider[ providerCode=" + providerCode + " ]";
    }
    
}
