/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;


import com.arslorem.hamzah.ejbs.SecurityGroupBean;
import com.arslorem.hamzah.ejbs.SecurityUserBean;
import com.arslorem.hamzah.entities.SecurityGroup;
import com.arslorem.hamzah.entities.SecurityUser;
import com.arslorem.hamzah.util.HelperMB;
import com.arslorem.hamzah.util.VlidatePassword;
import com.arslorem.hamzah.util.requestMB;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.servlet.http.Part;
import org.omnifaces.util.Utils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author user
 */
@Named(value = "securityUserMB")
@ViewScoped
public class SecurityUserMB implements Serializable {

    /**
     * Creates a new instance of SecurityUserMB
     */
    public SecurityUserMB() {
        System.out.println("test");
        Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "Just a test");
//        FacesMessage message = new FacesMessage("Succesful", "TEST");
//        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    UploadedFile file;
    private Part file2;

    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("sssssssssssssssssssssssssssss");
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void read() throws IOException {
        System.out.println("read");
        content = null;
        Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "reading content");
        try {
            content = Utils.toByteArray(file2.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "Content size is " + content.length);
        }
        Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "Content size is " + content.length);
//        saveImageName();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String strDate = dateFormat.format(date);
//        File o = new File("E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
//                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
//        );
        File oStream = new File(
                "E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
                + "\\" + strDate + ".png");
        if (!oStream.exists()) {
            oStream.mkdirs();
        }
        oStream.createNewFile();
        InputStream inputStream = new ByteArrayInputStream(content);
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            System.out.println("7");
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }
        float ff = (int) file.getSize() / 1024;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully -" + ff + "KB"));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "File Uploaded Successfully"));
    }

    public void saveImageName() throws FileNotFoundException, IOException {
        System.out.println("" + file2.getName());
        System.out.println("" + file2.getContentType());
        System.out.println("" + file2.getSubmittedFileName());
        System.out.println("" + file2.getSize());
        System.out.println("ssssssssssssss");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String strDate = dateFormat.format(date);
        System.out.println("converted Date to String: " + strDate);

        System.out.println("-1");

        System.out.println("0");

//        /resources/users-profile/#{session.getAttribute('userId')}/#{request.userPrincipal.name}.png
        File o = new File("E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
        );
        String f = "";

        File oStream = new File(
                "E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
                + "\\" + strDate + ".png");
        if (!o.exists()) {
            o.mkdirs();
        }

        System.out.println(strDate + ".png");

        System.out.println("3");
        oStream.createNewFile();
        System.out.println("4");

        System.out.println("5");
        InputStream inputStream = new ByteArrayInputStream(content);
        System.out.println("6");
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            System.out.println("7");
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        float ff = (int) file.getSize() / 1024;
        System.out.println("8");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully -" + ff + "KB"));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "File Uploaded Successfully"));

    }

    public byte[] getContent() {
        System.out.println("getContent");
        if (content != null) {
            Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "getting content" + content.length);
        } else {
            Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "content is null");
        }
        return content;
    }

    public Part getFile2() {
        System.out.println("getFile");
        return file2;
    }

    public void setFile2(Part file2) {
        System.out.println("dddd");
        this.file2 = file2;
    }
    private byte[] content;

    @PostConstruct
    public void init() {
        Logger.getLogger(SecurityUserMB.class.getName()).log(Level.INFO, "Initialized FileUplaodView");
    }
    private List<SecurityGroup> securityGroups;
    private List<SecurityGroup> securityGroups_user;
    private List<SecurityGroup> selectedsecurityGroups;
    private List<SecurityGroup> removeSelectedsecurityGroups;
    private SecurityUser item;
    private String pass;
    private String lastPass;
    private List<SecurityUser> items;
    private boolean updateName = false;
    private boolean updateUserName = false;
    private boolean updatePassword = false;
    private boolean updatePhoneNumber = false;
    private boolean updateOfficalEmail = false;
    private boolean updateImage = false;
    private boolean inProfile = false;
    private boolean disableContent = false;

    @Inject
    private SecurityUserBean bean;
    @Inject
    private SecurityGroupBean securityGroupBean;
    @Inject
    private requestMB b;
    @Inject
    private HelperMB helperMB;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new SecurityUser();
        item.setCreateTime(new Date());
        item.setCreateUser(new SecurityUser(1L));
        disableContent = false;
        pass = new String();
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
        securityGroups = null;
        disableContent = true;
        securityGroups_user = item.getGroups();
        securityGroups = securityGroupBean.findAll();
        securityGroups.removeAll(securityGroups_user);
        selectedsecurityGroups = null;
        removeSelectedsecurityGroups = null;
        pass = new String();
    }

    public String create() throws MessagingException {
//        pass = new String();
//        System.out.println("item.getPassword()" + pass);
//        VlidatePassword vp = new VlidatePassword();
//        vp.setPassword1(pass);
        System.out.println("1");
//        vp.setPassword2(pass);
//        System.out.println("2");
//            vp.setStatus("");
//        System.out.println("3");
//        vp.validateNewPass();
//        if (!vp.validateNewPass()) {
//            System.out.println("" + vp.validateNewPass());
//            System.out.println("" + vp.getStatus());
//            System.out.println("validatePassword(pass)");
////                (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Password must be Strong, at least 8 characters,"
//                    + "a digit must occur at least once "
//                    + "a lower case letter must occur at least once "
//                    + "an upper case letter must occur at least once "
//                    + "a special character must occur at least once "
//                    + "no whitespace allowed in the entire string "
//                    + " "));
//            item.setPassword("");

//        } else {
            //(?=.*[0-9]) a digit must occur at least once
            //(?=.*[a-z]) a lower case letter must occur at least once
            //(?=.*[A-Z]) an upper case letter must occur at least once
            //(?=.*[@#$%^&+=]) a special character must occur at least once
            //(?=\\S+$) no whitespace allowed in the entire string
            //.{8,} at least 8 characters
//            Calendar c = Calendar.getInstance();
//            c.setTime(new Date()); // Now use today date.
//            Date cDate = c.getTime();
//            c.add(Calendar.DATE, 5); // Adding 5 days
//            Date eDate = c.getTime();

            item.setPassword(pass);
            bean.create(item);
//            long x = 1234567L;
//            long y = 23456789L;
//            Random r = new Random();
//            long number = x + ((long) (r.nextDouble() * (y - x)));
//           
//            emailVerify = new EmailVerify();
//            emailVerify.setCreateTime(cDate);
//            emailVerify.setSecurityUser(item.getId());
//            emailVerify.setStatus(Boolean.FALSE);
//            emailVerify.setExpiryTime(eDate);
//            emailVerify.setVerifyId(number);
//            emailVerifyBean.create(emailVerify);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
//            Map m = new HashMap();
//            m.put("email", item.getOfficialEmail());
//            m.put("date", item.getCreateTime());
//            m.put("name", item.getName());
//            m.put("username", item.getUserName());
//            m.put("password", item.getPassword());
//            m.put("phone", item.getOfficialPhone());
//            m.put("verifyEmailID", number);
//            b.outComeTo("update.xhtml?id=" + item.getId());
//            b.SendEmail(m);

            //  return "items?faces-redirect=true";
            disableContent = true;
            securityGroups_user = item.getGroups();
            securityGroups = securityGroupBean.findAll();
               return "update?id="+item.getId()+"&faces-redirect=true";
//        }
    }

    public void addPermissionToGroup() {
        System.out.println("selectedsecurityGroups.size" + selectedsecurityGroups.size());
        if (selectedsecurityGroups != null) {
            System.out.println("1");
            item.getGroups().addAll(selectedsecurityGroups);
            bean.update(item);
        }
        //
        System.out.println("2");

        securityGroups = null;
        System.out.println("3");
        disableContent = true;
        System.out.println("4");
        securityGroups_user = item.getGroups();
        System.out.println("securityGroups_user.size" + securityGroups_user.size());
        System.out.println("5");
        securityGroups = securityGroupBean.findAll();
        System.out.println("6");
        securityGroups.removeAll(securityGroups_user);
        System.out.println("7");
        selectedsecurityGroups = null;
        System.out.println("8");
        removeSelectedsecurityGroups = null;
        System.out.println("9");
    }

    public void removePermissionFromGroup() {
        System.out.println("1");
        if (removeSelectedsecurityGroups != null) {
            System.out.println("2");
            System.out.println("removeSelectedsecurityGroups.size" + removeSelectedsecurityGroups.size());
            System.out.println("bool" + item.getGroups().removeAll(removeSelectedsecurityGroups));
            bean.update(item);
//            bean.update(item);
        }
        System.out.println("3");
        securityGroups = null;
        System.out.println("4");
        disableContent = true;
        System.out.println("5");
        securityGroups_user = item.getGroups();
        System.out.println("6");
        securityGroups = securityGroupBean.findAll();
        System.out.println("7");
        securityGroups.removeAll(securityGroups_user);
        System.out.println("8");
        selectedsecurityGroups = null;
        System.out.println("9");
        removeSelectedsecurityGroups = null;
    }

    public String update() {
        System.out.println("pass" + pass);
//        pass = new String();
        if (updateUserName) {
            items = bean.findByUserName(item.getUserName());
            System.out.println("items" + items.size());
            if (items.size() > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "please type another user name"));
                return null;
            }
        } else if (updatePassword) {
            if (inProfile) {
                if (!Objects.nonNull(bean.findByUserNamePassword(item.getUserName(), lastPass))) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Last Pssword", ""));
//                item.setPassword("");
                    pass = "";
                    lastPass = "";
                    return null;
                }
            }
            VlidatePassword vp = new VlidatePassword();
            vp.setPassword1(pass);
            System.out.println("1");
            vp.setPassword2(pass);
            System.out.println("2");
