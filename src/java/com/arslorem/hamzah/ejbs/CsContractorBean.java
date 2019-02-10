/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsContractor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsContractorBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(CsContractor obj) {
        dao.create(obj);
    }

    public List<CsContractor> findAll() {
        return dao.findAll("CsContractor.findAll", CsContractor.class);
    }

    public CsContractor find(Long id) {
        return dao.find(id, CsContractor.class);
    }

    public void update(CsContractor obj) {
        dao.update(obj);
    }

    public void delete(CsContractor obj) {
        dao.delete(obj);
    }

}
