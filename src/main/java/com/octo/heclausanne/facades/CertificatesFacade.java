/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.facades;

import com.octo.heclausanne.entity.Certificates;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ferhat
 */
@Stateless
public class CertificatesFacade extends AbstractFacade<Certificates> {
    @PersistenceContext(unitName = "com.OCTO.HECLausanne_CloudSF-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CertificatesFacade() {
        super(Certificates.class);
    }
    
}
