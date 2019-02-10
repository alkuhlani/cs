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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cs_contractor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsContractor.findAll", query = "SELECT c FROM CsContractor c")
    , @NamedQuery(name = "CsContractor.findByConrID", query = "SELECT c FROM CsContractor c WHERE c.conrID = :conrID")
    , @NamedQuery(name = "CsContractor.findByConrTitle1", query = "SELECT c FROM CsContractor c WHERE c.conrTitle1 = :conrTitle1")
    , @NamedQuery(name = "CsContractor.findByConrName1", query = "SELECT c FROM CsContractor c WHERE c.conrName1 = :conrName1")
    , @NamedQuery(name = "CsContractor.findByConrName2", query = "SELECT c FROM CsContractor c WHERE c.conrName2 = :conrName2")
    , @NamedQuery(name = "CsContractor.findByConrEmail", query = "SELECT c FROM CsContractor c WHERE c.conrEmail = :conrEmail")
    , @NamedQuery(name = "CsContractor.findByConrmobileNo", query = "SELECT c FROM CsContractor c WHERE c.conrmobileNo = :conrmobileNo")
    , @NamedQuery(name = "CsContractor.findByConrGender", query = "SELECT c FROM CsContractor c WHERE c.conrGender = :conrGender")
    , @NamedQuery(name = "CsContractor.findByConrTitle", query = "SELECT c FROM CsContractor c WHERE c.conrTitle = :conrTitle")
    , @NamedQuery(name = "CsContractor.findByConrStreet", query = "SELECT c FROM CsContractor c WHERE c.conrStreet = :conrStreet")
    , @NamedQuery(name = "CsContractor.findByConrGover", query = "SELECT c FROM CsContractor c WHERE c.conrGover = :conrGover")
    , @NamedQuery(name = "CsContractor.findByConrDist", query = "SELECT c FROM CsContractor c WHERE c.conrDist = :conrDist")
    , @NamedQuery(name = "CsContractor.findByConrCountry", query = "SELECT c FROM CsContractor c WHERE c.conrCountry = :conrCountry")
    , @NamedQuery(name = "CsContractor.findByConrNationality", query = "SELECT c FROM CsContractor c WHERE c.conrNationality = :conrNationality")
    , @NamedQuery(name = "CsContractor.findByConrBirthdate", query = "SELECT c FROM CsContractor c WHERE c.conrBirthdate = :conrBirthdate")
    , @NamedQuery(name = "CsContractor.findByConrcvFile", query = "SELECT c FROM CsContractor c WHERE c.conrcvFile = :conrcvFile")
    , @NamedQuery(name = "CsContractor.findByConrIDFile", query = "SELECT c FROM CsContractor c WHERE c.conrIDFile = :conrIDFile")
    , @NamedQuery(name = "CsContractor.findByConrBName", query = "SELECT c FROM CsContractor c WHERE c.conrBName = :conrBName")
    , @NamedQuery(name = "CsContractor.findByConrBAhn", query = "SELECT c FROM CsContractor c WHERE c.conrBAhn = :conrBAhn")
    , @NamedQuery(name = "CsContractor.findByConrBCountry", query = "SELECT c FROM CsContractor c WHERE c.conrBCountry = :conrBCountry")
    , @NamedQuery(name = "CsContractor.findByConrBBranch", query = "SELECT c FROM CsContractor c WHERE c.conrBBranch = :conrBBranch")
    , @NamedQuery(name = "CsContractor.findByConrBAn", query = "SELECT c FROM CsContractor c WHERE c.conrBAn = :conrBAn")
    , @NamedQuery(name = "CsContractor.findByConrBAc", query = "SELECT c FROM CsContractor c WHERE c.conrBAc = :conrBAc")
    , @NamedQuery(name = "CsContractor.findByConrBBlz", query = "SELECT c FROM CsContractor c WHERE c.conrBBlz = :conrBBlz")
    , @NamedQuery(name = "CsContractor.findByConrBSc", query = "SELECT c FROM CsContractor c WHERE c.conrBSc = :conrBSc")
    , @NamedQuery(name = "CsContractor.findByConrIDNO", query = "SELECT c FROM CsContractor c WHERE c.conrIDNO = :conrIDNO")})
