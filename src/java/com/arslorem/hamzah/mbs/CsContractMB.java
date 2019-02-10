/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.util.JasperManager;
import com.arslorem.hamzah.ejbs.CsContractBean;
import com.arslorem.hamzah.ejbs.CsContractorBean;
import com.arslorem.hamzah.ejbs.CsEmployeeBean;
import com.arslorem.hamzah.ejbs.CsPaBean;
import com.arslorem.hamzah.ejbs.CsProjectBean;
import com.arslorem.hamzah.ejbs.CsProjectnoBean;
import com.arslorem.hamzah.ejbs.CsSystemBean;
import com.arslorem.hamzah.ejbs.CsTorBean;
import com.arslorem.hamzah.ejbs.CsTranBean;
import com.arslorem.hamzah.ejbs.CsWorkplanBean;
import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsContractor;
import com.arslorem.hamzah.entities.CsEmployee;
import com.arslorem.hamzah.entities.CsPa;
import com.arslorem.hamzah.entities.CsProject;
import com.arslorem.hamzah.entities.CsProjectno;
import com.arslorem.hamzah.entities.CsSystem;
import com.arslorem.hamzah.entities.CsTor;
import com.arslorem.hamzah.entities.CsTran;
import com.arslorem.hamzah.entities.CsWorkplan;
import com.arslorem.hamzah.util.NumbersToWords;
import com.arslorem.hamzah.util.StaticClass;
import com.arslorem.hamzah.util.UtilClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author said
 */
