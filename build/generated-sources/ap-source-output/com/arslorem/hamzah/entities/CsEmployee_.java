package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsTor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsEmployee.class)
public class CsEmployee_ { 

    public static volatile ListAttribute<CsEmployee, CsTor> csTors;
    public static volatile SingularAttribute<CsEmployee, Long> empID;
    public static volatile SingularAttribute<CsEmployee, String> empType;
    public static volatile SingularAttribute<CsEmployee, String> empEmail;
    public static volatile SingularAttribute<CsEmployee, String> empPosition;
    public static volatile SingularAttribute<CsEmployee, String> empmobileNo;
    public static volatile ListAttribute<CsEmployee, CsContract> csContractList2;
    public static volatile ListAttribute<CsEmployee, CsTor> csTors4;
    public static volatile ListAttribute<CsEmployee, CsContract> csContracts1;
    public static volatile SingularAttribute<CsEmployee, String> empName;
    public static volatile SingularAttribute<CsEmployee, Boolean> empisDefaultTor;
    public static volatile ListAttribute<CsEmployee, CsTor> csTors2;
    public static volatile SingularAttribute<CsEmployee, String> empTitle;
    public static volatile ListAttribute<CsEmployee, CsTor> csTors3;
    public static volatile ListAttribute<CsEmployee, CsContract> csContracts;
    public static volatile ListAttribute<CsEmployee, CsTor> csTors1;

}