/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsContractBean;
import com.arslorem.hamzah.ejbs.CsSwTorBean;
import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsSwTor;
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
@Named(value = "csSwTorMB")
@ViewScoped
public class CsSwTorMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    
    public CsSwTorMB() {
    }
    private CsSwTor item;
    private List<CsSwTor> items;
    
    @Inject
    private CsSwTorBean bean;

    public void prepareItems() {
        items = bean.findAll();
    }
    
    public void prepareCreate() {
        item = new CsSwTor();

    }
    
    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
    }
    
    public void create() {
        bean.create(item);
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

    public CsSwTor getItem() {
        return item;
    }

    public void setItem(CsSwTor item) {
        this.item = item;
    }

    public List<CsSwTor> getItems() {
        return items;
    }

    public void setItems(List<CsSwTor> items) {
        this.items = items;
    }
    
}
