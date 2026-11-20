package br.com.codesync.repository;

import br.com.codesync.model.entity.ProjectRequiredSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRequiredSkillRepository extends JpaRepository<ProjectRequiredSkill, UUID> {
}
