package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.SecurityPermission;
import com.arslorem.hamzah.entities.SecurityUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(SecurityGroup.class)
public class SecurityGroup_ { 

    public static volatile SingularAttribute<SecurityGroup, Date> createTime;
    public static volatile ListAttribute<SecurityGroup, SecurityPermission> permissions;
    public static volatile SingularAttribute<SecurityGroup, String> name;
    public static volatile SingularAttribute<SecurityGroup, SecurityUser> updateUser;
    public static volatile SingularAttribute<SecurityGroup, Date> updateTime;
    public static volatile SingularAttribute<SecurityGroup, SecurityUser> createUser;
    public static volatile SingularAttribute<SecurityGroup, Long> id;
    public static volatile ListAttribute<SecurityGroup, SecurityUser> users;

}