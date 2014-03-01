/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ferhat
 */
@Embeddable
public class FilterApptypePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sm_code")
    private String smCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "app_code")
    private String appCode;

    public FilterApptypePK() {
    }

    public FilterApptypePK(String smCode, String appCode) {
        this.smCode = smCode;
        this.appCode = appCode;
    }

    public String getSmCode() {
        return smCode;
    }

    public void setSmCode(String smCode) {
        this.smCode = smCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smCode != null ? smCode.hashCode() : 0);
        hash += (appCode != null ? appCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilterApptypePK)) {
            return false;
        }
        FilterApptypePK other = (FilterApptypePK) object;
        if ((this.smCode == null && other.smCode != null) || (this.smCode != null && !this.smCode.equals(other.smCode))) {
            return false;
        }
        if ((this.appCode == null && other.appCode != null) || (this.appCode != null && !this.appCode.equals(other.appCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.FilterApptypePK[ smCode=" + smCode + ", appCode=" + appCode + " ]";
    }
    
}
