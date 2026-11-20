package br.com.codesync.repository;

import br.com.codesync.model.entity.ProjectAccessInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectAccessInstructionRepository extends JpaRepository<ProjectAccessInstruction, UUID> {
}
