/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsSystem.findAll", query = "SELECT c FROM CsSystem c")
    , @NamedQuery(name = "CsSystem.findBySysID", query = "SELECT c FROM CsSystem c WHERE c.sysID = :sysID")
    , @NamedQuery(name = "CsSystem.findBySysFb", query = "SELECT c FROM CsSystem c WHERE c.sysFb = :sysFb")
    , @NamedQuery(name = "CsSystem.findBySysTwi", query = "SELECT c FROM CsSystem c WHERE c.sysTwi = :sysTwi")
    , @NamedQuery(name = "CsSystem.findBySysWebsite", query = "SELECT c FROM CsSystem c WHERE c.sysWebsite = :sysWebsite")
    , @NamedQuery(name = "CsSystem.findBySysName", query = "SELECT c FROM CsSystem c WHERE c.sysName = :sysName")
    , @NamedQuery(name = "CsSystem.findBySysmainImageFile", query = "SELECT c FROM CsSystem c WHERE c.sysmainImageFile = :sysmainImageFile")
    , @NamedQuery(name = "CsSystem.findBySysnameImageFile", query = "SELECT c FROM CsSystem c WHERE c.sysnameImageFile = :sysnameImageFile")
    , @NamedQuery(name = "CsSystem.findBySyssmallImageFile", query = "SELECT c FROM CsSystem c WHERE c.syssmallImageFile = :syssmallImageFile")
    , @NamedQuery(name = "CsSystem.findBySys1conNo", query = "SELECT c FROM CsSystem c WHERE c.sys1conNo = :sys1conNo")
    , @NamedQuery(name = "CsSystem.findBySys2conNo", query = "SELECT c FROM CsSystem c WHERE c.sys2conNo = :sys2conNo")
    , @NamedQuery(name = "CsSystem.findBySys3conNo", query = "SELECT c FROM CsSystem c WHERE c.sys3conNo = :sys3conNo")
    , @NamedQuery(name = "CsSystem.findBySysconNoIsNew", query = "SELECT c FROM CsSystem c WHERE c.sysconNoIsNew = :sysconNoIsNew")
    , @NamedQuery(name = "CsSystem.findBySysconNoIsActive", query = "SELECT c FROM CsSystem c WHERE c.sysconNoIsActive = :sysconNoIsActive")
    , @NamedQuery(name = "CsSystem.findBySysconNoisDate", query = "SELECT c FROM CsSystem c WHERE c.sysconNoisDate = :sysconNoisDate")
    , @NamedQuery(name = "CsSystem.findBySysconNo", query = "SELECT c FROM CsSystem c WHERE c.sysconNo = :sysconNo")})
public class CsSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sys_ID")
    private Long sysID;
    @Column(name = "sys_fb")
    private String sysFb;
    @Column(name = "sys_twi")
    private String sysTwi;
    @Column(name = "sys_website")
    private String sysWebsite;
    @Column(name = "sys_name")
    private String sysName;
    @Column(name = "sys_mainImageFile")
    private String sysmainImageFile;
    @Column(name = "sys_nameImageFile")
    private String sysnameImageFile;
    @Column(name = "sys_smallImageFile")
    private String syssmallImageFile;
    @Column(name = "sys_1conNo")
    private String sys1conNo;
    @Column(name = "sys_11conNo")
    private String sys11conNo;
    @Column(name = "sys_2conNo")
    private String sys2conNo;
    @Column(name = "sys_3conNo")
    private String sys3conNo;
    @Column(name = "sys_conNoIsNew")
    private Boolean sysconNoIsNew;
    @Column(name = "sys_conNoIsActive")
    private Boolean sysconNoIsActive;
    @Column(name = "sys_conNoisDate")
    private Boolean sysconNoisDate;
    @Column(name = "sys_conNo")
    private BigInteger sysconNo;

    public CsSystem() {
    }

    public CsSystem(Long sysID) {
        this.sysID = sysID;
    }

    public Long getSysID() {
        return sysID;
    }

    public void setSysID(Long sysID) {
        this.sysID = sysID;
    }

    public String getSysFb() {
        return sysFb;
    }

    public void setSysFb(String sysFb) {
        this.sysFb = sysFb;
    }

    public String getSysTwi() {
        return sysTwi;
    }

    public void setSysTwi(String sysTwi) {
        this.sysTwi = sysTwi;
    }

    public String getSysWebsite() {
        return sysWebsite;
    }

    public void setSysWebsite(String sysWebsite) {
        this.sysWebsite = sysWebsite;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysmainImageFile() {
        return sysmainImageFile;
    }

    public void setSysmainImageFile(String sysmainImageFile) {
        this.sysmainImageFile = sysmainImageFile;
    }

    public String getSysnameImageFile() {
        return sysnameImageFile;
    }

    public void setSysnameImageFile(String sysnameImageFile) {
        this.sysnameImageFile = sysnameImageFile;
    }

    public String getSyssmallImageFile() {
        return syssmallImageFile;
    }

    public void setSyssmallImageFile(String syssmallImageFile) {
        this.syssmallImageFile = syssmallImageFile;
    }

    public String getSys1conNo() {
        return sys1conNo;
    }

    public void setSys1conNo(String sys1conNo) {
        this.sys1conNo = sys1conNo;
    }

    public String getSys2conNo() {
        return sys2conNo;
    }

    public void setSys2conNo(String sys2conNo) {
        this.sys2conNo = sys2conNo;
    }

    public String getSys3conNo() {
        return sys3conNo;
    }

    public void setSys3conNo(String sys3conNo) {
        this.sys3conNo = sys3conNo;
    }

    public Boolean getSysconNoIsNew() {
        return sysconNoIsNew;
    }

    public void setSysconNoIsNew(Boolean sysconNoIsNew) {
        this.sysconNoIsNew = sysconNoIsNew;
    }

    public Boolean getSysconNoIsActive() {
        return sysconNoIsActive;
    }

    public void setSysconNoIsActive(Boolean sysconNoIsActive) {
        this.sysconNoIsActive = sysconNoIsActive;
    }

    public Boolean getSysconNoisDate() {
        return sysconNoisDate;
    }

    public void setSysconNoisDate(Boolean sysconNoisDate) {
        this.sysconNoisDate = sysconNoisDate;
    }

    public BigInteger getSysconNo() {
        return sysconNo;
    }

    public void setSysconNo(BigInteger sysconNo) {
        this.sysconNo = sysconNo;
    }

    public String getSys11conNo() {
        return sys11conNo;
    }

    public void setSys11conNo(String sys11conNo) {
        this.sys11conNo = sys11conNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysID != null ? sysID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsSystem)) {
            return false;
        }
        CsSystem other = (CsSystem) object;
        if ((this.sysID == null && other.sysID != null) || (this.sysID != null && !this.sysID.equals(other.sysID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsSystem[ sysID=" + sysID + " ]";
    }
    
}
