package com.arslorem.hamzah.sec;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

/**
 *
 * @author mohammed
 */
@Stateless
public class SecurityService {

    @Inject
    private SecurityContext sc;

    public boolean hasPermission(String permission) {
        System.out.println("has "+permission+" ():");
        return sc.isCallerInRole(permission);
    }
}
