package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsContract;
import com.arslorem.hamzah.entities.CsContractor;
import com.arslorem.hamzah.entities.CsEmployee;
import com.arslorem.hamzah.entities.CsProject;
import com.arslorem.hamzah.entities.CsProjectno;
import com.arslorem.hamzah.entities.CsSwTor;
import com.arslorem.hamzah.entities.CsSwTorCo;
import com.arslorem.hamzah.entities.CsTorTask;
import com.arslorem.hamzah.entities.CsWorkplan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsTor.class)
public class CsTor_ { 

    public static volatile SingularAttribute<CsTor, Long> torId;
    public static volatile SingularAttribute<CsTor, String> torTasks;
    public static volatile SingularAttribute<CsTor, CsContractor> torconrID;
    public static volatile SingularAttribute<CsTor, CsEmployee> test1t1t;
    public static volatile SingularAttribute<CsTor, String> torPlace;
    public static volatile SingularAttribute<CsTor, CsProjectno> torproNoID;
    public static volatile ListAttribute<CsTor, CsTorTask> csTorTaskList;
    public static volatile SingularAttribute<CsTor, CsEmployee> tor3empID;
    public static volatile SingularAttribute<CsTor, CsProject> torproID;
    public static volatile SingularAttribute<CsTor, CsContract> csContract;
    public static volatile SingularAttribute<CsTor, String> tortaskAbove;
    public static volatile SingularAttribute<CsTor, Integer> torType;
    public static volatile SingularAttribute<CsTor, CsSwTor> torswtorID;
    public static volatile ListAttribute<CsTor, CsWorkplan> csWorkplanList;
    public static volatile SingularAttribute<CsTor, CsEmployee> tor1empID;
    public static volatile SingularAttribute<CsTor, String> tortempProID;
    public static volatile SingularAttribute<CsTor, String> torObjective;
    public static volatile SingularAttribute<CsTor, CsEmployee> test2t2;
    public static volatile SingularAttribute<CsTor, Integer> torworkingDays;
    public static volatile SingularAttribute<CsTor, String> torPsAfter;
    public static volatile SingularAttribute<CsTor, Date> torfromDate;
    public static volatile SingularAttribute<CsTor, String> torWpAfter;
    public static volatile SingularAttribute<CsTor, CsEmployee> tor2empID;
    public static volatile SingularAttribute<CsTor, Date> tortoDate;
    public static volatile SingularAttribute<CsTor, CsSwTorCo> torswtorcoID;

}