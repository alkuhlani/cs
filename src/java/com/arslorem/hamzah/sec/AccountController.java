package com.arslorem.hamzah.sec;


import com.arslorem.hamzah.ejbs.AccessTrackingBean;
import com.arslorem.hamzah.ejbs.SecurityUserBean;
import com.arslorem.hamzah.entities.AccessTracking;
import com.arslorem.hamzah.entities.SecurityUser;
import com.arslorem.hamzah.util.Helper;
import java.util.Date;
import java.util.Objects;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.validation.constraints.NotNull;

@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(loginPage = "/login.xhtml", errorPage = "/index.xhtml"))
@Named(value = "accountController")
@RequestScoped
public class AccountController {

//    @NotNull
    private String username;

//    @NotNull
    private String password;

    private AccessTracking item;
    private SecurityUser user;

    @Inject
    private SecurityContext securityContext;
    @Inject
    private AccessTrackingBean accessTrackingBean;
    @Inject
    private SecurityUserBean securityUserBean;

    public void login() {
        if (Objects.nonNull(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("name"))) {
            Helper.redirect("/index.xhtml?faces-redirect=true");
        }
//        System.out.println("getSessionId(true)-" + FacesContext.getCurrentInstance().getExternalContext().getSessionId(true));
//        System.out.println("getSession(true)-" + FacesContext.getCurrentInstance().getExternalContext().getSession(true));
//        System.out.println("getSessionMap().isEmpty()-" + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().isEmpty());
//        System.out.println("getSessionMap().get(\"name\")-" + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("name"));
//        HttpSession session d = FacesContext.getCurrentInstance().getExternalContext().get;

//        FacesContext facesContext1 = FacesContext.getCurrentInstance();
//        HttpSession session1 = (HttpSession) facesContext1.getExternalContext().getSession(false);
////        System.out.println("session.getId()-"+session1.getId());
////        System.out.println("session.getCreationTime()-"+session1.getCreationTime());
//        System.out.println("session.getLastAccessedTime()-"+session1.getLastAccessedTime());
//        System.out.println("session.isNew()-"+session1.isNew());
//        System.out.println("ddddddddddddddddddddddd");
//        System.out.println("in login");
        item = new AccessTracking();
        item.setUserName(username);
        item.setPassword(password);
        item.setCreateTime(new Date());
        item.setActionType("login");
        FacesContext context = FacesContext.getCurrentInstance();
        Credential credential = new UsernamePasswordCredential(username, new Password(password));

        securityContext.authenticate((HttpServletRequest) context.getExternalContext().getRequest(),
                (HttpServletResponse) context.getExternalContext().getResponse(),
                withParams().credential(credential));
        
            
            user = securityUserBean.findByUserNamePassword(username, password);
            if (Objects.nonNull(user)) {
                item.setSecurityUser(user);
                item.setStatus(Boolean.TRUE);
            }else{
                item.setStatus(Boolean.FALSE);
            }
       
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ip = httpServletRequest.getRemoteAddr();
        item.setActionDesc(ip);
        accessTrackingBean.create(item);
//        System.out.println("credential" + credential.isValid());
//        System.out.println("" + context.getELContext());
//        System.out.println("" + context.getRenderKit());
//        System.out.println("" + context.getViewRoot().getViewId());
//        System.out.println("" + context.getViewRoot().getLocale());
//        if (context.isProjectStage(ProjectStage.UnitTest)) {
//            System.out.println(ProjectStage.UnitTest);
//        }
//
//        System.out.println("getSessionId(true)-" + FacesContext.getCurrentInstance().getExternalContext().getSessionId(true));
//        System.out.println("getSession(true)-" + FacesContext.getCurrentInstance().getExternalContext().getSession(true));
//        System.out.println("getSessionMap().isEmpty()-" + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().isEmpty());
//        System.out.println("getSessionMap().get(\"name\")-" + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("name"));
//        HttpSession session d = FacesContext.getCurrentInstance().getExternalContext().get;
//
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//        System.out.println("session.getId()-"+session.getId());
//        System.out.println("session.getCreationTime()-"+session.getCreationTime());
//        System.out.println("session.getLastAccessedTime()-"+session.getLastAccessedTime());
//        System.out.println("session.isNew()-"+session.isNew());
//        System.out.println("ddddddddddddddddddddddd");
        //
//        
//        Enumeration e = session.getAttributeNames();
//        while (e.hasMoreElements()) {
//            String attr = (String) e.nextElement();
//            System.err.println("      attr  = " + attr);
//            Object value = session.getValue(attr);
//            System.err.println("      value = " + value);
//        }
        if (credential.isValid()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("name", "true");

        }
    }

    public String logout() {
        System.out.println("in logout");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("after logout");
        return "/index?faces-redirect=true";
    }

    public void changeLanguage(String language) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("language", language);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
