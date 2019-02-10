/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsSystem;
import com.arslorem.hamzah.entities.CsWorkplan;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsWorkplanBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsWorkplan obj) {
        dao.create(obj);
    }

    public List<CsWorkplan> findAll() {
        return dao.findAll("CsWorkplan.findAll", CsWorkplan.class);
    }
    public List<CsWorkplan> findByTorID(Long id) {
        return dao.find("CsWorkplan.findByTorID", CsWorkplan.class,"id",id);
    }
    
    public CsWorkplan find(Long id) {
        return dao.find(id, CsWorkplan.class);
    }

    public void update(CsWorkplan obj) {
        dao.update(obj);
    }

    public void delete(CsWorkplan obj) {
        dao.delete(obj);
    }
    
}

