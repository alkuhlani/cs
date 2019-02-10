package com.arslorem.hamzah.sec;


import com.arslorem.hamzah.ejbs.SecurityUserBean;
import com.arslorem.hamzah.entities.SecurityUser;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.enterprise.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author mohammed
 */
@RequestScoped
public class IdentityStoreImpl implements IdentityStore {

    @Inject
    private SecurityUserBean userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            System.out.println("VALIDATED_RESULT");
            return validate((UsernamePasswordCredential) credential);
        }
        System.out.println("NOT_VALIDATED_RESULT");
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        System.out.println("in CredentialValidationResult");
        SecurityUser user = userService.findByUserNamePassword(usernamePasswordCredential.getCaller(), usernamePasswordCredential.getPasswordAsString());
        System.out.println("hh"+user.getUserName());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName", user.getName());
        if (Objects.nonNull(user)) {
            System.out.println("nonNull user");
            Set<String> groups = new HashSet<>();
            user.getGroups().forEach((group) -> {
                group.getPermissions().forEach((permission) -> {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().putIfAbsent(permission.getName(), true);
                    System.out.println("permission"+permission.getName());
                    groups.add(permission.getName());
                });
            });
            user.getPermissions().forEach((permission) -> {
                System.out.println("permission"+permission.getName());
                groups.add(permission.getName());
            });
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", user.getId());
            return new CredentialValidationResult(new CallerPrincipal(user.getUserName()), groups);
        }
        System.out.println("null");
        return INVALID_RESULT;
    }
}
