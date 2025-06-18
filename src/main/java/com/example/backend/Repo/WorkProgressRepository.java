package com.example.backend.Repo;

import com.example.backend.Entity.WorkProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkProgressRepository extends JpaRepository<WorkProgress, String> {
    List<WorkProgress> findByStatusIgnoreCase(String status);

    List<WorkProgress> findByassignee(String assignee);

    List<WorkProgress> findByWorkflowId(String workflowId);
}
