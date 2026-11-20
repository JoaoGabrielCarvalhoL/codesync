package br.com.codesync.repository;

import br.com.codesync.model.entity.ProjectEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectEnvironmentRepository extends JpaRepository<ProjectEnvironment, UUID> {
}
