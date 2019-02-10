/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_tran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsTran.findAll", query = "SELECT c FROM CsTran c")
    , @NamedQuery(name = "CsTran.findByConId", query = "SELECT c FROM CsTran c WHERE c.traconID.conID = :id")
    , @NamedQuery(name = "CsTran.findByTraID", query = "SELECT c FROM CsTran c WHERE c.traID = :traID")
    , @NamedQuery(name = "CsTran.findByTraDesc", query = "SELECT c FROM CsTran c WHERE c.traDesc = :traDesc")
    , @NamedQuery(name = "CsTran.findByTraDate", query = "SELECT c FROM CsTran c WHERE c.traDate = :traDate")
    , @NamedQuery(name = "CsTran.findByTraKM", query = "SELECT c FROM CsTran c WHERE c.traKM = :traKM")
    , @NamedQuery(name = "CsTran.findByTraCost", query = "SELECT c FROM CsTran c WHERE c.traCost = :traCost")
    , @NamedQuery(name = "CsTran.findByTraTotal", query = "SELECT c FROM CsTran c WHERE c.traTotal = :traTotal")})
public class CsTran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tra_ID")
    private Long traID;
    @Column(name = "tra_desc")
    private String traDesc;
    @Column(name = "tra_remark")
    private String traRemark;
    @Column(name = "tra_times")
    private Integer traTimes;
    @Column(name = "tra_date")
    @Temporal(TemporalType.DATE)
    private Date traDate;
    @Column(name = "tra_KM")
    private Double traKM;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tra_cost")
    private Double traCost;
    @Column(name = "tra_total")
    private Double traTotal;
    @JoinColumn(name = "tra_con_ID", referencedColumnName = "con_ID")
    @ManyToOne
    private CsContract traconID;

    public CsTran() {
    }

    public CsTran(Long traID) {
        this.traID = traID;
    }

    public Long getTraID() {
        return traID;
    }

    public void setTraID(Long traID) {
        this.traID = traID;
    }

    public String getTraDesc() {
        return traDesc;
    }

    public void setTraDesc(String traDesc) {
        this.traDesc = traDesc;
    }

    public Date getTraDate() {
        return traDate;
    }

    public void setTraDate(Date traDate) {
        this.traDate = traDate;
    }

    public Double getTraKM() {
        return traKM;
    }

    public void setTraKM(Double traKM) {
        this.traKM = traKM;
    }


    public Double getTraCost() {
        return traCost;
    }

    public void setTraCost(Double traCost) {
        this.traCost = traCost;
    }

    public Double getTraTotal() {
        return traTotal;
    }

    public void setTraTotal(Double traTotal) {
        this.traTotal = traTotal;
    }

    public CsContract getTraconID() {
        return traconID;
    }

    public void setTraconID(CsContract traconID) {
        this.traconID = traconID;
    }

    public Integer getTraTimes() {
        return traTimes;
    }

    public void setTraTimes(Integer traTimes) {
        this.traTimes = traTimes;
    }

    public String getTraRemark() {
        return traRemark;
    }

    public void setTraRemark(String traRemark) {
        this.traRemark = traRemark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traID != null ? traID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsTran)) {
            return false;
        }
        CsTran other = (CsTran) object;
        if ((this.traID == null && other.traID != null) || (this.traID != null && !this.traID.equals(other.traID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsTran[ traID=" + traID + " ]";
    }
    
}
