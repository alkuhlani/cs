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
@Table(name = "cs_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsInvoice.findAll", query = "SELECT c FROM CsInvoice c")
    , @NamedQuery(name = "CsInvoice.findByInvID", query = "SELECT c FROM CsInvoice c WHERE c.invID = :invID")
    , @NamedQuery(name = "CsInvoice.findByInvType", query = "SELECT c FROM CsInvoice c WHERE c.invType = :invType")
    , @NamedQuery(name = "CsInvoice.findByInvApr", query = "SELECT c FROM CsInvoice c WHERE c.invApr = :invApr")
    , @NamedQuery(name = "CsInvoice.findByInvLsatc", query = "SELECT c FROM CsInvoice c WHERE c.invLsatc = :invLsatc")
    , @NamedQuery(name = "CsInvoice.findByInvDfr", query = "SELECT c FROM CsInvoice c WHERE c.invDfr = :invDfr")
    , @NamedQuery(name = "CsInvoice.findByInvDa", query = "SELECT c FROM CsInvoice c WHERE c.invDa = :invDa")
    , @NamedQuery(name = "CsInvoice.findByInvAa", query = "SELECT c FROM CsInvoice c WHERE c.invAa = :invAa")
    , @NamedQuery(name = "CsInvoice.findByInvAt", query = "SELECT c FROM CsInvoice c WHERE c.invAt = :invAt")
    , @NamedQuery(name = "CsInvoice.findByInvTc", query = "SELECT c FROM CsInvoice c WHERE c.invTc = :invTc")
    , @NamedQuery(name = "CsInvoice.findByInvOr", query = "SELECT c FROM CsInvoice c WHERE c.invOr = :invOr")
    , @NamedQuery(name = "CsInvoice.findByInvSt", query = "SELECT c FROM CsInvoice c WHERE c.invSt = :invSt")
    , @NamedQuery(name = "CsInvoice.findByInvTax", query = "SELECT c FROM CsInvoice c WHERE c.invTax = :invTax")
    , @NamedQuery(name = "CsInvoice.findByInvDoa", query = "SELECT c FROM CsInvoice c WHERE c.invDoa = :invDoa")
    , @NamedQuery(name = "CsInvoice.findByInvTotal", query = "SELECT c FROM CsInvoice c WHERE c.invTotal = :invTotal")})
public class CsInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_ID")
    private Long invID;
    @Column(name = "inv_type")
    private Character invType;
    @Column(name = "inv_apr")
    private String invApr;
    @Column(name = "inv_lsatc")
    private String invLsatc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_dfr")
    private Double invDfr;
    @Column(name = "inv_da")
    private Double invDa;
    @Column(name = "inv_aa")
    private Double invAa;
    @Column(name = "inv_at")
    private String invAt;
    @Column(name = "inv_tc")
    private Double invTc;
    @Column(name = "inv_or")
    private String invOr;
    @Column(name = "inv_st")
    private Double invSt;
    @Column(name = "inv_tax")
    private Double invTax;
    @Column(name = "inv_doa")
    private Double invDoa;
    @Column(name = "inv_total")
    private Double invTotal;
    @JoinColumn(name = "inv_conr_ID", referencedColumnName = "con_ID")
    @ManyToOne
    private CsContract invconrID;

    public CsInvoice() {
    }

    public CsInvoice(Long invID) {
        this.invID = invID;
    }

    public Long getInvID() {
        return invID;
    }

    public void setInvID(Long invID) {
        this.invID = invID;
    }

    public Character getInvType() {
        return invType;
    }

    public void setInvType(Character invType) {
        this.invType = invType;
    }

    public String getInvApr() {
        return invApr;
    }

    public void setInvApr(String invApr) {
        this.invApr = invApr;
    }

    public String getInvLsatc() {
        return invLsatc;
    }

    public void setInvLsatc(String invLsatc) {
        this.invLsatc = invLsatc;
    }

    public Double getInvDfr() {
        return invDfr;
    }

    public void setInvDfr(Double invDfr) {
        this.invDfr = invDfr;
    }

    public Double getInvDa() {
        return invDa;
    }

    public void setInvDa(Double invDa) {
        this.invDa = invDa;
    }

    public Double getInvAa() {
        return invAa;
    }

    public void setInvAa(Double invAa) {
        this.invAa = invAa;
    }

    public String getInvAt() {
        return invAt;
    }

    public void setInvAt(String invAt) {
        this.invAt = invAt;
    }

    public Double getInvTc() {
        return invTc;
    }

    public void setInvTc(Double invTc) {
        this.invTc = invTc;
    }

    public String getInvOr() {
        return invOr;
    }

    public void setInvOr(String invOr) {
        this.invOr = invOr;
    }

    public Double getInvSt() {
        return invSt;
    }

    public void setInvSt(Double invSt) {
        this.invSt = invSt;
    }

    public Double getInvTax() {
        return invTax;
    }

    public void setInvTax(Double invTax) {
        this.invTax = invTax;
    }

    public Double getInvDoa() {
        return invDoa;
    }

    public void setInvDoa(Double invDoa) {
        this.invDoa = invDoa;
    }

    public Double getInvTotal() {
        return invTotal;
    }

    public void setInvTotal(Double invTotal) {
        this.invTotal = invTotal;
    }

    public CsContract getInvconrID() {
        return invconrID;
    }

    public void setInvconrID(CsContract invconrID) {
        this.invconrID = invconrID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invID != null ? invID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsInvoice)) {
            return false;
        }
        CsInvoice other = (CsInvoice) object;
        if ((this.invID == null && other.invID != null) || (this.invID != null && !this.invID.equals(other.invID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsInvoice[ invID=" + invID + " ]";
    }
    
}
