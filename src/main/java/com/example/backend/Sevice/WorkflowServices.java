package com.example.backend.Sevice;

import com.example.backend.Entity.Workflow;

import com.example.backend.Repo.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowServices {

    @Autowired
    private WorkflowRepository workflowRepository;

    public Workflow createWorkflow(Workflow workflow) {
        return workflowRepository.save(workflow);
    }

    public List<Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }

    public Optional<Workflow> getWorkflowByformId(Long formId) {
        return workflowRepository.findByformId(formId);
    }
}

