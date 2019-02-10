/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsContractBean;
import com.arslorem.hamzah.ejbs.CsProjectBean;
import com.arslorem.hamzah.ejbs.CsProjectnoBean;
import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsProject;
import com.arslorem.hamzah.entities.CsProjectno;
import com.arslorem.hamzah.entities.CsWorkplan;
import com.oracle.wls.shaded.org.apache.bcel.generic.Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author said
 */
@Named(value = "csProjectMB")
@ViewScoped
public class CsProjectMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    public CsProjectMB() {
    }
    private CsProject item;
    private CsProjectno projectno;
    private List<CsProject> items;
    private List<CsProjectno> projectnos;
    private List<String> proIDs;

    @Inject
    private CsProjectBean bean;
    @Inject
    private CsProjectnoBean projectnoBean;

    public void prepareItems() {
        System.out.println("sss");
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new CsProject();

    }

    public void addProNo() {
        projectnoBean.update(projectno);
        projectnos = projectnoBean.findByProID(item.getProID());
    }

    public void deleteProNo(long id) {
        try {

            projectnoBean.delete(projectnoBean.find(id));
//        projectnoBean.update(projectno);
            projectnos = projectnoBean.findByProID(item.getProID());
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Can't Delete - it Has object related: ");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
        projectnos = projectnoBean.findByProID(id2);
        projectno = new CsProjectno();
        projectno.setPNoproID(item);
//        if (Objects.nonNull(projectnos)) {
//            proIDs = new ArrayList<>();
//            for (int i = 0; i < projectnos.size(); i++) {
//                projectno = projectnoBean.find(projectnos.get(i).getPNoid());
//                proIDs.add(i, projectno.getPNoNO());
//            }
//        }
    }

    public String create() {
        bean.create(item);
        for (int i = 0; i < proIDs.size(); i++) {
            projectno = new CsProjectno();
            projectno.setPNoproID(item);
            projectno.setPNoNO(proIDs.get(i));
            projectnoBean.create(projectno);
        }
        return "items?faces-redirect=true";
    }

    public String update() {
        bean.update(item);
        for (int i = 0; i < projectnos.size(); i++) {
            boolean isHave = false;
            for (int j = 0; j < proIDs.size(); j++) {
                if (projectnos.get(i).getPNoNO() == proIDs.get(j)) {
                    isHave = true;
                }
            }
            if (!isHave) {
                projectnoBean.delete(projectnos.get(i));
            }
        }
        for (int i = 0; i < proIDs.size(); i++) {
            if (projectnoBean.findByProID_NO(item.getProID(), proIDs.get(i)).size() > 0) {
            } else {
                projectno = new CsProjectno();
                projectno.setPNoproID(item);
                projectno.setPNoNO(proIDs.get(i));
                projectnoBean.create(projectno);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "items?faces-redirect=true";
    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public CsProject getItem() {
        return item;
    }

    public void setItem(CsProject item) {
        this.item = item;
    }

    public List<CsProject> getItems() {
        return items;
    }

    public void setItems(List<CsProject> items) {
        this.items = items;
    }

    public List<String> getProIDs() {
        return proIDs;
    }

    public void setProIDs(List<String> proIDs) {
        this.proIDs = proIDs;
    }

    public CsProjectno getProjectno() {
        return projectno;
    }

    public void setProjectno(CsProjectno projectno) {
        this.projectno = projectno;
    }

    public List<CsProjectno> getProjectnos() {
        return projectnos;
    }

    public void setProjectnos(List<CsProjectno> projectnos) {
        this.projectnos = projectnos;
    }

    public void onRowEdit(RowEditEvent event) {
        projectnoBean.update((CsProjectno) event.getObject());

//        prepareContract(((CsWorkplan) event.getObject()).getWptorID().getTorId());
        FacesMessage msg = new FacesMessage("Updated: ", ((CsProjectno) event.getObject()).getPNoNO());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
//        projectnoBean.update((CsProjectno) event.getObject());
//        prepareContract(((CsWorkplan) event.getObject()).getWptorID().getTorId());
        FacesMessage msg = new FacesMessage("Update Canceled: ", ((CsProjectno) event.getObject()).getPNoNO());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
