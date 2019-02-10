/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;


import com.arslorem.hamzah.entities.SecurityGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Stateless
public class SecurityGroupBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(SecurityGroup obj) {
        dao.create(obj);
    }

    public List<SecurityGroup> findAll() {
        return dao.findAll("SecurityGroup.findAll", SecurityGroup.class);
    }

    public List<SecurityGroup> findByPrimaryIdTable(Long primaryIdTable) {
        return dao.find("SecurityGroup.primaryIdTable", SecurityGroup.class, "id", primaryIdTable);
    }

    public SecurityGroup find(Long id) {
        return dao.find(id, SecurityGroup.class);
    }

    public void update(SecurityGroup obj) {
        dao.update(obj);
    }

    public void delete(SecurityGroup obj) {
        dao.delete(obj);
    }
}
