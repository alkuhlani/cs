/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.util;

import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.MessagingException;

/**
 *
 * @author user
 */
@Named(value = "requestMB")
@RequestScoped
public class requestMB {

    /**
     * Creates a new instance of requestMB
     */
    public requestMB() {
    }
    public void SendEmail(Map mailParams) throws MessagingException{
//        MailClass.sendEmail(mailParams);
    }
    public void outComeTo(String url){
        System.out.println();
        Helper.redirect(url);
    }
}
