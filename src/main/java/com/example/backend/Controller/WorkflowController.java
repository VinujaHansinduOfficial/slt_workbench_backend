package com.example.backend.Controller;

import com.example.backend.Entity.Workflow;
import com.example.backend.Sevice.WorkflowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://front-workflow-gzq3.vercel.app/")
@RequestMapping(value = "/api/workflows", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkflowController {
    @Autowired
    private WorkflowServices workflowService;


    @PostMapping
    public ResponseEntity<Workflow> createWorkflow(@RequestBody Workflow workflow) {
        Workflow savedworkflow = workflowService.createWorkflow(workflow);
        return ResponseEntity.ok(savedworkflow);
    }

    @GetMapping
    public ResponseEntity<List<Workflow>> getAllWorkflows() {
        return new ResponseEntity<>(workflowService.getAllWorkflows(),HttpStatus.OK);
    }


    @GetMapping("/{formId}")
    public Optional<Workflow> getWorkflowByformId(@PathVariable Long formId) {
        return workflowService.getWorkflowByformId(formId);
    }
}
