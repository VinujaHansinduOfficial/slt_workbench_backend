package com.example.backend.Controller;

import com.example.backend.Entity.WorkProgress;
import com.example.backend.Sevice.WorkProgressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/workprogress")
public class WorkProgressController {

    private final WorkProgressServices workProgressService;

    @Autowired
    public WorkProgressController(WorkProgressServices workProgressService) {
        this.workProgressService = workProgressService;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<WorkProgress>> getWorkProgressByStatus(@PathVariable String status) {
        List<WorkProgress> list = workProgressService.getWorkProgressByStatus(status);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/assignee/{assignee}")
    public ResponseEntity<List<WorkProgress>> getWorkProgressByassignee(@PathVariable String assignee) {
        List<WorkProgress> list = workProgressService.getWorkProgressByassignee(assignee);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<WorkProgress> createWorkflow(@RequestBody WorkProgress workflow) {
        WorkProgress savedWorkProgress = workProgressService.saveWorkProgress(workflow);
        return ResponseEntity.ok(savedWorkProgress);
    }

    @GetMapping
    public ResponseEntity<List<WorkProgress>> getAllWorkProgress() {
        List<WorkProgress> workProgressList = workProgressService.getAllWorkProgress();
        return ResponseEntity.ok(workProgressList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkProgress> updateWorkProgress(@PathVariable Long id, @RequestBody WorkProgress updatedWorkProgress) {
        try {
            WorkProgress updated = workProgressService.updateWorkProgress(id, updatedWorkProgress);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkProgress(@PathVariable Long id) {
        try {
            workProgressService.deleteWorkProgress(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // ✅ Approve endpoint
    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveWorkProgress(@PathVariable Long id) {
        try {
            workProgressService.approveStatusById(id);
            return ResponseEntity.ok("Approved successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/workflow/{workflowId}")
    public List<WorkProgress> getByWorkflowId(@PathVariable String workflowId) {
        return workProgressService.getWorkProgressByWorkflowId(workflowId);
    }
}
