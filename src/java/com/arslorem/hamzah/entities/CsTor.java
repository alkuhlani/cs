/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "cs_tor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsTor.findAll", query = "SELECT c FROM CsTor c")
    , @NamedQuery(name = "CsTor.findByTorId", query = "SELECT c FROM CsTor c WHERE c.torId = :torId")
    , @NamedQuery(name = "CsTor.findByTorfromDate", query = "SELECT c FROM CsTor c WHERE c.torfromDate = :torfromDate")
    , @NamedQuery(name = "CsTor.findByTortoDate", query = "SELECT c FROM CsTor c WHERE c.tortoDate = :tortoDate")
    , @NamedQuery(name = "CsTor.findByTorworkingDays", query = "SELECT c FROM CsTor c WHERE c.torworkingDays = :torworkingDays")
    , @NamedQuery(name = "CsTor.findByTortaskAbove", query = "SELECT c FROM CsTor c WHERE c.tortaskAbove = :tortaskAbove")
    , @NamedQuery(name = "CsTor.findByTorPlace", query = "SELECT c FROM CsTor c WHERE c.torPlace = :torPlace")
    , @NamedQuery(name = "CsTor.findByTortempProID", query = "SELECT c FROM CsTor c WHERE c.tortempProID = :tortempProID")
    , @NamedQuery(name = "CsTor.findByTorWpAfter", query = "SELECT c FROM CsTor c WHERE c.torWpAfter = :torWpAfter")
    , @NamedQuery(name = "CsTor.findByTorPsAfter", query = "SELECT c FROM CsTor c WHERE c.torPsAfter = :torPsAfter")
    , @NamedQuery(name = "CsTor.findByTorType", query = "SELECT c FROM CsTor c WHERE c.torType = :torType")})
