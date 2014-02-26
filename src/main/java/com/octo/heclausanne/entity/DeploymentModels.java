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
@Table(name = "DeploymentModels", catalog = "CloudSF", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeploymentModels.findAll", query = "SELECT d FROM DeploymentModels d"),
    @NamedQuery(name = "DeploymentModels.findByDeployCode", query = "SELECT d FROM DeploymentModels d WHERE d.deployCode = :deployCode")})
public class DeploymentModels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Deploy_Code")
    private String deployCode;
    @ManyToMany(mappedBy = "deploymentModelsCollection")
    private Collection<CloudProvider> cloudProviderCollection;

    public DeploymentModels() {
    }

    public DeploymentModels(String deployCode) {
        this.deployCode = deployCode;
    }

    public String getDeployCode() {
        return deployCode;
    }

    public void setDeployCode(String deployCode) {
        this.deployCode = deployCode;
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
        hash += (deployCode != null ? deployCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeploymentModels)) {
            return false;
        }
        DeploymentModels other = (DeploymentModels) object;
        if ((this.deployCode == null && other.deployCode != null) || (this.deployCode != null && !this.deployCode.equals(other.deployCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.DeploymentModels[ deployCode=" + deployCode + " ]";
    }
    
}
