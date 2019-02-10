/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsEmployee;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsEmployeeBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsEmployee obj) {
        dao.create(obj);
    }

    public List<CsEmployee> findByEmpType(String type) {
        return dao.find("CsEmployee.findByEmpType", CsEmployee.class,"empType",type);
    }
    public List<CsEmployee> findAll() {
        return dao.findAll("CsEmployee.findAll", CsEmployee.class);
    }
    
    public CsEmployee find(Long id) {
        return dao.find(id, CsEmployee.class);
    }

    public void update(CsEmployee obj) {
        dao.update(obj);
    }

    public void delete(CsEmployee obj) {
        dao.delete(obj);
    }
    
}

