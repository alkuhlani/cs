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
import javax.persistence.Lob;
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
@Table(name = "cs_sw_tor_co")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsSwTorCo.findAll", query = "SELECT c FROM CsSwTorCo c")
    , @NamedQuery(name = "CsSwTorCo.findBySwtorcoID", query = "SELECT c FROM CsSwTorCo c WHERE c.swtorcoID = :swtorcoID")
    , @NamedQuery(name = "CsSwTorCo.findBySwtorcoisDefault", query = "SELECT c FROM CsSwTorCo c WHERE c.swtorcoisDefault = :swtorcoisDefault")})
public class CsSwTorCo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sw_tor_co_ID")
    private Long swtorcoID;
    @Lob
    @Column(name = "sw_tor_co_txt")
    private String swTorCoTxt;
    @Column(name = "sw_tor_co_isDefault")
    private Boolean swtorcoisDefault;
    @OneToMany(mappedBy = "torswtorcoID")
    private List<CsTor> csTorList;

    public CsSwTorCo() {
    }

    public CsSwTorCo(Long swtorcoID) {
        this.swtorcoID = swtorcoID;
    }

    public Long getSwtorcoID() {
        return swtorcoID;
    }

    public void setSwtorcoID(Long swtorcoID) {
        this.swtorcoID = swtorcoID;
    }

    public String getSwTorCoTxt() {
        return swTorCoTxt;
    }

    public void setSwTorCoTxt(String swTorCoTxt) {
        this.swTorCoTxt = swTorCoTxt;
    }

    public Boolean getSwtorcoisDefault() {
        return swtorcoisDefault;
    }

    public void setSwtorcoisDefault(Boolean swtorcoisDefault) {
        this.swtorcoisDefault = swtorcoisDefault;
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
        hash += (swtorcoID != null ? swtorcoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsSwTorCo)) {
            return false;
        }
        CsSwTorCo other = (CsSwTorCo) object;
        if ((this.swtorcoID == null && other.swtorcoID != null) || (this.swtorcoID != null && !this.swtorcoID.equals(other.swtorcoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsSwTorCo[ swtorcoID=" + swtorcoID + " ]";
    }
    
}
