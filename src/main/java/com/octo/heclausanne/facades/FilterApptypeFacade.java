/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.facades;

import com.octo.heclausanne.entity.FilterApptype;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ferhat
 */
@Stateless
public class FilterApptypeFacade extends AbstractFacade<FilterApptype> {
    @PersistenceContext(unitName = "com.OCTO.HECLausanne_CloudSF-webApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilterApptypeFacade() {
        super(FilterApptype.class);
    }
    
}
