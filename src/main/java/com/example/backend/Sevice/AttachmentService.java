package com.example.backend.Sevice;

import com.example.backend.Entity.Attachment;
import com.example.backend.Repo.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    public Attachment saveAttachment(String workflowId, MultipartFile file, String createdBy,
                                     List<byte[]> fileAnnexes, List<String> fileAnnexesContentTypes) throws IOException {
        Attachment attachment = new Attachment();
        attachment.setWorkflowId(workflowId);
        attachment.setFile(file.getBytes());
        attachment.setCreatedBy(createdBy);
        attachment.setContenttype(file.getContentType());
        attachment.setFileAnnexes(fileAnnexes);
        attachment.setFileAnnexesContenttype(fileAnnexesContentTypes); // Store content types

        return attachmentRepository.save(attachment);
    }


    public List<Attachment> getAllAttachments(String createdBy) {
        return attachmentRepository.findAllByCreatedBy(createdBy);
    }

    // Add this method to retrieve an attachment by ID
    public Optional<Attachment> getAttachmentById(Long id) {
        return attachmentRepository.findById(String.valueOf(id));
    }

    public Optional<byte[]> getAnnexureById(Long attachmentId, int index) {
        Optional<Attachment> attachment = attachmentRepository.findById(String.valueOf(attachmentId));

        if (attachment.isPresent()) {
            List<byte[]> annexures = attachment.get().getFileAnnexes();
            if (index >= 0 && index < annexures.size()) {
                return Optional.of(annexures.get(index));
            }
        }
        return Optional.empty();
    }

    public Optional<String> getAnnexureContetById(Long attachmentId, int index) {
        Optional<Attachment> attachment = attachmentRepository.findById(String.valueOf(attachmentId));

        if (attachment.isPresent()) {
            List<String> annexures = attachment.get().getFileAnnexesContenttype();
            if (index >= 0 && index < annexures.size()) {
                return Optional.of(annexures.get(index));
            }
        }
        return Optional.empty();
    }

}
