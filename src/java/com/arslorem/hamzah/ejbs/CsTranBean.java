/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsSystem;
import com.arslorem.hamzah.entities.CsTran;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsTranBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsTran obj) {
        dao.create(obj);
    }

    public List<CsTran> findAll() {
        return dao.findAll("CsTran.findAll", CsTran.class);
    }
    public List<CsTran> findByConId(long id) {
        return dao.find("CsTran.findByConId", CsTran.class,"id",id);
    }
    
    public CsTran find(Long id) {
        return dao.find(id, CsTran.class);
    }

    public void update(CsTran obj) {
        dao.update(obj);
    }

    public void delete(CsTran obj) {
        dao.delete(obj);
    }
    
}

