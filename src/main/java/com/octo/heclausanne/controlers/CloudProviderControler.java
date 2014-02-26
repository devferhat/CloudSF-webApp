/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.octo.heclausanne.controlers;

import com.octo.heclausanne.entity.CloudProvider;
import com.octo.heclausanne.facades.CloudProviderFacade;
import com.octo.heclausanne.jsfutil.JsfUtil;
import com.octo.heclausanne.jsfutil.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author ferhat
 */
@Named("customerController")
@Stateless
public class CloudProviderControler implements Serializable {

    @EJB
    private CloudProviderFacade cloudProviderFacade;
    private List<CloudProvider> items = null;
    private CloudProvider selected;
 
    public CloudProviderControler() {
    }

    public CloudProviderFacade getCloudProviderFacade() {
        return cloudProviderFacade;
    }

    public void setCloudProviderFacade(CloudProviderFacade cloudProviderFacade) {
        this.cloudProviderFacade = cloudProviderFacade;
    }

    public CloudProvider getSelected() {
        return selected;
    }

    public void setSelected(CloudProvider selected) {
        this.selected = selected;
    }

    
    
    public CloudProvider prepareCreate() {
        selected = new CloudProvider();
        //initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }
    
    public void update(){
    persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderUpdated"));
    }
    public void destroy(){
    persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CloudProviderDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected=null;// Remove selection
            items=null; // Invalidate list of items to trigger re-query
        }
    }

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
            }catch (Exception ex) {
             Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,null,ex);
             JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }

        }

    }

    public List<CloudProvider> getItems() {
        if (items==null) {
            items=getCloudProviderFacade().findAll();
        }
        return items;
    }

    public void setItems(List<CloudProvider> items) {
        this.items = items;
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
    
    @FacesConverter(forClass = CloudProvider.class)
    public static class CloudProviderControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CloudProviderControler controller = (CloudProviderControler) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cloudProviderController");
            return controller.getCloudProvider(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CloudProvider) {
                CloudProvider o = (CloudProvider) object;
                return getStringKey(o.getProviderCode());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; "
                        + "expected type: {2}", new Object[]{object, object.getClass().getName(),
                            CloudProvider.class.getName()});
                return null;
            }
        }

    }

}
