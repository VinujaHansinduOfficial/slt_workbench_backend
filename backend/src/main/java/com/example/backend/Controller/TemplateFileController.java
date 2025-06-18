package com.example.backend.Controller;

import com.example.backend.Entity.TemplateFile;
import com.example.backend.Sevice.TemplateFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/templatefile")
public class TemplateFileController {
    private final TemplateFileService templateFileService;

    public TemplateFileController(TemplateFileService templateFileService) {
        this.templateFileService = templateFileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile( @RequestParam("file") MultipartFile mainFile) {
        try {
            // Call the service to save the file
            TemplateFile templateFile = templateFileService.savetemplateFile(mainFile);
            return new ResponseEntity<>(templateFile, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("File upload failed due to IO error", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{templateId}")
    public ResponseEntity<TemplateFile> getAttachmentById(@PathVariable Long templateId) {
        Optional<TemplateFile> attachment = templateFileService.getTemplateFileBytemplateId(templateId);
        return attachment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TemplateFile>> getAllTemplateFile() {
        return ResponseEntity.ok(templateFileService.getAllTemplateFile());
    }



}
