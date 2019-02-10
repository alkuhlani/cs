/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.util;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ahmed
 */
@Named(value = "helperMB")
@RequestScoped
public class HelperMB {

    /**
     * Creates a new instance of HelperMB
     */
    private String SPL=StaticClass.SPL;
    private String ER=StaticClass.ER;
    public HelperMB() {
    }
    public void outComeTo(String url){
        System.out.println();
        Helper.redirect(url);
    }

    public String getSPL() {
        return SPL;
    }

    public void setSPL(String SPL) {
        this.SPL = SPL;
    }

    public String getER() {
        return ER;
    }

    public void setER(String ER) {
        this.ER = ER;
    }
    
}
