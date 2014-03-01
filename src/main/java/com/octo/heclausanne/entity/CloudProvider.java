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
@Table(name = "cloud_provider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CloudProvider.findAll", query = "SELECT c FROM CloudProvider c"),
    @NamedQuery(name = "CloudProvider.findByProviderName", query = "SELECT c FROM CloudProvider c WHERE c.providerName = :providerName"),
    @NamedQuery(name = "CloudProvider.findByProviderUrl", query = "SELECT c FROM CloudProvider c WHERE c.providerUrl = :providerUrl"),
    @NamedQuery(name = "CloudProvider.findByProviderCode", query = "SELECT c FROM CloudProvider c WHERE c.providerCode = :providerCode"),
    @NamedQuery(name = "CloudProvider.findByProviderDescription", query = "SELECT c FROM CloudProvider c WHERE c.providerDescription = :providerDescription")})
public class CloudProvider implements Serializable {
    @JoinTable(name = "filter_servicemodel", joinColumns = {
        @JoinColumn(name = "provider_code", referencedColumnName = "provider_code")}, inverseJoinColumns = {
        @JoinColumn(name = "sm_code", referencedColumnName = "sm_code")})
    @ManyToMany
    private Collection<ServiceModel> serviceModelCollection;
    @ManyToMany(mappedBy = "cloudProviderCollection")
    private Collection<Certificate> certificateCollection;
    @JoinTable(name = "filter_location", joinColumns = {
        @JoinColumn(name = "provider_code", referencedColumnName = "provider_code")}, inverseJoinColumns = {
        @JoinColumn(name = "loca_code", referencedColumnName = "loca_code")})
    @ManyToMany
    private Collection<Location> locationCollection;
    @JoinTable(name = "filter_compliance", joinColumns = {
        @JoinColumn(name = "code_provider", referencedColumnName = "provider_code")}, inverseJoinColumns = {
        @JoinColumn(name = "code_compliance", referencedColumnName = "compliance_code")})
    @ManyToMany
    private Collection<ComplianceCertificate> complianceCertificateCollection;
    @JoinTable(name = "filter_deploymentmodel", joinColumns = {
        @JoinColumn(name = "provider_code", referencedColumnName = "provider_code")}, inverseJoinColumns = {
        @JoinColumn(name = "deploy_code", referencedColumnName = "deploy_code")})
    @ManyToMany
    private Collection<DeploymentModel> deploymentModelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerCode")
    private Collection<FilterApptype> filterApptypeCollection;
    @Size(max = 50)
    @Column(name = "provider_imgpath")
    private String providerImgpath;
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "provider_name")
    private String providerName;
    @Size(max = 300)
    @Column(name = "provider_url")
    private String providerUrl;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "provider_code")
    private Integer providerCode;
    @Size(max = 2147483647)
    @Column(name = "provider_description")
    private String providerDescription;

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

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
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

    public String getProviderImgpath() {
        return providerImgpath;
    }

    public void setProviderImgpath(String providerImgpath) {
        this.providerImgpath = providerImgpath;
    }

    @XmlTransient
    public Collection<ServiceModel> getServiceModelCollection() {
        return serviceModelCollection;
    }

    public void setServiceModelCollection(Collection<ServiceModel> serviceModelCollection) {
        this.serviceModelCollection = serviceModelCollection;
    }

    @XmlTransient
    public Collection<Certificate> getCertificateCollection() {
        return certificateCollection;
    }

    public void setCertificateCollection(Collection<Certificate> certificateCollection) {
        this.certificateCollection = certificateCollection;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @XmlTransient
    public Collection<ComplianceCertificate> getComplianceCertificateCollection() {
        return complianceCertificateCollection;
    }

    public void setComplianceCertificateCollection(Collection<ComplianceCertificate> complianceCertificateCollection) {
        this.complianceCertificateCollection = complianceCertificateCollection;
    }

    @XmlTransient
    public Collection<DeploymentModel> getDeploymentModelCollection() {
        return deploymentModelCollection;
    }

    public void setDeploymentModelCollection(Collection<DeploymentModel> deploymentModelCollection) {
        this.deploymentModelCollection = deploymentModelCollection;
    }

    @XmlTransient
    public Collection<FilterApptype> getFilterApptypeCollection() {
        return filterApptypeCollection;
    }

    public void setFilterApptypeCollection(Collection<FilterApptype> filterApptypeCollection) {
        this.filterApptypeCollection = filterApptypeCollection;
    }
    
}
