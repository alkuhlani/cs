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
@Table(name = "cs_sw_tor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsSwTor.findAll", query = "SELECT c FROM CsSwTor c")
    , @NamedQuery(name = "CsSwTor.findBySwtorID", query = "SELECT c FROM CsSwTor c WHERE c.swtorID = :swtorID")
    , @NamedQuery(name = "CsSwTor.findBySwtorisDefault", query = "SELECT c FROM CsSwTor c WHERE c.swtorisDefault = :swtorisDefault")})
public class CsSwTor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sw_tor_ID")
    private Long swtorID;
    @Lob
    @Column(name = "sw_tor_txt")
    private String swTorTxt;
    @Column(name = "sw_tor_isDefault")
    private Boolean swtorisDefault;
    @OneToMany(mappedBy = "torswtorID")
    private List<CsTor> csTorList;

    public CsSwTor() {
    }

    public CsSwTor(Long swtorID) {
        this.swtorID = swtorID;
    }

    public Long getSwtorID() {
        return swtorID;
    }

    public void setSwtorID(Long swtorID) {
        this.swtorID = swtorID;
    }

    public String getSwTorTxt() {
        return swTorTxt;
    }

    public void setSwTorTxt(String swTorTxt) {
        this.swTorTxt = swTorTxt;
    }

    public Boolean getSwtorisDefault() {
        return swtorisDefault;
    }

    public void setSwtorisDefault(Boolean swtorisDefault) {
        this.swtorisDefault = swtorisDefault;
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
        hash += (swtorID != null ? swtorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsSwTor)) {
            return false;
        }
        CsSwTor other = (CsSwTor) object;
        if ((this.swtorID == null && other.swtorID != null) || (this.swtorID != null && !this.swtorID.equals(other.swtorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsSwTor[ swtorID=" + swtorID + " ]";
    }
    
}
