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
@Table(name = "cs_tor_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsTorTask.findAll", query = "SELECT c FROM CsTorTask c")
    , @NamedQuery(name = "CsTorTask.findByTaskID", query = "SELECT c FROM CsTorTask c WHERE c.taskID = :taskID")})
public class CsTorTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_ID")
    private Long taskID;
    @Lob
    @Column(name = "task_txt")
    private String taskTxt;
    @JoinColumn(name = "task_tor_ID", referencedColumnName = "tor_id")
    @ManyToOne(optional = false)
    private CsTor tasktorID;

    public CsTorTask() {
    }

    public CsTorTask(Long taskID) {
        this.taskID = taskID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getTaskTxt() {
        return taskTxt;
    }

    public void setTaskTxt(String taskTxt) {
        this.taskTxt = taskTxt;
    }

    public CsTor getTasktorID() {
        return tasktorID;
    }

    public void setTasktorID(CsTor tasktorID) {
        this.tasktorID = tasktorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskID != null ? taskID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsTorTask)) {
            return false;
        }
        CsTorTask other = (CsTorTask) object;
        if ((this.taskID == null && other.taskID != null) || (this.taskID != null && !this.taskID.equals(other.taskID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arslorem.hamzah.entities.CsTorTask[ taskID=" + taskID + " ]";
    }
    
}
