/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author said
 */
@Entity
@Table(name = "cs_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsEmployee.findAll", query = "SELECT c FROM CsEmployee c")
    , @NamedQuery(name = "CsEmployee.findByEmpID", query = "SELECT c FROM CsEmployee c WHERE c.empID = :empID")
    , @NamedQuery(name = "CsEmployee.findByEmpName", query = "SELECT c FROM CsEmployee c WHERE c.empName = :empName")
    , @NamedQuery(name = "CsEmployee.findByEmpPosition", query = "SELECT c FROM CsEmployee c WHERE c.empPosition = :empPosition")
    , @NamedQuery(name = "CsEmployee.findByEmpmobileNo", query = "SELECT c FROM CsEmployee c WHERE c.empmobileNo = :empmobileNo")
    , @NamedQuery(name = "CsEmployee.findByEmpEmail", query = "SELECT c FROM CsEmployee c WHERE c.empEmail = :empEmail")
    , @NamedQuery(name = "CsEmployee.findByEmpType", query = "SELECT c FROM CsEmployee c WHERE c.empType = :empType")
    , @NamedQuery(name = "CsEmployee.findByEmpTitle", query = "SELECT c FROM CsEmployee c WHERE c.empTitle = :empTitle")
    , @NamedQuery(name = "CsEmployee.findByEmpisDefaultTor", query = "SELECT c FROM CsEmployee c WHERE c.empisDefaultTor = :empisDefaultTor")})
public class CsEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_ID")
    private Long empID;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_position")
    private String empPosition;
    @Column(name = "emp_mobileNo")
    private String empmobileNo;
    @Column(name = "emp_email")
    private String empEmail;
    @Column(name = "emp_type")
    private String empType;
    @Column(name = "emp_title")
    private String empTitle;
    @Column(name = "emp_isDefaultTor")
    private Boolean empisDefaultTor;

    @OneToMany(mappedBy = "conbyempID")
    private List<CsContract> csContractList2;
    
    @OneToMany(mappedBy = "dca_by1")
    private List<CsContract> csContracts;
    @OneToMany(mappedBy = "dca_by2")
    private List<CsContract> csContracts1;
    //
    @OneToMany(mappedBy = "tor1empID")
    private List<CsTor> csTors;
    //
    @OneToMany(mappedBy = "tor2empID")
    private List<CsTor> csTors1;
    //
    @OneToMany(mappedBy = "tor3empID")
    private List<CsTor> csTors2;
    @OneToMany(mappedBy = "test1t1t")
    private List<CsTor> csTors3;
    @OneToMany(mappedBy = "test2t2")
    private List<CsTor> csTors4;
    

    public CsEmployee() {
    }

    public List<CsTor> getCsTors() {
        return csTors;
    }

    public void setCsTors(List<CsTor> csTors) {
        this.csTors = csTors;
    }

    public List<CsTor> getCsTors1() {
        return csTors1;
    }

    public void setCsTors1(List<CsTor> csTors1) {
        this.csTors1 = csTors1;
    }

    public List<CsTor> getCsTors2() {
        return csTors2;
    }

    public void setCsTors2(List<CsTor> csTors2) {
        this.csTors2 = csTors2;
    }

    
 
    public List<CsContract> getCsContracts() {
        return csContracts;
    }

    public void setCsContracts(List<CsContract> csContracts) {
        this.csContracts = csContracts;
    }

    public List<CsContract> getCsContracts1() {
        return csContracts1;
    }

    public void setCsContracts1(List<CsContract> csContracts1) {
        this.csContracts1 = csContracts1;
    }

    public CsEmployee(Long empID) {
        this.empID = empID;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpmobileNo() {
        return empmobileNo;
    }

    public void setEmpmobileNo(String empmobileNo) {
        this.empmobileNo = empmobileNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle;
    }

    public Boolean getEmpisDefaultTor() {
        return empisDefaultTor;
    }

    public void setEmpisDefaultTor(Boolean empisDefaultTor) {
        this.empisDefaultTor = empisDefaultTor;
    }

    
    @XmlTransient
    public List<CsContract> getCsContractList2() {
        return csContractList2;
    }

    public void setCsContractList2(List<CsContract> csContractList2) {
        this.csContractList2 = csContractList2;
    }

    public List<CsTor> getCsTors3() {
        return csTors3;
    }

    public void setCsTors3(List<CsTor> csTors3) {
        this.csTors3 = csTors3;
    }

    public List<CsTor> getCsTors4() {
        return csTors4;
    }

    public void setCsTors4(List<CsTor> csTors4) {
        this.csTors4 = csTors4;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empID != null ? empID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsEmployee)) {
            return false;
        }
        CsEmployee other = (CsEmployee) object;
        if ((this.empID == null && other.empID != null) || (this.empID != null && !this.empID.equals(other.empID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsEmployee[ empID=" + empID + " ]";
    }
    
}
