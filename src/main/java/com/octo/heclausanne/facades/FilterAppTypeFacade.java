/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.facades;

import com.octo.heclausanne.entity.FilterAppType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ferhat
 */
@Stateless
public class FilterAppTypeFacade extends AbstractFacade<FilterAppType> {
    @PersistenceContext(unitName = "com.OCTO.HECLausanne_CloudSF-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilterAppTypeFacade() {
        super(FilterAppType.class);
    }
    
}
