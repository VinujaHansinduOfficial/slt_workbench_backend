package com.example.backend.Controller;

import com.example.backend.Entity.Attachment;
import com.example.backend.Sevice.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Attachment> uploadFile(
            @RequestParam("file") MultipartFile mainFile,
            @RequestParam(value = "auxFiles", required = false) MultipartFile[] auxFiles,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("workflowId") String workflowId) {
        try {
            List<byte[]> fileAnnexes = new ArrayList<>();
            List<String> fileAnnexesContentTypes = new ArrayList<>();

            if (auxFiles != null) {
                for (MultipartFile auxFile : auxFiles) {
                    fileAnnexes.add(auxFile.getBytes());
                    fileAnnexesContentTypes.add(auxFile.getContentType()); // Store content type
                }
            }

            Attachment attachment = attachmentService.saveAttachment(workflowId, mainFile, createdBy, fileAnnexes, fileAnnexesContentTypes);
            return new ResponseEntity<>(attachment, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{createdBy}")
    public ResponseEntity<List<Attachment>> getAllAttachments(@PathVariable String createdBy) {
        return ResponseEntity.ok(attachmentService.getAllAttachments(createdBy));
    }

    // New endpoint to serve file content as response (stream the file)
    @GetMapping("/file/{attachmentId}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long attachmentId) {
        Attachment attachment = attachmentService.getAttachmentById(attachmentId)
                .orElseThrow(() -> new RuntimeException("Attachment not found"));

        byte[] fileData = attachment.getFile();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=attachment.pdf"); // Set the file name
        headers.add(HttpHeaders.CONTENT_TYPE, attachment.getContenttype() != null ? attachment.getContenttype() : "application/pdf");

        return ResponseEntity.ok().headers(headers).body(fileData);
    }

    @GetMapping("/{attachmentId}/annexure/{index}")
    public ResponseEntity<byte[]> getAnnexureFile(@PathVariable Long attachmentId, @PathVariable int index) {
        // Fetch the annexure file and content type
        Optional<byte[]> annexureFile = attachmentService.getAnnexureById(attachmentId, index);
        Optional<String> annexureFileContenttype = attachmentService.getAnnexureContetById(attachmentId, index);

        if (annexureFile.isPresent() && annexureFileContenttype.isPresent()) {
            HttpHeaders headers = new HttpHeaders();

            // Get the content type
            String contentType = annexureFileContenttype.get();

            // Validate the content type format (e.g., "application/pdf")
            String[] typeParts = contentType.split("/");

            if (typeParts.length == 2) {
                String fileType = typeParts[1]; // Get the second part of the content type
                headers.setContentType(MediaType.parseMediaType(contentType));  // Set the content type dynamically
                headers.setContentDisposition(ContentDisposition.builder("inline")
                        .filename("annexure-" + index + "." + fileType) // Use the file type for the file extension
                        .build());
            } else {
                // Fallback in case the content type is not well-formed
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Invalid content type format".getBytes());
            }

            // Return the annexure file with proper headers
            return ResponseEntity.ok().headers(headers).body(annexureFile.get());
        }

        // If no file or content type found, return not found
        return ResponseEntity.notFound().build();
    }

}
