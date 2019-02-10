/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsContractBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsContract obj) {
        dao.create(obj);
    }

    public List<CsContract> findAll() {
        return dao.findAll("CsContract.findAll", CsContract.class);
    }
    public List<CsContract> findByTorID(Long id) {
        return dao.find("CsContract.findByTorID", CsContract.class,"id",id);
    }
    
    public CsContract find(Long id) {
        return dao.find(id, CsContract.class);
    }

    public void update(CsContract obj) {
        dao.update(obj);
    }

    public void delete(CsContract obj) {
        dao.delete(obj);
    }
    
}

