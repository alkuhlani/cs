package com.arslorem.hamzah.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author mohammed
 */
public class Helper {

    public static void message(Severity severity, String summary) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg(summary), null));
    }

    public static String msg(String key) {
        try {
            return FacesContext
                    .getCurrentInstance()
                    .getApplication()
                    .getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString(key);
        } catch (Exception e) {
            return key;
        }
    }

    public static void redirect(String url) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect(context.getRequestContextPath() + url);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
