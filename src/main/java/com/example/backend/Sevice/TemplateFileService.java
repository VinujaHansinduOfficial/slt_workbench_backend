package com.example.backend.Sevice;

import com.example.backend.Entity.TemplateFile;
import com.example.backend.Repo.TemplateFileRepository;
import com.example.backend.Repo.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateFileService {

    private final TemplateFileRepository templateFileRepository;

    @Autowired
    public TemplateFileService(TemplateFileRepository templateFileRepository, TemplateRepository templateRepository) {
        this.templateFileRepository = templateFileRepository;
    }

    public TemplateFile savetemplateFile(MultipartFile file) throws IOException {


        String contentType = file.getContentType();

        if (!isWordFile(contentType)) {
            throw new IllegalArgumentException("Only Word files (.doc, .docx) are allowed.");
        }

        TemplateFile templateFile = new TemplateFile();
        templateFile.setForm(file.getBytes());
        templateFile.setContentType(contentType);


        return templateFileRepository.save(templateFile);
    }

    private boolean isWordFile(String contentType) {
        return contentType != null && (
                contentType.equalsIgnoreCase("application/msword") || // .doc
                        contentType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.wordprocessingml.document") // .docx
        );
    }

    public List<TemplateFile> getAllTemplateFile() {
        return templateFileRepository.findAll();
    }

    public Optional<TemplateFile> getTemplateFileBytemplateId(Long templateId) {
        return templateFileRepository.findBytemplateId(templateId);
    }
}
