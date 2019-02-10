package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsContract;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsTran.class)
public class CsTran_ { 

    public static volatile SingularAttribute<CsTran, CsContract> traconID;
    public static volatile SingularAttribute<CsTran, Double> traKM;
    public static volatile SingularAttribute<CsTran, Double> traCost;
    public static volatile SingularAttribute<CsTran, Date> traDate;
    public static volatile SingularAttribute<CsTran, String> traDesc;
    public static volatile SingularAttribute<CsTran, Integer> traTimes;
    public static volatile SingularAttribute<CsTran, String> traRemark;
    public static volatile SingularAttribute<CsTran, Long> traID;
    public static volatile SingularAttribute<CsTran, Double> traTotal;

}