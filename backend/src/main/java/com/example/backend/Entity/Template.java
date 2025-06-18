package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Table(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formName;
    private String groupName;
    private String formNo;

    @OneToOne(mappedBy = "template", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TemplateFile templateFile;


    public Template(Long id, String formName, String groupName, String formNo, TemplateFile templateFile) {
        this.id = id;
        this.formName = formName;
        this.groupName = groupName;
        this.formNo = formNo;
        this.templateFile = templateFile;
    }

    public Template() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public TemplateFile getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(TemplateFile templateFile) {
        this.templateFile = templateFile;
    }
}
