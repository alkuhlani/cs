/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsSwTorCo;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsSwTorCoBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsSwTorCo obj) {
        dao.create(obj);
    }

    public List<CsSwTorCo> findAll() {
        return dao.findAll("CsSwTorCo.findAll", CsSwTorCo.class);
    }
    
    public CsSwTorCo find(Long id) {
        return dao.find(id, CsSwTorCo.class);
    }

    public void update(CsSwTorCo obj) {
        dao.update(obj);
    }

    public void delete(CsSwTorCo obj) {
        dao.delete(obj);
    }
    
}

