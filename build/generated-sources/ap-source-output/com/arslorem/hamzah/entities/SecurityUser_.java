package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.SecurityGroup;
import com.arslorem.hamzah.entities.SecurityPermission;
import com.arslorem.hamzah.entities.SecurityUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(SecurityUser.class)
public class SecurityUser_ { 

    public static volatile SingularAttribute<SecurityUser, String> imageName;
    public static volatile ListAttribute<SecurityUser, SecurityGroup> groups;
    public static volatile SingularAttribute<SecurityUser, SecurityUser> updateUser;
    public static volatile SingularAttribute<SecurityUser, Date> updateTime;
    public static volatile SingularAttribute<SecurityUser, String> officialPhone;
    public static volatile SingularAttribute<SecurityUser, String> userName;
    public static volatile SingularAttribute<SecurityUser, String> password;
    public static volatile SingularAttribute<SecurityUser, Date> createTime;
    public static volatile ListAttribute<SecurityUser, SecurityPermission> permissions;
    public static volatile SingularAttribute<SecurityUser, String> name;
    public static volatile SingularAttribute<SecurityUser, SecurityUser> createUser;
    public static volatile SingularAttribute<SecurityUser, Long> id;
    public static volatile SingularAttribute<SecurityUser, String> officialEmail;
    public static volatile SingularAttribute<SecurityUser, Boolean> status;

}