/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsSystemBean;
import com.arslorem.hamzah.entities.CsSystem;
import com.arslorem.hamzah.util.StaticClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author said
 */
@Named(value = "sessionMB")
@SessionScoped
public class SessionMB implements Serializable {

    /**
     * Creates a new instance of SessionMB
     */
    private CsSystem csSystem;

    @Inject
    private CsSystemBean bean;

    public SessionMB() {
    }
    private StreamedContent CV;
    private StreamedContent ID;
    private StreamedContent conID;
    private StreamedContent conVC;
    private StreamedContent conSPL;
    private StreamedContent conOffer;
    private StreamedContent conExchangeReate;
    private StreamedContent conWP;
    private StreamedContent conCL;
    private StreamedContent conTS;
    private StreamedContent conSD;
    private long currentID;

    public void getCVID(Long id) throws FileNotFoundException {
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = bean.find(new Long("1"));
            src = csSystem.getSysName();

        } else {
            csSystem = bean.find(new Long("1"));

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        System.out.println("wwwww");
        File CVFile = new File(src + StaticClass.contractorFolderName + "/" + id + "/CV.pdf");
        if (!CVFile.exists()) {
            CV = null;
        } else {
            InputStream CVIS = new FileInputStream(CVFile);
            CV = new DefaultStreamedContent(CVIS, "application/pdf");
        }
        System.out.println("wwwww");
        File IDFile = new File(src + StaticClass.contractorFolderName + "/" + id + "/ID.pdf");
        if (!IDFile.exists()) {
            ID = null;
        } else {
            InputStream IDIS = new FileInputStream(IDFile);
            ID = new DefaultStreamedContent(IDIS, "application/pdf");
        }

    }

    public void getTorContent(Long id) throws FileNotFoundException, IOException {
        //
        currentID = id;
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = bean.find(new Long("1"));
            src = csSystem.getSysName();

        } else {
            csSystem = bean.find(new Long("1"));

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        //
        File conCVFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._15CV);
        if (!conCVFile.exists()) {
            conVC = null;
        } else {
            InputStream conCVIS = new FileInputStream(conCVFile);
            conCVIS.mark(0);
            conVC = new DefaultStreamedContent(conCVIS, "application/pdf");
        }

        //
        File conIDFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._14ID);
        if (!conIDFile.exists()) {
            conID = null;
        } else {
            InputStream conIDIS = new FileInputStream(conIDFile);
            conIDIS.mark(0);
            conID = new DefaultStreamedContent(conIDIS, "application/pdf");

        }
        //
        File conSPLFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._9SPL);
        if (!conSPLFile.exists()) {
            conSPL = null;
        } else {
            InputStream conSPLIS = new FileInputStream(conSPLFile);
            conSPLIS.mark(0);
            conSPL = new DefaultStreamedContent(conSPLIS, "application/pdf");
        }
        //
        File conOfferFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._13Offer);
        if (!conOfferFile.exists()) {
            conOffer = null;
        } else {
            InputStream conOfferIS = new FileInputStream(conOfferFile);
            conOfferIS.mark(0);
            conOffer = new DefaultStreamedContent(conOfferIS, "application/pdf");
        }
        //
        File conERFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._16ExchangeRate);
        if (!conERFile.exists()) {
            conExchangeReate = null;
        } else {
            InputStream conERIS = new FileInputStream(conERFile);
            conERIS.mark(0);
            conExchangeReate = new DefaultStreamedContent(conERIS, "application/pdf");
        }
        //
        File conWPFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._3WorkPlan);
        if (!conWPFile.exists()) {
            conWP = null;
        } else {
            InputStream conWPIS = new FileInputStream(conWPFile);
            conWPIS.mark(0);
            conWP = new DefaultStreamedContent(conWPIS, "application/pdf");
        }
        //
        File conCLFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._12CheckList);
        if (!conCLFile.exists()) {
            conCL = null;
        } else {
            InputStream conCLIS = new FileInputStream(conCLFile);
            conCLIS.mark(0);
            conCL = new DefaultStreamedContent(conCLIS, "application/pdf");
        }
        //
        File conTSFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._5TimeSheet);
        if (!conTSFile.exists()) {
            conTS = null;
        } else {
            InputStream conTSIS = new FileInputStream(conTSFile);
            conTSIS.mark(0);
            conTS = new DefaultStreamedContent(conTSIS, "application/pdf");
        }
        //
        File conSDFile = new File(src + StaticClass.contractFolderName + "/" + id + StaticClass._6SecurityDeclaration);
        if (!conSDFile.exists()) {
            conSD = null;
        } else {
            InputStream conSDIS = new FileInputStream(conSDFile);
            conSDIS.mark(0);
            conSD = new DefaultStreamedContent(conSDIS, "application/pdf");
        }
        //
    }

    public StreamedContent getCV() {
        return CV;
    }

    public void setCV(StreamedContent CV) {
        this.CV = CV;
    }

    public StreamedContent getID() {
        return ID;
    }

    public void setID(StreamedContent ID) {
        this.ID = ID;
    }

    public StreamedContent getConID() throws IOException {
        if (conID != null) {
//            conID.getStream().reset(); //reset stream to the start position!
        }
        return conID;
    }

    public void setConID(StreamedContent conID) {
        this.conID = conID;
    }

    public StreamedContent getConVC() throws IOException {
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = bean.find(new Long("1"));
            src = csSystem.getSysName();

        } else {
            csSystem = bean.find(new Long("1"));

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File conCVFile = new File(src + StaticClass.contractFolderName + "/" + currentID + StaticClass._15CV);
        if (!conCVFile.exists()) {
            conVC = null;
            System.out.println("not exit");
        } else {
            System.out.println("exit");
            conVC.getStream().close();
            InputStream conCVIS = new FileInputStream(conCVFile);
            conCVIS.mark(0);
            conVC = new DefaultStreamedContent(conCVIS, "application/pdf");
            
        }
        return conVC;
    }

    public void setConVC(StreamedContent conVC) {
        this.conVC = conVC;
    }

    public StreamedContent getConSPL() {
        return conSPL;
    }

    public void setConSPL(StreamedContent conSPL) {
        this.conSPL = conSPL;
    }

    public StreamedContent getConOffer() {
        return conOffer;
    }

    public void setConOffer(StreamedContent conOffer) {
        this.conOffer = conOffer;
    }

    public StreamedContent getConExchangeReate() {
        return conExchangeReate;
    }

    public void setConExchangeReate(StreamedContent conExchangeReate) {
        this.conExchangeReate = conExchangeReate;
    }

    public StreamedContent getConWP() {
        return conWP;
    }

    public void setConWP(StreamedContent conWP) {
        this.conWP = conWP;
    }

    public StreamedContent getConCL() {
        return conCL;
    }

    public void setConCL(StreamedContent conCL) {
        this.conCL = conCL;
    }

    public void checkBoxListner(boolean stat) throws IOException{
    }

    public StreamedContent getConTS() {
        return conTS;
    }

    public void setConTS(StreamedContent conTS) {
        this.conTS = conTS;
    }

    public StreamedContent getConSD() {
        return conSD;
    }

    public void setConSD(StreamedContent conSD) {
        this.conSD = conSD;
    }
    
}
