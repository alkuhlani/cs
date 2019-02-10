/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;



import com.arslorem.hamzah.ejbs.SecurityGroupBean;
import com.arslorem.hamzah.ejbs.SecurityPermissionBean;
import com.arslorem.hamzah.entities.SecurityGroup;
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
@Named(value = "securityGroupMB")
@ViewScoped
public class SecurityGroupMB implements Serializable {

    /**
     * Creates a new instance of SecurityGroupMB
     */
    public SecurityGroupMB() {
    }
    private List<SecurityPermission> securityPermissions;
    private List<SecurityPermission> securityPermissions_Group;
    private List<SecurityPermission> selectedSecurityPermission;
    private List<SecurityPermission> removeSelectedSecurityPermission;
    private SecurityGroup item;
    private List<SecurityGroup> items;
    private boolean disableContent = false;

    @Inject
    private SecurityGroupBean bean;
    @Inject
    private SecurityPermissionBean securityPermissionBean;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new SecurityGroup();
        item.setCreateTime(new Date());
        item.setCreateUser(new SecurityUser(1L));
    }

    public void prepareUpdate(Long id2) {

        item = bean.find(id2);
        securityPermissions = null;
        disableContent = true;
        securityPermissions_Group = item.getPermissions();
        securityPermissions = securityPermissionBean.findAll();
        securityPermissions.removeAll(securityPermissions_Group);

        selectedSecurityPermission = null;
        removeSelectedSecurityPermission = null;
    }

    public void create() {
        bean.create(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
        disableContent = true;
        securityPermissions_Group = item.getPermissions();
        securityPermissions = securityPermissionBean.findAll();

    }

    public void addPermissionToGroup() {
        if (selectedSecurityPermission != null) {
            item.getPermissions().addAll(selectedSecurityPermission);
            bean.update(item);

        }
        //
        securityPermissions = null;

        disableContent = true;
        securityPermissions_Group = item.getPermissions();
        securityPermissions = securityPermissionBean.findAll();
        securityPermissions.removeAll(securityPermissions_Group);

        selectedSecurityPermission = null;
        removeSelectedSecurityPermission = null;
    }

    public void removePermissionFromGroup() {
        if (removeSelectedSecurityPermission != null) {
            item.getPermissions().removeAll(removeSelectedSecurityPermission);
            bean.update(item);
        }
        securityPermissions = null;

        disableContent = true;
        securityPermissions_Group = item.getPermissions();
        securityPermissions = securityPermissionBean.findAll();
        securityPermissions.removeAll(securityPermissions_Group);

        selectedSecurityPermission = null;
        removeSelectedSecurityPermission = null;
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

    public SecurityGroup getItem() {
        return item;
    }

    public void setItem(SecurityGroup item) {
        this.item = item;
    }

    public List<SecurityGroup> getItems() {
        return items;
    }

    public void setItems(List<SecurityGroup> items) {
        this.items = items;
    }

    public boolean isDisableContent() {
        return disableContent;
    }

    public void setDisableContent(boolean disableContent) {
        this.disableContent = disableContent;
    }

    public List<SecurityPermission> getSecurityPermissions() {
        return securityPermissions;
    }

    public void setSecurityPermissions(List<SecurityPermission> securityPermissions) {
        this.securityPermissions = securityPermissions;
    }

    public List<SecurityPermission> getSelectedSecurityPermission() {
        return selectedSecurityPermission;
    }

    public void setSelectedSecurityPermission(List<SecurityPermission> selectedSecurityPermission) {
        this.selectedSecurityPermission = selectedSecurityPermission;
    }

    public List<SecurityPermission> getSecurityPermissions_Group() {
        return securityPermissions_Group;
    }

    public void setSecurityPermissions_Group(List<SecurityPermission> securityPermissions_Group) {
        this.securityPermissions_Group = securityPermissions_Group;
    }

    public List<SecurityPermission> getRemoveSelectedSecurityPermission() {
        return removeSelectedSecurityPermission;
    }

    public void setRemoveSelectedSecurityPermission(List<SecurityPermission> removeSelectedSecurityPermission) {
        this.removeSelectedSecurityPermission = removeSelectedSecurityPermission;
    }

}
