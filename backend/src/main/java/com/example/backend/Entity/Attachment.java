package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "ATTACHMENT")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workflowId;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;
    private String createdBy;
    private String Contenttype;
    @ElementCollection
    @CollectionTable(name = "ATTACHMENT_AUX_FILES", joinColumns = @JoinColumn(name = "attachment_id"))
    @Column(name = "file_annexes_location", columnDefinition = "LONGBLOB")
    private List<byte[]> fileAnnexes = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "ATTACHMENT_AUX_FILES", joinColumns = @JoinColumn(name = "attachment_id"))
    private List<String> fileAnnexesContentType = new ArrayList<>();
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdTime;

    public Attachment(Long id, String workflowId, byte[] file, String createdBy, String contenttype, List<byte[]> fileAnnexes, List<String> fileAnnexesContenttype, Date createdTime) {
        this.id = id;
        this.workflowId = workflowId;
        this.file = file;
        this.createdBy = createdBy;
        Contenttype = contenttype;
        this.fileAnnexes = fileAnnexes;
        this.fileAnnexesContentType = fileAnnexesContenttype;
        this.createdTime = createdTime;
    }

    public Attachment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<byte[]> getFileAnnexes() {
        return fileAnnexes;
    }

    public void setFileAnnexes(List<byte[]> fileAnnexes) {
        this.fileAnnexes = fileAnnexes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getContenttype() {
        return Contenttype;
    }

    public void setContenttype(String contenttype) {
        Contenttype = contenttype;
    }

    public List<String> getFileAnnexesContenttype() {
        return fileAnnexesContentType;
    }

    public void setFileAnnexesContenttype(List<String> fileAnnexesContenttype) {
        this.fileAnnexesContentType = fileAnnexesContenttype;
    }
}