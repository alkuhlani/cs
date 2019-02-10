package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsTor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsSwTorCo.class)
public class CsSwTorCo_ { 

    public static volatile SingularAttribute<CsSwTorCo, Long> swtorcoID;
    public static volatile SingularAttribute<CsSwTorCo, String> swTorCoTxt;
    public static volatile SingularAttribute<CsSwTorCo, Boolean> swtorcoisDefault;
    public static volatile ListAttribute<CsSwTorCo, CsTor> csTorList;

}