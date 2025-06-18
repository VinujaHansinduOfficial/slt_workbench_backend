package com.example.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WORK_PROGRESS")
public class WorkProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workflowId;
    private String stage;
    private String request;
    private String assignee;
    private String assigner;
    private String status;
    private String assigneeComment;
    private String assignerComment;
    @Column(name = "assignee_updated_at",columnDefinition = "TIMESTAMP", nullable = true)
    private Date assigneeUpdatedTime;
    @Column(name = "assigner_updated_at",columnDefinition = "TIMESTAMP", nullable = true)
    private Date  assignerUpdatedTime;

    private Long AttachmentId;

    public WorkProgress(Long id, String workflowId, String stage, String request, String assignee, String assigner, String status, String assigneeComment, String assignerComment, Date assigneeUpdatedTime, Date assignerUpdatedTime, Long attachmentId) {
        this.id = id;
        this.workflowId = workflowId;
        this.stage = stage;
        this.request = request;
        this.assignee = assignee;
        this.assigner = assigner;
        this.status = status;
        this.assigneeComment = assigneeComment;
        this.assignerComment = assignerComment;
        this.assigneeUpdatedTime = assigneeUpdatedTime;
        this.assignerUpdatedTime = assignerUpdatedTime;
        AttachmentId = attachmentId;
    }

    public WorkProgress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssigneeComment() {
        return assigneeComment;
    }

    public void setAssigneeComment(String assigneeComment) {
        this.assigneeComment = assigneeComment;
    }

    public String getAssignerComment() {
        return assignerComment;
    }

    public void setAssignerComment(String assignerComment) {
        this.assignerComment = assignerComment;
    }

    public Date getAssigneeUpdatedTime() {
        return assigneeUpdatedTime;
    }

    public void setAssigneeUpdatedTime(Date assigneeUpdatedTime) {
        this.assigneeUpdatedTime = assigneeUpdatedTime;
    }

    public Date getAssignerUpdatedTime() {
        return assignerUpdatedTime;
    }

    public void setAssignerUpdatedTime(Date assignerUpdatedTime) {
        this.assignerUpdatedTime = assignerUpdatedTime;
    }

    public Long getAttachmentId() {
        return AttachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        AttachmentId = attachmentId;
    }
}