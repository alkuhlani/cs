/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsProject.findAll", query = "SELECT c FROM CsProject c")
    , @NamedQuery(name = "CsProject.findByProID", query = "SELECT c FROM CsProject c WHERE c.proID = :proID")
    , @NamedQuery(name = "CsProject.findByProfullName", query = "SELECT c FROM CsProject c WHERE c.profullName = :profullName")
    , @NamedQuery(name = "CsProject.findByProshortName", query = "SELECT c FROM CsProject c WHERE c.proshortName = :proshortName")
    , @NamedQuery(name = "CsProject.findByProAddress1", query = "SELECT c FROM CsProject c WHERE c.proAddress1 = :proAddress1")
    , @NamedQuery(name = "CsProject.findByProAddress2", query = "SELECT c FROM CsProject c WHERE c.proAddress2 = :proAddress2")
    , @NamedQuery(name = "CsProject.findByProX", query = "SELECT c FROM CsProject c WHERE c.proX = :proX")
    , @NamedQuery(name = "CsProject.findByProCity", query = "SELECT c FROM CsProject c WHERE c.proCity = :proCity")
    , @NamedQuery(name = "CsProject.findByProCountry", query = "SELECT c FROM CsProject c WHERE c.proCountry = :proCountry")})
public class CsProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_ID")
    private Long proID;
    @Column(name = "pro_fullName")
    private String profullName;
    @Column(name = "pro_shortName")
    private String proshortName;
    @Column(name = "pro_address1")
    private String proAddress1;
    @Column(name = "pro_address2")
    private String proAddress2;
    @Column(name = "pro_x")
    private String proX;
    @Column(name = "pro_city")
    private String proCity;
    @Column(name = "pro_country")
    private String proCountry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pNoproID")
    private List<CsProjectno> csProjectnoList;
    @OneToMany(mappedBy = "torproID")
    private List<CsTor> csTorList;

    public CsProject() {
    }

    public CsProject(Long proID) {
        this.proID = proID;
    }

    public Long getProID() {
        return proID;
    }

    public void setProID(Long proID) {
        this.proID = proID;
    }

    public String getProfullName() {
        return profullName;
    }

    public void setProfullName(String profullName) {
        this.profullName = profullName;
    }

    public String getProshortName() {
        return proshortName;
    }

    public void setProshortName(String proshortName) {
        this.proshortName = proshortName;
    }

    public String getProAddress1() {
        return proAddress1;
    }

    public void setProAddress1(String proAddress1) {
        this.proAddress1 = proAddress1;
    }

    public String getProAddress2() {
        return proAddress2;
    }

    public void setProAddress2(String proAddress2) {
        this.proAddress2 = proAddress2;
    }

    public String getProX() {
        return proX;
    }

    public void setProX(String proX) {
        this.proX = proX;
    }

    public String getProCity() {
        return proCity;
    }

    public void setProCity(String proCity) {
        this.proCity = proCity;
    }

    public String getProCountry() {
        return proCountry;
    }

    public void setProCountry(String proCountry) {
        this.proCountry = proCountry;
    }

    @XmlTransient
    public List<CsProjectno> getCsProjectnoList() {
        return csProjectnoList;
    }

    public void setCsProjectnoList(List<CsProjectno> csProjectnoList) {
        this.csProjectnoList = csProjectnoList;
    }

    @XmlTransient
    public List<CsTor> getCsTorList() {
        return csTorList;
    }

    public void setCsTorList(List<CsTor> csTorList) {
        this.csTorList = csTorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proID != null ? proID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsProject)) {
            return false;
        }
        CsProject other = (CsProject) object;
        if ((this.proID == null && other.proID != null) || (this.proID != null && !this.proID.equals(other.proID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsProject[ proID=" + proID + " ]";
    }
    
}
