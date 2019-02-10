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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author said
 */
@Entity(name = "SecurityUser")
@Table(name = "SECURITY_USER")
@NamedQueries({
    @NamedQuery(name = "SecurityUser.findAll", query = "SELECT u FROM SecurityUser u ")
        ,@NamedQuery(name = "SecurityUser.findByUserName", query = "SELECT u FROM SecurityUser u WHERE u.userName=:userName")
        ,@NamedQuery(name = "SecurityUser.findByOfficialEmail", query = "SELECT u FROM SecurityUser u WHERE u.officialEmail=:officialEmail")
        ,@NamedQuery(name = "SecurityUser.findByOfficialPhone", query = "SELECT u FROM SecurityUser u WHERE u.officialPhone=:officialPhone")
    ,@NamedQuery(name = "SecurityUser.findByUserNamePassword", query = "SELECT u FROM SecurityUser u WHERE u.userName = :userName AND u.password = :password AND u.status=TRUE")})
public class SecurityUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "officialEmail")
    private String officialEmail;
    @Column(name = "officialPhone")
    private String officialPhone;
    @Column(name = "imageName")
    private String imageName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"))
    List<SecurityGroup> groups;
    @ManyToMany
    @JoinTable(name = "USER_PERMISSION",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    
    List<SecurityPermission> permissions;
    @Column(name = "CREATE_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;
    @JoinColumn(name = "CREATE_USER", nullable = false)
    @ManyToOne
    protected SecurityUser createUser;
    @OneToMany(mappedBy = "updateUser")
    @JoinColumn(name = "UPDATE_USER")
    @ManyToOne
    protected SecurityUser updateUser;
    @Column(name = "STATUS")
    private Boolean status;
   
    

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getOfficialEmail() {
        return officialEmail;
    }

    public void setOfficialEmail(String officialEmail) {
        this.officialEmail = officialEmail;
    }

    public String getOfficialPhone() {
        return officialPhone;
    }

    public void setOfficialPhone(String officialPhone) {
        this.officialPhone = officialPhone;
    }

    
    
    public Date getCreateTime() {
        return createTime;
    }

    public SecurityUser(Long id) {
        this.id = id;
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

    public SecurityUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SecurityGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<SecurityGroup> groups) {
        this.groups = groups;
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
        if (!(object instanceof SecurityUser)) {
            return false;
        }
        SecurityUser other = (SecurityUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.akhohamzah365.vassystem.security.entities.SecurityUser[ id=" + id + " ]";
    }

}
