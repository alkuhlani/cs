/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsSwTor;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsSwTorBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsSwTor obj) {
        dao.create(obj);
    }

    public List<CsSwTor> findAll() {
        return dao.findAll("CsSwTor.findAll", CsSwTor.class);
    }
    
    public CsSwTor find(Long id) {
        return dao.find(id, CsSwTor.class);
    }

    public void update(CsSwTor obj) {
        dao.update(obj);
    }

    public void delete(CsSwTor obj) {
        dao.delete(obj);
    }
    
}

