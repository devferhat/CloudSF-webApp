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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "certificate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificate.findAll", query = "SELECT c FROM Certificate c"),
    @NamedQuery(name = "Certificate.findByCertifCode", query = "SELECT c FROM Certificate c WHERE c.certifCode = :certifCode"),
    @NamedQuery(name = "Certificate.findByCertifDescription", query = "SELECT c FROM Certificate c WHERE c.certifDescription = :certifDescription")})
public class Certificate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "certif_code")
    private String certifCode;
    @Size(max = 50)
    @Column(name = "certif_description")
    private String certifDescription;
    @JoinTable(name = "filter_certificate", joinColumns = {
        @JoinColumn(name = "certificate_code", referencedColumnName = "certif_code")}, inverseJoinColumns = {
        @JoinColumn(name = "provider_code", referencedColumnName = "provider_code")})
    @ManyToMany
    private Collection<CloudProvider> cloudProviderCollection;

    public Certificate() {
    }

    public Certificate(String certifCode) {
        this.certifCode = certifCode;
    }

    public String getCertifCode() {
        return certifCode;
    }

    public void setCertifCode(String certifCode) {
        this.certifCode = certifCode;
    }

    public String getCertifDescription() {
        return certifDescription;
    }

    public void setCertifDescription(String certifDescription) {
        this.certifDescription = certifDescription;
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
        hash += (certifCode != null ? certifCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificate)) {
            return false;
        }
        Certificate other = (Certificate) object;
        if ((this.certifCode == null && other.certifCode != null) || (this.certifCode != null && !this.certifCode.equals(other.certifCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.Certificate[ certifCode=" + certifCode + " ]";
    }
    
}
