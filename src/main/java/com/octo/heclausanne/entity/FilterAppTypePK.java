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
public class FilterAppTypePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SM_Code")
    private String sMCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "App_Code")
    private String appCode;

    public FilterAppTypePK() {
    }

    public FilterAppTypePK(String sMCode, String appCode) {
        this.sMCode = sMCode;
        this.appCode = appCode;
    }

    public String getSMCode() {
        return sMCode;
    }

    public void setSMCode(String sMCode) {
        this.sMCode = sMCode;
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
        hash += (sMCode != null ? sMCode.hashCode() : 0);
        hash += (appCode != null ? appCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilterAppTypePK)) {
            return false;
        }
        FilterAppTypePK other = (FilterAppTypePK) object;
        if ((this.sMCode == null && other.sMCode != null) || (this.sMCode != null && !this.sMCode.equals(other.sMCode))) {
            return false;
        }
        if ((this.appCode == null && other.appCode != null) || (this.appCode != null && !this.appCode.equals(other.appCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.FilterAppTypePK[ sMCode=" + sMCode + ", appCode=" + appCode + " ]";
    }
    
}
