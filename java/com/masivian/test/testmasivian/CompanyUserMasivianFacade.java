/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.testmasivian;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ingru
 */
@Stateless
public class CompanyUserMasivianFacade extends AbstractFacade<CompanyUserMasivian> {
    @PersistenceContext(unitName = "com.masivian.test_TestMasivian_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompanyUserMasivianFacade() {
        super(CompanyUserMasivian.class);
    }
    
}
