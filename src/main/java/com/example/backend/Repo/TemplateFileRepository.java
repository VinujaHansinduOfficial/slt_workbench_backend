package com.example.backend.Repo;

import com.example.backend.Entity.TemplateFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateFileRepository extends JpaRepository<TemplateFile, Long> {


    Optional<TemplateFile> findBytemplateId(Long templateId);
}
