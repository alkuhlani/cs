package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsProjectno;
import com.arslorem.hamzah.entities.CsTor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsProject.class)
public class CsProject_ { 

    public static volatile ListAttribute<CsProject, CsProjectno> csProjectnoList;
    public static volatile SingularAttribute<CsProject, String> proCountry;
    public static volatile SingularAttribute<CsProject, String> profullName;
    public static volatile SingularAttribute<CsProject, String> proCity;
    public static volatile SingularAttribute<CsProject, Long> proID;
    public static volatile SingularAttribute<CsProject, String> proshortName;
    public static volatile ListAttribute<CsProject, CsTor> csTorList;
    public static volatile SingularAttribute<CsProject, String> proAddress1;
    public static volatile SingularAttribute<CsProject, String> proAddress2;
    public static volatile SingularAttribute<CsProject, String> proX;

}