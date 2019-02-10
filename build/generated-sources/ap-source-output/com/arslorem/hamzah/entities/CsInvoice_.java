package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsContract;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsInvoice.class)
public class CsInvoice_ { 

    public static volatile SingularAttribute<CsInvoice, Character> invType;
    public static volatile SingularAttribute<CsInvoice, String> invApr;
    public static volatile SingularAttribute<CsInvoice, Double> invSt;
    public static volatile SingularAttribute<CsInvoice, Double> invAa;
    public static volatile SingularAttribute<CsInvoice, Double> invTax;
    public static volatile SingularAttribute<CsInvoice, Double> invTotal;
    public static volatile SingularAttribute<CsInvoice, CsContract> invconrID;
    public static volatile SingularAttribute<CsInvoice, Double> invDfr;
    public static volatile SingularAttribute<CsInvoice, String> invOr;
    public static volatile SingularAttribute<CsInvoice, String> invLsatc;
    public static volatile SingularAttribute<CsInvoice, Double> invDoa;
    public static volatile SingularAttribute<CsInvoice, Double> invDa;
    public static volatile SingularAttribute<CsInvoice, Long> invID;
    public static volatile SingularAttribute<CsInvoice, Double> invTc;
    public static volatile SingularAttribute<CsInvoice, String> invAt;

}