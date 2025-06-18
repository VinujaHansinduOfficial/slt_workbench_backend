package com.example.backend.Sevice;

import com.example.backend.Entity.WorkProgress;
import com.example.backend.Repo.WorkProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkProgressServices {
    @Autowired
    private WorkProgressRepository workProgressRepository;

    public WorkProgressServices(WorkProgressRepository workProgressRepository) {
        this.workProgressRepository = workProgressRepository;
    }

    public List<WorkProgress> getAllWorkProgress() {
        return workProgressRepository.findAll();
    }

    public WorkProgress saveWorkProgress(WorkProgress workProgress) {
        return workProgressRepository.save(workProgress);
    }

    public WorkProgress updateWorkProgress(Long id, WorkProgress updatedWorkProgress) {
        Optional<WorkProgress> existingWorkProgress = workProgressRepository.findById(id.toString());
        if (existingWorkProgress.isPresent()) {
            WorkProgress workProgress = existingWorkProgress.get();
            workProgress.setWorkflowId(updatedWorkProgress.getWorkflowId());
            workProgress.setStage(updatedWorkProgress.getStage());
            workProgress.setAssignee(updatedWorkProgress.getAssignee());
            workProgress.setAssigner(updatedWorkProgress.getAssigner());
            workProgress.setStatus(updatedWorkProgress.getStatus());
            workProgress.setAssigneeComment(updatedWorkProgress.getAssigneeComment());
            workProgress.setAssignerComment(updatedWorkProgress.getAssignerComment());
            workProgress.setAssigneeUpdatedTime(updatedWorkProgress.getAssigneeUpdatedTime());
            workProgress.setAssignerUpdatedTime(updatedWorkProgress.getAssignerUpdatedTime());
            workProgress.setAttachmentId(updatedWorkProgress.getAttachmentId());
            return workProgressRepository.save(workProgress);
        } else {
            throw new RuntimeException("WorkProgress not found with ID: " + id);
        }
    }
    public void deleteWorkProgress(Long id) {
        if (workProgressRepository.existsById(id.toString())) {
            workProgressRepository.deleteById(id.toString());
        } else {
            throw new RuntimeException("WorkProgress not found with ID: " + id);
        }
    }

    public List<WorkProgress> getWorkProgressByStatus(String status) {
        return workProgressRepository.findByStatusIgnoreCase(status);
    }

    public List<WorkProgress> getWorkProgressByassignee(String assignee) {
        return workProgressRepository.findByassignee(assignee);
    }

    public void approveStatusById(Long id) {
        Optional<WorkProgress> work = workProgressRepository.findById(id.toString());
        if (work.isPresent()) {
            WorkProgress wp = work.get();
            wp.setStatus("approved");
            wp.setAssigneeUpdatedTime(new Date()); // optionally update timestamp
            workProgressRepository.save(wp);
        } else {
            throw new RuntimeException("WorkProgress not found with ID: " + id);
        }
    }

    public List<WorkProgress> getWorkProgressByWorkflowId(String workflowId) {
        return workProgressRepository.findByWorkflowId(workflowId);
    }
}
