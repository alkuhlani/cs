/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsContractBean;
import com.arslorem.hamzah.ejbs.CsSystemBean;
import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsSystem;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Named(value = "csSystemMB")
@ViewScoped
public class CsSystemMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    
    public CsSystemMB() {
    }
    private CsSystem item;
    private List<CsSystem> items;
    
    @Inject
    private CsSystemBean bean;

    public void prepareItems() {
        items = bean.findAll();
    }
    
    public void prepareCreate() {
        item = new CsSystem();

    }
    
    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
    }
    public void prepareUpdate() {
        item = bean.find(new Long("1"));
        
    }
    
    public void create() {
        bean.create(item);
    }
    
    public void update() {
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        
    }
    
    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public CsSystem getItem() {
        return item;
    }

    public void setItem(CsSystem item) {
        this.item = item;
    }

    public List<CsSystem> getItems() {
        return items;
    }

    public void setItems(List<CsSystem> items) {
        this.items = items;
    }
    
}