//            vp.setStatus("");
            System.out.println("3");
//            vp.validateNewPass();
            if (!vp.validateNewPass()) {
                System.out.println("" + vp.validateNewPass());
                System.out.println("" + vp.getStatus());
                System.out.println("validatePassword(pass)");
//                (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", vp.getStatus()));
//                item.setPassword("");
                pass = "";
                return null;
            } else {
                item.setPassword(pass);
            }
        } else if (updateOfficalEmail) {
            items = bean.findByOfficialEmail(item.getOfficialEmail());
            if (items.size() > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "please type another email ID"));
                return null;
            }
        } else if (updatePhoneNumber) {
            items = bean.findByOfficialPhone(item.getOfficialPhone());
            if (items.size() > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "please type another phone number"));
                return null;
            }
        }

        bean.update(item);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        updateName = false;
        updateOfficalEmail = false;
        updatePassword = false;
        updatePhoneNumber = false;
        updateUserName = false;
        updateImage = false;
        return "items?faces-redirect=true";
    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public void prepareUpdateCurrentUser() throws IOException {
        try {
            item = new SecurityUser();
            item = bean.find(Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString()));
            inProfile = true;
            content = Files.readAllBytes(new File("E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\1\\ahmed.png").toPath());
        } catch (IOException ex) {
            Logger.getLogger(SecurityUserMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateName() {
        updateName = true;
        updateOfficalEmail = false;
        updatePassword = false;
        updatePhoneNumber = false;
        updateUserName = false;
        updateImage = false;
    }

    public void updateOfficalEmail() {
        updateOfficalEmail = true;
        updateName = false;
        updatePassword = false;
        updatePhoneNumber = false;
        updateUserName = false;
        updateImage = false;
    }

    public void updatePassword() {
        updatePassword = true;
        updateName = false;
        updateOfficalEmail = false;
        updatePhoneNumber = false;
        updateUserName = false;
        updateImage = false;
    }

    public void updatePhoneNumber() {
        updatePhoneNumber = true;
        updateName = false;
        updateOfficalEmail = false;
        updatePassword = false;
        updateUserName = false;
        updateImage = false;
    }

    public void updateUserName() {
        updateUserName = true;
        updateName = false;
        updateOfficalEmail = false;
        updatePassword = false;
        updatePhoneNumber = false;
        updateImage = false;
    }

    public void updateImage() {
        updateUserName = false;
        updateName = false;
        updateOfficalEmail = false;
        updatePassword = false;
        updatePhoneNumber = false;
        updateImage = true;
    }

    public SecurityUser getItem() {
        return item;
    }

    public void setItem(SecurityUser item) {
        this.item = item;
    }

    public List<SecurityUser> getItems() {
        return items;
    }

    public void setItems(List<SecurityUser> items) {
        this.items = items;
    }

    public List<SecurityGroup> getSecurityGroups() {
        return securityGroups;
    }

    public void setSecurityGroups(List<SecurityGroup> securityGroups) {
        this.securityGroups = securityGroups;
    }

    public List<SecurityGroup> getSecurityGroups_user() {
        return securityGroups_user;
    }

    public void setSecurityGroups_user(List<SecurityGroup> securityGroups_user) {
        this.securityGroups_user = securityGroups_user;
    }

    public List<SecurityGroup> getSelectedsecurityGroups() {
        return selectedsecurityGroups;
    }

    public void setSelectedsecurityGroups(List<SecurityGroup> selectedsecurityGroups) {
        this.selectedsecurityGroups = selectedsecurityGroups;
    }

    public List<SecurityGroup> getRemoveSelectedsecurityGroups() {
        return removeSelectedsecurityGroups;
    }

    public void setRemoveSelectedsecurityGroups(List<SecurityGroup> removeSelectedsecurityGroups) {
        this.removeSelectedsecurityGroups = removeSelectedsecurityGroups;
    }

    public boolean isDisableContent() {
        return disableContent;
    }

    public void setDisableContent(boolean disableContent) {
        this.disableContent = disableContent;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isUpdateName() {
        return updateName;
    }

    public void setUpdateName(boolean updateName) {
        this.updateName = updateName;
    }

    public boolean isUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(boolean updateUserName) {
        this.updateUserName = updateUserName;
    }

    public boolean isUpdatePassword() {
        return updatePassword;
    }

    public void setUpdatePassword(boolean updatePassword) {
        this.updatePassword = updatePassword;
    }

    public boolean isUpdatePhoneNumber() {
        return updatePhoneNumber;
    }

    public void setUpdatePhoneNumber(boolean updatePhoneNumber) {
        this.updatePhoneNumber = updatePhoneNumber;
    }

    public boolean isUpdateOfficalEmail() {
        return updateOfficalEmail;
    }

    public void setUpdateOfficalEmail(boolean updateOfficalEmail) {
        this.updateOfficalEmail = updateOfficalEmail;
    }
//    private static Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,25})");
    private static Pattern pswNamePtrn = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})");

    public static boolean validatePassword(String userName) {
        Matcher mtch = pswNamePtrn.matcher(userName);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    public String getLastPass() {
        return lastPass;
    }

    public void setLastPass(String lastPass) {
        this.lastPass = lastPass;
    }

    public boolean isInProfile() {
        return inProfile;
    }

    public void setInProfile(boolean inProfile) {
        this.inProfile = inProfile;
    }

    public void fileUploadListener(FileUploadEvent e) throws IOException, Exception {
        System.out.println("ssssssssssssss");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        String strDate = dateFormat.format(date);
        System.out.println("converted Date to String: " + strDate);
        this.file = e.getFile();
        String filename = file.getFileName();
        String ext = filename.substring(filename.lastIndexOf('.') + 1, filename.length());
        System.out.println("-1");
        System.out.println(ext);
        System.out.println("0");

//        /resources/users-profile/#{session.getAttribute('userId')}/#{request.userPrincipal.name}.png
        File o = new File("E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
        );
        String f = "";

        File oStream = new File(
                "E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
                + "\\" + strDate + "." + ext);
        if (!o.exists()) {
            o.mkdirs();
        }

        System.out.println(strDate + "." + ext);

        System.out.println("3");
        oStream.createNewFile();
        System.out.println("4");
        Long sss = file.getSize();
        System.out.println("5");
        InputStream inputStream = file.getInputstream();
        System.out.println("6");
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            System.out.println("7");
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        float ff = (int) file.getSize() / 1024;
        System.out.println("8");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully -" + ff + "KB"));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "File Uploaded Successfully"));

        String extension = file.getContentType();
        Long size1 = file.getSize();
        System.out.println(size1.toString());
        System.out.println(filename);
        System.out.println(extension);

    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public boolean isUpdateImage() {
        return updateImage;
    }

    public void setUpdateImage(boolean updateImage) {
        this.updateImage = updateImage;
    }
}
