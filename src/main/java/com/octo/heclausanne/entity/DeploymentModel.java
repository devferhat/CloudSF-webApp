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
@Table(name = "deployment_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeploymentModel.findAll", query = "SELECT d FROM DeploymentModel d"),
    @NamedQuery(name = "DeploymentModel.findByDeployCode", query = "SELECT d FROM DeploymentModel d WHERE d.deployCode = :deployCode")})
public class DeploymentModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "deploy_code")
    private String deployCode;
    @ManyToMany(mappedBy = "deploymentModelCollection")
    private Collection<CloudProvider> cloudProviderCollection;

    public DeploymentModel() {
    }

    public DeploymentModel(String deployCode) {
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
        if (!(object instanceof DeploymentModel)) {
            return false;
        }
        DeploymentModel other = (DeploymentModel) object;
        if ((this.deployCode == null && other.deployCode != null) || (this.deployCode != null && !this.deployCode.equals(other.deployCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.DeploymentModel[ deployCode=" + deployCode + " ]";
    }
    
}
