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
@Table(name = "Certificates", catalog = "CloudSF", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificates.findAll", query = "SELECT c FROM Certificates c"),
    @NamedQuery(name = "Certificates.findByCertifCode", query = "SELECT c FROM Certificates c WHERE c.certifCode = :certifCode"),
    @NamedQuery(name = "Certificates.findByCertifDescription", query = "SELECT c FROM Certificates c WHERE c.certifDescription = :certifDescription")})
public class Certificates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Certif_Code", nullable = false, length = 30)
    private String certifCode;
    @Size(max = 50)
    @Column(name = "Certif_Description", length = 50)
    private String certifDescription;
    @JoinTable(name = "FilterCertificates", joinColumns = {
        @JoinColumn(name = "Certificates_Code", referencedColumnName = "Certif_Code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Provider_Code", referencedColumnName = "Provider_Code", nullable = false)})
    @ManyToMany
    private Collection<CloudProvider> cloudProviderCollection;

    public Certificates() {
    }

    public Certificates(String certifCode) {
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
        if (!(object instanceof Certificates)) {
            return false;
        }
        Certificates other = (Certificates) object;
        if ((this.certifCode == null && other.certifCode != null) || (this.certifCode != null && !this.certifCode.equals(other.certifCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.octo.heclausanne.entity.Certificates[ certifCode=" + certifCode + " ]";
    }
    
}
