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
import javax.persistence.Lob;
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
@Table(name = "cs_workplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsWorkplan.findAll", query = "SELECT c FROM CsWorkplan c")
    , @NamedQuery(name = "CsWorkplan.findByTorID", query = "SELECT c FROM CsWorkplan c WHERE c.wptorID.torId = :id")
    , @NamedQuery(name = "CsWorkplan.findByWpID", query = "SELECT c FROM CsWorkplan c WHERE c.wpID = :wpID")
    , @NamedQuery(name = "CsWorkplan.findByWpNo", query = "SELECT c FROM CsWorkplan c WHERE c.wpNo = :wpNo")
    , @NamedQuery(name = "CsWorkplan.findByWpdayNO", query = "SELECT c FROM CsWorkplan c WHERE c.wpdayNO = :wpdayNO")
    , @NamedQuery(name = "CsWorkplan.findByWpRemark", query = "SELECT c FROM CsWorkplan c WHERE c.wpRemark = :wpRemark")})
public class CsWorkplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wp_ID")
    private Long wpID;
    @Column(name = "wp_no")
    private Integer wpNo;
    @Lob
    @Column(name = "wp_desc")
    private String wpDesc;
    @Column(name = "wp_dayNO")
    private Integer wpdayNO;
    @Column(name = "wp_remark")
    private String wpRemark;
    @JoinColumn(name = "wp_tor_ID", referencedColumnName = "tor_id")
    @ManyToOne
    private CsTor wptorID;

    public CsWorkplan() {
    }

    public CsWorkplan(Long wpID) {
        this.wpID = wpID;
    }

    public Long getWpID() {
        return wpID;
    }

    public void setWpID(Long wpID) {
        this.wpID = wpID;
    }

    public Integer getWpNo() {
        return wpNo;
    }

    public void setWpNo(Integer wpNo) {
        this.wpNo = wpNo;
    }

    public String getWpDesc() {
        return wpDesc;
    }

    public void setWpDesc(String wpDesc) {
        this.wpDesc = wpDesc;
    }

    public Integer getWpdayNO() {
        return wpdayNO;
    }

    public void setWpdayNO(Integer wpdayNO) {
        this.wpdayNO = wpdayNO;
    }

    public String getWpRemark() {
        return wpRemark;
    }

    public void setWpRemark(String wpRemark) {
        this.wpRemark = wpRemark;
    }

    public CsTor getWptorID() {
        return wptorID;
    }

    public void setWptorID(CsTor wptorID) {
        this.wptorID = wptorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wpID != null ? wpID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsWorkplan)) {
            return false;
        }
        CsWorkplan other = (CsWorkplan) object;
        if ((this.wpID == null && other.wpID != null) || (this.wpID != null && !this.wpID.equals(other.wpID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsWorkplan[ wpID=" + wpID + " ]";
    }
    
}
