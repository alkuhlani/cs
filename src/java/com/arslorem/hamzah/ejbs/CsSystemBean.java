/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsSystemBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Inject
    private DataAccessObject dao;

    public void create(CsSystem obj) {
        dao.create(obj);
    }

    public List<CsSystem> findAll() {
        return dao.findAll("CsSystem.findAll", CsSystem.class);
    }
    
    public CsSystem find(Long id) {
        return dao.find(id, CsSystem.class);
    }

    public void update(CsSystem obj) {
        dao.update(obj);
    }

    public void delete(CsSystem obj) {
        dao.delete(obj);
    }
    
}
