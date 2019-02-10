/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author said
 */
@Entity(name = "SecurityGroup")
@Table(name = "SECURITY_GROUP")
@NamedQueries({
    @NamedQuery(name = "SecurityGroup.findAll", query = "SELECT u FROM SecurityGroup u ")})
public class SecurityGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "groups")
    private List<SecurityUser> users;
    @ManyToMany
    @JoinTable(name = "GROUP_PERMISSION",
            joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    private List<SecurityPermission> permissions;
    @Column(name = "CREATE_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;
    @JoinColumn(name = "CREATE_USER", nullable = false)
    @ManyToOne
    protected SecurityUser createUser;
    @JoinColumn(name = "UPDATE_USER")
    @ManyToOne
    protected SecurityUser updateUser;

    public SecurityGroup(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public SecurityUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SecurityUser createUser) {
        this.createUser = createUser;
    }

    public SecurityUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SecurityUser updateUser) {
        this.updateUser = updateUser;
    }

    public SecurityGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SecurityUser> getUsers() {
        return users;
    }

    public void setUsers(List<SecurityUser> users) {
        this.users = users;
    }

    public List<SecurityPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SecurityPermission> permissions) {
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityGroup)) {
            return false;
        }
        SecurityGroup other = (SecurityGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.akhohamzah365.vassystem.security.entities.SecurityGroup[ id=" + id + " ]";
    }

}