@Named(value = "csContractMB")
@ViewScoped
public class CsContractMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    public CsContractMB() {
    }
    private CsContract item;
    private CsSystem csSystem;
    private CsTor csTor;
    private CsPa csPa;
    private CsWorkplan csWorkplan;
    private CsTran csTran;
    private List<CsTor> csTors;
    private List<CsPa> csPas;
    private List<CsProject> csProjects;
    private List<CsProjectno> csProjectnos;
    private List<CsContract> items;
    private List<CsContractor> csContractors;
    private CsContractor csContractor;
    private List<CsEmployee> csEmployees;
    private List<CsEmployee> csEmployees2;
    private List<CsEmployee> csEmployees3;
    private List<CsWorkplan> csWorkplans;
    private List<CsTran> csTrans;
    private String contractNo;
    private String contractNoForUpdate;
    private int workingDays = 0;
    private int paDayTotal = 0;
    private int paWorkingDayTotal = 0;

    private double paDPerdiemAverage = 0d;
    private double paDPerdiemTotal = 0d;
    private double paAcco = 0d;
    private double paAccoTotal = 0d;
    private int paAccoDayTotal = 0;
    private int paTranTimesTotal = 0;
    private double paTranKMTotal = 0d;
    private double paTranFeesTotal = 0d;
    private double paTranTotalTotal = 0d;
    private Double conTotalInNumbers = 0d;
    private String conTotalInWords = "";

    private Boolean p1;
    private Boolean p2;
    private Boolean p3;
    private Boolean p4;
    private int p1Percentage;
    private int p2Percentage;
    private int p3Percentage;
    private int p4Percentage;

    private boolean showSD = false;
    private boolean showTimeSheet = false;
    private boolean showGeneralTerm = false;
    private boolean showFeeSchedule = false;
    private boolean showSPL = false;
    private boolean showSPLUpload = false;
    private boolean showOffer = false;
    private boolean showOfferUpload = false;
    private boolean showExchangeRate = false;
    private boolean showExchangeRateUpload = false;
    private boolean showWP = false;
    private boolean showWPUpload = false;
    private boolean showCV = false;
    private boolean showID = false;
    private boolean showCL = false;
    private boolean showCLUpload = false;
    @Inject
    private CsContractBean bean;
    @Inject
    private CsProjectBean csProjectBean;
    @Inject
    private CsProjectnoBean csProjectnoBean;
    @Inject
    private CsSystemBean csSystemBean;
    @Inject
    private CsTorBean csTorBean;
    @Inject
    private CsWorkplanBean csWorkplanBean;
    @Inject
    private CsContractorBean csContractorBean;
    @Inject
    private CsEmployeeBean csEmployeeBean;
    @Inject
    private CsPaBean csPaBean;
    @Inject
    private CsTranBean csTranBean;
    @Inject
    private JasperManager jasperManager;

    public void onRowEdit(RowEditEvent event) {
        csWorkplanBean.update((CsWorkplan) event.getObject());

        prepareContract(((CsWorkplan) event.getObject()).getWptorID().getTorId());

        FacesMessage msg = new FacesMessage("Updated: ", ((CsWorkplan) event.getObject()).getWpNo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        csWorkplanBean.update((CsWorkplan) event.getObject());
        prepareContract(((CsWorkplan) event.getObject()).getWptorID().getTorId());
        FacesMessage msg = new FacesMessage("Update Canceled: ", ((CsWorkplan) event.getObject()).getWpNo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEditPA(RowEditEvent event) {
        csPaBean.update((CsPa) event.getObject());
        csPas = item.getCsPaList();
        if (Objects.nonNull(csPas)) {
            for (int i = 0; i < csPas.size(); i++) {
                paDayTotal++;
                if (csPas.get(i).getPaaccoisWorkingDay()) {
                    paWorkingDayTotal++;
                }
                if (csPas.get(i).getPaPerAmount() != null) {
                    item.setConPerdiemAverage(item.getConPerdiemAverage() + csPas.get(i).getPaPerAmount());
                }
                if (csPas.get(i).getPaAccoAmount() != null) {
                    paAccoTotal += csPas.get(i).getPaAccoAmount();
                }
            }
            item.setConPerdiemAverage(item.getConPerdiemAverage() / paDayTotal);
            paDPerdiemTotal = item.getConPerdiemAverage() * paDayTotal;
        }
        bean.update(item);
        prepareContract(((CsPa) event.getObject()).getPaconID().getContorID().getTorId());
        FacesMessage msg = new FacesMessage("Updated: ", ((CsPa) event.getObject()).getPaconrdayNo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancelPA(RowEditEvent event) {
        csPaBean.update((CsPa) event.getObject());
        csPas = item.getCsPaList();
        if (Objects.nonNull(csPas)) {
            for (int i = 0; i < csPas.size(); i++) {
                paDayTotal++;
                if (csPas.get(i).getPaaccoisWorkingDay()) {
                    paWorkingDayTotal++;
                }
                if (csPas.get(i).getPaPerAmount() != null) {
                    item.setConPerdiemAverage(item.getConPerdiemAverage() + csPas.get(i).getPaPerAmount());
                }
                if (csPas.get(i).getPaAccoAmount() != null) {
                    paAccoTotal += csPas.get(i).getPaAccoAmount();
                }
            }
            item.setConPerdiemAverage(item.getConPerdiemAverage() / paDayTotal);
            paDPerdiemTotal = item.getConPerdiemAverage() * paDayTotal;
        }
        bean.update(item);
        prepareContract(((CsPa) event.getObject()).getPaconID().getContorID().getTorId());
        FacesMessage msg = new FacesMessage("Update Canceled: ", ((CsPa) event.getObject()).getPaconrdayNo().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEditTra(RowEditEvent event) {
        csTranBean.update((CsTran) event.getObject());
        prepareContract(((CsTran) event.getObject()).getTraconID().getContorID().getTorId());
        FacesMessage msg = new FacesMessage("Updated: ", ((CsTran) event.getObject()).getTraDesc());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancelTra(RowEditEvent event) {
        csTranBean.update((CsTran) event.getObject());
        prepareContract(((CsTran) event.getObject()).getTraconID().getContorID().getTorId());
        FacesMessage msg = new FacesMessage("Update Canceled: ", ((CsTran) event.getObject()).getTraDesc());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void prepareItems() {
//        items = bean.findAll();
        csTors = csTorBean.findAll();
    }

    public String saveH() {
        bean.update(item);
        prepareContract(csTor.getTorId());
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public void saveAverage() {
        bean.update(item);
        prepareContract(csTor.getTorId());
    }

    public void startPayement() {
        item.setConIsPayment(true);
    }

    public void doneSPL() {
        item.setConIsAdhoc(true);
        bean.update(item);
    }

    public String savePayement() {
        if (item.getCon_payment1_p() + item.getCon_payment2_p() + item.getCon_payment3_p() + item.getCon_payment4_p() == 100) {
            item.setConIsPayment(true);
            bean.update(item);
            return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "sum of persentage must be 100"));
            return null;
        }

    }

    public void doPayment() {
        if (item.getConPayment4Invoice()) {
            item.setConPayment4(conTotalInNumbers);
            item.setConPayment1(0d);
            item.setConPayment2(0d);
            item.setConPayment3(0d);
            item.setCon_payment4_p(100);
            item.setCon_payment1_p(0);
            item.setCon_payment2_p(0);
            item.setCon_payment3_p(0);
            if (item.getConPayment1Invoice()) {
                item.setConPayment4(conTotalInNumbers / 100 * 60);
                item.setConPayment1(conTotalInNumbers / 100 * 40);
                item.setConPayment2(0d);
                item.setConPayment3(0d);
                item.setCon_payment4_p(60);
                item.setCon_payment1_p(40);
                item.setCon_payment2_p(0);
                item.setCon_payment3_p(0);
                if (item.getConPayment2Invoice()) {
                    item.setConPayment4(conTotalInNumbers / 100 * 60);
                    item.setConPayment1(conTotalInNumbers / 100 * 20);
                    item.setConPayment2(conTotalInNumbers / 100 * 20);
                    item.setConPayment3(0d);
                    item.setCon_payment4_p(60);
                    item.setCon_payment1_p(20);
                    item.setCon_payment2_p(20);
                    item.setCon_payment3_p(0);
                    if (item.getConPayment3Invoice()) {
                        item.setConPayment4(conTotalInNumbers);
                        item.setConPayment1(conTotalInNumbers);
                        item.setConPayment2(conTotalInNumbers);
                        item.setConPayment3(conTotalInNumbers);
                        item.setCon_payment4_p(60);
                        item.setCon_payment1_p(20);
                        item.setCon_payment2_p(10);
                        item.setCon_payment3_p(10);
                    }
                }
            }

        }
    }

    public void doPayment2() {
        if (item.getConPayment4Invoice()) {
            item.setConPayment4(conTotalInNumbers / 100 * item.getCon_payment4_p());
            item.setConPayment1(0d);
            item.setConPayment2(0d);
            item.setConPayment3(0d);

            if (item.getConPayment1Invoice()) {
                item.setConPayment4(conTotalInNumbers / 100 * item.getCon_payment4_p());
                item.setConPayment1(conTotalInNumbers / 100 * item.getCon_payment1_p());
                item.setConPayment2(0d);
                item.setConPayment3(0d);

                if (item.getConPayment2Invoice()) {
                    item.setConPayment4(conTotalInNumbers / 100 * item.getCon_payment4_p());
                    item.setConPayment1(conTotalInNumbers / 100 * item.getCon_payment1_p());
                    item.setConPayment2(conTotalInNumbers / 100 * item.getCon_payment2_p());
                    item.setConPayment3(0d);

                    if (item.getConPayment3Invoice()) {
                        item.setConPayment4(conTotalInNumbers / 100 * item.getCon_payment4_p());
                        item.setConPayment1(conTotalInNumbers / 100 * item.getCon_payment1_p());
                        item.setConPayment2(conTotalInNumbers / 100 * item.getCon_payment2_p());
                        item.setConPayment3(conTotalInNumbers / 100 * item.getCon_payment3_p());
                    }
                }
            }

        }
    }

    public void prepareContract(long torId) {
        csEmployees = csEmployeeBean.findAll();
        csEmployees2 = csEmployeeBean.findAll();
        csEmployees3 = csEmployeeBean.findAll();
        csProjects = csProjectBean.findAll();
        csContractors = csContractorBean.findAll();
//        System.out.println(""+csTor.getTorproID().getProID());
        //        System.out.println(""+csTor.getTorproID().getProID());
        //        System.out.println(""+csTor.getTorproID().getProID());
        //        System.out.println(""+csTor.getTorproID().getProID());
        ////        if (Objects.nonNull(csProjects)) {
        //            csProjectnos = csProjectnoBean.findByProID(csTor.getTorproID().getProID());
//        }

        csWorkplan = new CsWorkplan();
        csTor = csTorBean.find(torId);
        csContractor = csContractorBean.find(csTor.getTorconrID().getConrID());
        csProjectnos = csProjectnoBean.findByProID(csTor.getTorproID().getProID());
//        csWorkplan.setWptorID(new CsTor());
        csWorkplan.setWptorID(csTor);
        csWorkplans = csWorkplanBean.findByTorID(csTor.getTorId());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        System.out.println("" + csWorkplans.size());
        if (Objects.nonNull(csWorkplans)) {
            for (int i = 0; i < csWorkplans.size(); i++) {
                if (csWorkplans.get(i).getWpdayNO() != null) {
                    workingDays += csWorkplans.get(i).getWpdayNO();
                }
            }
        }
//        System.out.println("" + csTor.getCsContract().getConID());
//        System.out.println("" + csTor.getCsContract().getConID());
        items = bean.findByTorID(csTor.getTorId());
        if (Objects.nonNull(items) && items.size() > 0) {
            System.out.println("not null");
            System.out.println("" + items.size());
            item = bean.find(items.get(0).getConID());
        } else {
            System.out.println("null");
            item = new CsContract();
            item.setContorID(csTor);
            bean.create(item);
        }
        csPa = new CsPa();
        csPa.setPaPerType("2/3");
        csPa.setPaPerDesc("Only Two-thirds of day per-diem is calculated");
        csPa.setPaPerItems("None");
        csPas = item.getCsPaList();
        if (Objects.nonNull(csPas)) {
            for (int i = 0; i < csPas.size(); i++) {
                paDayTotal++;
                if (csPas.get(i).getPaaccoisWorkingDay()) {
                    paWorkingDayTotal++;
                }
                if (csPas.get(i).getPaPerAmount() != null) {
                    paDPerdiemAverage += csPas.get(i).getPaPerAmount();
                }
                if (csPas.get(i).getPaAccoAmount() != null && csPas.get(i).getPaAccoAmount() > 0) {
                    paAccoTotal += csPas.get(i).getPaAccoAmount();
                    paAccoDayTotal++;
                    paAcco = csPas.get(i).getPaAccoAmount();
                }

            }
            if (item.getConPerdiemAverage() == null) {
                item.setConPerdiemAverage(0d);
            }
//            paDPerdiemAverage = paDPerdiemAverage / paDayTotal;
            paDPerdiemTotal = item.getConPerdiemAverage() * paDayTotal;
        }
        csTran = new CsTran();
        csTrans = item.getCsTranList();
        for (int i = 0; i < csTrans.size(); i++) {
            if (csTrans.get(i).getTraTimes() != null) {
                paTranTimesTotal += csTrans.get(i).getTraTimes();
            }
            if (csTrans.get(i).getTraKM() != null) {
                paTranKMTotal += csTrans.get(i).getTraKM();
            }
            if (csTrans.get(i).getTraCost() != null) {
                paTranFeesTotal += csTrans.get(i).getTraCost();
            }
            if (csTrans.get(i).getTraTotal() != null) {
                paTranTotalTotal += csTrans.get(i).getTraTotal();
            }
        }

        if (item.getConHonorarium() == null) {
            item.setConHonorarium(0d);
        }
        if (item.getConOtherExpenses() == null) {
            item.setConOtherExpenses(0d);
        }
        conTotalInNumbers = (workingDays * item.getConHonorarium()) + paDPerdiemTotal + paAccoTotal + paTranTotalTotal + item.getConOtherExpenses();
        conTotalInWords = NumbersToWords.convert(conTotalInNumbers.intValue());
        conTotalInWords = UtilClass.convert(conTotalInWords);

        System.out.println(conTotalInWords);

        if (item.getConIsPayment() == null || !item.getConIsPayment()) {

            if (item.getConPayment1() == null) {
                item.setConPayment1(0d);
            }
            if (item.getConPayment2() == null) {
                item.setConPayment2(0d);
            }
            if (item.getConPayment2() == null) {
                item.setConPayment3(0d);
            }
            if (item.getConPayment2() == null) {
                item.setConPayment4(0d);
            }
            if (item.getConPayment1Invoice() == null) {
                item.setConPayment1Invoice(false);
            }
            if (item.getConPayment2Invoice() == null) {
                item.setConPayment2Invoice(false);
            }
            if (item.getConPayment3Invoice() == null) {
                item.setConPayment3Invoice(false);
            }
            if (item.getConPayment4Invoice() == null) {
                item.setConPayment4Invoice(false);
            }
        }
//        doPayment();
//        if (!Objects.nonNull(item.getDca_by1())) {
//            System.out.println("tr");
//            System.out.println("tr");
//            System.out.println("tr");
//            System.out.println("tr");
//            item.setDca_by1(new CsEmployee());
//        }
//        if (!Objects.nonNull(item.getDca_by2())) {
//            System.out.println("fr");
//            System.out.println("fr");
//            System.out.println("fr");
//            item.setDca_by2(new CsEmployee());
//        }
    }

    public void createWP() {
        csWorkplan.setWptorID(csTor);
        csWorkplanBean.create(csWorkplan);
        csWorkplans = csWorkplanBean.findByTorID(csTor.getTorId());
    }

    public void prepareCreate() {
        csTor = new CsTor();
//        csTor.setTest1t1t(new CsEmployee());
//        csTor.setTest2t2(new CsEmployee());
        csWorkplan = new CsWorkplan();
        csSystem = csSystemBean.find(new Long("1"));
        if (csSystem.getSysconNoIsActive()) {
            if (csSystem.getSysconNoIsNew()) {
                Integer te = Integer.parseInt(csSystem.getSys1conNo());

                contractNo = te + "" + csSystem.getSys2conNo() + "" + csSystem.getSys3conNo();
                System.out.println("" + contractNo);
                System.out.println("" + contractNo);
                System.out.println("" + contractNo);
                System.out.println("" + contractNo);
                csSystem.setSysconNoIsNew(false);
                te = te + 1;
                csSystem.setSys11conNo(te.toString());
//                int contractNo11 = Integer.getInteger(csSystem.getSys1conNo());
//                contractNo11++;
//                csSystem.setSys1conNo(String.valueOf(contractNo11));
//                csSystem.setSysConNoIsNew(false);
//                csSystemBean.update(csSystem);
            } else {
//                items = bean.findAll();
//                if (Objects.nonNull(items)) {
//                    String newConNo = items.get(items.size()).getConNo();
//                    String newConNo2 = newConNo.substring(0, newConNo.indexOf(csSystem.getSys2conNo()));
//                    int newConNo3 = Integer.getInteger(newConNo2);
//                    newConNo3++;
                Integer te = Integer.parseInt(csSystem.getSys11conNo());
//                te++;
                contractNo = te + "" + csSystem.getSys2conNo() + "" + csSystem.getSys3conNo();
                te++;
                csSystem.setSys11conNo(te.toString());
//                contractNo = String.valueOf(newConNo3) + "" + csSystem.getSys2conNo() + "" + csSystem.getSys3conNo();
//                }
            }
        } else {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
            String strDate = dateFormat.format(date);
            System.out.println("Converted String: " + strDate);
            contractNo = strDate;
        }

        csEmployees = csEmployeeBean.findAll();
        csContractors = csContractorBean.findAll();
        csTor.setTortaskAbove("The consultant has to perform the following tasks:-");
        csTor.setTorconrID(new CsContractor());

//        if (Objects.nonNull(csContractors)) {
//            csTor.setTorconrID(csContractorBean.find(csContractors.get(0).getConrID()));
//        }
        csProjects = csProjectBean.findAll();
        csTor.setTorproID(new CsProject(csProjects.get(0).getProID()));

        csProjectnos = csProjectnoBean.findByProID(csProjects.get(0).getProID());
        csTor.setTorproNoID(new CsProjectno(csProjectnos.get(0).getPNoid()));
//        if (Objects.nonNull(csProjects)) {

//            if (Objects.nonNull(csProjectnos)) {
//                csTor.setTorproNoID(csProjectnoBean.find());
//            }
//        }
//        if (Objects.nonNull(csEmployees)) {
//            for (int i = 0; i < csEmployees.size(); i++) {
//                if (csEmployees.get(i).getEmpisDefaultTor()) {
//                    switch (csEmployees.get(i).getEmpType()) {
//                        case "1":
//                            csTor.setTor1empID(new CsEmployee(csEmployees.get(i).getEmpID()));
//                            break;
//                        case "2":
//                            csTor.setTor2empID(new CsEmployee(csEmployees.get(i).getEmpID()));
//                            break;
//                        case "3":
//                            csTor.setTor3empID(new CsEmployee(csEmployees.get(i).getEmpID()));
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//        }
//        if (csTor.getTor1empID().getEmpID() == null) {
//            csTor.setTor1empID(new CsEmployee());
//        }
//        if (csTor.getTor2empID().getEmpID() == null) {
        csTor.setTor2empID(new CsEmployee());
//        }
//        if (csTor.getTor3empID().getEmpID() == null) {
        csTor.setTor3empID(new CsEmployee());
//        }
        csTor.setTortempProID(contractNo);
    }

    public void addWorkPlan() {
        csWorkplanBean.create(csWorkplan);
        if (Objects.nonNull(csWorkplans)) {
            csWorkplans.add(csWorkplan);
            csWorkplan = new CsWorkplan();
        } else {
            csWorkplans = new ArrayList<>();
            csWorkplans.add(csWorkplan);
            csWorkplan = new CsWorkplan();
        }
        workingDays = 0;
        if (Objects.nonNull(csWorkplans)) {
            for (int i = 0; i < csWorkplans.size(); i++) {
                workingDays += csWorkplans.get(i).getWpdayNO();
            }
        }
    }

    public void addWorkPlanInCon() {
        csWorkplan.setWptorID(csTor);
        csWorkplanBean.create(csWorkplan);
        if (Objects.nonNull(csWorkplans)) {
            csWorkplans.add(csWorkplan);
            csWorkplan = new CsWorkplan();
            csWorkplan.setWptorID(csTor);
        } else {
            csWorkplans = new ArrayList<>();
            csWorkplans.add(csWorkplan);
            csWorkplan = new CsWorkplan();
            csWorkplan.setWptorID(csTor);
        }
        csWorkplans = csTor.getCsWorkplanList();
        workingDays = 0;
        if (Objects.nonNull(csWorkplans)) {
            for (int i = 0; i < csWorkplans.size(); i++) {
                workingDays += csWorkplans.get(i).getWpdayNO();
            }
        }
    }

    public void deleteTripSheet(long id) {
        CsTran csTrane = csTranBean.find(id);
        csTranBean.delete(csTrane);
        csTrans = csTranBean.findByConId(item.getConID());
//        System.out.println("" + csTrans.size());
        for (int i = 0; i < csTrans.size(); i++) {
            if (csTrans.get(i).getTraTimes() != null) {
                paTranTimesTotal += csTrans.get(i).getTraTimes();
            }
            if (csTrans.get(i).getTraKM() != null) {
                paTranKMTotal += csTrans.get(i).getTraKM();
            }
            if (csTrans.get(i).getTraCost() != null) {
                paTranFeesTotal += csTrans.get(i).getTraCost();
            }
            if (csTrans.get(i).getTraTotal() != null) {
                paTranTotalTotal += csTrans.get(i).getTraTotal();
            }
        }
    }

    public void addTripSheet() {
        csTran.setTraconID(item);
        csTranBean.create(csTran);
        csTrans.add(csTran);
        csTrans = csTranBean.findByConId(item.getConID());
//        System.out.println("" + csTrans.size());
        for (int i = 0; i < csTrans.size(); i++) {
            if (csTrans.get(i).getTraTimes() != null) {
                paTranTimesTotal += csTrans.get(i).getTraTimes();
            }
            if (csTrans.get(i).getTraKM() != null) {
                paTranKMTotal += csTrans.get(i).getTraKM();
            }
            if (csTrans.get(i).getTraCost() != null) {
                paTranFeesTotal += csTrans.get(i).getTraCost();
            }
            if (csTrans.get(i).getTraTotal() != null) {
                paTranTotalTotal += csTrans.get(i).getTraTotal();
            }
        }
        bean.update(item);
        prepareTripSheet(csTran.getTraDesc(),
                csTran.getTraTimes(), csTran.getTraKM(), csTran.getTraCost(), csTran.getTraTotal(), csTran.getTraRemark());
//        System.out.println(NumberToWordsConverter.convert(csTran.getTraTotal().intValue()));

    }

    public void prepareTripSheet(String desc, Integer times, Double km, Double fee, Double total, String remark) {
        csTran = new CsTran();
        csTran.setTraDesc(desc);
        csTran.setTraTimes(times);
        csTran.setTraKM(km);
        csTran.setTraCost(fee);
        csTran.setTraTotal(total);
        csTran.setTraRemark(remark);
        csTran.setTraconID(item);
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
    }

    public void create() {
        csTor.setTortempProID(contractNo);
        csTorBean.create(csTor);

//        bean.create(item);
    }

    public String createTor() {
        csTor.setTorType(0);
        csTorBean.create(csTor);
        for (int i = 0; i < csWorkplans.size(); i++) {
            csWorkplan = csWorkplanBean.find(csWorkplans.get(i).getWpID());
            csWorkplan.setWptorID(csTor);
            csWorkplanBean.update(csWorkplan);
        }
        csSystemBean.update(csSystem);
        return "items?faces-redirect=true";
    }

    public String savecon() {
        bean.update(item);
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public void deletePerdiem(long id) {
        CsPa csPae = csPaBean.find(id);
        csPaBean.delete(csPae);
        csPas = csPaBean.findByConId(item.getConID());
        if (Objects.nonNull(csPas)) {
            paDayTotal = 0;
            for (int i = 0; i < csPas.size(); i++) {
                paDayTotal++;
                if (csPas.get(i).getPaaccoisWorkingDay()) {
                    paWorkingDayTotal++;
                }
                if (csPas.get(i).getPaPerAmount() != null) {
                    item.setConPerdiemAverage(item.getConPerdiemAverage() + csPas.get(i).getPaPerAmount());
                }
                if (csPas.get(i).getPaAccoAmount() != null) {
                    paAccoTotal += csPas.get(i).getPaAccoAmount();
                }
            }
            item.setConPerdiemAverage(item.getConPerdiemAverage() / paDayTotal);
            paDPerdiemTotal = item.getConPerdiemAverage() * paDayTotal;
        }
    }

    public void savePerdiem() {
        csPa.setPaconID(item);
        csPaBean.create(csPa);
        csPas.add(csPa);
        csPas = csPaBean.findByConId(item.getConID());

        if (Objects.nonNull(csPas)) {
            paDayTotal = 0;
            for (int i = 0; i < csPas.size(); i++) {
                paDayTotal++;
                if (csPas.get(i).getPaaccoisWorkingDay()) {
                    paWorkingDayTotal++;
                }
                if (csPas.get(i).getPaPerAmount() != null) {
                    item.setConPerdiemAverage(item.getConPerdiemAverage() + csPas.get(i).getPaPerAmount());
                }
                if (csPas.get(i).getPaAccoAmount() != null) {
                    paAccoTotal += csPas.get(i).getPaAccoAmount();
                }
            }
            item.setConPerdiemAverage(item.getConPerdiemAverage() / paDayTotal);
            paDPerdiemTotal = item.getConPerdiemAverage() * paDayTotal;
        }
        bean.update(item);
        preparePerdiem(csPa.getPaconrdayNo(),
                csPa.getPaPerAvrg(),
                csPa.getPaPerType(),
                csPa.getPaPerItems(),
                csPa.getPaPerAmount(),
                csPa.getPaPerDesc(),
                csPa.getPaAccoAmount(),
                csPa.getPaaccoisWorkingDay(),
                csPa.getPaRemark());

    }

    public void preparePerdiem(int dayNo,
            double perdiemAmount,
            String type,
            String ites,
            double perAmount,
            String perDesc,
            double accAmount,
            boolean workingDay,
            String remark) {
        csPa = new CsPa();
        csPa.setPaconrdayNo(dayNo + 1);
        csPa.setPaPerAvrg(perdiemAmount);
        csPa.setPaPerType(type);
        csPa.setPaPerItems(ites);
        csPa.setPaPerAmount(perAmount);
        csPa.setPaPerDesc(perDesc);
        csPa.setPaAccoAmount(accAmount);
        csPa.setPaaccoisWorkingDay(workingDay);
        csPa.setPaRemark(remark);
        csPa.setPaconID(item);

    }

    public void ProjectNoListner() {
        System.out.println("" + csTor.getTorproID().getProID());
        csProjectnos = csProjectnoBean.findByProID(csTor.getTorproID().getProID());
    }

    public void PerdiemListner() {
        double f = 0;
        if (csPa != null) {
            if ("2/3".equals(csPa.getPaPerType())) {
                csPa.setPaPerDesc("Only Two-thirds of day per-diem is calculated");
                f = 2d / 3d;
            } else if ("1".equals(csPa.getPaPerType())) {
                csPa.setPaPerDesc("Only Third of day per-diem is calculated");
                f = 1;
            }
            System.out.println("" + f);
            System.out.println("" + f);
            System.out.println("" + f);
            if (csPa.getPaPerAvrg() != null) {
                csPa.setPaPerAmount(csPa.getPaPerAvrg() * f);
            }

        }
    }

    public void TraListner() {
        if (csTran.getTraTimes() != null && csTran.getTraCost() != null) {
            csTran.setTraTotal(csTran.getTraTimes() * csTran.getTraCost());
        }
    }

    public void GetAllContractors() {
        System.out.println("all");
        System.out.println("all");
        csContractors = csContractorBean.findAll();

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

    public String generateCV() throws IOException, Exception {
        try {

            System.out.println("" + csTor.getTorconrID().getConrID());
            System.out.println("" + csTor.getTorconrID().getConrID());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
            String strDate = dateFormat.format(date);
            System.out.println("Converted String: " + strDate);
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            File oStreamFile = new File(
                    src
                    + StaticClass.contractFolderName
                    + csTor.getTorId());
            System.out.println("oStreamFile.exists()=" + oStreamFile.exists());
            System.out.println("oStreamFile.getName()=" + oStreamFile.getPath());
            if (!oStreamFile.exists()) {
                System.out.println("in create");
                System.out.println("oStreamFile.mkdirs()" + oStreamFile.mkdirs());
            }
            File oStream2 = new File(
                    src
                    + StaticClass.contractFolderName
                    + csTor.getTorId()
                    + StaticClass._15CV);
            System.out.println("" + oStream2.getPath());
            File oStream = new File(
                    src
                    + StaticClass.contractorFolderName
                    + csTor.getTorconrID().getConrID()
                    + "/CV.pdf");
            System.out.println("" + oStream.getPath());
            RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
            if (oStream.exists()) {
//                accessFile.close();
                System.out.println("" + oStream.getName());
                copyFileUsingStream(oStream, oStream2);
//                System.out.println("oStream.renameTo(oStream2)=" + oStream.renameTo(oStream2));
//            System.out.println(oStream.delete());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public String generateID() throws IOException, Exception {
        try {

            System.out.println("" + csTor.getTorconrID().getConrID());
            System.out.println("" + csTor.getTorconrID().getConrID());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
            String strDate = dateFormat.format(date);
            System.out.println("Converted String: " + strDate);
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            File oStreamFile = new File(
                    src
                    + StaticClass.contractFolderName
                    + csTor.getTorId());
            System.out.println("oStreamFile.exists()=" + oStreamFile.exists());
            System.out.println("oStreamFile.getName()=" + oStreamFile.getPath());
            if (!oStreamFile.exists()) {
                System.out.println("in create");
                System.out.println("oStreamFile.mkdirs()" + oStreamFile.mkdirs());
            }
            File oStream2 = new File(
                    src
                    + StaticClass.contractFolderName
                    + csTor.getTorId()
                    + StaticClass._14ID);
            System.out.println("" + oStream2.getPath());
            File oStream = new File(
                    src
                    + StaticClass.contractorFolderName
                    + csTor.getTorconrID().getConrID()
                    + "/ID.pdf");
            System.out.println("" + oStream.getPath());
            RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
            if (oStream.isFile()) {

                accessFile.close();
                System.out.println("" + oStream.getName());
                copyFileUsingStream(oStream, oStream2);
//                System.out.println("oStream.renameTo(oStream2)=" + oStream.renameTo(oStream2));

                System.out.println("after rename");
//            System.out.println(oStream.delete());
            } else {
                System.out.println("not file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public CsContract getItem() {
        return item;
    }

    public void setItem(CsContract item) {
        this.item = item;
    }

    public List<CsContract> getItems() {
        return items;
    }

    public void setItems(List<CsContract> items) {
        this.items = items;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public CsSystem getCsSystem() {
        return csSystem;
    }

    public void setCsSystem(CsSystem csSystem) {
        this.csSystem = csSystem;
    }

    public CsTor getCsTor() {
        return csTor;
    }

    public void setCsTor(CsTor csTor) {
        this.csTor = csTor;
    }

    public CsWorkplan getCsWorkplan() {
        return csWorkplan;
    }

    public void setCsWorkplan(CsWorkplan csWorkplan) {
        this.csWorkplan = csWorkplan;
    }

    public List<CsProject> getCsProjects() {
        return csProjects;
    }

    public void setCsProjects(List<CsProject> csProjects) {
        this.csProjects = csProjects;
    }

    public List<CsProjectno> getCsProjectnos() {
        return csProjectnos;
    }

    public void setCsProjectnos(List<CsProjectno> csProjectnos) {
        this.csProjectnos = csProjectnos;
    }

    public List<CsContractor> getCsContractors() {
        return csContractors;
    }

    public void setCsContractors(List<CsContractor> csContractors) {
        this.csContractors = csContractors;
    }

    public List<CsEmployee> getCsEmployees() {
        return csEmployees;
    }

    public void setCsEmployees(List<CsEmployee> csEmployees) {
        this.csEmployees = csEmployees;
    }

    public List<CsWorkplan> getCsWorkplans() {
        return csWorkplans;
    }

    public void setCsWorkplans(List<CsWorkplan> csWorkplans) {
        this.csWorkplans = csWorkplans;
    }

    public List<CsTor> getCsTors() {
        return csTors;
    }

    public void setCsTors(List<CsTor> csTors) {
        this.csTors = csTors;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public CsPa getCsPa() {
        return csPa;
    }

    public void setCsPa(CsPa csPa) {
        this.csPa = csPa;
    }

    public List<CsPa> getCsPas() {
        return csPas;
    }

    public void setCsPas(List<CsPa> csPas) {
        this.csPas = csPas;
    }

    public int getPaDayTotal() {
        return paDayTotal;
    }

    public void setPaDayTotal(int paDayTotal) {
        this.paDayTotal = paDayTotal;
    }

    public int getPaWorkingDayTotal() {
        return paWorkingDayTotal;
    }

    public void setPaWorkingDayTotal(int paWorkingDayTotal) {
        this.paWorkingDayTotal = paWorkingDayTotal;
    }

    public double getPaDPerdiemAverage() {
        return paDPerdiemAverage;
    }

    public void setPaDPerdiemAverage(double paDPerdiemAverage) {
        this.paDPerdiemAverage = paDPerdiemAverage;
    }

    public double getPaDPerdiemTotal() {
        return paDPerdiemTotal;
    }

    public void setPaDPerdiemTotal(double paDPerdiemTotal) {
        this.paDPerdiemTotal = paDPerdiemTotal;
    }

    public double getPaAccoTotal() {
        return paAccoTotal;
    }

    public void setPaAccoTotal(double paAccoTotal) {
        this.paAccoTotal = paAccoTotal;
    }

    public CsTran getCsTran() {
        return csTran;
    }

    public void setCsTran(CsTran csTran) {
        this.csTran = csTran;
    }

    public List<CsTran> getCsTrans() {
        return csTrans;
    }

    public void setCsTrans(List<CsTran> csTrans) {
        this.csTrans = csTrans;
    }

    public int getPaTranTimesTotal() {
        return paTranTimesTotal;
    }

    public void setPaTranTimesTotal(int paTranTimesTotal) {
        this.paTranTimesTotal = paTranTimesTotal;
    }

    public double getPaTranKMTotal() {
        return paTranKMTotal;
    }

    public void setPaTranKMTotal(double paTranKMTotal) {
        this.paTranKMTotal = paTranKMTotal;
    }

    public double getPaTranFeesTotal() {
        return paTranFeesTotal;
    }

    public void setPaTranFeesTotal(double paTranFeesTotal) {
        this.paTranFeesTotal = paTranFeesTotal;
    }

    public double getPaTranTotalTotal() {
        return paTranTotalTotal;
    }

    public void setPaTranTotalTotal(double paTranTotalTotal) {
        this.paTranTotalTotal = paTranTotalTotal;
    }

    public int getPaAccoDayTotal() {
        return paAccoDayTotal;
    }

    public void setPaAccoDayTotal(int paAccoDayTotal) {
        this.paAccoDayTotal = paAccoDayTotal;
    }

    public double getPaAcco() {
        return paAcco;
    }

    public void setPaAcco(double paAcco) {
        this.paAcco = paAcco;
    }

    public double getConTotalInNumbers() {
        return conTotalInNumbers;
    }

    public void setConTotalInNumbers(double conTotalInNumbers) {
        this.conTotalInNumbers = conTotalInNumbers;
    }

    public String getConTotalInWords() {
        return conTotalInWords;
    }

    public void setConTotalInWords(String conTotalInWords) {
        this.conTotalInWords = conTotalInWords;
    }

    public int getP4Percentage() {
        return p4Percentage;
    }

    public void setP4Percentage(int p4Percentage) {
        this.p4Percentage = p4Percentage;
    }

    public Boolean getP1() {
        return p1;
    }

    public void setP1(Boolean p1) {
        this.p1 = p1;
    }

    public Boolean getP2() {
        return p2;
    }

    public void setP2(Boolean p2) {
        this.p2 = p2;
    }

    public Boolean getP3() {
        return p3;
    }

    public void setP3(Boolean p3) {
        this.p3 = p3;
    }

    public Boolean getP4() {
        return p4;
    }

    public void setP4(Boolean p4) {
        this.p4 = p4;
    }

    public int getP1Percentage() {
        return p1Percentage;
    }

    public void setP1Percentage(int p1Percentage) {
        this.p1Percentage = p1Percentage;
    }

    public int getP2Percentage() {
        return p2Percentage;
    }

    public void setP2Percentage(int p2Percentage) {
        this.p2Percentage = p2Percentage;
    }

    public int getP3Percentage() {
        return p3Percentage;
    }

    public void setP3Percentage(int p3Percentage) {
        this.p3Percentage = p3Percentage;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public boolean isShowFeeSchedule() {
        return showFeeSchedule;
    }

    public void setShowFeeSchedule(boolean showFeeSchedule) {
        this.showFeeSchedule = showFeeSchedule;
    }

    public boolean isShowSPL() {
        return showSPL;
    }

    public void setShowSPL(boolean showSPL) {
        this.showSPL = showSPL;
    }

    public boolean isShowSPLUpload() {
        return showSPLUpload;
    }

    public void setShowSPLUpload(boolean showSPLUpload) {
        this.showSPLUpload = showSPLUpload;
    }

    public String fileUploadListenerSPL(FileUploadEvent e) throws IOException, Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = csSystemBean.find(new Long("1"));
            src = csSystem.getSysName();
        } else {
            csSystem = csSystemBean.find(new Long("1"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File oStreamFile = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId());
        if (!oStreamFile.exists()) {
            oStreamFile.mkdirs();
        }
        fileSPL = e.getFile();

        File oStream = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._9SPL);
        File oStream2 = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._9SPL_ + strDate + ".pdf");

        RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
        if (oStream.exists()) {
            accessFile.close();
            System.out.println("" + oStream.getName());
//            oStream.renameTo(oStream2);
            copyFileUsingStream(oStream, oStream2);
//            System.out.println(oStream.delete());
        }
        oStream.createNewFile();
        InputStream inputStream = fileSPL.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public String fileUploadListenerOffer(FileUploadEvent e) throws IOException, Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = csSystemBean.find(new Long("1"));
            src = csSystem.getSysName();
        } else {
            csSystem = csSystemBean.find(new Long("1"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File oStreamFile = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId());
        if (!oStreamFile.exists()) {
            oStreamFile.mkdirs();
        }
        fileOffer = e.getFile();

        File oStream = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._13Offer);
        File oStream2 = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._13Offer_ + strDate + ".pdf");

        RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
        if (oStream.exists()) {
            accessFile.close();
            System.out.println("" + oStream.getName());
//            oStream.renameTo(oStream2);
            copyFileUsingStream(oStream, oStream2);
//            System.out.println(oStream.delete());
        }
        oStream.createNewFile();
        InputStream inputStream = fileOffer.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public String fileUploadListenerExchangeRate(FileUploadEvent e) throws IOException, Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormate);
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = csSystemBean.find(new Long("1"));
            src = csSystem.getSysName();
        } else {
            csSystem = csSystemBean.find(new Long("1"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File oStreamFile = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId());
        if (!oStreamFile.exists()) {
            oStreamFile.mkdirs();
        }
        fileExchangeRate = e.getFile();

        File oStream = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._16ExchangeRate);
        File oStream2 = new File(
                src
                + StaticClass.contractFolderName
                + csTor.getTorId()
                + StaticClass._16ExchangeRate_ + strDate + ".pdf");

        RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
        if (oStream.exists()) {
            accessFile.close();
            System.out.println("" + oStream.getName());
//            oStream.renameTo(oStream2);
            copyFileUsingStream(oStream, oStream2);
//            System.out.println(oStream.delete());
        }
        oStream.createNewFile();
        InputStream inputStream = fileExchangeRate.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }
    UploadedFile fileSPL;
    UploadedFile fileOffer;
    UploadedFile fileExchangeRate;

    public UploadedFile getFileOffer() {
        return fileOffer;
    }

    public void setFileOffer(UploadedFile fileOffer) {
        this.fileOffer = fileOffer;
    }

    public UploadedFile getFileSPL() {
        return fileSPL;
    }

    public void setFileSPL(UploadedFile fileSPL) {
        this.fileSPL = fileSPL;
    }

    public void addMessage() {
        System.out.println("" + item.getDca_io1_status());
    }

    public boolean isShowOffer() {
        return showOffer;
    }

    public void setShowOffer(boolean showOffer) {
        this.showOffer = showOffer;
    }

    public boolean isShowOfferUpload() {
        return showOfferUpload;
    }

    public void setShowOfferUpload(boolean showOfferUpload) {
        this.showOfferUpload = showOfferUpload;
    }

    public UploadedFile getFileExchangeRate() {
        return fileExchangeRate;
    }

    public void setFileExchangeRate(UploadedFile fileExchangeRate) {
        this.fileExchangeRate = fileExchangeRate;
    }

    public boolean isShowExchangeRate() {
        return showExchangeRate;
    }

    public void setShowExchangeRate(boolean showExchangeRate) {
        this.showExchangeRate = showExchangeRate;
    }

    public boolean isShowExchangeRateUpload() {
        return showExchangeRateUpload;
    }

    public void setShowExchangeRateUpload(boolean showExchangeRateUpload) {
        this.showExchangeRateUpload = showExchangeRateUpload;
    }

    public void test() {
//        csTorBean.update(csTor);
//        System.out.println("1="+csTor.getTor1empID().getEmpID());
//        System.out.println("2="+csTor.getTor2empID().getEmpID());
//        System.out.println("3="+csTor.getTor3empID().getEmpID());
        System.out.println("" + csTor.getTest1t1t().getEmpID());
        System.out.println("" + csTor.getTest2t2().getEmpID());
    }

    public CsContractor getCsContractor() {
        return csContractor;
    }

    public void setCsContractor(CsContractor csContractor) {
        this.csContractor = csContractor;
    }

    public String saveTor() {
        csTor.setTorconrID(csContractor);
        csTorBean.update(csTor);
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public String saveTor1() {
//        csTor.setTorproID(new CsProject(csTor.getTorproID().getProID()));
//        csTor.setTorproNoID(new CsProjectno(csTor.getTorproNoID().getPNoid()));
//        csTor.setTorconrID(new CsContractor(csTor.getTorconrID().getConrID()));

//        csTor.setTor1empID(new CsEmployee(csTor.getTor1empID().getEmpID()));
//        System.out.println("prepare="+csTor.getTor2empID().getEmpID());
//        csTor.setTor2empID(new CsEmployee(csTor.getTor2empID().getEmpID()));
//        csTor.setTor3empID(new CsEmployee(csTor.getTor3empID().getEmpID()));
//        csTor.setTest1t1t(new CsEmployee(csTor.getTest1t1t().getEmpID()));
//        csTor.setTest2t2(new CsEmployee(csTor.getTest2t2().getEmpID()));
        csTorBean.update(csTor);
        System.out.println("prepare=" + csTor.getTor2empID().getEmpID());
        return "contract?id=" + csTor.getTorId() + "&faces-redirect=true";

    }

    public String saveTor2() {
        System.out.println("befor=" + csTor.getTor1empID().getEmpID());

        csTor.setTor1empID(new CsEmployee(csTor.getTor1empID().getEmpID()));
//        csTor.setTorconrID(csContractor);

        csTorBean.update(csTor);
        System.out.println("after=" + csTor.getTor1empID().getEmpID());
        return "update_1?id=" + csTor.getTorId() + "&faces-redirect=true";
    }

    public void prepareContract2(long torId) {
        csEmployees = csEmployeeBean.findAll();
        csTor = csTorBean.find(torId);
        System.out.println("prepare=" + csTor.getTor1empID().getEmpID());
//        csTor.setTor1empID(new CsEmployee());
    }

    public List<CsEmployee> getCsEmployees2() {
        return csEmployees2;
    }

    public void setCsEmployees2(List<CsEmployee> csEmployees2) {
        this.csEmployees2 = csEmployees2;
    }

    public List<CsEmployee> getCsEmployees3() {
        return csEmployees3;
    }

    public void setCsEmployees3(List<CsEmployee> csEmployees3) {
        this.csEmployees3 = csEmployees3;
    }

    public void deleteWP(long id) {
        CsWorkplan cwe = csWorkplanBean.find(id);
        csWorkplanBean.delete(cwe);
        csWorkplans = csWorkplanBean.findByTorID(csTor.getTorId());
        workingDays = 0;
        if (Objects.nonNull(csWorkplans)) {
            for (int i = 0; i < csWorkplans.size(); i++) {
                workingDays += csWorkplans.get(i).getWpdayNO();
            }
        }
    }

    public void generate4(int ty) throws JRException, IOException {
        System.out.println("1");
        try {
            System.out.println("2");
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            System.out.println("3");
            Map<String, Object> m = new HashMap();
            System.out.println("4");
            m.put("torID", csTor.getTorId());
            System.out.println("5");
            if (ty == 1) {
                jasperManager.exportToPDF(src, "GIZ_WP5.jrxml", null, null, m, false, StaticClass._3WorkPlan_, StaticClass._3WorkPlan);
            } else if (ty == 2) {
                jasperManager.exportToDOC(src, "GIZ_WP5.jrxml", null, null, m, false, StaticClass._3WorkPlan_, StaticClass._3WorkPlan);
            }

            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate12(int ty) throws JRException, IOException {
        System.out.println("1");
        try {
            System.out.println("2");
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            System.out.println("3");
            CsContractor contractore = new CsContractor();
            contractore = csContractorBean.find(csTor.getTorconrID().getConrID());
            Date date = contractore.getConrBirthdate();
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormateReport);
            String strDate = dateFormat.format(date);

            Map<String, Object> m = new HashMap();
            System.out.println("4");
            m.put("conrID", csTor.getTorconrID().getConrID());
            m.put("torID", csTor.getTorId());
            m.put("dt", strDate);
            System.out.println("5");
            if (ty == 1) {
                jasperManager.exportToPDF(src, "GIZ_CL1.jrxml", null, null, m, false, StaticClass._12CheckList_, StaticClass._12CheckList);
            } else if (ty == 2) {
                jasperManager.exportToDOC(src, "GIZ_CL1.jrxml", null, null, m, false, StaticClass._12CheckList_, StaticClass._12CheckList);
            }

            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void generate5(int ty) throws JRException, IOException {
        System.out.println("1");
        try {
            System.out.println("2");
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            System.out.println("3");
            CsContractor contractore = new CsContractor();
            contractore = csContractorBean.find(csTor.getTorconrID().getConrID());
            Date date = contractore.getConrBirthdate();
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormateReport);
            String strDate = dateFormat.format(date);

            Map<String, Object> m = new HashMap();
            System.out.println("4");
            m.put("torID", csTor.getTorId());
            m.put("conrId", csTor.getTorconrID().getConrID());
            m.put("proID", csTor.getTorproID().getProID());
            m.put("conID", item.getConID());
            System.out.println("5");
            if (ty == 1) {
                jasperManager.exportToPDF(src, "GIZ_TS.jrxml", null, null, m, false, StaticClass._5TimeSheet_, StaticClass._5TimeSheet);
            } else if (ty == 2) {
                jasperManager.exportToDOC(src, "GIZ_TS.jrxml", null, null, m, false, StaticClass._5TimeSheet_, StaticClass._5TimeSheet);
            }

            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void generate6(int ty) throws JRException, IOException {
        try {
            String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
            if (Objects.nonNull(src)) {
                csSystem = csSystemBean.find(new Long("1"));
                src = csSystem.getSysName();
            } else {
                csSystem = csSystemBean.find(new Long("1"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
            }
            CsContractor contractore = new CsContractor();
            contractore = csContractorBean.find(csTor.getTorconrID().getConrID());
            DateFormat dateFormat = new SimpleDateFormat(StaticClass.dateFormateReport);
            String fromDate = dateFormat.format(csTor.getTorfromDate());
            String toDate = dateFormat.format(csTor.getTortoDate());
            Map<String, Object> m = new HashMap();
            m.put("torID", csTor.getTorId());
            m.put("fromDate", fromDate);
            m.put("toDate", toDate);
            if (ty == 1) {
                jasperManager.exportToPDF(src, "GIZ_SD.jrxml", null, null, m, false, StaticClass._6SecurityDeclaration_, StaticClass._6SecurityDeclaration);
            } else if (ty == 2) {
                jasperManager.exportToDOC(src, "GIZ_SD.jrxml", null, null, m, false, StaticClass._6SecurityDeclaration_, StaticClass._6SecurityDeclaration);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isShowWP() {
        return showWP;
    }

    public void setShowWP(boolean showWP) {
        this.showWP = showWP;
    }

    public boolean isShowWPUpload() {
        return showWPUpload;
    }

    public void setShowWPUpload(boolean showWPUpload) {
        this.showWPUpload = showWPUpload;
    }

    public boolean isShowCL() {
        return showCL;
    }

    public void setShowCL(boolean showCL) {
        this.showCL = showCL;
    }

    public boolean isShowCLUpload() {
        return showCLUpload;
    }

    public void setShowCLUpload(boolean showCLUpload) {
        this.showCLUpload = showCLUpload;
    }

    public boolean isShowGeneralTerm() {
        return showGeneralTerm;
    }

    public void setShowGeneralTerm(boolean showGeneralTerm) {
        this.showGeneralTerm = showGeneralTerm;
    }

    public boolean isShowCV() {
        return showCV;
    }

    public void setShowCV(boolean showCV) {
        this.showCV = showCV;
    }

    public boolean isShowID() {
        return showID;
    }

    public void setShowID(boolean showID) {
        this.showID = showID;
    }

    public boolean isShowTimeSheet() {
        return showTimeSheet;
    }

    public void setShowTimeSheet(boolean showTimeSheet) {
        this.showTimeSheet = showTimeSheet;
    }

    public boolean isShowSD() {
        return showSD;
    }

    public void setShowSD(boolean showSD) {
        this.showSD = showSD;
    }

}
