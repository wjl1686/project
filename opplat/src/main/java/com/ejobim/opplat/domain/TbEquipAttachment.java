package com.ejobim.opplat.domain;

import java.util.Date;

public class TbEquipAttachment {
    private Integer id;

    private String attachmentNo;

    private String attachmentFilename;

    private String attachmentDescribe;

    private String attachmentUpload;

    private Date attachmentUploadTime;

    private String attachmentFilepath;

    private String equipNo;

    private Integer fileType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachmentNo() {
        return attachmentNo;
    }

    public void setAttachmentNo(String attachmentNo) {
        this.attachmentNo = attachmentNo == null ? null : attachmentNo.trim();
    }

    public String getAttachmentFilename() {
        return attachmentFilename;
    }

    public void setAttachmentFilename(String attachmentFilename) {
        this.attachmentFilename = attachmentFilename == null ? null : attachmentFilename.trim();
    }

    public String getAttachmentDescribe() {
        return attachmentDescribe;
    }

    public void setAttachmentDescribe(String attachmentDescribe) {
        this.attachmentDescribe = attachmentDescribe == null ? null : attachmentDescribe.trim();
    }

    public String getAttachmentUpload() {
        return attachmentUpload;
    }

    public void setAttachmentUpload(String attachmentUpload) {
        this.attachmentUpload = attachmentUpload == null ? null : attachmentUpload.trim();
    }

    public Date getAttachmentUploadTime() {
        return attachmentUploadTime;
    }

    public void setAttachmentUploadTime(Date attachmentUploadTime) {
        this.attachmentUploadTime = attachmentUploadTime;
    }

    public String getAttachmentFilepath() {
        return attachmentFilepath;
    }

    public void setAttachmentFilepath(String attachmentFilepath) {
        this.attachmentFilepath = attachmentFilepath == null ? null : attachmentFilepath.trim();
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo == null ? null : equipNo.trim();
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}