public class CsTor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tor_id")
    private Long torId;
    @Lob
    @Column(name = "tor_objective")
    private String torObjective;
    @Column(name = "tor_fromDate")
    @Temporal(TemporalType.DATE)
    private Date torfromDate;
    @Column(name = "tor_toDate")
    @Temporal(TemporalType.DATE)
    private Date tortoDate;
    @Column(name = "tor_workingDays")
    private Integer torworkingDays;
    @Lob
    @Column(name = "tor_tasks")
    private String torTasks;
    @Column(name = "tor_taskAbove")
    private String tortaskAbove;
    @Column(name = "tor_place")
    private String torPlace;
    @Column(name = "tor_tempProID")
    private String tortempProID;
    @Column(name = "tor_wp_after")
    private String torWpAfter;
    @Column(name = "tor_ps_after")
    private String torPsAfter;
    @Column(name = "tor_type")
    private Integer torType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tasktorID")
    private List<CsTorTask> csTorTaskList;
    //
    @JoinColumn(name = "tor_1emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee tor1empID;
    //
    @JoinColumn(name = "tor_2emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee tor2empID;
    //
    @JoinColumn(name = "tor_3emp_ID", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee tor3empID;
    @JoinColumn(name = "tor_conr_ID", referencedColumnName = "conr_ID")
    @ManyToOne
    private CsContractor torconrID;
    @JoinColumn(name = "tor_proNo_ID", referencedColumnName = "pNo_id")
    @ManyToOne
    private CsProjectno torproNoID;
    @JoinColumn(name = "tor_pro_ID", referencedColumnName = "pro_ID")
    @ManyToOne
    private CsProject torproID;
    @JoinColumn(name = "tor_sw_tor_ID", referencedColumnName = "sw_tor_ID")
    @ManyToOne
    private CsSwTor torswtorID;
    @JoinColumn(name = "tor_sw_tor_co_ID", referencedColumnName = "sw_tor_co_ID")
    @ManyToOne
    private CsSwTorCo torswtorcoID;
    @OneToMany(mappedBy = "wptorID")
    private List<CsWorkplan> csWorkplanList;
    //
    @JoinColumn(name = "test2t2", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee test2t2;
    //
    @OneToOne(mappedBy = "contorID")
    private CsContract csContract;
    //
    @JoinColumn(name = "test1t1t", referencedColumnName = "emp_ID")
    @ManyToOne
    private CsEmployee test1t1t;
    //

    public CsTor() {
    }

    public CsTor(Long torId) {
        this.torId = torId;
    }

    public Long getTorId() {
        return torId;
    }

    public CsEmployee getTest2t2() {
        return test2t2;
    }

    public void setTest2t2(CsEmployee test2t2) {
        this.test2t2 = test2t2;
    }

    public CsEmployee getTest1t1t() {
        return test1t1t;
    }

    public void setTest1t1t(CsEmployee test1t1t) {
        this.test1t1t = test1t1t;
    }

    public void setTorId(Long torId) {
        this.torId = torId;
    }

    public String getTorObjective() {
        return torObjective;
    }

    public void setTorObjective(String torObjective) {
        this.torObjective = torObjective;
    }

    public Date getTorfromDate() {
        return torfromDate;
    }

    public void setTorfromDate(Date torfromDate) {
        this.torfromDate = torfromDate;
    }

    public Date getTortoDate() {
        return tortoDate;
    }

    public void setTortoDate(Date tortoDate) {
        this.tortoDate = tortoDate;
    }

    public Integer getTorworkingDays() {
        return torworkingDays;
    }

    public void setTorworkingDays(Integer torworkingDays) {
        this.torworkingDays = torworkingDays;
    }

    public String getTorTasks() {
        return torTasks;
    }

    public void setTorTasks(String torTasks) {
        this.torTasks = torTasks;
    }

    public String getTortaskAbove() {
        return tortaskAbove;
    }

    public void setTortaskAbove(String tortaskAbove) {
        this.tortaskAbove = tortaskAbove;
    }

    public String getTorPlace() {
        return torPlace;
    }

    public void setTorPlace(String torPlace) {
        this.torPlace = torPlace;
    }

    public String getTortempProID() {
        return tortempProID;
    }

    public void setTortempProID(String tortempProID) {
        this.tortempProID = tortempProID;
    }

    public String getTorWpAfter() {
        return torWpAfter;
    }

    public void setTorWpAfter(String torWpAfter) {
        this.torWpAfter = torWpAfter;
    }

    public String getTorPsAfter() {
        return torPsAfter;
    }

    public void setTorPsAfter(String torPsAfter) {
        this.torPsAfter = torPsAfter;
    }

    public Integer getTorType() {
        return torType;
    }

    public void setTorType(Integer torType) {
        this.torType = torType;
    }

    public CsContract getCsContract() {
        return csContract;
    }

    public void setCsContract(CsContract csContract) {
        this.csContract = csContract;
    }

    
    @XmlTransient
    public List<CsTorTask> getCsTorTaskList() {
        return csTorTaskList;
    }

    public void setCsTorTaskList(List<CsTorTask> csTorTaskList) {
        this.csTorTaskList = csTorTaskList;
    }

    public CsEmployee getTor1empID() {
        return tor1empID;
    }

    public void setTor1empID(CsEmployee tor1empID) {
        this.tor1empID = tor1empID;
    }

    public CsEmployee getTor2empID() {
        return tor2empID;
    }

    public void setTor2empID(CsEmployee tor2empID) {
        this.tor2empID = tor2empID;
    }

    public CsEmployee getTor3empID() {
        return tor3empID;
    }

    public void setTor3empID(CsEmployee tor3empID) {
        this.tor3empID = tor3empID;
    }

    public CsContractor getTorconrID() {
        return torconrID;
    }

    public void setTorconrID(CsContractor torconrID) {
        this.torconrID = torconrID;
    }

    public CsProjectno getTorproNoID() {
        return torproNoID;
    }

    public void setTorproNoID(CsProjectno torproNoID) {
        this.torproNoID = torproNoID;
    }

    public CsProject getTorproID() {
        return torproID;
    }

    public void setTorproID(CsProject torproID) {
        this.torproID = torproID;
    }

    public CsSwTor getTorswtorID() {
        return torswtorID;
    }

    public void setTorswtorID(CsSwTor torswtorID) {
        this.torswtorID = torswtorID;
    }

    public CsSwTorCo getTorswtorcoID() {
        return torswtorcoID;
    }

    public void setTorswtorcoID(CsSwTorCo torswtorcoID) {
        this.torswtorcoID = torswtorcoID;
    }

    @XmlTransient
    public List<CsWorkplan> getCsWorkplanList() {
        return csWorkplanList;
    }

    public void setCsWorkplanList(List<CsWorkplan> csWorkplanList) {
        this.csWorkplanList = csWorkplanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (torId != null ? torId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsTor)) {
            return false;
        }
        CsTor other = (CsTor) object;
        if ((this.torId == null && other.torId != null) || (this.torId != null && !this.torId.equals(other.torId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsTor[ torId=" + torId + " ]";
    }
    
}
