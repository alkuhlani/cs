/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.util;

import java.util.UUID;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author said
 */
@Named(value = "utilMB")
@RequestScoped
public class utilMB {

    /**
     * Creates a new instance of utilMB
     */
    public utilMB() {
    }
    public String getIdFile() {
        return UUID.randomUUID().toString();
    }
    
}
