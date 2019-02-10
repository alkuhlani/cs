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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cs_projectno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsProjectno.findAll", query = "SELECT c FROM CsProjectno c")
    , @NamedQuery(name = "CsProjectno.findByProID", query = "SELECT c FROM CsProjectno c WHERE c.pNoproID.proID = :id")
    , @NamedQuery(name = "CsProjectno.findByPNoid", query = "SELECT c FROM CsProjectno c WHERE c.pNoid = :pNoid")
    , @NamedQuery(name = "CsProjectno.findByPNoNO", query = "SELECT c FROM CsProjectno c WHERE c.pNoNO = :no")})
public class CsProjectno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pNo_id")
    private Long pNoid;
    @Column(name = "pNo_NO")
    private String pNoNO;
    @JoinColumn(name = "pNo_proID", referencedColumnName = "pro_ID")
    @ManyToOne(optional = false)
    private CsProject pNoproID;
    @OneToMany(mappedBy = "torproNoID")
    private List<CsTor> csTorList;

    public CsProjectno() {
    }

    public CsProjectno(Long pNoid) {
        this.pNoid = pNoid;
    }

    public Long getPNoid() {
        return pNoid;
    }

    public void setPNoid(Long pNoid) {
        this.pNoid = pNoid;
    }

    public String getPNoNO() {
        return pNoNO;
    }

    public void setPNoNO(String pNoNO) {
        this.pNoNO = pNoNO;
    }

    public CsProject getPNoproID() {
        return pNoproID;
    }

    public void setPNoproID(CsProject pNoproID) {
        this.pNoproID = pNoproID;
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
        hash += (pNoid != null ? pNoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsProjectno)) {
            return false;
        }
        CsProjectno other = (CsProjectno) object;
        if ((this.pNoid == null && other.pNoid != null) || (this.pNoid != null && !this.pNoid.equals(other.pNoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsProjectno[ pNoid=" + pNoid + " ]";
    }
    
}
