package com.arslorem.hamzah.entities;

import com.arslorem.hamzah.entities.CsEmployee;
import com.arslorem.hamzah.entities.CsInvoice;
import com.arslorem.hamzah.entities.CsPa;
import com.arslorem.hamzah.entities.CsTor;
import com.arslorem.hamzah.entities.CsTran;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-11T22:12:00")
@StaticMetamodel(CsContract.class)
public class CsContract_ { 

    public static volatile SingularAttribute<CsContract, Date> conPayment1Date;
    public static volatile SingularAttribute<CsContract, BigInteger> conotherMoney;
    public static volatile SingularAttribute<CsContract, Integer> con_payment3_p;
    public static volatile SingularAttribute<CsContract, Integer> con_payment1_p;
    public static volatile SingularAttribute<CsContract, String> dca_case1_to;
    public static volatile SingularAttribute<CsContract, CsEmployee> conbyempID;
    public static volatile SingularAttribute<CsContract, Double> conHonorarium;
    public static volatile SingularAttribute<CsContract, Character> dca_io1_status;
    public static volatile SingularAttribute<CsContract, Character> dca_io3_status;
    public static volatile SingularAttribute<CsContract, Double> concostPerDay;
    public static volatile SingularAttribute<CsContract, Date> conPayment3Date;
    public static volatile ListAttribute<CsContract, CsInvoice> csInvoiceList;
    public static volatile SingularAttribute<CsContract, String> dca_io1;
    public static volatile SingularAttribute<CsContract, String> dca_io2;
    public static volatile SingularAttribute<CsContract, Date> conPayment2Date;
    public static volatile SingularAttribute<CsContract, String> dca_io3;
    public static volatile SingularAttribute<CsContract, CsEmployee> con1empID;
    public static volatile SingularAttribute<CsContract, Boolean> conIsAdhoc;
    public static volatile SingularAttribute<CsContract, Long> conID;
    public static volatile SingularAttribute<CsContract, Boolean> conPayment1Invoice;
    public static volatile SingularAttribute<CsContract, Boolean> conPayment3Invoice;
    public static volatile ListAttribute<CsContract, CsTran> csTranList;
    public static volatile ListAttribute<CsContract, CsPa> csPaList;
    public static volatile SingularAttribute<CsContract, CsTor> contorID;
    public static volatile SingularAttribute<CsContract, String> conNo;
    public static volatile SingularAttribute<CsContract, Date> dcaDate;
    public static volatile SingularAttribute<CsContract, Double> conOtherExpenses;
    public static volatile SingularAttribute<CsContract, Integer> con_payment2_p;
    public static volatile SingularAttribute<CsContract, Integer> con_payment4_p;
    public static volatile SingularAttribute<CsContract, Character> conbuyLevel;
    public static volatile SingularAttribute<CsContract, Date> conPayment4Date;
    public static volatile SingularAttribute<CsContract, String> dca_case2_other;
    public static volatile SingularAttribute<CsContract, CsEmployee> dca_by2;
    public static volatile SingularAttribute<CsContract, CsEmployee> dca_by1;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case;
    public static volatile SingularAttribute<CsContract, Character> dca_io2_status;
    public static volatile SingularAttribute<CsContract, Double> conPayment4;
    public static volatile SingularAttribute<CsContract, CsEmployee> con2empID;
    public static volatile SingularAttribute<CsContract, Double> conPerdiemAverage;
    public static volatile SingularAttribute<CsContract, Boolean> conIsPayment;
    public static volatile SingularAttribute<CsContract, Date> conDate;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case2_2;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case2_3;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case2_4;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case2_5;
    public static volatile SingularAttribute<CsContract, Double> conPayment1;
    public static volatile SingularAttribute<CsContract, String> dca_case1_desc;
    public static volatile SingularAttribute<CsContract, Double> conPayment3;
    public static volatile SingularAttribute<CsContract, Double> conPayment2;
    public static volatile SingularAttribute<CsContract, Boolean> dca_case2_1;
    public static volatile SingularAttribute<CsContract, Boolean> conForCenter;
    public static volatile SingularAttribute<CsContract, Boolean> conPayment2Invoice;
    public static volatile SingularAttribute<CsContract, Boolean> conPayment4Invoice;

}