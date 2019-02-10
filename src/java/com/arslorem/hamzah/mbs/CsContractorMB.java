/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.mbs;

import com.arslorem.hamzah.ejbs.CsContractorBean;
import com.arslorem.hamzah.ejbs.CsSystemBean;
import com.arslorem.hamzah.entities.CsContractor;
import com.arslorem.hamzah.entities.CsSystem;
import com.arslorem.hamzah.util.StaticClass;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.Part;
import org.omnifaces.util.Servlets;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author said
 */
@Named(value = "csContractorMB")
@javax.enterprise.context.SessionScoped
public class CsContractorMB implements Serializable {

    /**
     * Creates a new instance of CsContractMB
     */
    public CsContractorMB() {
    }
    private CsContractor item;
    private List<CsContractor> items;
    private String conr_name;
    private CsSystem csSystem;
    private boolean isUpdate = false;

    @Inject
    private CsSystemBean csSystemBean;
    @Inject
    private CsContractorBean bean;

    public void fileUploadListener(FileUploadEvent e) throws IOException, Exception {
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");

        this.file = e.getFile();
        System.out.println("getFileName" + file.getFileName());
        System.out.println("getContentType" + file.getContentType());
        File oStream = new File(
                "E:\\CTTEST\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
                + "\\" + file.getFileName());
//                if (!oStream.exists()) {
//                    oStream.mkdirs();
//                }
        oStream.createNewFile();
        InputStream inputStream = file.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            System.out.println("7");
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }
    }

    public String fileUploadListenerCV(FileUploadEvent e) throws IOException, Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS");
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = csSystemBean.find(new Long("1"));
            src = csSystem.getSysName();
        } else {
            csSystem = csSystemBean.find(new Long("1"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File oStreamFile = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID());
        if (!oStreamFile.exists()) {
            oStreamFile.mkdirs();
        }
        fileCV = e.getFile();

        File oStream = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID()
                + "/CV.pdf");
        File oStream2 = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID()
                + "/CV" + strDate + ".pdf");

        RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
        if (oStream.exists()) {
            accessFile.close();
            System.out.println("" + oStream.getName());
            oStream.renameTo(oStream2);
//            System.out.println(oStream.delete());
        }
        oStream.createNewFile();
        InputStream inputStream = fileCV.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }

        return "update?id=" + item.getConrID() + "&faces-redirect=true";
    }

    public String fileUploadListenerID(FileUploadEvent e) throws IOException, Exception {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS");
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);
        String src = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("src", null);
        if (Objects.nonNull(src)) {
            csSystem = csSystemBean.find(new Long("1"));
            src = csSystem.getSysName();
        } else {
            csSystem = csSystemBean.find(new Long("1"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("src", csSystem.getSysName());
        }
        File oStreamFile = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID());
        if (!oStreamFile.exists()) {
            oStreamFile.mkdirs();
        }
        fileID = e.getFile();

        File oStream = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID()
                + "/ID.pdf");
        File oStream2 = new File(
                src
                + StaticClass.contractorFolderName
                + item.getConrID()
                + "/ID" + strDate + ".pdf");

        RandomAccessFile accessFile = new RandomAccessFile(oStream, "rwd");
        if (oStream.exists()) {
            accessFile.close();
            System.out.println("" + oStream.getName());
            oStream.renameTo(oStream2);
//            System.out.println(oStream.delete());
        }

        oStream.createNewFile();
        InputStream inputStream = fileID.getInputstream();
        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lenght);
            }
        }
        return "update?id=" + item.getConrID() + "&faces-redirect=true";
    }

    UploadedFile file;
    UploadedFile fileCV;
    UploadedFile fileID;

    public void read() throws IOException {
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");
        System.out.println("read");

        try {

            if (file2 != null) {
                String name = Servlets.getSubmittedFileName(file2);
                String ty = file2.getContentType();
                long sz = file2.getSize();
                InputStream contente = file2.getInputStream();
                System.out.println("name" + name);
                System.out.println("ty" + ty);
                System.out.println("sz" + sz);
                File oStream = new File(
                        "E:\\CTTEST\\"
                        + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
                        + "\\" + name);
//                if (!oStream.exists()) {
//                    oStream.mkdirs();
//                }
                oStream.createNewFile();
                InputStream inputStream = file2.getInputStream();
                try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
                    System.out.println("7");
                    byte[] buffer = new byte[1024];
                    int lenght;
                    while ((lenght = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, lenght);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        
//        content = null;
//        Logger.getLogger(CsContractMB.class.getName()).log(Level.INFO, "reading content");
//        try {
//            content = Utils.toByteArray(file2.getInputStream());
//        } catch (IOException ex) {
//            Logger.getLogger(CsContractMB.class.getName()).log(Level.INFO, "Content size is " + content.length);
//        }
//        Logger.getLogger(CsContractMB.class.getName()).log(Level.INFO, "Content size is " + content.length);
////        saveImageName();
//        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmm");
//        String strDate = dateFormat.format(date);
////        File o = new File("E:\\rms\\rms\\src\\main\\webapp\\resources\\users-profile\\"
////                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
////        );
//        File oStream = new File(
//                "C:\\CTTEST\\"
//                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
//                + "\\" + strDate + ".png");
//        if (!oStream.exists()) {
//            oStream.mkdirs();
//        }
////        oStream.createNewFile();
//        InputStream inputStream = new ByteArrayInputStream(content);
//        try (FileOutputStream outputStream = new FileOutputStream(oStream)) {
//            System.out.println("7");
//            byte[] buffer = new byte[1024];
//            int lenght;
//            while ((lenght = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, lenght);
//            }
//        }
//        float ff = (int) file.getSize() / 1024;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully -" + ff + "KB"));
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "File Uploaded Successfully"));
    }
    private Part file2;

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
        File o = new File("C:\\CTTEST\\"
                + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("userId", "0")
        );
        String f = "";

        File oStream = new File(
                "C:\\CTTEST\\"
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
            System.out.println("1");
            Logger.getLogger(CsContractMB.class.getName()).log(Level.INFO, "getting content" + content.length);
        } else {
            Logger.getLogger(CsContractMB.class.getName()).log(Level.INFO, "content is null");
        }
        return content;
    }
    private byte[] content;

    public void prepareItems() {

        items = bean.findAll();
    }

    public void prepareCreate() {
        isUpdate = false;
        item = new CsContractor();

    }

    public void prepareUpdate(Long id2) throws FileNotFoundException {
        isUpdate = true;
        item = bean.find(id2);
        conr_name = item.getConrName1() + " " + item.getConrName2();

//        System.out.println("wwwww");
//        File sdsd = new File("C:/Users/said/Desktop/testt.pdf");
//        InputStream dsfdfd = new FileInputStream(sdsd);
//        media = new DefaultStreamedContent(dsfdfd, "application/pdf");
    }

    public String create() {
        bean.create(item);
        return "update?id=" + item.getConrID() + "&faces-redirect=true";
    }

    public String update() {
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "items?faces-redirect=true";
    }

    public String updateWithRefresh() {
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "update?id=" + item.getConrID() + "&faces-redirect=true";
    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public CsContractor getItem() {
        return item;
    }

    public void setItem(CsContractor item) {
        this.item = item;
    }

    public List<CsContractor> getItems() {
        return items;
    }

    public void setItems(List<CsContractor> items) {
        this.items = items;
    }

    public String getConr_name() {
        return conr_name;
    }

    public void setConr_name(String conr_name) {
        this.conr_name = conr_name;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    private static final String FILE_PREFIX = "C:\\Users\\said\\Desktop\\";
    private static final String FILE_EXTENSION = ".pdf";
    private int count = 1;
    private StreamedContent media;

    @PostConstruct
    public void init() {

//////        File e=new File("C:\\Users\\said\\Desktop\\testt.pdf");
//        /* * Feed the media content */ FacesContext fc = FacesContext.getCurrentInstance();
//        InputStream stream = fc.getExternalContext().getResourceAsStream(getMediaFile());
//////        InputStream stream1 = this.getClass().getResourceAsStream(getMediaFile());
//        try {
//            if (stream != null) {
//                System.out.println("init: file name = " + getMediaFile() + " size = " + stream.available());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(CsContractorMB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        media = new DefaultStreamedContent(stream, "application/pdf");
    }

    public void next(ActionEvent actionEvent) {
        //Repeadly loop from 1 to 4 count++;

        /* * Feed the media content */
        FacesContext fc = FacesContext.getCurrentInstance();
        InputStream stream = fc.getExternalContext().getResourceAsStream(getMediaFile());
        File e = new File("C:\\Users\\said\\Desktop\\testt.pdf");
//        InputStream stream = this.getClass().getResourceAsStream(getMediaFile());
        try {
            if (stream != null) {
                System.out.println("next: media file = " + getMediaFile() + " size = " + stream.available());
            }
        } catch (IOException ex) {
            Logger.getLogger(CsContractorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        media = new DefaultStreamedContent(stream, "application/pdf");
    }

    /**
     * * This method is used to construct the * media source file in the
     * similar format: * /audio/ATT_TTS_sample_x.mp3 * @return
     */
    public String getMediaFile() {
        return FILE_PREFIX + "testt" + FILE_EXTENSION;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }

    public UploadedFile getFileCV() {
        return fileCV;
    }

    public void setFileCV(UploadedFile fileCV) {
        this.fileCV = fileCV;
    }

    public UploadedFile getFileID() {
        return fileID;
    }

    public void setFileID(UploadedFile fileID) {
        this.fileID = fileID;
    }

    public CsSystem getCsSystem() {
        return csSystem;
    }

    public void setCsSystem(CsSystem csSystem) {
        this.csSystem = csSystem;
    }

    public boolean isIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getIdFile() {
        return UUID.randomUUID().toString();
    }
}
