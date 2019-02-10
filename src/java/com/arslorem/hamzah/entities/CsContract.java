/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_contract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsContract.findAll", query = "SELECT c FROM CsContract c")
    , @NamedQuery(name = "CsContract.findByConID", query = "SELECT c FROM CsContract c WHERE c.conID = :conID")
    , @NamedQuery(name = "CsContract.findByTorID", query = "SELECT c FROM CsContract c WHERE c.contorID.torId = :id")
    , @NamedQuery(name = "CsContract.findByConotherMoney", query = "SELECT c FROM CsContract c WHERE c.conotherMoney = :conotherMoney")
    , @NamedQuery(name = "CsContract.findByConcostPerDay", query = "SELECT c FROM CsContract c WHERE c.concostPerDay = :concostPerDay")
    , @NamedQuery(name = "CsContract.findByConbuyLevel", query = "SELECT c FROM CsContract c WHERE c.conbuyLevel = :conbuyLevel")
    , @NamedQuery(name = "CsContract.findByConDate", query = "SELECT c FROM CsContract c WHERE c.conDate = :conDate")
    , @NamedQuery(name = "CsContract.findByConNo", query = "SELECT c FROM CsContract c WHERE c.conNo = :conNo")})
public class CsContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_ID")
    private Long conID;
    @Column(name = "con_otherMoney")
    private BigInteger conotherMoney;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "con_costPerDay")
    private Double concostPerDay;
    @Column(name = "con_honorarium")
    private Double conHonorarium;
    @Column(name = "con_otherExpenses")
    private Double conOtherExpenses;
    @Column(name = "con_payment1")
    private Double conPayment1;
    @Column(name = "con_payment2")
    private Double conPayment2;
    @Column(name = "con_payment3")
    private Double conPayment3;
    @Column(name = "con_payment4")
    private Double conPayment4;
    @Column(name = "con_perdiem_average")
    private Double conPerdiemAverage;
    @Column(name = "con_payment1_invoice")
    private Boolean conPayment1Invoice;
    @Column(name = "con_payment2_invoice")
    private Boolean conPayment2Invoice;
    @Column(name = "con_payment3_invoice")
    private Boolean conPayment3Invoice;
    @Column(name = "con_payment4_invoice")
    private Boolean conPayment4Invoice;
    @Column(name = "con_payment1_p")
    private Integer con_payment1_p;
    @Column(name = "con_payment2_p")
    private Integer con_payment2_p;
    @Column(name = "con_payment3_p")
    private Integer con_payment3_p;
    @Column(name = "con_payment4_p")
    private Integer con_payment4_p;
    @Column(name = "con_is_payment")
    private Boolean conIsPayment;
    @Column(name = "con_is_adhoc")
    private Boolean conIsAdhoc;
    @Column(name = "con_for_center")
    private Boolean conForCenter;
    @Column(name = "con_buyLevel")
    private Character conbuyLevel;
    @Column(name = "con_date")
    @Temporal(TemporalType.DATE)
    private Date conDate;
    @Column(name = "dca_date")
    @Temporal(TemporalType.DATE)
    private Date dcaDate;
    @Column(name = "con_payment1_date")
    @Temporal(TemporalType.DATE)
    private Date conPayment1Date;
    @Column(name = "con_payment2_date")
    @Temporal(TemporalType.DATE)
    private Date conPayment2Date;
    @Column(name = "con_payment3_date")
    @Temporal(TemporalType.DATE)
    private Date conPayment3Date;
    @Column(name = "con_payment4_date")
    @Temporal(TemporalType.DATE)
    private Date conPayment4Date;
    @Column(name = "con_No")
    private String conNo;
    @Column(name = "dca_io1")
    private String dca_io1;
    @Column(name = "dca_io2")
    private String dca_io3;
    @Column(name = "dca_io3")
    private String dca_io2;
    @Column(name = "dca_io1_status")
    private Character dca_io1_status;
    @Column(name = "dca_io2_status")
    private Character dca_io2_status;
    @Column(name = "dca_io3_status")
    private Character dca_io3_status;
    @Column(name = "dca_case")
    private Boolean dca_case;
    @Column(name = "dca_case1_to")
    private String dca_case1_to;
    @Column(name = "dca_case1_desc")
    private String dca_case1_desc;
    @Column(name = "dca_case2_1")
    private Boolean dca_case2_1;
    @Column(name = "dca_case2_2")
    private Boolean dca_case2_2;
    @Column(name = "dca_case2_3")
    private Boolean dca_case2_3;
    @Column(name = "dca_case2_4")
    private Boolean dca_case2_4;
    @Column(name = "dca_case2_5")
    private Boolean dca_case2_5;
    @Column(name = "dca_case2_other")
    private String dca_case2_other;
    @JoinColumn(name = "dca_by1", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee dca_by1;
    @JoinColumn(name = "dca_by2", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee dca_by2;
    @JoinColumn(name = "con_1_emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee con1empID;
    @JoinColumn(name = "con_2_emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee con2empID;
    @JoinColumn(name = "con_by_emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee conbyempID;
    @JoinColumn(name = "con_tor_ID", referencedColumnName = "tor_id")
    @OneToOne
    private CsTor contorID;
    @OneToMany(mappedBy = "paconID")
    private List<CsPa> csPaList;
    @OneToMany(mappedBy = "traconID")
    private List<CsTran> csTranList;
    @OneToMany(mappedBy = "invconrID")
    private List<CsInvoice> csInvoiceList;

    public CsContract() {
    }

    public Integer getCon_payment1_p() {
        return con_payment1_p;
    }

    public void setCon_payment1_p(Integer con_payment1_p) {
        this.con_payment1_p = con_payment1_p;
    }

    public Integer getCon_payment2_p() {
        return con_payment2_p;
    }

    public void setCon_payment2_p(Integer con_payment2_p) {
        this.con_payment2_p = con_payment2_p;
    }

    public Integer getCon_payment3_p() {
        return con_payment3_p;
    }

    public void setCon_payment3_p(Integer con_payment3_p) {
        this.con_payment3_p = con_payment3_p;
    }

    public Integer getCon_payment4_p() {
        return con_payment4_p;
    }

    public void setCon_payment4_p(Integer con_payment4_p) {
        this.con_payment4_p = con_payment4_p;
    }

    public Date getDcaDate() {
        return dcaDate;
    }

    public void setDcaDate(Date dcaDate) {
        this.dcaDate = dcaDate;
    }

    public String getDca_io1() {
        return dca_io1;
    }

    public void setDca_io1(String dca_io1) {
        this.dca_io1 = dca_io1;
    }

    public String getDca_io3() {
        return dca_io3;
    }

    public void setDca_io3(String dca_io3) {
        this.dca_io3 = dca_io3;
    }

    public String getDca_io2() {
        return dca_io2;
    }

    public void setDca_io2(String dca_io2) {
        this.dca_io2 = dca_io2;
    }

    public Character getDca_io1_status() {
        return dca_io1_status;
    }

    public void setDca_io1_status(Character dca_io1_status) {
        this.dca_io1_status = dca_io1_status;
    }

    public Character getDca_io2_status() {
        return dca_io2_status;
    }

    public void setDca_io2_status(Character dca_io2_status) {
        this.dca_io2_status = dca_io2_status;
    }

    public Character getDca_io3_status() {
        return dca_io3_status;
    }

    public void setDca_io3_status(Character dca_io3_status) {
        this.dca_io3_status = dca_io3_status;
    }

    public Boolean getDca_case() {
        return dca_case;
    }

    public void setDca_case(Boolean dca_case) {
        this.dca_case = dca_case;
    }

    public String getDca_case1_to() {
        return dca_case1_to;
    }

    public void setDca_case1_to(String dca_case1_to) {
        this.dca_case1_to = dca_case1_to;
    }

    public String getDca_case1_desc() {
        return dca_case1_desc;
    }

    public void setDca_case1_desc(String dca_case1_desc) {
        this.dca_case1_desc = dca_case1_desc;
    }

    public Boolean getDca_case2_1() {
        return dca_case2_1;
    }

    public void setDca_case2_1(Boolean dca_case2_1) {
        this.dca_case2_1 = dca_case2_1;
    }

    public Boolean getDca_case2_2() {
        return dca_case2_2;
    }

    public void setDca_case2_2(Boolean dca_case2_2) {
        this.dca_case2_2 = dca_case2_2;
    }

    public Boolean getDca_case2_3() {
        return dca_case2_3;
    }

    public void setDca_case2_3(Boolean dca_case2_3) {
        this.dca_case2_3 = dca_case2_3;
    }

    public Boolean getDca_case2_4() {
        return dca_case2_4;
    }

    public void setDca_case2_4(Boolean dca_case2_4) {
        this.dca_case2_4 = dca_case2_4;
    }

    public Boolean getDca_case2_5() {
        return dca_case2_5;
    }

    public void setDca_case2_5(Boolean dca_case2_5) {
        this.dca_case2_5 = dca_case2_5;
    }

    public String getDca_case2_other() {
        return dca_case2_other;
    }

    public void setDca_case2_other(String dca_case2_other) {
        this.dca_case2_other = dca_case2_other;
    }

    public CsEmployee getDca_by1() {
        return dca_by1;
    }

    public void setDca_by1(CsEmployee dca_by1) {
        this.dca_by1 = dca_by1;
    }

    public CsEmployee getDca_by2() {
        return dca_by2;
    }

    public void setDca_by2(CsEmployee dca_by2) {
        this.dca_by2 = dca_by2;
    }

    public CsContract(Long conID) {
        this.conID = conID;
    }

    public Long getConID() {
        return conID;
    }

    public void setConID(Long conID) {
        this.conID = conID;
    }

    public BigInteger getConotherMoney() {
        return conotherMoney;
    }

    public void setConotherMoney(BigInteger conotherMoney) {
        this.conotherMoney = conotherMoney;
    }

    public Double getConcostPerDay() {
        return concostPerDay;
    }

    public void setConcostPerDay(Double concostPerDay) {
        this.concostPerDay = concostPerDay;
    }

    public Character getConbuyLevel() {
        return conbuyLevel;
    }

    public void setConbuyLevel(Character conbuyLevel) {
        this.conbuyLevel = conbuyLevel;
    }

    public Date getConDate() {
        return conDate;
    }

    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    public String getConNo() {
        return conNo;
    }

    public void setConNo(String conNo) {
        this.conNo = conNo;
    }

    public CsEmployee getCon1empID() {
        return con1empID;
    }

    public void setCon1empID(CsEmployee con1empID) {
        this.con1empID = con1empID;
    }

    public CsEmployee getCon2empID() {
        return con2empID;
    }

    public void setCon2empID(CsEmployee con2empID) {
        this.con2empID = con2empID;
    }

    public CsEmployee getConbyempID() {
        return conbyempID;
    }

    public void setConbyempID(CsEmployee conbyempID) {
        this.conbyempID = conbyempID;
    }

    public CsTor getContorID() {
        return contorID;
    }

    public void setContorID(CsTor contorID) {
        this.contorID = contorID;
    }
    public List<CsPa> getCsPaList() {
        return csPaList;
    }

    public void setCsPaList(List<CsPa> csPaList) {
        this.csPaList = csPaList;
    }

    
    public List<CsTran> getCsTranList() {
        return csTranList;
    }

    public void setCsTranList(List<CsTran> csTranList) {
        this.csTranList = csTranList;
    }

    public Double getConOtherExpenses() {
        return conOtherExpenses;
    }

    public void setConOtherExpenses(Double conOtherExpenses) {
        this.conOtherExpenses = conOtherExpenses;
    }

    @XmlTransient
    public List<CsInvoice> getCsInvoiceList() {
        return csInvoiceList;
    }

    public void setCsInvoiceList(List<CsInvoice> csInvoiceList) {
        this.csInvoiceList = csInvoiceList;
    }

    public Double getConHonorarium() {
        return conHonorarium;
    }

    public void setConHonorarium(Double conHonorarium) {
        this.conHonorarium = conHonorarium;
    }

    public Double getConPayment4() {
        return conPayment4;
    }

    public void setConPayment4(Double conPayment4) {
        this.conPayment4 = conPayment4;
    }

    public Double getConPayment1() {
        return conPayment1;
    }

    public void setConPayment1(Double conPayment1) {
        this.conPayment1 = conPayment1;
    }

    public Double getConPayment2() {
        return conPayment2;
    }

    public void setConPayment2(Double conPayment2) {
        this.conPayment2 = conPayment2;
    }

    public Double getConPayment3() {
        return conPayment3;
    }

    public void setConPayment3(Double conPayment3) {
        this.conPayment3 = conPayment3;
    }

    public Boolean getConPayment1Invoice() {
        return conPayment1Invoice;
    }

    public void setConPayment1Invoice(Boolean conPayment1Invoice) {
        this.conPayment1Invoice = conPayment1Invoice;
    }

    public Boolean getConPayment2Invoice() {
        return conPayment2Invoice;
    }

    public void setConPayment2Invoice(Boolean conPayment2Invoice) {
        this.conPayment2Invoice = conPayment2Invoice;
    }

    public Boolean getConPayment3Invoice() {
        return conPayment3Invoice;
    }

    public void setConPayment3Invoice(Boolean conPayment3Invoice) {
        this.conPayment3Invoice = conPayment3Invoice;
    }

    public Boolean getConPayment4Invoice() {
        return conPayment4Invoice;
    }

    public void setConPayment4Invoice(Boolean conPayment4Invoice) {
        this.conPayment4Invoice = conPayment4Invoice;
    }

    public Boolean getConIsPayment() {
        return conIsPayment;
    }

    public void setConIsPayment(Boolean conIsPayment) {
        this.conIsPayment = conIsPayment;
    }

    public Date getConPayment1Date() {
        return conPayment1Date;
    }

    public void setConPayment1Date(Date conPayment1Date) {
        this.conPayment1Date = conPayment1Date;
    }

    public Date getConPayment2Date() {
        return conPayment2Date;
    }

    public void setConPayment2Date(Date conPayment2Date) {
        this.conPayment2Date = conPayment2Date;
    }

    public Date getConPayment3Date() {
        return conPayment3Date;
    }

    public void setConPayment3Date(Date conPayment3Date) {
        this.conPayment3Date = conPayment3Date;
    }

    public Date getConPayment4Date() {
        return conPayment4Date;
    }

    public void setConPayment4Date(Date conPayment4Date) {
        this.conPayment4Date = conPayment4Date;
    }

    public Double getConPerdiemAverage() {
        return conPerdiemAverage;
    }

    public void setConPerdiemAverage(Double conPerdiemAverage) {
        this.conPerdiemAverage = conPerdiemAverage;
    }

    public Boolean getConIsAdhoc() {
        return conIsAdhoc;
    }

    public void setConIsAdhoc(Boolean conIsAdhoc) {
        this.conIsAdhoc = conIsAdhoc;
    }

    public Boolean getConForCenter() {
        return conForCenter;
    }

    public void setConForCenter(Boolean conForCenter) {
        this.conForCenter = conForCenter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conID != null ? conID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsContract)) {
            return false;
        }
        CsContract other = (CsContract) object;
        if ((this.conID == null && other.conID != null) || (this.conID != null && !this.conID.equals(other.conID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsContract[ conID=" + conID + " ]";
    }
    
}
