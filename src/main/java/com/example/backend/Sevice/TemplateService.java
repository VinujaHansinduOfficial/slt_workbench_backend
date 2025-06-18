package com.example.backend.Sevice;

import com.example.backend.Entity.Template;
import com.example.backend.Repo.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateService {

    public final TemplateRepository templateRepository;
    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Template saveTemplate(Template template) {

        Template template1 = Template.builder()
                .id(template.getId())
                .formName(template.getFormName())
                .groupName(template.getGroupName())
                .formNo(template.getFormNo())
                .build();

        return templateRepository.save(template1);
    }

    public List<Template> getAllTemplate() {
        return templateRepository.findAll();
    }

    public Template updateTemplate(Long id, Template updatedTemplate) {
        Optional<Template> existingTemplate = templateRepository.findById(id);
        if (existingTemplate.isPresent()) {
            Template template = existingTemplate.get();
            template.setFormName(updatedTemplate.getFormName());
            template.setFormNo(updatedTemplate.getFormNo());
            return templateRepository.save(template);
        } else {
            throw new RuntimeException("Template not found with ID: " + id);
        }
    }

    public void deleteTemplate(Long id) {
        if (templateRepository.existsById(id)) {
            templateRepository.deleteById(id);
        } else {
            throw new RuntimeException("Template not found with ID: " + id);
        }
    }
}
