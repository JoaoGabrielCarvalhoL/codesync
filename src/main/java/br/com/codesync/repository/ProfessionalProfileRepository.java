package br.com.codesync.repository;

import br.com.codesync.model.entity.ProfessionalProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalProfileRepository extends JpaRepository<ProfessionalProfile, UUID> {
}
