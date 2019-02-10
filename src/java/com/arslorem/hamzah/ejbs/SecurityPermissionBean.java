/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import com.arslorem.hamzah.entities.SecurityPermission;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Stateless
public class SecurityPermissionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(SecurityPermission obj) {
        dao.create(obj);
    }

    public List<SecurityPermission> findAll() {
        return dao.findAll("SecurityPermission.findAll", SecurityPermission.class);
    }

    public List<SecurityPermission> findByPrimaryIdTable(Long primaryIdTable) {
        return dao.find("SecurityPermission.findAll", SecurityPermission.class, "id", primaryIdTable);
    }

    public SecurityPermission find(Long id) {
        return dao.find(id, SecurityPermission.class);
    }

    public void update(SecurityPermission obj) {
        dao.update(obj);
    }

    public void delete(SecurityPermission obj) {
        dao.delete(obj);
    }
}
