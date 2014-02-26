/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    
}
