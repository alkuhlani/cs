package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsProject;
import com.arslorem.hamzah.entities.CsTor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsProjectno.class)
public class CsProjectno_ { 

    public static volatile SingularAttribute<CsProjectno, Long> pNoid;
    public static volatile SingularAttribute<CsProjectno, CsProject> pNoproID;
    public static volatile ListAttribute<CsProjectno, CsTor> csTorList;
    public static volatile SingularAttribute<CsProjectno, String> pNoNO;

}