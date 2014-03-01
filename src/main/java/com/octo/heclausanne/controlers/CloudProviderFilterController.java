/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.octo.heclausanne.controlers;

import com.octo.heclausanne.entity.Certificate;
import com.octo.heclausanne.entity.CloudProvider;
import com.octo.heclausanne.entity.ComplianceCertificate;
import com.octo.heclausanne.entity.DeploymentModel;
import com.octo.heclausanne.entity.Location;
import com.octo.heclausanne.entity.ServiceModel;
import com.octo.heclausanne.facades.CloudProviderFacade;
import com.octo.heclausanne.jsfutil.JsfUtil;
import com.octo.heclausanne.jsfutil.JsfUtil.PersistAction;
import com.octo.heclausanne.models.CloudProviders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;

/**
 *
 * @author ferhat
 */
@Named("cloudProviderFilterController")
@Stateless
public class CloudProviderFilterController implements Serializable {

    @EJB
    private CloudProviderFacade cloudProviderFacade;
    private List<CloudProviders> modelitems = null;
    private List<CloudProvider> items = null;
    private CloudProviders selectedmodel;
    
    private List<Certificate> certificates;
    private List<ComplianceCertificate> complianceCertificates;
    private List<DeploymentModel> deploymentModels;
    private List<Location> locations;
    private List<ServiceModel> serviceModels;

    public CloudProviderFilterController() {
    }

    public CloudProviderFacade getCloudProviderFacade() {
        return cloudProviderFacade;
    }

    public void setCloudProviderFacade(CloudProviderFacade cloudProviderFacade) {
        this.cloudProviderFacade = cloudProviderFacade;
    }

    public CloudProviders getSelectedmodel() {
        return selectedmodel;
    }

    public void setSelectedmodel(CloudProviders selectedmodel) {
        this.selectedmodel = selectedmodel;
    }

   

   /* public CloudProvider prepareCreate() {
        selected = new CloudProvider();
        //initializeEmbeddableKey();
        return selected;
    }
    */

    /*
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }
    */
    
    /*
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null;// Remove selection
            items = null; // Invalidate list of items to trigger re-query
        }
    }
    */
 
    /*
    public void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getCloudProviderFacade().edit(selected);
                } else {
                    getCloudProviderFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }

        }

    }
    */
 
  
    public void setModelitems(List<CloudProviders> modelitems) {
        this.modelitems = modelitems;
    }

 
    public List<CloudProviders> getModelitems() {
        if (modelitems == null) {
            modelitems=new ArrayList<CloudProviders>();
            items = getCloudProviderFacade().findAll();
            for (CloudProvider cloudProvider : items) {
                certificates = (List<Certificate>) cloudProvider.getCertificateCollection();
                String certificatesList=" ";
                for (Certificate c : certificates) {
                    certificatesList = certificatesList+"|"+c.getCertifCode();
                }
                complianceCertificates = (List<ComplianceCertificate>) cloudProvider.getComplianceCertificateCollection();
                String complianceCertificatesList=" ";
                for (ComplianceCertificate c : complianceCertificates) {
                    complianceCertificatesList = complianceCertificatesList+"|"+c.getComplianceCode();
                }
                deploymentModels = (List<DeploymentModel>) cloudProvider.getDeploymentModelCollection();
                String deploymentModelsList=" ";
                for (DeploymentModel c : deploymentModels) {
                    deploymentModelsList = deploymentModelsList+"|"+c.getDeployCode();
                }
                locations =(List<Location>) cloudProvider.getLocationCollection();
                String locationList=" ";
                for (Location c : locations) {
                   locationList = locationList+"|"+c.getLocaCode();
                }
                serviceModels = (List<ServiceModel>) cloudProvider.getServiceModelCollection();
                String serviceModelsList=" ";
                for (ServiceModel c : serviceModels) {
                    serviceModelsList = serviceModelsList+"|"+c.getSmCode();
                }
               CloudProviders modelitem= new CloudProviders(cloudProvider,certificatesList,complianceCertificatesList, 
                       deploymentModelsList,locationList,serviceModelsList);
              
               modelitems.add(modelitem);
            }
        }      
         return modelitems;
    }
    

   

    protected void setEmbeddableKeys() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    private void initializeEmbeddableKey() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    public CloudProvider getCloudProvider(java.lang.Integer id) {
        return getCloudProviderFacade().find(id);
    }

    public List<CloudProvider> getItemsAvailableSelectMany() {
        return getCloudProviderFacade().findAll();
    }

    public List<CloudProvider> getItemsAvailableSelectOne() {
        return getCloudProviderFacade().findAll();
    }

    public void handleClose(CloseEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                event.getComponent().getId() + " closed", "Not yet implemented?");

        facesContext.addMessage(null, message);
    }

}
