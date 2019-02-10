/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;



import com.arslorem.hamzah.ejbs.SecurityPermissionBean;
import com.arslorem.hamzah.entities.SecurityPermission;
import com.arslorem.hamzah.entities.SecurityUser;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "securityPermissionMB")
@ViewScoped
public class SecurityPermissionMB implements Serializable{

    /**
     * Creates a new instance of SecurityPermissionMB
     */
    public SecurityPermissionMB() {
    }
    private SecurityPermission item;
    private List<SecurityPermission> items;
    
    

    @Inject
    private SecurityPermissionBean bean;


    public void prepareItems() {
        items = bean.findAll();
    }


    public void prepareCreate() {
        item = new SecurityPermission();
        item.setCreateTime(new Date());
        item.setCreateUser(new SecurityUser(1L));
       
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
    }

    public void create() {
        bean.create(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
        //  return "items?faces-redirect=true";
    }

    public String update() {
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "items?faces-redirect=true";

    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public SecurityPermission getItem() {
        return item;
    }

    public void setItem(SecurityPermission item) {
        this.item = item;
    }

    public List<SecurityPermission> getItems() {
        return items;
    }

    public void setItems(List<SecurityPermission> items) {
        this.items = items;
    }
    
}
