package br.com.codesync.repository;

import br.com.codesync.model.entity.ProfessionalLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalLanguageRepository extends JpaRepository<ProfessionalLanguage, UUID> {
}
