/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_pa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsPa.findAll", query = "SELECT c FROM CsPa c")
    , @NamedQuery(name = "CsPa.findByConId", query = "SELECT c FROM CsPa c WHERE c.paconID.conID = :id")
    , @NamedQuery(name = "CsPa.findByPaID", query = "SELECT c FROM CsPa c WHERE c.paID = :paID")
    , @NamedQuery(name = "CsPa.findByPaconrdayNo", query = "SELECT c FROM CsPa c WHERE c.paconrdayNo = :paconrdayNo")
    , @NamedQuery(name = "CsPa.findByPaPerType", query = "SELECT c FROM CsPa c WHERE c.paPerType = :paPerType")
    , @NamedQuery(name = "CsPa.findByPaPerAvrg", query = "SELECT c FROM CsPa c WHERE c.paPerAvrg = :paPerAvrg")
    , @NamedQuery(name = "CsPa.findByPaPerAmount", query = "SELECT c FROM CsPa c WHERE c.paPerAmount = :paPerAmount")
    , @NamedQuery(name = "CsPa.findByPaPerDesc", query = "SELECT c FROM CsPa c WHERE c.paPerDesc = :paPerDesc")
    , @NamedQuery(name = "CsPa.findByPaAccoAmount", query = "SELECT c FROM CsPa c WHERE c.paAccoAmount = :paAccoAmount")
    , @NamedQuery(name = "CsPa.findByPaaccoisWorkingDay", query = "SELECT c FROM CsPa c WHERE c.paaccoisWorkingDay = :paaccoisWorkingDay")
    , @NamedQuery(name = "CsPa.findByPaRemark", query = "SELECT c FROM CsPa c WHERE c.paRemark = :paRemark")})
public class CsPa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pa_ID")
    private Long paID;
    @Column(name = "pa_conr_dayNo")
    private Integer paconrdayNo;
    @Column(name = "pa_per_type")
    private String paPerType;
    @Column(name = "pa_per_items")
    private String paPerItems;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pa_per_avrg")
    private Double paPerAvrg;
    @Column(name = "pa_per_amount")
    private Double paPerAmount;
    @Column(name = "pa_per_desc")
    private String paPerDesc;
    @Column(name = "pa_acco_amount")
    private Double paAccoAmount;
    @Column(name = "pa_acco_isWorkingDay")
    private Boolean paaccoisWorkingDay;
    @Column(name = "pa_remark")
    private String paRemark;
    @JoinColumn(name = "pa_con_ID", referencedColumnName = "con_ID")
    @ManyToOne
    private CsContract paconID;

    public CsPa() {
    }

    public CsPa(Long paID) {
        this.paID = paID;
    }

    public Long getPaID() {
        return paID;
    }

    public void setPaID(Long paID) {
        this.paID = paID;
    }

    public Integer getPaconrdayNo() {
        return paconrdayNo;
    }

    public void setPaconrdayNo(Integer paconrdayNo) {
        this.paconrdayNo = paconrdayNo;
    }

    public String getPaPerType() {
        return paPerType;
    }

    public void setPaPerType(String paPerType) {
        this.paPerType = paPerType;
    }

    public Double getPaPerAvrg() {
        return paPerAvrg;
    }

    public void setPaPerAvrg(Double paPerAvrg) {
        this.paPerAvrg = paPerAvrg;
    }

    public Double getPaPerAmount() {
        return paPerAmount;
    }

    public void setPaPerAmount(Double paPerAmount) {
        this.paPerAmount = paPerAmount;
    }

    public String getPaPerDesc() {
        return paPerDesc;
    }

    public void setPaPerDesc(String paPerDesc) {
        this.paPerDesc = paPerDesc;
    }

    public Double getPaAccoAmount() {
        return paAccoAmount;
    }

    public void setPaAccoAmount(Double paAccoAmount) {
        this.paAccoAmount = paAccoAmount;
    }

    public Boolean getPaaccoisWorkingDay() {
        return paaccoisWorkingDay;
    }

    public void setPaaccoisWorkingDay(Boolean paaccoisWorkingDay) {
        this.paaccoisWorkingDay = paaccoisWorkingDay;
    }

    public String getPaRemark() {
        return paRemark;
    }

    public void setPaRemark(String paRemark) {
        this.paRemark = paRemark;
    }

    public CsContract getPaconID() {
        return paconID;
    }

    public void setPaconID(CsContract paconID) {
        this.paconID = paconID;
    }

    public String getPaPerItems() {
        return paPerItems;
    }

    public void setPaPerItems(String paPerItems) {
        this.paPerItems = paPerItems;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paID != null ? paID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsPa)) {
            return false;
        }
        CsPa other = (CsPa) object;
        if ((this.paID == null && other.paID != null) || (this.paID != null && !this.paID.equals(other.paID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsPa[ paID=" + paID + " ]";
    }
    
}
