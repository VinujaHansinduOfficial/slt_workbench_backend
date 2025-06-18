package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;


@Entity
@Table(name = "FORWARD_QUEUE")
public class ForwardQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stageId;
    private String assignee;
    private String assigner;
    private String status;
    private String assigneeComment;
    private String assignerComment;
    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp   assigneeUpdatedTime;
    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp   assignerUpdatedTime;
    private Long workflowId;

    public ForwardQueue(Long id, Integer stageId, String assignee, String assigner, String status, String assigneeComment, String assignerComment, Timestamp   assigneeUpdatedTime, Timestamp   assignerUpdatedTime, Long workflowId) {
        this.id = id;
        this.stageId = stageId;
        this.assignee = assignee;
        this.assigner = assigner;
        this.status = status;
        this.assigneeComment = assigneeComment;
        this.assignerComment = assignerComment;
        this.assigneeUpdatedTime = assigneeUpdatedTime;
        this.assignerUpdatedTime = assignerUpdatedTime;
        this.workflowId = workflowId;
    }

    public ForwardQueue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
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

    public Timestamp   getAssigneeUpdatedTime() {
        return assigneeUpdatedTime;
    }

    public void setAssigneeUpdatedTime(Timestamp   assigneeUpdatedTime) {
        this.assigneeUpdatedTime = assigneeUpdatedTime;
    }

    public Timestamp   getAssignerUpdatedTime() {
        return assignerUpdatedTime;
    }

    public void setAssignerUpdatedTime(Timestamp assignerUpdatedTime) {
        this.assignerUpdatedTime = assignerUpdatedTime;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }
}