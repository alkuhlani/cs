/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsPa;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsPaBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsPa obj) {
        dao.create(obj);
    }

    public List<CsPa> findAll() {
        return dao.findAll("CsPa.findAll", CsPa.class);
    }
    public List<CsPa> findByConId(long id) {
        return dao.find("CsPa.findByConId", CsPa.class,"id",id);
    }
    
    public CsPa find(Long id) {
        return dao.find(id, CsPa.class);
    }

    public void update(CsPa obj) {
        dao.update(obj);
    }

    public void delete(CsPa obj) {
        dao.delete(obj);
    }
    
}

