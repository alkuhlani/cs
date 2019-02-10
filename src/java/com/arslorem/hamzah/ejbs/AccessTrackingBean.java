/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;


import com.arslorem.hamzah.entities.AccessTracking;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Stateless
public class AccessTrackingBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(AccessTracking obj) {
        dao.create(obj);
    }

    public List<AccessTracking> findAll() {
        return dao.findAll("AccessTracking.findAll", AccessTracking.class);
    }
public List<AccessTracking> findBy2Date(Date date1,Date date2) {
        return dao.find("AccessTracking.findBy2Date", AccessTracking.class,"date1",date1,"date2",date2);
    } 
public List<AccessTracking> findAllofToday(Date reqTime) {
        return dao.find("AccessTracking.findAllofToday", AccessTracking.class,"date",reqTime);
    }
    public AccessTracking find(Long id) {
        return dao.find(id, AccessTracking.class);
    }

    public void update(AccessTracking obj) {
        dao.update(obj);
    }

    public void delete(AccessTracking obj) {
        dao.delete(obj);
    }
}
