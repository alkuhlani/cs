/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;


import com.arslorem.hamzah.entities.SecurityUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Stateless
public class SecurityUserBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(SecurityUser obj) {
        dao.create(obj);
    }

    public List<SecurityUser> findAll() {
        return dao.findAll("SecurityUser.findAll", SecurityUser.class);
    }

    public SecurityUser findByUserNamePassword(String userName, String password) {
        return dao.findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
    }
    public List<SecurityUser> findByUserName(String userName) {
        return dao.find("SecurityUser.findByUserName", SecurityUser.class, "userName", userName);
    }
    public List<SecurityUser> findByOfficialEmail(String officialEmail) {
        return dao.find("SecurityUser.findByOfficialEmail", SecurityUser.class, "officialEmail", officialEmail);
    }
    public List<SecurityUser> findByOfficialPhone(String officialPhone) {
        return dao.find("SecurityUser.findByOfficialPhone", SecurityUser.class, "officialPhone", officialPhone);
    }

    public SecurityUser find(Long id) {
        return dao.find(id, SecurityUser.class);
    }

    public void update(SecurityUser obj) {
        dao.update(obj);
    }

    public void delete(SecurityUser obj) {
        dao.delete(obj);
    }
}
