/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;


import com.arslorem.hamzah.ejbs.AccessTrackingBean;
import com.arslorem.hamzah.entities.AccessTracking;
import com.arslorem.hamzah.util.HelperClass;
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
@Named(value = "accessTrackingMB")
@ViewScoped
public class AccessTrackingMB implements Serializable {

    /**
     * Creates a new instance of SecurityPermissionMB
     */
    public AccessTrackingMB() {
    }
    private AccessTracking item;
    private List<AccessTracking> items;
    private Date currentDate;
    private Date firstYesterdatDate;
    private HelperClass helperClass = new HelperClass();

    @Inject
    private AccessTrackingBean bean;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareItemsOnly(int type) {
        currentDate = new Date();
        currentDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate(), 00, 00, 00);
        firstYesterdatDate = new Date(getMeYesterday().getYear(), getMeYesterday().getMonth(), getMeYesterday().getDate(), 00, 00, 00);
        if (type == 1) {
            items = bean.findAllofToday(firstYesterdatDate);
        }
        if (type == 2) {
            items = bean.findAllofToday(currentDate);
        }
        if (type == 3) {
            items = bean.findAll();
        }
        if (type == 4) {
            items = bean.findBy2Date(helperClass.getFirstDate(), helperClass.getLastDate());
        }
        
    }

    private Date getMeYesterday() {
        return new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }

    private Date getMeTomorrow() {
        return new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
    }

    public void prepareCreate() {
        item = new AccessTracking();
        item.setCreateTime(new Date());
//        item.setCreateUser(new SecurityUser(1L));

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

    public AccessTracking getItem() {
        return item;
    }

    public void setItem(AccessTracking item) {
        this.item = item;
    }

    public List<AccessTracking> getItems() {
        return items;
    }

    public void setItems(List<AccessTracking> items) {
        this.items = items;
    }

}
