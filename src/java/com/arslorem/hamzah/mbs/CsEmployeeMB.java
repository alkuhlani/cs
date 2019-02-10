/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsContractBean;
import com.arslorem.hamzah.ejbs.CsEmployeeBean;
import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsEmployee;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author said
 */
@Named(value = "csEmployeeMB")
@ViewScoped
public class CsEmployeeMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    public CsEmployeeMB() {
    }
    private CsEmployee item;
    private List<CsEmployee> items;

    @Inject
    private CsEmployeeBean bean;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new CsEmployee();
        item.setEmpisDefaultTor(Boolean.FALSE);

    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
    }

    public String create() {
        
        if (item.getEmpisDefaultTor()) {
            items = bean.findByEmpType(item.getEmpType());
            if (Objects.nonNull(items)) {
                for (int i = 0; i < items.size(); i++) {
                    CsEmployee newItem;
                    newItem = bean.find(items.get(i).getEmpID());
                    newItem.setEmpisDefaultTor(Boolean.FALSE);
                    bean.update(newItem);
                }
            }
        }
        bean.create(item);
        return "items?faces-redirect=true";
    }

    public String update() {
        if (item.getEmpisDefaultTor()) {
            items = bean.findByEmpType(item.getEmpType());
            if (Objects.nonNull(items)) {
                for (int i = 0; i < items.size(); i++) {
                    CsEmployee newItem;
                    newItem = bean.find(items.get(i).getEmpID());
                    newItem.setEmpisDefaultTor(Boolean.FALSE);
                    bean.update(newItem);
                }
            }
        }
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "items?faces-redirect=true";

    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public CsEmployee getItem() {
        return item;
    }

    public void setItem(CsEmployee item) {
        this.item = item;
    }

    public List<CsEmployee> getItems() {
        return items;
    }

    public void setItems(List<CsEmployee> items) {
        this.items = items;
    }

}
