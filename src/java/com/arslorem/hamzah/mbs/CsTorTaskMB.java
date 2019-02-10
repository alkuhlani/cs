/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsTorBean;
import com.arslorem.hamzah.ejbs.CsTorTaskBean;
import com.arslorem.hamzah.entities.CsTor;
import com.arslorem.hamzah.entities.CsTorTask;
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
@Named(value = "csTorTaskMB")
@ViewScoped
public class CsTorTaskMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    
    public CsTorTaskMB() {
    }
    private CsTorTask item;
    private List<CsTorTask> items;
    
    @Inject
    private CsTorTaskBean bean;

    public void prepareItems() {
        items = bean.findAll();
    }
    
    public void prepareCreate() {
        item = new CsTorTask();

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

    public CsTorTask getItem() {
        return item;
    }

    public void setItem(CsTorTask item) {
        this.item = item;
    }

    public List<CsTorTask> getItems() {
        return items;
    }

    public void setItems(List<CsTorTask> items) {
        this.items = items;
    }

    
}