public class CsContractor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conr_ID")
    private Long conrID;
    @Column(name = "conr_title1")
    private String conrTitle1;
    @Column(name = "conr_name1")
    private String conrName1;
    @Column(name = "conr_name2")
    private String conrName2;
    @Column(name = "conr_email")
    private String conrEmail;
    @Column(name = "conr_mobileNo")
    private String conrmobileNo;
    @Column(name = "conr_gender")
    private Boolean conrGender;
    @Column(name = "conr_title")
    private String conrTitle;
    @Column(name = "conr_street")
    private String conrStreet;
    @Column(name = "conr_gover")
    private String conrGover;
    @Column(name = "conr_dist")
    private String conrDist;
    @Column(name = "conr_country")
    private String conrCountry;
    @Column(name = "conr_nationality")
    private String conrNationality;
    @Column(name = "conr_birthdate")
    @Temporal(TemporalType.DATE)
    private Date conrBirthdate;
    @Column(name = "conr_cvFile")
    private String conrcvFile;
    @Column(name = "conr_IDFile")
    private String conrIDFile;
    @Column(name = "conr_b_name")
    private String conrBName;
    @Column(name = "conr_b_ahn")
    private String conrBAhn;
    @Column(name = "conr_b_country")
    private String conrBCountry;
    @Column(name = "conr_b_branch")
    private String conrBBranch;
    @Column(name = "conr_b_an")
    private String conrBAn;
    @Column(name = "conr_b_ac")
    private String conrBAc;
    @Column(name = "conr_b_blz")
    private String conrBBlz;
    @Column(name = "conr_b_sc")
    private String conrBSc;
    @Column(name = "conr_ID_NO")
    private String conrIDNO;
    @OneToMany(mappedBy = "torconrID")
    private List<CsTor> csTorList;

    public CsContractor() {
    }

    public CsContractor(Long conrID) {
        this.conrID = conrID;
    }

    public Long getConrID() {
        return conrID;
    }

    public void setConrID(Long conrID) {
        this.conrID = conrID;
    }

    public String getConrTitle1() {
        return conrTitle1;
    }

    public void setConrTitle1(String conrTitle1) {
        this.conrTitle1 = conrTitle1;
    }

    public String getConrName1() {
        return conrName1;
    }

    public void setConrName1(String conrName1) {
        this.conrName1 = conrName1;
    }

    public String getConrName2() {
        return conrName2;
    }

    public void setConrName2(String conrName2) {
        this.conrName2 = conrName2;
    }

    public String getConrEmail() {
        return conrEmail;
    }

    public void setConrEmail(String conrEmail) {
        this.conrEmail = conrEmail;
    }

    public String getConrmobileNo() {
        return conrmobileNo;
    }

    public void setConrmobileNo(String conrmobileNo) {
        this.conrmobileNo = conrmobileNo;
    }

    public Boolean getConrGender() {
        return conrGender;
    }

    public void setConrGender(Boolean conrGender) {
        this.conrGender = conrGender;
    }

    public String getConrTitle() {
        return conrTitle;
    }

    public void setConrTitle(String conrTitle) {
        this.conrTitle = conrTitle;
    }

    public String getConrStreet() {
        return conrStreet;
    }

    public void setConrStreet(String conrStreet) {
        this.conrStreet = conrStreet;
    }

    public String getConrGover() {
        return conrGover;
    }

    public void setConrGover(String conrGover) {
        this.conrGover = conrGover;
    }

    public String getConrDist() {
        return conrDist;
    }

    public void setConrDist(String conrDist) {
        this.conrDist = conrDist;
    }

    public String getConrCountry() {
        return conrCountry;
    }

    public void setConrCountry(String conrCountry) {
        this.conrCountry = conrCountry;
    }

    public String getConrNationality() {
        return conrNationality;
    }

    public void setConrNationality(String conrNationality) {
        this.conrNationality = conrNationality;
    }

    public Date getConrBirthdate() {
        return conrBirthdate;
    }

    public void setConrBirthdate(Date conrBirthdate) {
        this.conrBirthdate = conrBirthdate;
    }

    public String getConrcvFile() {
        return conrcvFile;
    }

    public void setConrcvFile(String conrcvFile) {
        this.conrcvFile = conrcvFile;
    }

    public String getConrIDFile() {
        return conrIDFile;
    }

    public void setConrIDFile(String conrIDFile) {
        this.conrIDFile = conrIDFile;
    }

    public String getConrBName() {
        return conrBName;
    }

    public void setConrBName(String conrBName) {
        this.conrBName = conrBName;
    }

    public String getConrBAhn() {
        return conrBAhn;
    }

    public void setConrBAhn(String conrBAhn) {
        this.conrBAhn = conrBAhn;
    }

    public String getConrBCountry() {
        return conrBCountry;
    }

    public void setConrBCountry(String conrBCountry) {
        this.conrBCountry = conrBCountry;
    }

    public String getConrBBranch() {
        return conrBBranch;
    }

    public void setConrBBranch(String conrBBranch) {
        this.conrBBranch = conrBBranch;
    }

    public String getConrBAn() {
        return conrBAn;
    }

    public void setConrBAn(String conrBAn) {
        this.conrBAn = conrBAn;
    }

    public String getConrBAc() {
        return conrBAc;
    }

    public void setConrBAc(String conrBAc) {
        this.conrBAc = conrBAc;
    }

    public String getConrBBlz() {
        return conrBBlz;
    }

    public void setConrBBlz(String conrBBlz) {
        this.conrBBlz = conrBBlz;
    }

    public String getConrBSc() {
        return conrBSc;
    }

    public void setConrBSc(String conrBSc) {
        this.conrBSc = conrBSc;
    }

    public String getConrIDNO() {
        return conrIDNO;
    }

    public void setConrIDNO(String conrIDNO) {
        this.conrIDNO = conrIDNO;
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
        hash += (conrID != null ? conrID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsContractor)) {
            return false;
        }
        CsContractor other = (CsContractor) object;
        if ((this.conrID == null && other.conrID != null) || (this.conrID != null && !this.conrID.equals(other.conrID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsContractor[ conrID=" + conrID + " ]";
    }
    
}
