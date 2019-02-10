/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsTor;
import com.arslorem.hamzah.entities.CsTorTask;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsTorTaskBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(CsTorTask obj) {
        dao.create(obj);
    }

    public List<CsTorTask> findAll() {
        return dao.findAll("CsTorTask.findAll", CsTorTask.class);
    }

    public CsTorTask find(Long id) {
        return dao.find(id, CsTorTask.class);
    }

    public void update(CsTorTask obj) {
        dao.update(obj);
    }

    public void delete(CsTorTask obj) {
        dao.delete(obj);
    }

}
