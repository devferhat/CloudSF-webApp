/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.models;

import com.octo.heclausanne.entity.CloudProvider;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author ferhat
 */
@Stateless
public class CloudProviders implements Serializable {

    private CloudProvider cloudProvider;
    private String certificates;
    private String complianceCertificates;
    private String deploymentModels;
    private String location;
    private String serviceModels; 

    public CloudProviders() {
    }

    public CloudProviders(CloudProvider cloudProvider, String certificates, String complianceCertificates, String deploymentModels, String location, String serviceModels) {
        this.cloudProvider = cloudProvider;
        this.certificates = certificates;
        this.complianceCertificates = complianceCertificates;
        this.deploymentModels = deploymentModels;
        this.location = location;
        this.serviceModels = serviceModels;
    }

    public CloudProvider getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(CloudProvider cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public String getComplianceCertificates() {
        return complianceCertificates;
    }

    public void setComplianceCertificates(String complianceCertificates) {
        this.complianceCertificates = complianceCertificates;
    }

    public String getDeploymentModels() {
        return deploymentModels;
    }

    public void setDeploymentModels(String deploymentModels) {
        this.deploymentModels = deploymentModels;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServiceModels() {
        return serviceModels;
    }

    public void setServiceModels(String serviceModels) {
        this.serviceModels = serviceModels;
    }

    
    
    
}
