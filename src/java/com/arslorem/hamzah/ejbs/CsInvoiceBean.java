/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.CsInvoice;
import com.arslorem.hamzah.entities.CsSystem;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Stateless
public class CsInvoiceBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Inject
    private DataAccessObject dao;

    public void create(CsInvoice obj) {
        dao.create(obj);
    }

    public List<CsInvoice> findAll() {
        return dao.findAll("CsInvoice.findAll", CsInvoice.class);
    }
    
    public CsInvoice find(Long id) {
        return dao.find(id, CsInvoice.class);
    }

    public void update(CsInvoice obj) {
        dao.update(obj);
    }

    public void delete(CsInvoice obj) {
        dao.delete(obj);
    }
    
}

