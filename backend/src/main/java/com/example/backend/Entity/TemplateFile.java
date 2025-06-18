package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Template_File")
public class TemplateFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] Form;
    private String ContentType;

    @OneToOne
    @JoinColumn(name = "template_id", referencedColumnName = "templateId")
    @JsonBackReference
    private Template template;

    public TemplateFile(Long templateId, byte[] form, Template template, String contentType) {
        this.templateId = templateId;
        Form = form;
        this.template = template;
        ContentType = contentType;
    }

    public TemplateFile() {
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public byte[] getForm() {
        return Form;
    }

    public void setForm(byte[] form) {
        Form = form;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}