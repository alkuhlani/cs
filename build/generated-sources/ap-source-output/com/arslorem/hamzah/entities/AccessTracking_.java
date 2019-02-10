package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.SecurityUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(AccessTracking.class)
public class AccessTracking_ { 

    public static volatile SingularAttribute<AccessTracking, String> actionType;
    public static volatile SingularAttribute<AccessTracking, String> password;
    public static volatile SingularAttribute<AccessTracking, Date> createTime;
    public static volatile SingularAttribute<AccessTracking, SecurityUser> securityUser;
    public static volatile SingularAttribute<AccessTracking, Long> id;
    public static volatile SingularAttribute<AccessTracking, String> userName;
    public static volatile SingularAttribute<AccessTracking, String> actionDesc;
    public static volatile SingularAttribute<AccessTracking, Boolean> status;

}